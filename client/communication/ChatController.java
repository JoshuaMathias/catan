package client.communication;

import java.util.ArrayList;
import java.util.List;

import shared.definitions.CatanColor;
import client.base.*;
import client.facade.Facade;
import client.model.ClientModel;
import client.model.MessageLine;
import client.model.MessageList;
import client.model.Player;


/**
 * Chat controller implementation
 */
public class ChatController extends Controller implements IChatController {

	private Facade clientFacade; 
	
	public ChatController(IChatView view) {
		
		super(view);
		clientFacade = Facade.getSingleton();
		//clientFacade.setChatController(this);
	}

	@Override
	public IChatView getView() {
		return (IChatView)super.getView();
	}

	@Override
	public void sendMessage(String message) {
		clientFacade.sendChat(message);
	}
	
	public void initFromModel(ClientModel clientModel) {
		
		ArrayList<Player> players = clientModel.getPlayers();
		MessageList messages = clientModel.getChat();
		
		ArrayList<MessageLine> messageArray = messages.getLines();
		
		List<LogEntry> entries = new ArrayList<LogEntry>();
		
		for(MessageLine message : messageArray) {
		
			String username = message.getSource();
			
			for(Player player: players) {
				
				if(player != null && player.getName().equals(username)) {
					
					CatanColor color = player.getColor();
					String messageLine = message.getMessage();
					
					entries.add(new LogEntry(color, messageLine));
				}
			}
		}
		
		getView().setEntries(entries);
	}

}

