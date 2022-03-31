package ca.ntro.app;


public class      ServerRegistrarJdkImpl

       extends    ServerRegistrarNtro 
       
       implements ServerRegistrarJdk {
	
	private SessionCreatorLambda sessionCreator;

	public SessionCreatorLambda getSessionCreator() {
		return sessionCreator;
	}

	public void setSessionCreator(SessionCreatorLambda sessionCreator) {
		this.sessionCreator = sessionCreator;
	}

	@Override
	public void registerSessionCreator(SessionCreatorLambda creator) {
		setSessionCreator(creator);
	}

}
