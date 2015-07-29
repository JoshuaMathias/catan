package testing.command;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.facade.ServerFacade;
import shared.gameModel.GameModel;
import shared.gameModel.Hex;
import shared.gameModel.Map;
import shared.gameModel.Port;

public class CreateGameCommand {

	private GameModel gameModel; 
	private ServerFacade serverFacade;
	
	@Before 
	public void setUp() {
		
		serverFacade = ServerFacade.getSingleton();
		
		
	}
	
	@After
	public void tearDown() {
		gameModel = null;
		return;
	}
	
	@Test
	public void test() {
		
		serverFacade.createGame(true, true, true, "default game");
		ArrayList<GameModel> gamesList = serverFacade.getGamesList();
		GameModel game = gamesList.get(0);
		
		Map map = game.getMap();
		ArrayList<Port> ports= map.getPorts();
		ArrayList<Hex> hexes= map.getHexes();
		
		for(Port port : ports) {
			System.out.println(port.toString());
		}
		
		System.out.println("Hexes: " + hexes.size());
		
		for(Hex hex : hexes) {
			System.out.println(hex.toString());
		}
		
		assertTrue(true);
	}
}
