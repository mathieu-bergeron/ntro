package ntro.core.services;

import java.util.Timer;
import java.util.TimerTask;

import ca.ntro.core.services.TimeJdk;
import javafx.application.Platform;

public class TimeFx extends TimeJdk {

	@Override
	public void runAfterDelay(long milliseconds, Runnable runnable) {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(runnable);
			}

		}, milliseconds);
	}

	@Override
	public void runRepeatedly(long milliseconds, Runnable runnable) {
		new Timer().scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(runnable);
			}
			
		}, 0, milliseconds);
	}

}
