package client.facade;

import java.util.ArrayList;

import shared.locations.*;
import client.model.*;
import client.poller.ServerPoller;
import client.serverproxy.ServerProxy;
import shared.definitions.*;

/**
 * Encapsulating class for the ClientModel, ServerPoller, and ServerProxy. The GUI calls methods on this class.
 * @author Ife's Group
 *
 */
public class Facade {
	private ClientModel model;
	private ServerProxy proxy;
	private ServerPoller poller;
	
	public Facade() {
		model=new ClientModel();
		proxy=new ServerProxy("localhost");
		poller=new ServerPoller(proxy, this);
	}

	public ClientModel getModel() {
		return model;
	}

	public void setModel(ClientModel model) {
		this.model = model;
	}

	public ServerProxy getProxy() {
		return proxy;
	}

	public void setProxy(ServerProxy proxy) {
		this.proxy = proxy;
	}

	public ServerPoller getPoller() {
		return poller;
	}

	public void setPoller(ServerPoller poller) {
		this.poller = poller;
	}

    //ClientModel Methods
    public DevCardList getDeck()  {
        return model.getDeck();
    }

    public void setDeck(DevCardList deck)  {
        model.setDeck(deck);
    }

    public ResourceList getBank()  {
        return model.getBank();
    }

    public void setBank(ResourceList bank)  {
        model.setBank(bank);
    }

    public MessageList getChat()  {
        return model.getChat();
    }

    public void setChat(MessageList chat)  {
        model.setChat(chat);
    }

    public MessageList getLog()  {
        return model.getLog();
    }

    public void setLog(MessageList log)  {
        model.setLog(log);
    }

    public Map getMap()  {
        return model.getMap();
    }

    public void setMap(Map map)  {
        model.setMap(map);
    }

    public ArrayList<Player> getPlayers()  {
        return model.getPlayers();
    }

    public void setPlayers(ArrayList<Player> players)  {
        model.setPlayers(players);
    }

    public TradeOffer getTradeOffer()  {
        return model.getTradeOffer();
    }

    public void setTradeOffer(TradeOffer tradeOffer)  {
        model.setTradeOffer(tradeOffer);
    }

    public TurnTracker getTurnTracker()  {
        return model.getTurnTracker();
    }

    public void setTurnTracker(TurnTracker turnTracker)  {
        model.setTurnTracker(turnTracker);
    }

    public int getVersion()  {
        return model.getVersion();
    }

    public void setVersion(int version)  {
        model.setVersion(version);
    }

    public int getWinner()  {
        return model.getWinner();
    }

    public void setWinner(int winner)  {
        model.setWinner(winner);
    }

    /**
     * checks newClientModel version against current client model version and updates if versions differ
     * @param newClientModel
     * @pre newClientModel != null
     * @post if version number is different, newClientModel replaces current client Model, otherwise, nothing happens.
     */
    public void updateClientModel(ClientModel newClientModel) {
        model.updateClientModel(newClientModel);
    }
    
    /**
     * checks whether a player has the longest road
     * @pre none
     * @post returns integer of the index of the player with the longest road. Player has longest road if road length is 5 and more than any other player. If nobody has longest road, returns -1
     */
    public int checkLongestRoad() {
        return model.checkLongestRoad();
    }
    
    /**
     * checks whether a player has the largest army
     * @pre none
     * @post returns integer representing the index of the player with the largest army. Player has largest army if they have played at least 3 soldier cards and more soldier cards than any other player. If nobody has largest army, returns -1
     */
    public int checkLargestArmy() {
        return model.checkLargestArmy();
    }
    
    /**
     * checks to see if a player has 10 victory points
     * @pre none
     * @post returns integer representing the index of the player who has 10 or more victory points. If no player has 10 or more victory points, returns -1
     */
    public int checkVictoryPoints() {
        return model.checkVictoryPoints();
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
        return model.canRollDice(playerIndex);
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
        return model.canBankTrade(playerIndex, offer, request);
    }
    
    /**
     * 
     * Players are allowed to offer trades with other players 
     * 
     * @pre none
     * @post players turn, player has the number of resources they are attempting to trade return true. Otherwise return false. 
     */
    public boolean canOfferTrade(TradeOffer tradeOffer) {
        return model.canOfferTrade(tradeOffer);
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
        return model.canAcceptTrade(playerIndex, tradeOffer);
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
        return canBuyDevCard(playerIndex);
    }

    /**
     * 
     * Player attempts to build settlement
     * 
     * @pre none
     * @post Must be players turn, must have the required resources to build it, must have a settlement left, must be appropriately placed on the map - return true. Otherwise return false.
     */
    public boolean canBuildSettlement(VertexObject settlement) {
        return model.canBuildSettlement(settlement);
    }
    
    /**
     * 
     * Player attempts to build city
     * 
     * @pre none
     * @post Must be players turn, must have the required resources to build it, settlement must already be built in the spot, must have a city left, must be appropriately placed on the map - return true. Otherwise return false.
     */
    public boolean canBuildCity(VertexObject city) {
        return model.canBuildCity(city);
    }
    
    /**
     * 
     * Player attempts to build a road
     * 
     * @pre none
     * @post Must be a players turn, player must have required resources to build road, road must be appropriately placed on map, player must have a road left to build- return true. Otherwise false.
     */
    public boolean canBuildRoad(Road road) {
        return model.canBuildRoad(road);
    }

    /**
     * 
     * Player attempts to play a development card 
     * 
     * @pre none
     * @post Player must have the development card, must be players turn, card can't have been received on the players turn- return true. Otherwise return false.
     */
    public boolean canPlayDevCard(int playerIndex, DevCardType cardType) {
        return model.canPlayDevCard(playerIndex, cardType);
    }
    
    /**
     * 
     * Player attempts to place a robber on a hex
     * 
     * @pre none
     * @post Must be players turn, player rolls a seven, must be appropriately placed- return true. Otherwise return false.
     */
    public boolean canPlaceRobber(int playerIndex, int diceRoll, HexLocation hexLoc) {
        return model.canPlaceRobber(playerIndex, diceRoll, hexLoc);
    }
    

    /**
     * 
     * Player attempts to steal a resource card
     * 
     * @pre none
     * @post Must be players turn, player must roll a seven, target player must have a resource card- return true. Otherwise return false
     */
    public boolean canStealResourceCard(int playerIndex, int diceRoll, int targetPlayer) {
        return model.canStealResourceCard(playerIndex, diceRoll, targetPlayer);
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
        return model.mustDiscardHalfCards(diceRoll, playerIndex);
    }

    //ProxyServer (Do) Methods

    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param number
     * @pre playerIndex and number != null, number between 2 and 12 inclusive, playerIndex between 0 and 3 inclusive
     * @post Server receives information
     */
    public void rollNumber(int playerIndex, int number) 
    {
        proxy.rollNumber(playerIndex, number);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param spot1
     * @param spot2
     * @pre playerIndex between 0 and 3 inclusive, playerIndex and spot1 and spot2 are not null
     * @post Server receives information
     */
    public void roadBuilding(int playerIndex, EdgeLocation spot1, EdgeLocation spot2) 
    {
        proxy.roadBuilding(playerIndex, spot1, spot2);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post Server receives information
     */
    public void finishTurn(int playerIndex) 
    {
        proxy.finishTurn(playerIndex);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post Server receives information
     */
    public void buyDevCard(int playerIndex) 
    {
        proxy.buyDevCard(playerIndex);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param resource1
     * @param resource2
     * @pre playerIndex between 0 and 3 inclusive and not null, both resources must not be null and one of the key words for resources
     * @post Server receives information
     */
    public void yearOfPlenty(int playerIndex, String resource1, String resource2) 
    {
        proxy.yearOfPlenty(playerIndex, resource1, resource2);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param victimIndex
     * @param location
     * @pre playerIndex and victinIndex between 0 and 3 inclusive and not null, location not null
     * @post Server receives information
     */
    public void soldier(int playerIndex, int victimIndex, HexLocation location) 
    {
        proxy.soldier(playerIndex, victimIndex, location);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param resource
     * @param playerIndex
     * @pre resource must not be null and one of the key words for resources, playerIndex between 0 and 3 inclusive and not null
     * @post Server receives information
     */
    public void monopoly(String resource, int playerIndex) 
    {
        proxy.monopoly(resource, playerIndex);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param roadLocation
     * @param free
     * @pre playerIndex between 0 and 3 inclusive and not null, roadLocation not null
     * @post Server receives information
     */
    public void buildRoad(int playerIndex, EdgeLocation roadLocation, boolean free) 
    {
        proxy.buildRoad(playerIndex, roadLocation, free);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param vertexLocation
     * @param free
     * @pre playerIndex between 0 and 3 inclusive and not null, vertexLocation not null
     * @post Server receives information
     */
    public void buildSettlement(int playerIndex, VertexLocation vertexLocation, boolean free)
    {
        proxy.buildSettlement(playerIndex, vertexLocation, free);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param vertexLocation
     * @param free
     * @pre playerIndex between 0 and 3 inclusive and not null, vertexLocation not null
     * @post Server receives information
     */
    public void buildCity(int playerIndex, VertexLocation vertexLocation) 
    {
        proxy.buildCity(playerIndex, vertexLocation);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param offer
     * @param receiver
     * @pre playerIndex and receiver between 0 and 3 inclusive and not null, offer not null
     * @post Server receives information
     */
    public void offerTrade(int playerIndex, ResourceList offer, int receiver) 
    {
        proxy.offerTrade(playerIndex, offer, receiver);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param willAccept
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post Server receives information
     */
    public void acceptTrade(int playerIndex, boolean willAccept) 
    {
        proxy.acceptTrade(playerIndex, willAccept);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param discardedCards
     * @pre playerIndex between 0 and 3 inclusive and not null, discardedCards not null
     * @post Server receives information
     */
    public void discardCards(int playerIndex, ResourceList discardedCards) 
    {
        proxy.discardCards(playerIndex, discardedCards);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @pre none
     * @post Server receives information
     */
    public ClientModel getClientModel(int version) 
    {
        return proxy.getClientModel(version);
    }
	
}
