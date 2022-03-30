package ca.ntro.app.backend;

import java.net.URI;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class WebSocketClientNtro extends WebSocketClient {

	public WebSocketClientNtro(URI serverUri) {
		super(serverUri);
	}

	@Override
	public void onOpen(ServerHandshake handshakedata) {
		System.out.println("onOpen");

		send("bonjour du client");
		
	}

	@Override
	public void onMessage(String message) {
		System.out.println("onMessage: " + message);
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		
	}

	@Override
	public void onError(Exception ex) {
		
	}

}
