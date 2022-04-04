package ca.ntro.app;

import java.net.BindException;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import ca.ntro.app.NtroApp;
import ca.ntro.app.messages.BroadcastMessage;
import ca.ntro.app.messages.DeliveryMode;
import ca.ntro.app.messages.Message;
import ca.ntro.app.messages.MessageFromServerHandler;
import ca.ntro.app.messages.MessageServer;
import ca.ntro.app.messages.ObservationFromServerHandler;
import ca.ntro.app.messages.BroadcastMessageNtro;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.json.JsonObject;
import ca.ntro.core.reflection.object_graph.ObjectGraph;
import ca.ntro.core.reflection.observer.Observable;
import ca.ntro.core.reflection.observer.Observation;
import ca.ntro.core.reflection.observer.ObservationNtro;

public class WebSocketServerNtro extends WebSocketServer implements MessageServer {
	
	private int port;
	private String serverName;
	private Set<WebSocket> connections = new HashSet<>();

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public WebSocketServerNtro(String serverName, int port) {
		super(new InetSocketAddress(serverName, port));
		
		setServerName(serverName);
		setPort(port);

        Ntro.factory().registerNamedClass(BroadcastMessageNtro.class);
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		connections.add(conn);
		
		pushObservationsToNewClient(conn);
	}

	private void pushObservationsToNewClient(WebSocket client) {
		NtroApp.models().modelStream().forEach(model  -> {
			ObservationNtro observation = new ObservationNtro();
			observation.setPreviousValue((Observable) Ntro.factory().newInstance(model.getClass()));
			observation.setCurrentValue((Observable)model);
			
			pushObservationToClient(client, observation);
		});
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		connections.remove(conn);
	}

	@Override
	public void onMessage(WebSocket conn, String messageText) {
		try {
			JsonObject jsonObject = Ntro.json().fromJsonString(messageText);
			ObjectGraph objectGraph = Ntro.reflection().graphFromJsonObject(jsonObject);

			Object messageObject = Ntro.reflection().objectFromGraph(objectGraph);
			
			if(messageObject instanceof Message) {

				NtroApp.messageService().receiveMessageFromServer((Message) messageObject);

			}else if(messageObject instanceof BroadcastMessage) {
				
				BroadcastMessage broadcastMessage = (BroadcastMessage) messageObject;
				Message message = broadcastMessage.message();
				
				broadcastMessage(conn, message);
			}

		}catch(Throwable t) {
			System.out.println("\n\n[INFO] onMessage: " + messageText + "\n\n");
			t.printStackTrace();
		}
		
	}

	private void broadcastMessage(WebSocket conn, Message message) {
		String messageText = Ntro.reflection().toJsonObject(message).toJsonString(false);

		for(WebSocket broadcastTo : connections) {
			if(!broadcastTo.equals(conn)) {
				broadcastTo.send(messageText);
			}
		}
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		if(ex instanceof BindException) {

			System.out.println(ex);
			System.out.println("\n\n[FATAL] Cannot listen on ws://" + getServerName() + ":" + getPort());
			System.out.println("        Port already in use?\n\n");
			NtroApp.exit(() -> {});

		}else {

			Ntro.throwException(ex);
		}
	}

	@Override
	public void onStart() {
		System.out.println("\n\n[INFO] Listening on ws://" + getServerName() + ":" + getPort() + "\n\n\n");
		NtroApp.messageService().registerMessageServer(this, DeliveryMode.DISPATCH_LOCALLY);
	}

	@Override
	public void sendMessageToServer(Message message) {
	}

	@Override
	public void broadcastMessageToOtherClients(Message message) {
		// XXX: broadcast to all clients
		String messageText = Ntro.reflection().toJsonObject(message).toJsonString(false);

		for(WebSocket broadcastTo : connections) {
			broadcastTo.send(messageText);
		}
	}

	@Override
	public void pushObservationToClients(String observationName, Observation<?> observation) {
		for(WebSocket client : connections) {
			pushObservationToClient(client, observation);
		}
	}

	private void pushObservationToClient(WebSocket client, Observation<?> observation) {
		client.send(Ntro.reflection().toJsonObject(observation).toJsonString(false));
	}

	@Override
	public void onMessageFromServer(MessageFromServerHandler handler) {
	}

	@Override
	public void onObservationFromServer(ObservationFromServerHandler handler) {
	}

}
