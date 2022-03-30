package ca.ntro.app.backend;

public abstract class RemoteBackendNtro 

	   extends        BackendNtro

       implements     RemoteBackend {

	@Override
	public boolean isLocalBackend() {
		return false;
	}

	@Override
	public boolean useSsl() {
		return false;
	}

}
