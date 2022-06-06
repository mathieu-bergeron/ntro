package ntro.core.services;

import ca.ntro.core.path.Path;
import ca.ntro.core.services.StorageServiceJdk;
import ca.ntro.core.storage.FileWatcher;
import javafx.application.Platform;

public class StorageServiceFx extends StorageServiceJdk {
	
	// FIXME: this should be done in a ThreadService

	@Override
	public void writeTextFile(Path filePath, String content) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				writeTextFileSync(filePath, content);
			}
		});
	}

	@Override
	protected void callWatcher(FileWatcher watcher) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				watcher.fileChanged();
			}
		});
	}
	

}
