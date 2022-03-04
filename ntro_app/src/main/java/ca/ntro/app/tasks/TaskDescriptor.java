package ca.ntro.app.tasks;

public interface TaskDescriptor<O> {
	
	String id();
	
	boolean hasType();
	Class<O> type();

}
