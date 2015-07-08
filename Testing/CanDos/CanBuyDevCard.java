package Testing.CanDos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.model.*;

public class CanBuyDevCard {
	
	private ClientModel clientModel;
	private DevCardList deck;
	private TurnTracker turnTracker;
	private Player Ife;
	private Player Josh;
	private Player Daniel;
	private Player Paul;
	
	
	//sheep,ore,wheat
	@Before 
	public void setUp() {
		
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
	}
	
	@After
	public void tearDown() {
		clientModel = null;
		return;
	}
	
	@Test
	public void test() {
		
		deck = new DevCardList(3,3,3,3,3);
		clientModel.setDeck(deck);
		
		turnTracker = new TurnTracker();
		clientModel.setTurnTracker(turnTracker);
		
		turnTracker.setStatus("Playing");
		turnTracker.setCurrentTurn(0);
		
		assertFalse(clientModel.canBuyDevCard(0));//Ife doesn't have any resources to buy a development card.
		
		turnTracker.setCurrentTurn(2);
		assertTrue(clientModel.canBuyDevCard(2));//Daniel does have enough resource cards to buy a development card.
		
		assertFalse(clientModel.canBuyDevCard(3));//Paul has enough resources to buy a development card, but isn't his turn.
		
		turnTracker.setCurrentTurn(3);
		assertTrue(clientModel.canBuyDevCard(3));//Now Paul's turn. Can buy development card
		
		turnTracker.setCurrentTurn(1);
		assertFalse(clientModel.canBuyDevCard(1));//Josh is just short a sheep of buying a development card
	}
}
