package client.model;

import java.util.ArrayList;

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
	
	private Map initializeMap(ClientModel clientModel) {
		
		Map map = null;
		
		return map;
	}
	
	private int rollDice() {
		
		int diceRoll = 7;
		
		return diceRoll;
	}
	
	private void finishTurn() {
		
	}
	
	private void bankTrade() {
		
	}
	
	private void offerTrade() {
		
	}
	
	private void acceptTrade() {
		
	}
	
	private void buyDevCard() {
		
	}
	
	private void buildSettlement() {
		
	}
	
	private void buildCity() {
		
	}
	
	private void buildRoad() {
		
	}
	
	private void playYearOfPlenty() {
		
	}
	
	private void playRoadBuilderCard() {
		
	}
	
	private void playSoldierCard() {
		
	}
	
	private void playMonopolyCard() {
		
	}
	
	private void playVictoryCard() {
		
	}
	
	private void buyResourceCard() {
		
	}
	
	private void discardHalfCards() {
		
	}
	
	private void moveRobber() {
		
	}
	
	private void stealResourceCard(Player player) {
		
	}
	
	private int checkLongestRoad() {
		
		int longestRoadCount = 0;
		
		return longestRoadCount;
	}
	
	private int checkLargestArmy() {
		
		int longestArmyCount = 0;
		
		return longestArmyCount;
	}
	
	private int checkVictoryPoints() {
		
		int victoryPointCount = 0;
		
		return victoryPointCount;
	}
	
	//Can Methods Below
	
	private boolean canRollDice() {
		
		boolean test = false;
		return test;
	}

	private boolean canbankTrade() {
		
		boolean test = false;
		return test;
	}
	
	private boolean canOfferTrade() {
	
		boolean test = false;
		return test;
    }

	private boolean canAcceptTrade() {
	
		boolean test = false;
		return test;
	}

	private boolean canBuyDevCard() {
	
		boolean test = false;
		return test;
	}

	private boolean canbuildSettlement() {
	
		boolean test = false;
		return test;
	}

	private boolean canBuildSettlement() {
	
		boolean test = false;
		return test;
	}
	
	private boolean canBuildCity() {
	
		boolean test = false;
		return test;
	}
	
	private boolean canBuildRoad() {
	
		boolean test = false;
		return test;
	}

	private boolean canPlayDevCard() {
	
		boolean test = false;
		return test;
	}
	
	private boolean canBuyResourceCard() {
		
		boolean test = false;
		return test;
	}
	
	private boolean canPlaceRobber() {
	
		boolean test = false;
		return test;
	}
	
	private boolean canDiscardHalfCards() {
	
		boolean test = false;
		return test;
	}

	private boolean canStealResourceCard() {
	
		boolean test = false;
		return test;
	}
}
