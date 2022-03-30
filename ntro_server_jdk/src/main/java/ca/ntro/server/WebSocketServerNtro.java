package ca.ntro.server;

import java.net.InetSocketAddress;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class WebSocketServerNtro extends WebSocketServer {
	
	public WebSocketServerNtro(int port) {
		super(new InetSocketAddress(port));
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		System.out.println("onOpen");
		
		conn.send("bonjour du serveur");
		
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		System.out.println("onMessage: " + message);
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		
	}

}
