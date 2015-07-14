package client.turntracker;

import java.util.ArrayList;

import shared.definitions.CatanColor;
import client.base.*;
import client.facade.Facade;
import client.model.ClientModel;
import client.model.Player;
import client.model.TurnTracker;


/**
 * Implementation for the turn tracker controller
 */
public class TurnTrackerController extends Controller implements ITurnTrackerController {

	private Facade clientFacade;
	
	public TurnTrackerController(ITurnTrackerView view) {
		
		super(view);
		
		clientFacade = Facade.getSingleton();
		
		clientFacade.setTurnTrackerController(this);
		
		initFromModel();
	}
	
	@Override
	public ITurnTrackerView getView() {
		
		return (ITurnTrackerView)super.getView();
	}

	@Override
	public void endTurn() {

	}
	
	public void initFromModel(ClientModel clientModel){
		ArrayList<Player> players = clientModel.getPlayers();
		TurnTracker turnTracker = clientModel.getTurnTracker();
		int currentTurn = turnTracker.getCurrentTurn();
		int largestArmyIndex = turnTracker.getLargestArmy();
		int longestRoadIndex = turnTracker.getLongestRoad();
		
		
		for(Player player: players){//Putting players names on the screen
			if(player != null){
				int playerIndex = player.getPlayerIndex();
				getView().initializePlayer(playerIndex, player.getName(), player.getColor());
				
				boolean highlight = false;
				boolean largestArmy = false;
				boolean longestRoad = false;
				if(playerIndex == currentTurn){
					highlight = true;
				}
				if(playerIndex == largestArmyIndex){
					largestArmy = true;
				}
				if(playerIndex == longestRoadIndex){
					longestRoad = true;
				}
				
				getView().updatePlayer(playerIndex, player.getVictoryPoints(), highlight, largestArmy, longestRoad);
			}
		}
		
	}
	
	public void initFromModel(CatanColor localPlayerColor){
		getView().setLocalPlayerColor(localPlayerColor);
	}
	
	private void initFromModel() {
		//<temp>
		getView().setLocalPlayerColor(CatanColor.white);
		//</temp>
	}
	

}

