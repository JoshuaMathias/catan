package client.model;

import java.util.ArrayList;

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
	private TurnTracker turntracker;
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
	
//	/**
//	 * initializes map and resets map when needed
//	 * @param clientModel
//	 * @pre clientModel != null
//	 * @post Map is updated
//	 */
//	public Map initializeMap(ClientModel clientModel) {
//		
//		Map map = null;
//		
//		return map;
//	}
//	
//	/**
//	 * rolls dice for current player
//	 * @pre is current player's turn
//	 * @post player is given an int representing value of dice roll
//	 */
//	public int rollDice() {
//		
//		int diceRoll = 7;
//		
//		return diceRoll;
//	}
//	
//	/**
//	 * Ends current Player's turn
//	 * @pre is a player's turn
//	 * @post is next player's turn
//	 */
//	public void finishTurn() {
//		
//	}
//	
//	/**
//	 * trades a given number of one type of resource card with game card bank
//	 * @pre is players turn and player has required number of one type of resource card
//	 * @post player has required number less of one resource card and one more of another type
//	 */
//	public void bankTrade() {
//		
//	}
//	
//	/**
//	 * sends trade offer to another player
//	 * @pre trade offer is held by player
//	 * @post message is sent to other player
//	 */
//	public void offerTrade() {
//		
//	}
//	
//	/**
//	 * accepts trade offer from other player and adjusts card number
//	 * @pre player has required amount of resources in offer
//	 * @post player either accepts and changes amount of resource card number or rejects trade offer
//	 */
//	public void acceptTrade() {
//		
//	}
//	
//	/**
//	 * player purchases development card from game card bank for required resource card amount
//	 * @pre player has required resource card amount and is player's turn
//	 * @post player recieves a development card and pays resource cards
//	 */
//	public void buyDevCard() {
//		
//	}
//	
//	/**
//	 * player builds a settlement on map
//	 * @pre player has enough resource cards and spot on map is valid
//	 * @post Settlement is built and resources are used
//	 */
//	public void buildSettlement() {
//		
//	}
//	
//	/**
//	 * player builds a city in place of a settlement
//	 * @pre player has enough resource cards and spot on map has settlement
//	 * @post settlement is replaced by city and resources are used
//	 */
//	public void buildCity() {
//		
//	}
//	
//	/**
//	 * player builds road on map
//	 * @pre player has enough resource cards and edge location on map is valid
//	 * @post Road is built and resources are used
//	 */
//	public void buildRoad() {
//		
//	}
//	
//	/**
//	 * player plays year of plenty card
//	 * @pre is player's turn, player hasn't played a development card during current turn, and player has year of plenty card in old dev cards pile
//	 * @post effect is applied and year of plenty card is discarded
//	 */
//	public void playYearOfPlenty() {
//		
//	}
//	
//	/**
//	 * player playes road builder card
//	 * @pre is player's turn, player hasn't played a development card during current turn and player has road builder card in old dev cards pile
//	 * @post effect is applied and road builder card is discarded
//	 */
//	public void playRoadBuilderCard() {
//		
//	}
//	
//	/**
//	 * player plays soldier card and moves the thief
//	 * @pre is player's turn, player hasn't played a development card during current turn, and player has soldier card in old dev cards pile
//	 * @post effect is applied and soldier card is discarded
//	 */
//	public void playSoldierCard() {
//		
//	}
//	
//	/**
//	 * player plays monopoly card
//	 * @pre is player's turn, player hasn't played a development card during current turn, and player has monopoly card in old dev cards pile
//	 * @post effect is applied and monopoly card is discarded
//	 */
//	public void playMonopolyCard() {
//		
//	}
//	
//	/**
//	 * player plays victory card and gains a victory point
//	 * @pre is player's turn, player hasn't played a development card during current turn, and player has victory card in old dev cards pile
//	 * @post victory point is gained and victory card is discarded
//	 */
//	public void playVictoryCard() {
//		
//	}
//	
//	/**
//	 * player purchases resource card
//	 * @pre
//	 * @post
//	 */
//	public void buyResourceCard() {
//		
//	}
//	
//	/**
//	 * 
//	 * @pre
//	 * @post
//	 */
//	public void discardHalfCards() {
//		
//	}
//	
//	/**
//	 * 
//	 * @pre
//	 * @post
//	 */
//	public void moveRobber() {
//		
//	}
//	
//	/**
//	 * 
//	 * @pre
//	 * @post
//	 */
//	public void stealResourceCard(Player player) {
//		
//	}
	
	/**
	 * checks whether a player has the longest road
	 * @pre none
	 * @post returns integer of the index of the player with the longest road. Player has longest road if road length is 5 and more than any other player. If nobody has longest road, returns -1
	 */
	public int checkLongestRoad() {
		
		int playerIndex = -1;
		
		return playerIndex;
	}
	
	/**
	 * checks whether a player has the largest army
	 * @pre none
	 * @post returns integer representing the index of the player with the largest army. Player has largest army if they have played at least 3 soldier cards and more soldier cards than any other player. If nobody had largest road, returns -1
	 */
	public int checkLargestArmy() {
		
		int playerIndex = -1;
		
		return playerIndex;
	}
	
	/**
	 * checks to see if a player has 10 victory points
	 * @pre none
	 * @post returns integer representing the index of the player who has 10 or more victory points. If no player has 10 or more victory points, returns -1
	 */
	public int checkVictoryPoints() {
		
		int playerIndex = -1;
		
		return playerIndex;
	}
	
	//Can Methods Below********************************************************************************
	
	/**
	 * 
	 * checks to see if the player is allowed to roll the dice
	 * @pre none
	 * @post Returns true if it's the player's turn and player hasn't rolled yet. Otherwise returns false   
	 */
	public boolean canRollDice() {
		
		boolean test = false;
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
	public boolean canBankTrade() {
		
		boolean test = false;
		return test;
	}
	
	/**
	 * 
	 * Players are allowed to offer trades with other players 
	 * 
	 * @pre none
	 * @post players turn, player has the number of resources they are attempting to trade, other player
	 * has the resources the player is attempting to obtain, return true. Otherwise return false. 
	 */
	public boolean canOfferTrade() {
	
		boolean test = false;
		return test;
    }

	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean canAcceptTrade() {
	
		boolean test = false;
		return test;
	}

	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean canBuyDevCard() {
	
		boolean test = false;
		return test;
	}

	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean canbuildSettlement() {
	
		boolean test = false;
		return test;
	}

	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean canBuildSettlement() {
	
		boolean test = false;
		return test;
	}
	
	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean canBuildCity() {
	
		boolean test = false;
		return test;
	}
	
	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean canBuildRoad() {
	
		boolean test = false;
		return test;
	}

	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean canPlayDevCard() {
	
		boolean test = false;
		return test;
	}
	
	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean canBuyResourceCard() {
		
		boolean test = false;
		return test;
	}
	
	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean canPlaceRobber() {
	
		boolean test = false;
		return test;
	}
	
	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean canDiscardHalfCards() {
	
		boolean test = false;
		return test;
	}

	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean canStealResourceCard() {
	
		boolean test = false;
		return test;
	}
	
	/**
	 * 
	 * @pre
	 * @post
	 */
	public boolean mustDiscardHalfCards() {
		boolean test = false;
		return test;
	}
}
