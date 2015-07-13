package client.communication;

import client.base.*;
import client.facade.Facade;


/**
 * Chat controller implementation
 */
public class ChatController extends Controller implements IChatController {

	private Facade clientFacade; 
	
	public ChatController(IChatView view) {
		
		super(view);
		clientFacade = Facade.getSingleton();
	}

	@Override
	public IChatView getView() {
		return (IChatView)super.getView();
	}

	@Override
	public void sendMessage(String message) {
		clientFacade.sendChat(message);
	}

}

