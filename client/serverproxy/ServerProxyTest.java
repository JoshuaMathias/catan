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

	@Before
	public void setUp() 
	{
		facade = new Facade("localhost");
		facade.createGame(false, false, false, "test");
		turnTracker = new TurnTracker();

		String u = "Ife"+Integer.toString(Facade.count);
		String p = "testpass";
		facade.register(u, p);
		facade.login(u, p);
		facade.joinGame(Integer.toString(3+Facade.count), "red");

		String u2 = "Josh"+Integer.toString(Facade.count);
		String p2 = "testpass";
		facade2 = new Facade("localhost");
		facade2.register(u2, p2);
		facade2.login(u2, p2);
		facade2.joinGame(Integer.toString(3+Facade.count), "green");

		String u3 = "Daniel"+Integer.toString(Facade.count);
		String p3 = "testpass";
		facade3 = new Facade("localhost");
		facade3.register(u3, p3);
		facade3.login(u3, p3);
		facade3.joinGame(Integer.toString(3+Facade.count), "blue");

		String u4 = "Paul"+Integer.toString(Facade.count);
		String p4 = "testpass";
		facade4 = new Facade("localhost");
		facade4.register(u4, p4);
		facade4.login(u4, p4);
		facade4.joinGame(Integer.toString(3+Facade.count), "yellow");
		
		Facade.count++;
		
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
		facade.yearOfPlenty(0, "wood", "wheat");
	}

	@Test
	public void testSoldier() {
		System.out.println("testSoldier");
		
		//Player 1 puts down a house on one side of the (0,0)
		HexLocation hexLoc = new HexLocation(0, 0);
		VertexLocation vertLoc = new VertexLocation(hexLoc,
				VertexDirection.East);
		facade.buildSettlement(0, vertLoc, true);
		
		//Player 2 puts down a house on one side of the (0,0)
		HexLocation hexLoc1 = new HexLocation(0, 0);
		VertexLocation vertLoc1 = new VertexLocation(hexLoc1,
				VertexDirection.West);
		facade2.buildSettlement(1, vertLoc1, true);
		
		//Both players get some resource to steal
		facade.rollNumber(0, 11);
		
		facade.soldier(0, 1,  new HexLocation(0, 0));
	}

	@Test
	public void testMonopoly() {
		System.out.println("testMonopoly");
		facade.monopoly("wood", 0);
	}

	@Test
	public void testMonument() {
		System.out.println("testMonument");
		facade.monument(0);
	}

	//Need to find out what we are gonna do about North(what the given code has) and N what the server expects
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
		HexLocation hexLoc = new HexLocation(0, 0);
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
		//Need to have a trade offered before you can accept it or reject it
		System.out.println("testAcceptTrade");
		ResourceList offer = new ResourceList(132, -465, 348, -298, 141);
		facade.offerTrade(0, offer, 1);
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
	
	@Test
	public void testRobPlayer() {
		System.out.println("testRobPlayer");
		
		//Player 1 puts down a house on one side of the (0,0)
		HexLocation hexLoc = new HexLocation(0, 0);
		VertexLocation vertLoc = new VertexLocation(hexLoc,
				VertexDirection.East);
		facade.buildSettlement(0, vertLoc, true);
		
		//Player 2 puts down a house on one side of the (0,0)
		HexLocation hexLoc1 = new HexLocation(0, 0);
		VertexLocation vertLoc1 = new VertexLocation(hexLoc1,
				VertexDirection.West);
		facade2.buildSettlement(1, vertLoc1, true);
		
		//Both players get some resource to steal
		facade.rollNumber(0, 11);
		
		facade.robPlayer(0, 1, new HexLocation(0,0));
	}
	
	@Test
	public void maritimeTrade() {
		//Make sure that the resources you ask for are real
		System.out.println("maritimeTrade");
		facade.maritimeTrade(0, 2, "wood", "sheep");
	}

}
