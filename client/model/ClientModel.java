package client.model;

import java.util.ArrayList;

import shared.definitions.DevCardType;
import shared.definitions.ResourceType;
import shared.locations.HexLocation;
import shared.locations.VertexDirection;
import shared.locations.VertexLocation;

/**
 * Class represents model of game on client side
 * @author Ife's Group
 *
 */
public class ClientModel {
	private DevCardList deck;
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
		
		boolean can = false;
		players.get(playerIndex).getResources();
		int whoseTurn = turnTracker.getCurrentTurn();
		String status = turnTracker.getStatus();
		boolean twoToOne = false;
		boolean threeToOne = false;
		
		if(whoseTurn == playerIndex && status.equals("Playing")){
			ArrayList<VertexObject> playerSettlementsCities = map.getPlayerSettlementsCities(playerIndex);
			for(VertexObject settlementCity: playerSettlementsCities){
				int portRatio = map.matchSettlementToPortRatio(settlementCity.getLocation(), offer);
				if(portRatio == 2){
					twoToOne = true;
					break;
				}
				else if(portRatio == 3){
					threeToOne = true;
				}
			}
			
			int ratio = 4;
			if(twoToOne){
				ratio = 2;
			}
			else if(threeToOne){
				ratio = 3;
			}
			
			ResourceList playerResources = players.get(playerIndex).getResources();
			switch(offer){
				case BRICK:
					if(playerResources.getBrick() < ratio || bank.getBrick() < 1){
						return false;
					}
					break;
				case ORE:
					if(playerResources.getOre() < ratio || bank.getOre() < 1){
						return false;
					}
					break;
				case SHEEP:
					if(playerResources.getSheep() < ratio || bank.getSheep() < 1){
						return false;
					}
					break;
				case WHEAT:
					if(playerResources.getWheat() < ratio || bank.getWheat() < 1){
						return false;
					}
					break;
				case WOOD:
					if(playerResources.getWood() < ratio || bank.getWood() < 1){
						return false;
					}
					break;
				default: //should never get here Throw Exception
					break;
			}
			
			can = true;
		}
		
		return can;
		
	}
	
	/**
	 * 
	 * Players are allowed to offer trades with other players 
	 * 
	 * @pre none
	 * @post players turn, player has the number of resources they are attempting to trade return true. Otherwise return false. 
	 */
	public boolean canOfferTrade(TradeOffer tradeOffer) {
	
		int playerIndex = tradeOffer.getSender();
		ResourceList proposedTradeList = tradeOffer.getOffer();
		String status = turnTracker.getStatus();
		int whoseTurn = turnTracker.getCurrentTurn();
		
		if(status.equals("Playing") && whoseTurn == playerIndex) {
		
			ResourceList playerResourceList = players.get(playerIndex).getResources();
			boolean test = true;
		
			if(proposedTradeList.getBrick() > playerResourceList.getBrick()) {
				return false;
			}
			
			if(proposedTradeList.getSheep() > playerResourceList.getSheep()) {
				return false;
			}
			
			if(proposedTradeList.getOre() > playerResourceList.getOre()) {
				return false;
			}
			
			if(proposedTradeList.getWood() > playerResourceList.getWood()) {
				return false;
			}
			
			if(proposedTradeList.getWheat() > playerResourceList.getWheat()) {
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
	public boolean canAcceptTrade(int playerIndex, TradeOffer tradeOffer) {
	
		int receiver = tradeOffer.getReceiver();
		ResourceList proposedTradeList = tradeOffer.getOffer();
		
		if(playerIndex == receiver){
			
			ResourceList playerResourceList = players.get(playerIndex).getResources();
			boolean test = true;
			
			if(proposedTradeList.getBrick() < 0) {
				if(Math.abs(proposedTradeList.getBrick()) > playerResourceList.getBrick()){
					return false;
				}
			}
			
			if(proposedTradeList.getSheep() < 0) {
				if(Math.abs(proposedTradeList.getSheep()) > playerResourceList.getSheep()){
					return false;
				}
			}
			
			if(proposedTradeList.getOre() < 0) {
				if(Math.abs(proposedTradeList.getOre()) > playerResourceList.getOre()){
					return false;
				}
			}
			
			if(proposedTradeList.getWood() < 0) {
				if(Math.abs(proposedTradeList.getWood()) > playerResourceList.getWood()){
					return false;
				}
			}
			
			if(proposedTradeList.getWheat() < 0) {
				if(Math.abs(proposedTradeList.getWheat()) > playerResourceList.getWheat()){
					return false;
				}
			}
			return test;
		}
		else{
			return false;
		}
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
	public boolean canBuyDevCard(int playerIndex) {
		
		int whoseTurn = turnTracker.getCurrentTurn();
		String status = turnTracker.getStatus();
		
		boolean can = false;
		if(playerIndex == whoseTurn && status.equals("Playing")){
			Player player = players.get(playerIndex);
			ResourceList playersResources= player.getResources();
			if (playersResources.getSheep() > 0 && playersResources.getOre() > 0 && playersResources.getWheat() > 0){
				can = deck.canBuyDevCard();
			}
		}
		
		return can;
	}

	/**
	 * 
	 * Player attempts to build settlement
	 * 
	 * @pre none
	 * @post Must be players turn, must have the required resources to build it, must have a settlement left,must be appropriately placed on the map - return true. Otherwise return false.
	 */
	public boolean canBuildSettlement(VertexObject settlement) {
	
		int playerIndex = settlement.getOwner();
		int whoseTurn = turnTracker.getCurrentTurn();
		String status = turnTracker.getStatus();
		
		boolean can = false;
		
		if (playerIndex == whoseTurn && status.equals("Playing")){
			ResourceList playersResources = players.get(playerIndex).getResources();
			if(playersResources.getBrick() < 1 || playersResources.getSheep() < 1 || playersResources.getWheat() < 1 || playersResources.getWood() < 1){
				return false;
			}
			
			VertexLocation settlementSpot = settlement.getLocation();
			
			if(players.get(playerIndex).getSettlements() >= 5) {
				return false;
			}
			
			if (map.isSpotTaken(settlementSpot)){
				return false;
			}
			
			if (map.isSpotNeighbored(settlementSpot)){
				return false;
			}
			
			can = map.hasNeighboringOwnRoad(settlement);
		}
		
		
		return can;
	}
	
	/**
	 * 
	 * Player attempts to build city
	 * 
	 * @pre none
	 * @post Must be players turn, must have the required resources to build it, settlement must already be built in the spot, must have a city left,must be appropriately placed on the map - return true. Otherwise return false.
	 */
	public boolean canBuildCity(VertexObject city) {
	
		int playerIndex = city.getOwner();
		int whoseTurn = turnTracker.getCurrentTurn();
		String status = turnTracker.getStatus();
		
		boolean can = false;
		
		if (playerIndex == whoseTurn && status.equals("Playing")){
			ResourceList playersResources = players.get(playerIndex).getResources();
			if(playersResources.getOre() < 3 || playersResources.getWheat() < 2) {
				return false;
			}
			
			if(players.get(playerIndex).getSettlements() < 1) {
				return false;
			}
			
			VertexLocation citySpot = city.getLocation();
			
			can = map.isSpotMySettlement(citySpot, playerIndex);
		}
		return can;
	}
	
	/**
	 * 
	 * Player attempts to build a road
	 * 
	 * @pre none
	 * @post Must be a players turn, player must have required resources to build road, road must be appropriately placed on map, player must have a road left to build- return true. Otherwise false.
	 */
	public boolean canBuildRoad(Road road) {
	
		int playerIndex = road.getOwner();
		int whoseTurn = turnTracker.getCurrentTurn();
		String status = turnTracker.getStatus();
	
		boolean can = false;
		
		if(playerIndex == whoseTurn && status.equals("Playing")){
			Player player = players.get(playerIndex);
			ResourceList playerResources = player.getResources();
			if(playerResources.getBrick() < 1 || playerResources.getWood() < 1){
				return false;
			}
			
			if(player.getRoads() >= 15){
				return false;
			}
			
			if(map.isRoadHere(road.getLocation())){
				return false;
			}
			
			can = map.hasNeighboringOwnRoad(road);
			
		}
		
		return can;
	}

	/**
	 * 
	 * Player attempts to play a development card 
	 * 
	 * @pre none
	 * @post Player must have the development card, must be players turn, card can't have been received on the players turn- return true. Otherwise return false.
	 */
	public boolean canPlayDevCard(int playerIndex, DevCardType cardType) {
		
		int whoseTurn = turnTracker.getCurrentTurn();
		String status = turnTracker.getStatus();
		
		boolean can = true;
		
		Player player = players.get(playerIndex);
		
		if (playerIndex == whoseTurn && status.equals("Playing") && player.isPlayedDevCard() == false) {
			
			DevCardList playersDevCardList = players.get(playerIndex).getOldDevCards();
			
			if(playersDevCardList.size() < 1) {
				return false;
			}
			can = playersDevCardList.canPlayDevCard(cardType);
			
		} else {
			return false;
		}		
		return can;
	}
	
	/**
	 * 
	 * Player attempts to place a robber on a hex
	 * 
	 * @pre none
	 * @post Must be players turn, player rolls a seven, must be appropriately placed- return true. Otherwise return false.
	 */
	public boolean canPlaceRobber(int playerIndex, int diceRoll, HexLocation hexLoc) {
	
		int whoseTurn = turnTracker.getCurrentTurn();
		String status = turnTracker.getStatus();
		
		if(diceRoll == 7 && whoseTurn == playerIndex && status == "Playing") {
			
			if(hexLoc.equals(map.getRobberLocation())) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
	

	/**
	 * 
	 * Player attempts to steal a resource card
	 * 
	 * @pre none
	 * @post Must be players turn, player must roll a seven, target player must have a resource card- return true. Otherwise return false
	 */
	public boolean canStealResourceCard(int playerIndex, int diceRoll, int targetPlayer) {
	
		int whoseTurn = turnTracker.getCurrentTurn();
		String status = turnTracker.getStatus();
		HexLocation robberLocation = map.getRobberLocation();
		boolean canSteal = false;
		
		if(diceRoll == 7 && whoseTurn == playerIndex && status == "Robbing") {
			
			ResourceList targetResourceList = players.get(targetPlayer).getResources();
			
			if(targetResourceList.isEmpty() == true) {
				return false;
			}
			
			boolean buildingTest = map.isSpotMySettlement(new VertexLocation(robberLocation,VertexDirection.NorthEast), targetPlayer);
			boolean buildingTest2 = map.isSpotMySettlement(new VertexLocation(robberLocation,VertexDirection.NorthWest), targetPlayer);
			boolean buildingTest3 = map.isSpotMySettlement(new VertexLocation(robberLocation,VertexDirection.SouthEast), targetPlayer);
			boolean buildingTest4 = map.isSpotMySettlement(new VertexLocation(robberLocation,VertexDirection.SouthWest), targetPlayer);
			boolean buildingTest5 = map.isSpotMySettlement(new VertexLocation(robberLocation,VertexDirection.East), targetPlayer);
			boolean buildingTest6 = map.isSpotMySettlement(new VertexLocation(robberLocation,VertexDirection.West), targetPlayer);
	
			if(buildingTest == true || buildingTest2 == true || buildingTest3 == true || buildingTest4 == true 
														|| buildingTest5 == true || buildingTest6 == true) {
				return true;
			}
		}
		return canSteal;
	}
	
	/**
	 * 
	 * Players discard half their cards to be placed back in the bank. 
	 * If odd number, round down.
	 * 
	 * @pre none
	 * @post A seven must have been rolled, and a player has to have eight or more cards- return true. Otherwise return false.
	 */
	public boolean mustDiscardHalfCards(int diceRoll, int playerIndex) {
		
		if(diceRoll != 7) {
			return false;
		}
		
		ResourceList playerResourceList = players.get(playerIndex).getResources();
		
		if(playerResourceList.getSize() > 7) {
			return true;
		} else {
			return false;
		}
	}
}
