package ca.ntro.app;

import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

public interface NtroServer {

	void registerMessages(MessageRegistrar registrar);
	void registerModels(ModelRegistrar registrar);
	void registerBackend(BackendRegistrar registrar);
	
	public static void launch(String[] args) {
		
	}

}
