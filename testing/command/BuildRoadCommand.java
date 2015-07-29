package testing.command;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.facade.ServerFacade;
import shared.gameModel.GameModel;
import shared.gameModel.Map;
import shared.gameModel.Player;
import shared.gameModel.ResourceList;
import shared.gameModel.Road;
import shared.locations.EdgeDirection;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexDirection;
import shared.locations.VertexLocation;

public class BuildRoadCommand {

	private ServerFacade serverFacade;
	private ArrayList<Player> players = new ArrayList<>();
	
	@Before 
	public void setUp() {
		
		serverFacade = ServerFacade.getSingleton();
		
		Player paul = new Player();
		Player daniel = new Player();
		
		paul.setName("paul");
		daniel.setName("daniel");
		
		players.add(paul);
		players.add(daniel);
		
		GameModel newGame = new GameModel();
		newGame.setGameID(0);
		
		Map newMap = new Map();
		newGame.setMap(newMap);
		
		ArrayList<GameModel> games = serverFacade.getGamesList();
		newGame.setPlayers(players);
		
		games.add(newGame);	
	}
	
	@After
	public void tearDown() {
		serverFacade = null;
		return;
	}
	
	@Test
	public void test() {
		
		roadTest(true);
		
		roadTest(false);
	}
	
	private void roadTest(boolean free) {
		
		EdgeLocation roadLocation = new EdgeLocation(new HexLocation(1,0), EdgeDirection.NW);
		HexLocation hexLoc = roadLocation.getHexLoc();
		
		ResourceList beforeResources = players.get(0).getResources();
		ResourceList tempResources = new ResourceList(beforeResources.getBrick(), beforeResources.getOre(), beforeResources.getSheep(),
				beforeResources.getWheat(), beforeResources.getWood());
		
		ResourceList beforeBankResources = serverFacade.getGamesList().get(0).getBank();
		ResourceList tempBankResources = new ResourceList(beforeBankResources.getBrick(),beforeBankResources.getOre(),beforeBankResources.getSheep(),
				beforeBankResources.getWheat(), beforeBankResources.getWood());
		
		int roadAmount = players.get(0).getRoads();
		
		serverFacade.buildRoad(0, roadLocation, free, 0);
		
		int afterRoadAmount = players.get(0).getRoads();
		
		assertEquals(roadAmount, (afterRoadAmount + 1));
		ResourceList afterResources = players.get(0).getResources();
		
		ResourceList afterBankResources = serverFacade.getGamesList().get(0).getBank();
		
		compareResources(tempResources,afterResources, free, false);
		
		if(free == false) {
			compareResources(tempBankResources,afterBankResources,free, true);
		}
		
		Map board = serverFacade.getGamesList().get(0).getMap();
		ArrayList<Road> roads= board.getRoads();
		
		assertTrue(hexLoc.equals(roads.get(0).getLocation().getHexLoc()));
		
	}
	
	private void compareResources(ResourceList beforeResources, ResourceList afterResources, boolean free, boolean banking) {
		
		int beforeBrick = beforeResources.getBrick();
		int beforeOre = beforeResources.getOre();
		int beforeSheep = beforeResources.getSheep();
		int beforeWheat = beforeResources.getWheat();
		int beforeWood = beforeResources.getWood();
		
		int afterBrick = afterResources.getBrick();
		int afterOre = afterResources.getOre();
		int afterSheep = afterResources.getSheep();
		int afterWheat = afterResources.getWheat();
		int afterWood = afterResources.getWood();
		
		if(free == false && banking == false) {
			
		assertEquals(beforeBrick, (afterBrick + 1));
		assertEquals(beforeOre, afterOre);
		assertEquals(beforeSheep, afterSheep);
		assertEquals(beforeWheat, afterWheat);
		assertEquals(beforeWood, (afterWood + 1)); 
		} 
		else if(banking == false && free == true){
			assertEquals(beforeBrick, afterBrick);
			assertEquals(beforeOre, afterOre);
			assertEquals(beforeSheep, afterSheep);
			assertEquals(beforeWheat, afterWheat);
			assertEquals(beforeWood, afterWood); 
		} else {
			assertEquals(beforeBrick, (afterBrick - 1));
			assertEquals(beforeOre, afterOre);
			assertEquals(beforeSheep, afterSheep);
			assertEquals(beforeWheat, afterWheat);
			assertEquals(beforeWood, (afterWood - 1)); 
		}
	}
	
}
