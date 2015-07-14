package client.turntracker;

import shared.definitions.CatanColor;
import client.base.*;
import client.facade.Facade;


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
	
	public void initFromModel(int playerIndex, String playerName, CatanColor playerColor){
		getView().setLocalPlayerColor(playerColor);
		getView().initializePlayer(playerIndex, playerName, playerColor);
	}
	
	private void initFromModel() {
		//<temp>
		getView().setLocalPlayerColor(CatanColor.blue);
		//</temp>
	}
	

}

