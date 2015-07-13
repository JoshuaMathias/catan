package client.communication;

import java.util.*;

import client.base.*;
import client.facade.Facade;
import client.model.ClientModel;
import client.model.Map;
import client.model.MessageLine;
import client.model.MessageList;
import client.model.Player;
import shared.definitions.*;


/**
 * Game history controller implementation
 */
public class GameHistoryController extends Controller implements IGameHistoryController {

	private Facade clientFacade;
	
	public GameHistoryController(IGameHistoryView view) {
		
		super(view);
		
		clientFacade = Facade.getSingleton();
//		clientFacade.setGameHistoryController(this);
		
		initFromModel();
	}
	
	@Override
	public IGameHistoryView getView() {
		
		return (IGameHistoryView)super.getView();
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
	
	private void initFromModel() {
		
		//<temp>
		
		List<LogEntry> entries = new ArrayList<LogEntry>();
		entries.add(new LogEntry(CatanColor.brown, "This is a brown message"));
		entries.add(new LogEntry(CatanColor.orange, "This is an orange message ss x y z w.  This is an orange message.  This is an orange message.  This is an orange message."));
		entries.add(new LogEntry(CatanColor.brown, "This is a brown message"));
		entries.add(new LogEntry(CatanColor.orange, "This is an orange message ss x y z w.  This is an orange message.  This is an orange message.  This is an orange message."));
		entries.add(new LogEntry(CatanColor.brown, "This is a brown message"));
		entries.add(new LogEntry(CatanColor.orange, "This is an orange message ss x y z w.  This is an orange message.  This is an orange message.  This is an orange message."));
		entries.add(new LogEntry(CatanColor.brown, "This is a brown message"));
		entries.add(new LogEntry(CatanColor.orange, "This is an orange message ss x y z w.  This is an orange message.  This is an orange message.  This is an orange message."));
		
		getView().setEntries(entries);
	
		//</temp>
	}
	
}

