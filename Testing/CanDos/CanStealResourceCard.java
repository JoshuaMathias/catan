package Testing.CanDos;


import org.junit.*;

import shared.locations.*;
import client.model.*;

import java.util.ArrayList;

import static org.junit.Assert.* ;

public class CanStealResourceCard {

		private Map map;
		private ClientModel clientModel;
		private TurnTracker turnTracker;
		private Player Ife;
		private Player Josh;
		private Player Daniel;
		private Player Paul;
		
		@Before 
		public void setUp() {
			
			map = new Map();
			clientModel = new ClientModel();
			turnTracker = new TurnTracker();
			Ife = new Player();
			Josh = new Player();
			Daniel = new Player();
			Paul= new Player();
			
			ArrayList<Player> playerList = new ArrayList<>();

			ResourceList ifeResources = new ResourceList(0,0,0,0,0);
			ResourceList joshResources = new ResourceList(0,2,3,0,2);
			ResourceList danielResources = new ResourceList(0,4,0,1,0);
			ResourceList paulResources = new ResourceList(5,4,0,1,0);
			
			Ife.setResources(ifeResources);
			Josh.setResources(joshResources);
			Daniel.setResources(danielResources);
			Paul.setResources(paulResources);
			
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
		public void testOne() {
			
			HexLocation hexLoc = new HexLocation(0,1);
			VertexLocation spot = new VertexLocation(hexLoc,VertexDirection.NorthEast);
		
			VertexObject paulSettlement = new VertexObject();
			paulSettlement.setOwner(3);
			paulSettlement.setLocation(spot);
			
			map.addSettlement(paulSettlement);
			map.setRobber(hexLoc);
			
			Paul.incrementSettlement();
			turnTracker.setStatus("Robbing");
			turnTracker.setCurrentTurn(0);
			
			assertTrue(clientModel.canStealResourceCard(0, 7, 3));
		}
		
		
		
}
