package server;

import java.util.ArrayList;

import shared.definitions.*;
import shared.locations.*;

import client.model.*;

/**
 * Interface for the server.
 * @author Ife's group
 *
 */
public interface IServer {

    //Can Do Methods
    public DevCardList getDeck();

    public void setDeck(DevCardList deck);

    public ResourceList getBank();

    public void setBank(ResourceList bank);

    public MessageList getChat();

    public void setChat(MessageList chat);

    public MessageList getLog();

    public void setLog(MessageList log);

    public Map getMap();

    public void setMap(Map map);

    public ArrayList<Player> getPlayers();

    public void setPlayers(ArrayList<Player> players);

    public TradeOffer getTradeOffer();

    public void setTradeOffer(TradeOffer tradeOffer);

    public TurnTracker getTurnTracker();

    public void setTurnTracker(TurnTracker turnTracker);

    public int getVersion();

    public void setVersion(int version);

    public int getWinner();

    public void setWinner(int winner);

    /**
     * checks newClientModel version against current client model version and updates if versions differ
     * @param newClientModel
     * @pre newClientModel != null
     * @post if version number is different, newClientModel replaces current client Model, otherwise, nothing happens.
     */
    public void updateClientModel(ClientModel newClientModel);
    
    /**
     * checks whether a player has the longest road
     * @pre none
     * @post returns integer of the index of the player with the longest road. Player has longest road if road length is 5 and more than any other player. If nobody has longest road, returns -1
     */
    public int checkLongestRoad();
    
    /**
     * checks whether a player has the largest army
     * @pre none
     * @post returns integer representing the index of the player with the largest army. Player has largest army if they have played at least 3 soldier cards and more soldier cards than any other player. If nobody has largest army, returns -1
     */
    public int checkLargestArmy();
    
    /**
     * checks to see if a player has 10 victory points
     * @pre none
     * @post returns integer representing the index of the player who has 10 or more victory points. If no player has 10 or more victory points, returns -1
     */
    public int checkVictoryPoints();
    
//CanDo Methods Below********************************************************************************
    
    /**
     * 
     * Checks to see if the player is allowed to roll the dice
     * 
     * @pre none
     * @post Must be player's turn, and player hasn't rolled yet- return true. Otherwise returns false.   
     */
    public boolean canRollDice(int playerIndex);

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
    public boolean canBankTrade(int playerIndex, ResourceType offer, ResourceType request);
    
    /**
     * 
     * Players are allowed to offer trades with other players 
     * 
     * @pre none
     * @post players turn, player has the number of resources they are attempting to trade return true. Otherwise return false. 
     */
    public boolean canOfferTrade(TradeOffer tradeOffer);

    /**
     * 
     * Deciding if the player is able to accept the trade offered to them
     * 
     * @pre none
     * @post A trade is offered to the player, the player has the resources the other player is trading for, return true
     * Otherwise return false
     * 
     */
    public boolean canAcceptTrade(int playerIndex, TradeOffer tradeOffer);

    /**
     *
     * A player is attempting to buy a development card
     * 
     * @pre none
     * @post A player must have the resources needed to buy the development card, the bank needs
     * to have the development card, and must be players turn- return true
     * Otherwise return false
     */
    public boolean canBuyDevCard(int playerIndex);

    /**
     * 
     * Player attempts to build settlement
     * 
     * @pre none
     * @post Must be players turn, must have the required resources to build it, must have a settlement left, must be appropriately placed on the map - return true. Otherwise return false.
     */
    public boolean canBuildSettlement(VertexObject settlement);
    
    /**
     * 
     * Player attempts to build city
     * 
     * @pre none
     * @post Must be players turn, must have the required resources to build it, settlement must already be built in the spot, must have a city left, must be appropriately placed on the map - return true. Otherwise return false.
     */
    public boolean canBuildCity(VertexObject city);
    
    /**
     * 
     * Player attempts to build a road
     * 
     * @pre none
     * @post Must be a players turn, player must have required resources to build road, road must be appropriately placed on map, player must have a road left to build- return true. Otherwise false.
     */
    public boolean canBuildRoad(Road road);

    /**
     * 
     * Player attempts to play a development card 
     * 
     * @pre none
     * @post Player must have the development card, must be players turn, card can't have been received on the players turn- return true. Otherwise return false.
     */
    public boolean canPlayDevCard(int playerIndex, DevCardType cardType);
    
    /**
     * 
     * Player attempts to place a robber on a hex
     * 
     * @pre none
     * @post Must be players turn, player rolls a seven, must be appropriately placed- return true. Otherwise return false.
     */
    public boolean canPlaceRobber(int playerIndex, int diceRoll, HexLocation hexLoc);
    

    /**
     * 
     * Player attempts to steal a resource card
     * 
     * @pre none
     * @post Must be players turn, player must roll a seven, target player must have a resource card- return true. Otherwise return false
     */
    public boolean canStealResourceCard(int playerIndex, int diceRoll, int targetPlayer);
    
    /**
     * 
     * Players discard half their cards to be placed back in the bank. 
     * If odd number, round down.
     * 
     * @pre none
     * @post A seven must have been rolled, and a player has to have eight or more cards- return true. Otherwise return false.
     */
    public boolean mustDiscardHalfCards(int diceRoll, int playerIndex);

    //Do Methods

    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param number
     * @pre playerIndex and number != null, number between 2 and 12 inclusive, playerIndex between 0 and 3 inclusive
     * @post Server receives information
     */
    public void rollNumber(int playerIndex, int number);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param spot1
     * @param spot2
     * @pre playerIndex between 0 and 3 inclusive, playerIndex and spot1 and spot2 are not null
     * @post Server receives information
     */
    public void roadBuilding(int playerIndex, EdgeLocation spot1, EdgeLocation spot2);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post Server receives information
     */
    public void finishTurn(int playerIndex);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post Server receives information
     */
    public void buyDevCard(int playerIndex);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param resource1
     * @param resource2
     * @pre playerIndex between 0 and 3 inclusive and not null, both resources must not be null and one of the key words for resources
     * @post Server receives information
     */
    public void yearOfPlenty(int playerIndex, String resource1, String resource2);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param victimIndex
     * @param location
     * @pre playerIndex and victinIndex between 0 and 3 inclusive and not null, location not null
     * @post Server receives information
     */
    public void soldier(int playerIndex, int victimIndex, HexLocation location);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param resource
     * @param playerIndex
     * @pre resource must not be null and one of the key words for resources, playerIndex between 0 and 3 inclusive and not null
     * @post Server receives information
     */
    public void monopoly(String resource, int playerIndex);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param roadLocation
     * @param free
     * @pre playerIndex between 0 and 3 inclusive and not null, roadLocation not null
     * @post Server receives information
     */
    public void buildRoad(int playerIndex, EdgeLocation roadLocation, boolean free);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param vertexLocation
     * @param free
     * @pre playerIndex between 0 and 3 inclusive and not null, vertexLocation not null
     * @post Server receives information
     */
    public void buildSettlement(int playerIndex, VertexLocation vertexLocation, boolean free);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param vertexLocation
     * @param free
     * @pre playerIndex between 0 and 3 inclusive and not null, vertexLocation not null
     * @post Server receives information
     */
    public void buildCity(int playerIndex, VertexLocation vertexLocation);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param offer
     * @param receiver
     * @pre playerIndex and receiver between 0 and 3 inclusive and not null, offer not null
     * @post Server receives information
     */
    public void offerTrade(int playerIndex, ResourceList offer, int receiver);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param willAccept
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post Server receives information
     */
    public void acceptTrade(int playerIndex, boolean willAccept);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param discardedCards
     * @pre playerIndex between 0 and 3 inclusive and not null, discardedCards not null
     * @post Server receives information
     */
    public void discardCards(int playerIndex, ResourceList discardedCards);
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @pre none
     * @post Server receives information
     */
    public ClientModel getClientModel(String version);
}
