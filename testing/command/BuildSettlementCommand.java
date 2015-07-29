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
import shared.gameModel.VertexObject;
import shared.locations.HexLocation;
import shared.locations.VertexDirection;
import shared.locations.VertexLocation;

public class BuildSettlementCommand {
	
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
		
		VertexLocation vertexLocation = new VertexLocation(new HexLocation(3,0), VertexDirection.E);
		free(true, vertexLocation,0);
		
		vertexLocation = new VertexLocation(new HexLocation(-1,-1), VertexDirection.NE);
		free(false,vertexLocation,1);
	}
	
	private void free(boolean free, VertexLocation vertexLocation, int playerId) {
		
		GameModel gameModel = serverFacade.getGamesList().get(0);
		ArrayList<VertexObject> settlementArray = gameModel.getMap().getSettlements();
		
		int settlementAmount = 0;
		for(VertexObject settlement : settlementArray) {
			
			if(settlement.getOwner() == playerId) {
				settlementAmount++;
			}
		}
		
		assertTrue(settlementAmount == 0);//Tests to make sure the player hasn't placed a settlement yet
		
		Player player = gameModel.getPlayers().get(playerId);
		ResourceList beforeBuildResourceList = player.getResources();
		
		ResourceList tempBeforeBuildResourceList = new ResourceList(beforeBuildResourceList.getBrick(),beforeBuildResourceList.getWood(),
				beforeBuildResourceList.getWheat(), beforeBuildResourceList.getSheep(), beforeBuildResourceList.getOre());
		
		
		serverFacade.buildSettlement(playerId, vertexLocation, free, 0);
		
		gameModel = serverFacade.getGamesList().get(0);
		
		Map board = gameModel.getMap();
		
		player = gameModel.getPlayers().get(playerId);
		ResourceList afterBuildResourceList = player.getResources();
	
		testResources(tempBeforeBuildResourceList, afterBuildResourceList, free);
		
		settlementAmount = 0;
		for(VertexObject settlement : settlementArray) {
			
			if(settlement.getOwner() == playerId) {
				settlementAmount++;
			}
		}
		assertTrue(settlementAmount == 1);
		
		VertexObject playerSettlement = board.getSettlements().get(playerId);

		int owner = playerSettlement.getOwner();
		VertexLocation mapVertex = playerSettlement.getLocation();
		
		assertTrue(owner == playerId);
		assertTrue(mapVertex.equals(vertexLocation));
	}
	
	private void testResources(ResourceList beforeBuildResourceList, ResourceList afterBuildResourceList, boolean free) {
		
		int brickCountBeforeBuild = beforeBuildResourceList.getBrick();
		int woodCountBeforeBuild = beforeBuildResourceList.getWood();
		int sheepCountBeforeBuild = beforeBuildResourceList.getSheep();
		int wheatCountBeforeBuild = beforeBuildResourceList.getWheat();
		int oreCountBeforeBuild = beforeBuildResourceList.getOre();
		
		int brickCountAfterBuild = afterBuildResourceList.getBrick();
		int woodCountAfterBuild = afterBuildResourceList.getWood();
		int sheepCountAfterBuild = afterBuildResourceList.getSheep();
		int wheatCountAfterBuild = afterBuildResourceList.getWheat();
		int oreCountAfterBuild = afterBuildResourceList.getOre();
		
		if(free == true) {
			assertEquals(brickCountBeforeBuild,brickCountAfterBuild);
			assertEquals(woodCountBeforeBuild,woodCountAfterBuild);
			assertEquals(sheepCountBeforeBuild,sheepCountAfterBuild);
			assertEquals(wheatCountBeforeBuild,wheatCountAfterBuild);
			assertEquals(oreCountBeforeBuild,oreCountAfterBuild);
		}
		else {
			assertEquals(brickCountBeforeBuild,(brickCountAfterBuild+1));
			assertEquals(woodCountBeforeBuild,(woodCountAfterBuild+1));
			assertEquals(sheepCountBeforeBuild,(sheepCountAfterBuild+1));
			assertEquals(wheatCountBeforeBuild,(wheatCountAfterBuild+1));
			assertEquals(oreCountBeforeBuild,oreCountAfterBuild);
		}
		
	}
}
