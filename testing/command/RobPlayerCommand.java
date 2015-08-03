package testing.command;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.data.GameInfo;
import server.facade.IServerFacade;
import server.facade.ServerFacade;
import shared.gameModel.DevCardList;
import shared.gameModel.GameModel;
import shared.gameModel.Hex;
import shared.gameModel.Map;
import shared.gameModel.Player;
import shared.gameModel.ResourceList;
import shared.gameModel.TurnTracker;
import shared.locations.HexLocation;

public class RobPlayerCommand {

	private IServerFacade serverFacade;
	private Player paul = new Player();
	private Player daniel = new Player();
	private Player ife = new Player();
	private Player josh = new Player();
	private GameModel game;
	private TurnTracker turnTracker;
	
	@Before 
	public void setUp() {
		
		serverFacade = ServerFacade.getSingleton();
	
		paul.setPlayerIndex(0);
		daniel.setPlayerIndex(1);
		ife.setPlayerIndex(2);
		josh.setPlayerIndex(3);
		
		game = new GameModel();
		game.setGameID(0);
		
		ArrayList<Player> players = new ArrayList<>();
		players.add(paul);
		players.add(daniel);
		players.add(ife);
		players.add(josh);
		
		paul.setName("paul");
		daniel.setName("daniel");
		ife.setName("ife");
		josh.setName("josh");
		
		daniel.setDiscarded(false);
		ife.setDiscarded(false);
		josh.setDiscarded(false);
		
		ResourceList paulsResources = new ResourceList(9,9,9,9,9);
		paul.setResources(paulsResources);
		DevCardList oldDevCardList = new DevCardList(1,1,1,1,1);
		paul.setOldDevCards(oldDevCardList);
		
		ResourceList danielsResources = new ResourceList(1,1,1,1,1);
		daniel.setResources(danielsResources);
		
		ResourceList ifesResources = new ResourceList(2,2,2,2,2);
		ife.setResources(ifesResources);
		
		ResourceList joshsResources = new ResourceList(2,2,2,2,2);
		josh.setResources(joshsResources);
		
		Map board = new Map();
		serverFacade.createGame(false, false, false, "default game");
		game = serverFacade.getGamesList().get(0);
		
		game.setMap(board);
		game.setPlayers(players);
		
		
		turnTracker = new TurnTracker();
		turnTracker.setStatus("Playing");
		turnTracker.setCurrentTurn(0);
		game.setTurnTracker(turnTracker);
		serverFacade.addGameToList(game);
	}
	
	@After
	public void tearDown() {
		serverFacade = null;
		return;
	}	
	
	
	@Test
	public void test() {
		
		HexLocation hexLocation = new HexLocation(2,2);
		serverFacade.robPlayer(0, 1, hexLocation, 0);
		
		System.out.println(paul.getResources().getTotal());
		System.out.println(daniel.getResources().getTotal());
		
		
	}

}
