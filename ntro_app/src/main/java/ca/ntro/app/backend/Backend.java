package ca.ntro.app.backend;

public interface Backend {

	boolean isLocalBackend();
	LocalBackend asLocalBackend();
	
	Session session();
	

}
