package ca.ntro.app;

import ca.ntro.app.session.Session;

public interface SessionCreatorLambda {
	
	Session createSession(ConnectionInfo info);

}
