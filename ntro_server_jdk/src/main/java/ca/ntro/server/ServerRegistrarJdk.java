package ca.ntro.server;

import ca.ntro.app.ServerRegistrar;

public interface ServerRegistrarJdk extends ServerRegistrar {

	void registerSessionCreator(SessionCreatorLambda creator);

}
