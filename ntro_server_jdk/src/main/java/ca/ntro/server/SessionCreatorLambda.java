package ca.ntro.server;

import ca.ntro.app.session.Session;

public interface SessionCreatorLambda {
	
	Session createSession(ConnectionInfo info);

}
