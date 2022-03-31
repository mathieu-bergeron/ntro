package ca.ntro.app;

import java.net.InetSocketAddress;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import ca.ntro.app.NtroApp;

public class WebSocketServerNtro extends WebSocketServer {
	
	private int port;
	private String serverName;

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
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		
	}

	@Override
	public void onMessage(WebSocket conn, String message) {

	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		System.out.println("\n\n[FATAL] Cannot listen on ws://" + getServerName() + ":" + getPort());
		System.out.println("        Port already in use?\n\n");
		NtroApp.exit(() -> {});
	}

	@Override
	public void onStart() {
		System.out.println("\n\n[INFO] Listening on ws://" + getServerName() + ":" + getPort() + "\n\n\n");
	}

}
