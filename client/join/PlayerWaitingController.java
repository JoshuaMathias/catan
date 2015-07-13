package client.join;

import java.util.ArrayList;
import java.util.List;

import client.base.*;
import client.data.PlayerInfo;
import client.facade.Facade;


/**
 * Implementation for the player waiting controller
 */
public class PlayerWaitingController extends Controller implements IPlayerWaitingController {

	private Facade clientFacade;
	
	public PlayerWaitingController(IPlayerWaitingView view) {
		super(view);
		clientFacade=Facade.getSingleton();
	}

	@Override
	public IPlayerWaitingView getView() {
		return (IPlayerWaitingView)super.getView();
	}

	@Override
	public void start() {
		List<PlayerInfo> playersList = clientFacade.gamesList().getGames().get(clientFacade.getCurrentGameId()).getPlayers();
		PlayerInfo[] players = new PlayerInfo[playersList.size()];
		getView().setPlayers(players);
		getView().showModal();
	}

	@Override
	public void addAI() {

		// TEMPORARY
		getView().closeModal();
	}

}

