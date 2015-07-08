package client.serverproxy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.facade.Facade;
import client.model.ClientModel;
import client.model.Player;
import client.model.ResourceList;
import client.model.TradeOffer;
import client.model.TurnTracker;

public class ServerProxyTest {

	private Facade facade;
	private Facade facade2;
	private Facade facade3;
	private Facade facade4;
	private TurnTracker turnTracker;
	private TradeOffer tradeOffer;
	private Player Ife;
	private Player Josh;
	private Player Daniel;
	private Player Paul;
	
	@Before 
	public void setUp() {
		facade = new Facade("localhost");
		turnTracker = new TurnTracker();
		String u = "Ife";
		String p = "testpass";
		facade.register(u, p);
		facade.login(u, p);
		facade.joinGame("3", "red");
		String u2 = "Josh";
		String p2 = "testpass";
		facade2.register(u2, p2);
		facade2.login(u2, p2);
		facade2.joinGame("3", "green");
		String u3 = "Daniel";
		String p3 = "testpass";
		facade3.register(u3, p3);
		facade3.login(u3, p3);
		facade3.joinGame("3", "blue");
		String u4 = "Paul";
		String p4 = "testpass";
		facade4.register(u4, p4);
		facade4.login(u4, p4);
		facade4.joinGame("3", "yellow");
		
		Ife = new Player();
		Josh = new Player();
		Daniel = new Player();
		Paul= new Player();
		
		ResourceList ifeResources = new ResourceList(1,4,3,2,1);
		ResourceList joshResources = new ResourceList(0,2,3,0,2);
		ResourceList danielResources = new ResourceList(0,4,0,1,0);
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
		
		
		facade.setPlayers(playerList);
		facade.setTurnTracker(turnTracker);
	}
	@Test
	public void testRollNumber() {
		facade.rollNumber(0, 5);
	}

	@Test
	public void testRoadBuilding() {
		
	}

	@Test
	public void testFinishTurn() {

	}

	@Test
	public void testBuyDevCard() {

	}

	@Test
	public void testYearOfPlenty() {

	}

	@Test
	public void testSoldier() {

	}

	@Test
	public void testMonopoly() {

	}

	@Test
	public void testBuildRoad() {

	}

	@Test
	public void testBuildSettlement() {

	}

	@Test
	public void testBuildCity() {

	}

	@Test
	public void testOfferTrade() {

	}

	@Test
	public void testAcceptTrade() {

	}

	@Test
	public void testDiscardCards() {

	}

	@Test
	public void testGetClientModel() {

	}
	
	@After
	public void tearDown() {
		facade = null;
		return;
	}

}
