package ntro.core.initialization;

import ca.ntro.core.initialization.InitializerJdk;
import ca.ntro.core.services.StorageService;
import ntro.core.services.StorageServiceFx;

public class InitializerFx extends InitializerJdk {

	@Override
	protected StorageService provideStorageService() {
		return new StorageServiceFx();
	}

}
