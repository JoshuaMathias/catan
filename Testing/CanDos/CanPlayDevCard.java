package Testing.CanDos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import shared.definitions.DevCardType;
import client.model.ClientModel;
import client.model.DevCardList;
import client.model.Player;
import client.model.ResourceList;
import client.model.TurnTracker;

public class CanPlayDevCard {
	
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
		
		turnTracker.setCurrentTurn(0);
		turnTracker.setStatus("Playing");
		Ife.setPlayedDevCard(true);
		DevCardList ifeDevCardList = new DevCardList(2,2,1,1,0);
		Ife.setOldDevCards(ifeDevCardList);
		
		assertFalse(clientModel.canPlayDevCard(0, DevCardType.MONOPOLY));
		
	}
}
