package ca.ntro.app.backend;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import ca.ntro.app.NtroApp;
import ca.ntro.core.initialization.Ntro;

public class WebSocketClientNtro extends WebSocketClient {
	
	public WebSocketClientNtro(String serverName, int port) {
		super(connectionUri(serverName, port));
	}
	
	private static URI connectionUri(String serverName, int port) {
		URI uri = null;
		try {

			uri = new URI(connectionString(serverName, port));

		} catch (URISyntaxException e) {
			Ntro.throwException(e);
		}
		
		return uri;
	}
	
	private static String connectionString(String serverName, int port) {
		return String.format("ws://%s:%d", serverName, port);
		
	}

	@Override
	public void onOpen(ServerHandshake handshakedata) {
		System.out.println("\n\n[INFO] connected to " + getURI() + "\n\n");
	}

	@Override
	public void onMessage(String message) {

	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		System.out.println("\n\n[FATAL] lost connection to " + getURI());
		NtroApp.exit(() -> {
			System.out.println("\n\n");
		});
	}

	@Override
	public void onError(Exception ex) {
		System.out.println("\n\n[FATAL] failed to connect to " + getURI());
		NtroApp.exit(() -> {
			System.out.println("\n\n");
		});
	}

}
