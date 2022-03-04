package ca.ntro.app.services;

import ca.ntro.app.messages.Message;
import ca.ntro.app.messages.MessageNtro;
import ca.ntro.core.reflection.observer.Observation;
import ca.ntro.core.task_graphs.task_graph.SimpleTask;

public interface MessageService {

	<MSG extends MessageNtro> MSG newMessage(Class<MSG> messageClass);

	<MSG extends Message> void registerMessageHandler(Class<MSG> messageClass, SimpleTask messageHandlerTask);

	void registerObserverTask(String revisionsName, SimpleTask revisionsHandlerTask);
	
	void sendMessage(Message message);
	void pushObservation(String revisionsName, Observation<?> observation);

}
