package Testing.CanDos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import shared.definitions.HexType;
import shared.locations.HexLocation;
import client.model.ClientModel;
import client.model.DevCardList;
import client.model.Hex;
import client.model.Map;
import client.model.Player;
import client.model.ResourceList;
import client.model.TurnTracker;

public class CanPlaceRobber {

	private ClientModel clientModel;
	private DevCardList deck;
	private TurnTracker turnTracker;
	private Map map;
	private Player Ife;
	private Player Josh;
	private Player Daniel;
	private Player Paul;
	
	
	//sheep,ore,wheat
	@Before 
	public void setUp() {
		
		map = new Map();
		clientModel = new ClientModel();
		turnTracker = new TurnTracker();
		Ife = new Player();
		Josh = new Player();
		Daniel = new Player();
		Paul= new Player();
		
		ResourceList ifeResources = new ResourceList(0,0,0,0,0);
		ResourceList joshResources = new ResourceList(2,2,0,7,0);
		ResourceList danielResources = new ResourceList(0,1,1,1,0);
		ResourceList paulResources = new ResourceList(5,4,3,1,2);
		
		Ife.setResources(ifeResources);
		Josh.setResources(joshResources);
		Daniel.setResources(danielResources);
		Paul.setResources(paulResources);
		
		ArrayList<Player> playerList = new ArrayList<>();

		Ife.setPlayerID(0);
		Josh.setPlayerID(1);
		Daniel.setPlayerID(2);
		Paul.setPlayerID(3);
		
		playerList.add(Ife);
		playerList.add(Josh);
		playerList.add(Daniel);
		playerList.add(Paul);
		
		
		clientModel.setPlayers(playerList);
		clientModel.setTurnTracker(turnTracker);
		clientModel.setMap(map);
	}
	
	@After
	public void tearDown() {
		clientModel = null;
		return;
	}
	
	@Test
	public void test() {
		
		Hex oreHex = new Hex();
		Hex woodHex = new Hex();
		Hex wheatHex = new Hex();
		Hex brickHex = new Hex();
		Hex deseretHex = new Hex();
		
		oreHex.setLocation(new HexLocation(0,0));
		oreHex.setResource(HexType.ORE);
		woodHex.setLocation(new HexLocation(0,1));
		woodHex.setResource(HexType.WOOD);
		wheatHex.setLocation(new HexLocation(1,0));
		wheatHex.setResource(HexType.WHEAT);
		brickHex.setLocation(new HexLocation(1,-1));
		brickHex.setResource(HexType.BRICK);
		deseretHex.setLocation(new HexLocation(2,1));
		deseretHex.setResource(HexType.DESERT);
		
		ArrayList<Hex> hexArray = new ArrayList<>();
		hexArray.add(oreHex);
		hexArray.add(woodHex);
		hexArray.add(wheatHex);
		hexArray.add(brickHex);
		hexArray.add(deseretHex);
		
		map.setHexes(hexArray);
		
		turnTracker.setCurrentTurn(2);
		turnTracker.setStatus("Playing");
		
		HexLocation hexLoc = new HexLocation(0,1);
	
		assertTrue(clientModel.canPlaceRobber(2, 7, hexLoc));//Daniel places Robber on wood Hex succesfully
		
		turnTracker.setCurrentTurn(0);
		turnTracker.setStatus("Rolling");
		
		HexLocation hexLoc2 = new HexLocation(1,-1);
		assertFalse(clientModel.canPlaceRobber(0, 7, hexLoc2));//Ife cant place Robber because status is on Rolling
		
		turnTracker.setStatus("Playing");
		assertTrue(clientModel.canPlaceRobber(0, 7, hexLoc2));//Ife successfully places Robber. Status is set to Playing now
		
		turnTracker.setCurrentTurn(3);
		HexLocation hexLoc3 = new HexLocation(2,1);
		assertFalse(clientModel.canPlaceRobber(3, 7, hexLoc3));//Paul can't place robber on deseret;
		
		hexLoc3 = new HexLocation(0,0);
		assertTrue(clientModel.canPlaceRobber(3, 7, hexLoc3));//Paul places robber on Ore Hex
		
		HexLocation hexLoc4 = new HexLocation(5,5);
		assertFalse(clientModel.canPlaceRobber(3, 7, hexLoc4));//Hex does not exist
		
		HexLocation hexLoc5 = new HexLocation(0,0);
		assertFalse(clientModel.canPlaceRobber(1, 7, hexLoc5));//Not Joshs turn
		
		turnTracker.setCurrentTurn(1);
		
		assertFalse(clientModel.canPlaceRobber(1, 4, hexLoc5));//Josh rolls a 4
		
		assertTrue(clientModel.canPlaceRobber(1, 7, hexLoc5));//Josh successfully places robber on ore
		
		//**did not test for water because not planning on using water hexes
		
	}
	
	
}
