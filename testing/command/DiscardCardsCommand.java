package testing.command;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.facade.ServerFacade;
import shared.gameModel.GameModel;
import shared.gameModel.Player;
import shared.gameModel.ResourceList;
import shared.gameModel.TurnTracker;

public class DiscardCardsCommand {

	private ServerFacade serverFacade;
	private Player paul = new Player();
	private Player daniel = new Player();
	private Player ife = new Player();
	private Player josh = new Player();
	private GameModel game;
	
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
		
		game.setPlayers(players);
		
		TurnTracker turnTracker = new TurnTracker();
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
		
		ResourceList discardResourceList = new ResourceList(4,4,4,4,4);
		paul.setResources(discardResourceList);
		serverFacade.discardCards(0, discardResourceList, 0);
		System.out.println(paul.getResources().getTotal());
	}

}
