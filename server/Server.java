package server;

import java.util.ArrayList;

import shared.definitions.*;
import shared.locations.*;
import client.model.*;

/**
 * The server.
 * @author Ife's group
 *
 */
public class Server implements IServer {

	@Override
	public DevCardList getDeck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDeck(DevCardList deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResourceList getBank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBank(ResourceList bank) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageList getChat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setChat(MessageList chat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageList getLog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLog(MessageList log) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMap(Map map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayers(ArrayList<Player> players) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TradeOffer getTradeOffer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTradeOffer(TradeOffer tradeOffer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TurnTracker getTurnTracker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTurnTracker(TurnTracker turnTracker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setVersion(int version) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWinner() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWinner(int winner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClientModel(ClientModel newClientModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checkLongestRoad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkLargestArmy() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkVictoryPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canRollDice(int playerIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canBankTrade(int playerIndex, ResourceType offer,
			ResourceType request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canOfferTrade(TradeOffer tradeOffer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canAcceptTrade(int playerIndex, TradeOffer tradeOffer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canBuyDevCard(int playerIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canBuildSettlement(VertexObject settlement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canBuildCity(VertexObject city) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canBuildRoad(Road road) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canPlayDevCard(int playerIndex, DevCardType cardType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canPlaceRobber(int playerIndex, int diceRoll,
			HexLocation hexLoc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canStealResourceCard(int playerIndex, int diceRoll,
			int targetPlayer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mustDiscardHalfCards(int diceRoll, int playerIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void rollNumber(int playerIndex, int number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void roadBuilding(int playerIndex, EdgeLocation spot1,
			EdgeLocation spot2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finishTurn(int playerIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyDevCard(int playerIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void yearOfPlenty(int playerIndex, String resource1, String resource2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void soldier(int playerIndex, int victimIndex, HexLocation location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void monopoly(String resource, int playerIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildRoad(int playerIndex, EdgeLocation roadLocation,
			boolean free) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildSettlement(int playerIndex, VertexLocation vertexLocation,
			boolean free) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildCity(int playerIndex, VertexLocation vertexLocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void offerTrade(int playerIndex, ResourceList offer, int receiver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptTrade(int playerIndex, boolean willAccept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void discardCards(int playerIndex, ResourceList discardedCards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientModel getClientModel(String version) {
		// TODO Auto-generated method stub
		return null;
	}

}
