package ca.ntro.app.backend;

public class BackendNtro implements Backend {

	@Override
	public boolean isLocalBackend() {
		return false;
	}

	@Override
	public LocalBackend asLocalBackend() {
		return (LocalBackend) this;
	}

	@Override
	public Session session() {
		// TODO Auto-generated method stub
		return null;
	}

}
