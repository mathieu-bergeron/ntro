package ca.ntro.app;

public interface ServerRegistrarJdk extends ServerRegistrar {

	void registerSessionCreator(SessionCreatorLambda creator);

}
