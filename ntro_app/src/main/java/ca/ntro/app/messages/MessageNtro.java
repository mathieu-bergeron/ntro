package ca.ntro.app.messages;

import ca.ntro.app.services.MessageServiceNtro;

public class MessageNtro implements Message {
	
	private MessageServiceNtro messageService;

	public MessageServiceNtro getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageServiceNtro messageService) {
		this.messageService = messageService;
	}


	public void send() {
		getMessageService().sendMessage(this);
	}

}
