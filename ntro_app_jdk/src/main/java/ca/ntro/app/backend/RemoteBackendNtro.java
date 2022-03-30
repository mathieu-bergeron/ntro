package ca.ntro.app.backend;

import java.net.URI;
import java.net.URISyntaxException;

import ca.ntro.core.initialization.Ntro;

public abstract class RemoteBackendNtro 

	   extends        BackendNtro

       implements     RemoteBackend {
	
	@Override
	public void openConnection() {
		
		try {

			WebSocketClientNtro client = new WebSocketClientNtro(new URI("ws://localhost:8080"));
			client.connect();

		} catch (URISyntaxException e) {
			Ntro.throwException(e);
		}
	}

	@Override
	public boolean isRemoteBackend() {
		return true;
	}

	@Override
	public boolean isLocalBackend() {
		return false;
	}

	@Override
	public boolean useSecureConnection() {
		return false;
	}

}
