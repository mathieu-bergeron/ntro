package ca.ntro.app.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.ntro.app.messages.Message;
import ca.ntro.app.messages.MessageNtro;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.observer.Modified;
import ca.ntro.core.reflection.observer.Observation;
import ca.ntro.core.task_graphs.task_graph.SimpleTask;

public class MessageServiceNtro implements MessageService {
	
	private Map<Class<? extends Message>, Set<SimpleTask>> messageHandlers = new HashMap<>();
	private Map<String, Set<SimpleTask>> observationHandlers = new HashMap<>();

	@Override
	public <MSG extends MessageNtro> MSG newMessage(Class<MSG> messageClass) {
		MSG message = Ntro.factory().newInstance(messageClass);
		
		message.setMessageService(this);
		
		return message;
	}

	@Override
	public <MSG extends Message> void registerMessageHandler(Class<MSG> messageClass, SimpleTask messageHandlerTask) {
		Set<SimpleTask> handlers = messageHandlers.get(messageClass);
		if(handlers == null) {
			handlers = new HashSet<>();
			messageHandlers.put(messageClass, handlers);
		}
		
		handlers.add(messageHandlerTask);
	}

	@Override
	public void registerObserverTask(String observableName, SimpleTask observationHandlerTask) {
		Set<SimpleTask> handlers = observationHandlers.get(observableName);
		if(handlers == null) {
			handlers = new HashSet<>();
			observationHandlers.put(observableName, handlers);
		}

		handlers.add(observationHandlerTask);
	}

	@Override
	public void sendMessage(Message message) {
		Set<SimpleTask> handlers = messageHandlers.get(message.getClass());
		
		// XXX: clone to simulate the message is serialized
		//      and deserialized
		Message sentMessage = (Message) Ntro.reflection().clone(message);
		
		if(handlers != null) {
			
			for(SimpleTask handler : handlers) {

				handler.addResult(sentMessage);
			}
		}
	}

	@Override
	public void pushObservation(String observationName, Observation<?> observation) {
		Set<SimpleTask> handlers = observationHandlers.get(observationName);
		
		if(handlers != null) {
			
			for(SimpleTask handler : handlers) {

				handler.addResult((Modified<?>) observation);
			}
		}
	}

}
