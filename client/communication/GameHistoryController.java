package client.communication;

import java.util.*;


import client.base.*;
import client.facade.Facade;
import client.model.ClientModel;
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
		clientFacade.setGameHistoryController(this);
		
		initFromModel();
	}
	
	@Override
	public IGameHistoryView getView() {
		
		return (IGameHistoryView)super.getView();
	}
	
	public void initFromModel(ClientModel clientModel) {
		
		List<LogEntry> entries = new ArrayList<LogEntry>();
		ArrayList<Player> players = clientModel.getPlayers();
		
		MessageList messages = clientModel.getLog();
		ArrayList<MessageLine> lines = messages.getLines();
		System.out.println("Line Size: " + lines.size());
		
		if(lines.size() == 1) {
			System.out.println(lines.get(0).getMessage());
		}
		
		for(MessageLine line: lines) {
			
			for(Player player : players) {
				
				
				if(player != null && player.getName().equals(line.getSource())) {
					
					String message = line.getMessage();
					CatanColor color = player.getColor();
					entries.add(new LogEntry(color, message));
					System.out.println("IN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
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

