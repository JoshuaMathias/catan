package client.facade;

import java.util.ArrayList;

import client.communication.ChatController;
import client.communication.GameHistoryController;
import client.discard.DiscardController;
import client.main.Catan;
import client.map.MapController;
import client.model.*;
import client.points.PointsController;
import client.poller.ServerPoller;
import client.resources.ResourceBarController;
import client.roll.RollController;
import client.serverproxy.GamesList;
import client.serverproxy.ServerProxy;
import client.turntracker.TurnTrackerController;
import shared.definitions.*;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;

/**
 * Encapsulating class for the ClientModel, ServerPoller, and ServerProxy. The GUI calls methods on this class.
 * @author Ife's Group
 *
 */
public class Facade {
	private ClientModel clientModel;
	public static ServerProxy proxy;
	public static Facade thisFacade;
	private String host;
	private ServerPoller poller;
	public static int count=0;
	public int playerIndex=0;
	public int diceRoll=0;
	public HexLocation tempRobLoc;
	private String username;
	private int playerId;
	private int currentGameId;
	private MapController mapController;
	private GameHistoryController gameHistoryController;
	private ChatController chatController;
	private TurnTrackerController turnTrackerController;
	private RollController rollController;
	private ResourceBarController resourceBarController;
	private DiscardController discardController;
	private CatanColor playerColor;
	private PointsController pointsController;
	
	private Facade(String host) {
		this.host=host;
		clientModel=new ClientModel();
		proxy=new ServerProxy(host);
		poller=new ServerPoller(proxy, this);
		thisFacade=this;
	}
	
	public static Facade getSingleton() {
		if (thisFacade==null) {
			thisFacade=new Facade(Catan.host);
		}
		return thisFacade;
	}
	
	public static String convertColor(CatanColor color) {
		switch (color) {
			case red:
				return "red";
			case orange:
				return "orange";
			case yellow:
				return "yellow";
			case blue:
				return "blue";
			case green:
				return "green";
			case purple:
				return "purple";
			case puce:
				return "puce";
			case white:
				return "white";
			case brown:
				return "brown";
			default:
				return "";
		}
	}
	
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getCurrentGameId() {
		return currentGameId;
	}

	public void setCurrentGameId(int currentGameId) {
		this.currentGameId = currentGameId;
	}

	public HexLocation getTempRobLoc() {
		return tempRobLoc;
	}

	public void setTempRobLoc(HexLocation tempRobLoc) {
		this.tempRobLoc = tempRobLoc;
	}

	public int getDiceRoll() {
		return diceRoll;
	}

	public  void setDiceRoll(int diceRoll) {
		this.diceRoll = diceRoll;
	}

	public String getHost() {
		return host;
	}
	
	public String getName() {
		return username;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPlayerIndex() {
		return playerIndex;
	}

	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}
	
	public CatanColor getPlayerColor(){
		return playerColor;
	}

	public void sendChat(String content) {
		proxy.sendChat(playerIndex, content);
	}
	
	public ClientModel getClientModel() {
		return clientModel;
	}

	public void setClientModel(ClientModel model) {
		this.clientModel = model;
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
        return clientModel.getDeck();
    }

    public void setDeck(DevCardList deck)  {
        clientModel.setDeck(deck);
    }

    public ResourceList getBank()  {
        return clientModel.getBank();
    }

    public void setBank(ResourceList bank)  {
        clientModel.setBank(bank);
    }

    public MessageList getChat()  {
        return clientModel.getChat();
    }

    public void setChat(MessageList chat)  {
        clientModel.setChat(chat);
    }

    public MessageList getLog()  {
        return clientModel.getLog();
    }

    public void setLog(MessageList log)  {
        clientModel.setLog(log);
    }

    public Map getMap()  {
        return clientModel.getMap();
    }

    public void setMap(Map map)  {
        clientModel.setMap(map);
    }

    public ArrayList<Player> getPlayers()  {
        return clientModel.getPlayers();
    }

    public void setPlayers(ArrayList<Player> players)  {
        clientModel.setPlayers(players);
    }

    public TradeOffer getTradeOffer()  {
        return clientModel.getTradeOffer();
    }

    public void setTradeOffer(TradeOffer tradeOffer)  {
        clientModel.setTradeOffer(tradeOffer);
    }

    public TurnTracker getTurnTracker()  {
        return clientModel.getTurnTracker();
    }

    public void setTurnTracker(TurnTracker turnTracker)  {
        clientModel.setTurnTracker(turnTracker);
    }

    public int getVersion()  {
        return clientModel.getVersion();
    }

    public void setVersion(int version)  {
        clientModel.setVersion(version);
    }

    public int getWinner()  {
        return clientModel.getWinner();
    }

    public void setWinner(int winner)  {
        clientModel.setWinner(winner);
    }
    
    public void setMapController(MapController mapController){
    	this.mapController = mapController;
    }

    public void setGameHistoryController(GameHistoryController gameHistoryController) {
    	this.gameHistoryController = gameHistoryController;
    }
    
    public void setChatController(ChatController chatcontroller)
    {
    	this.chatController=chatcontroller;
    }
    
    public void setTurnTrackerController(TurnTrackerController turnTrackerController){
    	this.turnTrackerController = turnTrackerController;
    }
    
    public void setRollController(RollController rollController) {
    	this.rollController = rollController;
    }
    
    public void setResourceBarController(ResourceBarController resourceBarController) {
    	this.resourceBarController = resourceBarController;
    }
    
    public void setDiscardController(DiscardController discardController){
    	this.discardController = discardController;
    }
    
    public void setPointsController(PointsController pointsController) {
    	this.pointsController = pointsController;
    }
    
    /**
     * checks newClientModel version against current client model version and updates if versions differ
     * @param newClientModel
     * @pre newClientModel != null
     * @post if version number is different, newClientModel replaces current client Model, otherwise, nothing happens.
     */
    public void updateClientModel(ClientModel newClientModel) {
    		clientModel = newClientModel;
            //Some kind of refresher function on the model needs to be called here to update the view of the GUI
    		if(mapController != null){
    			mapController.initFromModel(clientModel);
    		}
    		
    		if(gameHistoryController != null) {
    			gameHistoryController.initFromModel(clientModel);
    		}
    		
    		if(chatController != null) {
    			chatController.initFromModel(clientModel);
    		}
    		
    		if(turnTrackerController != null){
    			turnTrackerController.initFromModel(clientModel);
    		}
    		
    		if(rollController != null){
    			if(clientModel.canRollDice(playerIndex)) {
    				rollController.startRollGui();
    			}
    		}
    		
    		if(resourceBarController != null) {
    			resourceBarController.initFromModel(clientModel);
    		}
    		
    		if(discardController != null){
    			if(clientModel.mustDiscard(playerIndex)){
    				discardController.beginDiscarding();
    			}
    		}
    		
    		if(pointsController != null) {
    			pointsController.initFromModel(clientModel, playerIndex);
    		}
    		
    		if(clientModel.getWinner() != -1) {
    			pointsController.weHaveAWinner(playerIndex, clientModel.getWinner());
    		}
    }
    
    /**
     * checks whether a player has the longest road
     * @pre none
     * @post returns integer of the index of the player with the longest road. Player has longest road if road length is 5 and more than any other player. If nobody has longest road, returns -1
     */
    public int checkLongestRoad() {
        return clientModel.checkLongestRoad();
    }
    
    /**
     * checks whether a player has the largest army
     * @pre none
     * @post returns integer representing the index of the player with the largest army. Player has largest army if they have played at least 3 soldier cards and more soldier cards than any other player. If nobody has largest army, returns -1
     */
    public int checkLargestArmy() {
        return clientModel.checkLargestArmy();
    }
    
    /**
     * checks to see if a player has 10 victory points
     * @pre none
     * @post returns integer representing the index of the player who has 10 or more victory points. If no player has 10 or more victory points, returns -1
     */
    public int checkVictoryPoints() {
        return clientModel.checkVictoryPoints();
    }
    
//CanDo Methods Below********************************************************************************
    
    /**
     * 
     * Checks to see if the player is allowed to roll the dice
     * 
     * @pre none
     * @post Must be player's turn, and player hasn't rolled yet- return true. Otherwise returns false.   
     */
    public boolean canRollDice() {
        return clientModel.canRollDice(playerIndex);
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
    public boolean canBankTrade(PortType offer, PortType request) {
        return clientModel.canBankTrade(playerIndex, offer, request);
    }
    
    /**
     * 
     * Players are allowed to offer trades with other players 
     * 
     * @pre none
     * @post players turn, player has the number of resources they are attempting to trade return true. Otherwise return false. 
     */
    public boolean canOfferTrade(TradeOffer tradeOffer) {
        return clientModel.canOfferTrade(tradeOffer);
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
    public boolean canAcceptTrade(TradeOffer tradeOffer) {
        return clientModel.canAcceptTrade(playerIndex, tradeOffer);
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
        return clientModel.canBuyDevCard(playerIndex);
    }

    /**
     * 
     * Player attempts to build settlement
     * 
     * @pre none
     * @post Must be players turn, must have the required resources to build it, must have a settlement left, must be appropriately placed on the map - return true. Otherwise return false.
     */
    public boolean canBuildSettlement(VertexObject settlement) {
        return clientModel.canBuildSettlement(settlement);
    }
    
    /**
     * 
     * Player attempts to build city
     * 
     * @pre none
     * @post Must be players turn, must have the required resources to build it, settlement must already be built in the spot, must have a city left, must be appropriately placed on the map - return true. Otherwise return false.
     */
    public boolean canBuildCity(VertexObject city) {
        return clientModel.canBuildCity(city);
    }
    
    /**
     * 
     * Player attempts to build a road
     * 
     * @pre none
     * @post Must be a players turn, player must have required resources to build road, road must be appropriately placed on map, player must have a road left to build- return true. Otherwise false.
     */
    public boolean canBuildRoad(Road road) {
        return clientModel.canBuildRoad(road);
    }

    /**
     * 
     * Player attempts to play a development card 
     * 
     * @pre none
     * @post Player must have the development card, must be players turn, card can't have been received on the players turn- return true. Otherwise return false.
     */
    public boolean canPlayDevCard(DevCardType cardType) {
        return clientModel.canPlayDevCard(playerIndex, cardType);
    }
    
    /**
     * 
     * Player attempts to place a robber on a hex
     * 
     * @pre none
     * @post Must be players turn, player rolls a seven, must be appropriately placed- return true. Otherwise return false.
     */
    public boolean canPlaceRobber(int diceRoll, HexLocation hexLoc) {
        return clientModel.canPlaceRobber(playerIndex, diceRoll, hexLoc);
    }
    

    /**
     * 
     * Player attempts to steal a resource card
     * 
     * @pre none
     * @post Must be players turn, player must roll a seven, target player must have a resource card- return true. Otherwise return false
     */
    public boolean canStealResourceCard(int diceRoll, int targetPlayer) {
        return clientModel.canStealResourceCard(playerIndex, diceRoll, targetPlayer);
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
        return clientModel.mustDiscardHalfCards(diceRoll, playerIndex);
    }

    //ProxyServer (Do) Methods

    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param number
     * @pre playerIndex and number != null, number between 2 and 12 inclusive, playerIndex between 0 and 3 inclusive
     * @post Server receives information
     */
    public void rollNumber(int number) 
    {
    	this.diceRoll=number;
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
    public void roadBuilding(EdgeLocation spot1, EdgeLocation spot2) 
    {
        proxy.roadBuilding(playerIndex, spot1, spot2);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post Server receives information
     */
    public void finishTurn() 
    {
        proxy.finishTurn(playerIndex);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post Server receives information
     */
    public void buyDevCard() 
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
    public void yearOfPlenty(String resource1, String resource2) 
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
    public void soldier(int victimIndex, HexLocation location) 
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
    
    public void monument(int playerIndex) 
    {
        proxy.monument(playerIndex);
    }
    
    public void maritimeTrade(int ratio, String inputResource, String outputResource) {
    	proxy.maritimeTrade(playerIndex, ratio, inputResource, outputResource);
    }
    
    /**
     * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
     * @param playerIndex
     * @param roadLocation
     * @param free
     * @pre playerIndex between 0 and 3 inclusive and not null, roadLocation not null
     * @post Server receives information
     */
    public void buildRoad(EdgeLocation roadLocation, boolean free) 
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
    public void buildSettlement(VertexLocation vertexLocation, boolean free)
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
    public void buildCity(VertexLocation vertexLocation) 
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
    public void offerTrade(ResourceList offer, int receiver) 
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
    public void acceptTrade(boolean willAccept) 
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
    public void discardCards(ResourceList discardedCards) 
    {
        proxy.discardCards(playerIndex, discardedCards);
    }
    
    public void robPlayer(int victimIndex, HexLocation location) {
    	proxy.robPlayer(playerIndex, victimIndex, location);
    }
    
    public void refresh()
    {
    	updateClientModel(proxy.getClientModel(-1));
    }
    
	//----------------------------------------------SETTING COOKIES---------------------------------------------------//
	
	
	public boolean register(String username, String password)
	{
		boolean result = false;
		if(proxy.register(username, password))
		{
			result = true;
			this.username = username;
		}
		return result;
	}
	
	public boolean login(String username, String password)
	{
		boolean result = false;
		if(proxy.login(username, password))
		{
			result = true;
			this.username = username;
		}
		
		return result;
	}
	
	public void createGame(boolean randomTiles,boolean randomNumbers,boolean randomPorts, String gameName)
	{
		proxy.createGame(randomTiles, randomNumbers, randomPorts, gameName);
	}
	
	public boolean joinGame(String gameId, String color)
	{
		boolean result = false;
		if(proxy.joinGame(gameId, color))
		{
			result =true;
			//while(getClientModel().getVersion()==-1){} If this is too slow we can always go get the Client model directly
			ClientModel tempModel = proxy.getClientModel(-1);
			ArrayList<Player> temp = tempModel.getPlayers();
			for(int i = 0;i<temp.size();i++)
			{
				Player p = temp.get(i);
				if(p.getName().equals(username))
				{
					playerIndex = p.getPlayerIndex();
					this.playerId = p.getPlayerID();
					playerColor = temp.get(playerIndex).getColor();//Daniel added this code to change color of Gui to the local player's color
					turnTrackerController.initFromModel(playerColor);
					break;
				}
			}
			
		}
		//this.playerIndex=getPlayers().size(); Get 1 more than the current highest player index (before adding this player)
		
		return result;
	}
	
	public GamesList gamesList()
	{
		return proxy.getGamesList();
	}
	
	//Before using the Facade functions just make sure that function is doing exactly what you want it to do
	
}
