package client.serverproxy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import shared.locations.EdgeDirection;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexDirection;
import shared.locations.VertexLocation;

import client.facade.Facade;
import client.model.*;

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
	private boolean hasSetup = true;

	@Before
	public void setUp() 
	{
		if (hasSetup) 
		{
			hasSetup=false;
			facade = new Facade("localhost");
			facade.createGame(true, true, true, "test");
			turnTracker = new TurnTracker();

			String u = "Ife";
			String p = "testpass";
			facade.register(u, p);
			facade.login(u, p);
			facade.joinGame("3", "red");

			String u2 = "Josh";
			String p2 = "testpass";
			facade2 = new Facade("localhost");
			facade2.register(u2, p2);
			facade2.login(u2, p2);
			facade2.joinGame("3", "green");

			String u3 = "Daniel";
			String p3 = "testpass";
			facade3 = new Facade("localhost");
			facade3.register(u3, p3);
			facade3.login(u3, p3);
			facade3.joinGame("3", "blue");

			String u4 = "Paul";
			String p4 = "testpass";
			facade4 = new Facade("localhost");
			facade4.register(u4, p4);
			facade4.login(u4, p4);
			facade4.joinGame("3", "yellow");

			Ife = new Player();
			Josh = new Player();
			Daniel = new Player();
			Paul = new Player();

			ResourceList ifeResources = new ResourceList(1, 4, 3, 2, 1);
			ResourceList joshResources = new ResourceList(0, 2, 3, 0, 2);
			ResourceList danielResources = new ResourceList(0, 4, 0, 1, 0);
			ResourceList paulResources = new ResourceList(5, 4, 3, 1, 2);

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
	}

	@Test
	public void testSendChat() {
		System.out.println("testSendChat");
		facade.sendChat(0, "Hello World");
	}

	@Test
	public void testRollNumber() {
		System.out.println("testRollNumber");
		facade.rollNumber(0, 5);
	}

	@Test
	public void testRoadBuilding() {
		System.out.println("testRoadBuilding");
		HexLocation hexLoc = new HexLocation(0, 0);
		EdgeLocation loc = new EdgeLocation(hexLoc, EdgeDirection.North);
		HexLocation hexLoc2 = new HexLocation(0, 0);
		EdgeLocation loc2 = new EdgeLocation(hexLoc, EdgeDirection.North);
		facade.roadBuilding(0, loc, loc2);
	}

	@Test
	public void testFinishTurn() {
		System.out.println("testFinishTurn");
		facade.finishTurn(0);
	}

	@Test
	public void testBuyDevCard() {
		System.out.println("testBuyDevCard");
		facade.buyDevCard(0);
	}

	@Test
	public void testYearOfPlenty() {
		System.out.println("testYearOfPlenty");
		facade.yearOfPlenty(0, "Wool", "Brick");
	}

	@Test
	public void testSoldier() {
		System.out.println("testSoldier");
		HexLocation hexLoc = new HexLocation(0, 0);
		facade.soldier(0, 1, hexLoc);
	}

	@Test
	public void testMonopoly() {
		System.out.println("testMonopoly");
		facade.monopoly("Brick", 0);
	}

	@Test
	public void testMonument() {
		System.out.println("testMonument");
		facade.monument(0);
	}

	@Test
	public void testBuildRoad() {
		System.out.println("testBuildRoad");
		HexLocation hexLoc = new HexLocation(0, 0);
		EdgeLocation loc = new EdgeLocation(hexLoc, EdgeDirection.North);
		facade.buildRoad(0, loc, true);
	}

	@Test
	public void testBuildSettlement() {
		System.out.println("testBuildSettlement");
		HexLocation hexLoc = new HexLocation(0, 0);
		VertexLocation vertLoc = new VertexLocation(hexLoc,
				VertexDirection.East);
		facade.buildSettlement(0, vertLoc, true);
	}

	@Test
	public void testBuildCity() {
		System.out.println("testBuildCity");
		HexLocation hexLoc = new HexLocation(3, 4);
		VertexLocation vertLoc = new VertexLocation(hexLoc,
				VertexDirection.NorthEast);
		facade.buildCity(0, vertLoc);
	}

	@Test
	public void testOfferTrade() {
		System.out.println("testOfferTrade");
		ResourceList offer = new ResourceList(1, -4, 3, -2, 1);
		facade.offerTrade(0, offer, 1);
	}

	@Test
	public void testAcceptTrade() {
		System.out.println("testAcceptTrade");
		facade.acceptTrade(1, true);
	}

	@Test
	public void testDiscardCards() {
		System.out.println("testDiscardCards");
		ResourceList discardedCards = new ResourceList(1, 1, 1, 1, 1);
		facade.discardCards(2, discardedCards);
	}

	@Test
	public void testGetClientModel() {
		System.out.println("testGetClientModel");
		facade.getClientModel(1);
	}

}
