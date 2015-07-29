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
import shared.locations.HexLocation;
import shared.locations.VertexDirection;
import shared.locations.VertexLocation;

public class BuildCityCommand {

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
		
		Player playerOne = players.get(0);
		
		int cityBeforeAmount = playerOne.getCities();
		int settlementBeforeAmount = playerOne.getSettlements();
		int victoryPointsBeforeAmount = playerOne.getVictoryPoints();
		ResourceList beforeResourceList= playerOne.getResources();
		ResourceList tempResourceList = new ResourceList(beforeResourceList.getBrick(),beforeResourceList.getOre(),
				beforeResourceList.getSheep(),beforeResourceList.getWheat(),beforeResourceList.getWood());
		
		ResourceList beforeBank = serverFacade.getGamesList().get(0).getBank();
		
		ResourceList tempBank = new ResourceList(beforeBank.getBrick(),beforeBank.getOre(), beforeBank.getSheep(),
									beforeBank.getWheat(), beforeBank.getWood());
		
		serverFacade.buildCity(0, vertexLocation, 0);
		
		int cityAfterAmount = playerOne.getCities();
		int settlementAfterAmount = playerOne.getSettlements();
		int victoryPointsAfterAmount = playerOne.getVictoryPoints();
		
		ResourceList afterResourceList = playerOne.getResources();
		
		ResourceList afterBank = serverFacade.getGamesList().get(0).getBank();
		
		compareResources(tempResourceList,afterResourceList);
		
		compareBankResources(tempBank,afterBank);
		
		assertEquals(cityBeforeAmount,(cityAfterAmount + 1));
		assertEquals(settlementBeforeAmount,(settlementAfterAmount - 1));
		assertEquals(victoryPointsBeforeAmount,(victoryPointsAfterAmount - 1));
		
	}
	
	private void compareResources(ResourceList beforeResources, ResourceList afterResources) {
		
		int beforeBrickCount = beforeResources.getBrick();
		int beforeWheatCount = beforeResources.getWheat();
		int beforeWoodCount = beforeResources.getWood();
		int beforeSheepCount = beforeResources.getSheep();
		int beforeOreCount = beforeResources.getOre();
		
		int afterBrickCount = afterResources.getBrick();
		int afterWheatCount = afterResources.getWheat();
		int afterWoodCount = afterResources.getWood();
		int afterSheepCount = afterResources.getSheep();
		int afterOreCount = afterResources.getOre();
		
		assertEquals(beforeBrickCount,afterBrickCount);
		assertEquals(beforeWoodCount,afterWoodCount);
		assertEquals(beforeSheepCount,afterSheepCount);
	
		assertEquals(beforeWheatCount,(afterWheatCount + 2));
		assertEquals(beforeOreCount,(afterOreCount + 3));
	}
	
	private void compareBankResources(ResourceList beforeResources, ResourceList afterResources) {
		
		int beforeBrickCount = beforeResources.getBrick();
		int beforeWheatCount = beforeResources.getWheat();
		int beforeWoodCount = beforeResources.getWood();
		int beforeSheepCount = beforeResources.getSheep();
		int beforeOreCount = beforeResources.getOre();
		
		int afterBrickCount = afterResources.getBrick();
		int afterWheatCount = afterResources.getWheat();
		int afterWoodCount = afterResources.getWood();
		int afterSheepCount = afterResources.getSheep();
		int afterOreCount = afterResources.getOre();
		
		assertEquals(beforeBrickCount,afterBrickCount);
		assertEquals(beforeWoodCount,afterWoodCount);
		assertEquals(beforeSheepCount,afterSheepCount);
		
		assertEquals(beforeWheatCount,(afterWheatCount - 2));
		assertEquals(beforeOreCount,(afterOreCount - 3));
	}
}
