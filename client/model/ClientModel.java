package client.model;

import java.util.ArrayList;

import shared.definitions.ResourceType;

/**
 * Class represents model of game on client side
 * @author Ife's Group
 *
 */
public class ClientModel {
	private ResourceList bank;
	private MessageList chat;
	private MessageList log;
	private Map map;
	private ArrayList<Player> players;
	private TradeOffer tradeOffer;
	private TurnTracker turnTracker;
	private int version;
	private int winner = -1;

	/**
	 * checks newClientModel version against current client model version and updates if versions differ
	 * @param newClientModel
	 * @pre newClientModel != null
	 * @post if version number is different, newClientModel replaces current client Model, otherwise, nothing happens.
	 */
	public void updateClientModel(ClientModel newClientModel){
		
	}
	
	/**
	 * checks whether a player has the longest road
	 * @pre none
	 * @post returns integer of the index of the player with the longest road. Player has longest road if road length is 5 and more than any other player. If nobody has longest road, returns -1
	 */
	public int checkLongestRoad() {
		
		int previousLongest = turnTracker.getLongestRoad();
		int playerIndex = 0;
		int highestRoadCount = players.get(0).getRoads();
		
		for (int i = 1; i < 4; i++){
			int toCompare = players.get(i).getRoads();
			if (toCompare > highestRoadCount){
				highestRoadCount = toCompare;
				playerIndex = i;
			}
		}
		
		if(highestRoadCount >= 5){
			if(previousLongest == -1){
				return playerIndex;
			}
			else if(players.get(previousLongest).getRoads() == players.get(playerIndex).getRoads()){
				return previousLongest;
			}
			else{
				return playerIndex;
			}
		}
		else{
			return -1;
		}
	}
	
	/**
	 * checks whether a player has the largest army
	 * @pre none
	 * @post returns integer representing the index of the player with the largest army. Player has largest army if they have played at least 3 soldier cards and more soldier cards than any other player. If nobody had largest road, returns -1
	 */
	public int checkLargestArmy() {
		
		int previousLargest = turnTracker.getLargestArmy();
		int playerIndex = 0;
		int highestSoldierCount = players.get(0).getSoldiers();
		
		for (int i = 1; i < 4; i++){
			int toCompare = players.get(i).getSoldiers();
			if (toCompare > highestSoldierCount){
				highestSoldierCount = toCompare;
				playerIndex = i;
			}
		}
		
		if(highestSoldierCount >= 3){
			if(previousLargest == -1){
				return playerIndex;
			}
			else if(players.get(previousLargest).getSoldiers() == players.get(playerIndex).getSoldiers()){
				return previousLargest;
			}
			else{
				return playerIndex;
			}
		}
		else{
			return -1;
		}
	}
	
	/**
	 * checks to see if a player has 10 victory points
	 * @pre none
	 * @post returns integer representing the index of the player who has 10 or more victory points. If no player has 10 or more victory points, returns -1
	 */
	public int checkVictoryPoints() {
		
		int playerIndex = -1;
		
		for(int i = 0; i < 4 ; i++){
			if(players.get(i).getVictoryPoints() >= 10){
				return i;
			}
		}
		
		return playerIndex;
	}
	
	//CanDo Methods Below********************************************************************************
	
	/**
	 * 
	 * Checks to see if the player is allowed to roll the dice
	 * 
	 * @pre none
	 * @post Must be player's turn, and player hasn't rolled yet- return true. Otherwise returns false.   
	 */
	public boolean canRollDice(int playerIndex) {
		
		boolean test = false;
		String status = turnTracker.getStatus();
		
		if (playerIndex == turnTracker.getCurrentTurn() && status == "Rolling"){
			test = true;
		}
		
		return test;
	}

	/**
	 * 
	 * Tests whether players can trade a number of resource cards of one type for one resource card of another
	 * type
	 * @pre none
	 * @post If player hex is next to generic harbor, allowed 3:1 at resource of their choice. Return true
	 * If player owns resource harbor, they are allowed to trade two cards indicated by Harbor type for 
	 * resource of their choice. Return true
	 * Player always allowed 4:1 with Bank for resource of their choice. Return true
	 * 
	 * Otherwise return false
	 */
	public boolean canBankTrade(int playerIndex, ResourceType offer, ResourceType request) {
		
		boolean test = false;
		players.get(playerIndex).getResources();
		
		if(offer == ResourceType.WOOD) { 
			
			
			
		} else if(offer == ResourceType.BRICK) {
			
		} else if(offer == ResourceType.SHEEP) {
			
		} else if(offer == ResourceType.WHEAT) {
			
		} else if(offer == ResourceType.ORE) {
			
		}
		
		return false;
		
	}
	
	/**
	 * 
	 * Players are allowed to offer trades with other players 
	 * 
	 * @pre none
	 * @post players turn, player has the number of resources they are attempting to trade return true. Otherwise return false. 
	 */
	public boolean canOfferTrade(int playerIndex, ResourceList proposedTradeList) {
	
		String status = turnTracker.getStatus();
		int whoseTurn = turnTracker.getCurrentTurn();
		
		if(status.equals("Playing") && whoseTurn == playerIndex) {
		
			ResourceList playerResourceList = players.get(playerIndex).getResources();
			boolean test = true;
		
			if(proposedTradeList.getBrick() < playerResourceList.getBrick()) {
				return false;
			}
			
			if(proposedTradeList.getSheep() < playerResourceList.getSheep()) {
				return false;
			}
			
			if(proposedTradeList.getOre() < playerResourceList.getOre()) {
				return false;
			}
			
			if(proposedTradeList.getWood() < playerResourceList.getWood()) {
				return false;
			}
			
			if(proposedTradeList.getWheat() < playerResourceList.getWheat()) {
				return false;
			}
			return test;
		} 
		else{
			return false;
		}
    }

	/**
	 * 
	 * Deciding if the player is able to accept the trade offered to them
	 * 
	 * @pre none
	 * @post A trade is offered to the player, the player has the resources the other player is trading for, return true
	 * Otherwise return false
	 * 
	 */
	public boolean canAcceptTrade() {
	
		boolean test = false;
		return test;
	}

	/**
	 *
	 * A player is attempting to buy a development card
	 * 
	 * @pre none
	 * @post A player must have the resources needed to buy the development card, the bank needs
	 * to have the development card, and must be players turn- return true
	 * Otherwise return false
	 */
	public boolean canBuyDevCard() {
	
		boolean test = false;
		return test;
	}

	/**
	 * 
	 * Player attempts to build settlement
	 * 
	 * @pre none
	 * @post Must be players turn, must have the required resources to build it, must have a settlement left,must be appropriately placed on the map - return true. Otherwise return false.
	 */
	public boolean canbuildSettlement() {
	
		boolean test = false;
		return test;
	}
	
	/**
	 * 
	 * Player attempts to build city
	 * 
	 * @pre none
	 * @post Must be players turn, must have the required resources to build it, settlement must already be built in the spot, must have a city left,must be appropriately placed on the map - return true. Otherwise return false.
	 */
	public boolean canBuildCity() {
	
		boolean test = false;
		return test;
	}
	
	/**
	 * 
	 * Player attempts to build a road
	 * 
	 * @pre none
	 * @post Must be a players turn, player must have required resources to build road, road must be appropriately placed on map, player must have a road left to build- return true. Otherwise false.
	 */
	public boolean canBuildRoad() {
	
		boolean test = false;
		return test;
	}

	/**
	 * 
	 * Player attempts to play a development card 
	 * 
	 * @pre none
	 * @post Player must have the development card, must be players turn, card can't have been received on the players turn- return true. Otherwise return false.
	 */
	public boolean canPlayDevCard() {
	
		boolean test = false;
		return test;
	}
	
	/**
	 * 
	 * Player attempts to place a robber on a hex
	 * 
	 * @pre none
	 * @post Must be players turn, player rolls a seven, must be appropriately placed- return true. Otherwise return false.
	 */
	public boolean canPlaceRobber() {
	
		boolean test = false;
		return test;
	}
	

	/**
	 * 
	 * Player attempts to steal a resource card
	 * 
	 * @pre none
	 * @post Must be players turn, player must roll a seven, target player must have a resource card- return true. Otherwise return false
	 */
	public boolean canStealResourceCard() {
	
		boolean test = false;
		return test;
	}
	
	/**
	 * 
	 * Players discard half their cards to be placed back in the bank. 
	 * If odd number, round down.
	 * 
	 * @pre none
	 * @post A seven must have been rolled, and a player has to have eight or more cards- return true. Otherwise return false.
	 */
	public boolean mustDiscardHalfCards() {
		boolean test = false;
		return test;
	}
}
