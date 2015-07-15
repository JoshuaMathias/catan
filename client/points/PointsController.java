package client.points;

import java.util.ArrayList;

import client.base.*;
import client.facade.Facade;
import client.model.ClientModel;
import client.model.Player;


/**
 * Implementation for the points controller
 */
public class PointsController extends Controller implements IPointsController {

	private IGameFinishedView finishedView;
	private Facade clientFacade;
	
	/**
	 * PointsController constructor
	 * 
	 * @param view Points view
	 * @param finishedView Game finished view, which is displayed when the game is over
	 */
	public PointsController(IPointsView view, IGameFinishedView finishedView) {
		
		super(view);
		
		setFinishedView(finishedView);
		
		clientFacade = Facade.getSingleton();
		
		initFromModel();
	}
	
	public IPointsView getPointsView() {
		
		return (IPointsView)super.getView();
	}
	
	public IGameFinishedView getFinishedView() {
		return finishedView;
	}
	public void setFinishedView(IGameFinishedView finishedView) {
		this.finishedView = finishedView;
	}
	
	public void initFromModel(ClientModel clientModel, int playerIndex) {
		
		ArrayList<Player> players= clientModel.getPlayers();
		
		for(Player player : players) {
			
			if(player.getPlayerIndex() == playerIndex) {
				
				int victoryPoints = player.getVictoryPoints();
				getPointsView().setPoints(victoryPoints);
			}
		}
	}

	private void initFromModel() {
		//<temp>		
		getPointsView().setPoints(5);
		//</temp>
	}
	
}

