package ca.ntro.app.tasks.frontend;

import ca.ntro.core.clock.Tick;

public interface ClockDescriptor {
	
	FrontendSimpleTaskDescriptor<Tick> nextTick();

}
