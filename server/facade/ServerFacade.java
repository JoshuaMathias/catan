package server.facade;

import java.util.ArrayList;

import server.User;
import server.command.BuildSettlementCommand;
import server.command.CreateGameCommand;
import shared.gameModel.GameModel;
import shared.gameModel.ResourceList;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;
import client.serverproxy.GamesList;

/**
 * The Server Facade. The facade contains the server model and the methods
 * that the handlers call for each command. The methods make a specific command
 * object and execute it.
 * @author Ife's Group
 *
 */
public class ServerFacade {
	
	private static ServerFacade serverFacade;
	private ArrayList<GameModel> gamesList = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	
	private ServerFacade(){
		
	}
	
	public static ServerFacade getSingleton(){
		if(serverFacade == null){
			serverFacade = new ServerFacade();
		}
		return serverFacade;
	}
// All methods return void only as placeholders. They should all return specific response types	
	/**
	 * Creates a AcceptTradeCommand object and executes it.
	 * @param playerIndex
	 * @param willAccept
	 * @pre playerIndex between 0 and 3 inclusive and not null
	 * @post Trade is accepted; resources are exchanged.
	 */
	public void acceptTrade(int playerIndex, boolean willAccept){
		
	}
	
	/**
	 * Creates a BuildCityCommand object and executes it.
	 * @param playerIndex
	 * @param vertexLocation
	 * @param free
	 * @pre playerIndex between 0 and 3 inclusive and not null, vertexLocation not null
	 * @post City is placed. Player of given playerIndex loses 3 ore and 2 wheat.
	 */
	public void buildCity(int playerIndex, VertexLocation vertexLocation){
		
	}
	
    /**
     * Creates a BuildRoadCommand object and executes it.
     * @param playerIndex
     * @param roadLocation
     * @param free
     * @pre playerIndex between 0 and 3 inclusive and not null, roadLocation not null
     * @post Road is placed. Player of given playerIndex has 1 less brick and 1 less wood.
     */
	public void buildRoad(int playerIndex, EdgeLocation roadLocation, boolean free){
		
	}
	
    /**
     * Creates a BuildSettlementCommand object and executes it.
     * @param playerIndex
     * @param vertexLocation
     * @param free
     * @pre playerIndex between 0 and 3 inclusive and not null, vertexLocation not null
     * @post Settlement for player of given playerIndex is placed. Player loses 1 wood, 1 brick, 1 wool, and 1 wheat.
     */
	public void buildSettlement(int playerIndex, VertexLocation vertexLocation, boolean free, int gameID){
		new BuildSettlementCommand(playerIndex, vertexLocation, free, gameID).execute();
	}
	
    /**
     * Creates a BuildSettlementCommand object and executes it.
     * @param playerIndex
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post The given player receives a random dev card and loses 1 ore, 1 wool, and 1 wheat.
     */
	public void buyDevCard(int playerIndex){
		
	}
	
	/**
	 * Creates a CreateGameCommand object and executes it.
	 * @param randomTiles
	 * @param randomNumbers
	 * @param randomPorts
	 * @param gameName
	 * @pre A game is created and added to the games list using the given parameters.
	 */
	public void createGame(boolean randomTiles,boolean randomNumbers,boolean randomPorts, String gameName){
		new CreateGameCommand(randomTiles, randomNumbers, randomPorts, gameName).execute();
	}
	
	/**
	 * Creates a DiscardCardsCommand object and executes it.
	 * @param playerIndex
     * @param discardedCards
     * @pre playerIndex between 0 and 3 inclusive and not null, discardedCards not null
     * @post The player no longer has the specified discardedCards.
	 */
	public void discardCards(int playerIndex, ResourceList discardedCards){
		
	}
	
	/**
	 * Creates a FinishTurnCommand object and executes it.
	 * @param playerIndex
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post The player's turn has ended and the next player's turn has begun.
	 */
	public void finishTurn(){
		
	}
	
	/**
	 * Creates a GameModelCommand object and executes it.
	 * @return The game model.
	 * @pre Game cookie header is set.
	 * @post The model for the current game is returned.
	 */
	public GameModel GameModel() {
		return null;
	}
	
	/**
	 * Creates a GamesListCommand object and executes it.
	 * @return The list of games as a GamesList.
	 * @pre There is at least 1 game.
	 * @post The games list is returned.
	 */
	public GamesList GamesList(){
		return null;
	}
	
	/**
	 * Creates a JoinGameCommand object and executes it.
	 * @param gameID
	 * @param color
	 * @pre A game with the given ID exists. The given color is available. There aren't 4 other players already in the game.
	 * @post The player has joined the game.
	 */
	public void joinGame(String gameId, String color){
		
	}
	
	/**
	 * Creates a LogInCommand object and executes it.
	 * @param username
	 * @param password
	 * @pre A user with the given username and password exists.
	 * @post The player is logged in as the user with the given username.
	 */
	public void logIn(String username, String password){
		
	}
	
	/**
	 * Creates a MaritimeTradeCommand object and executes it.
	 * @param playerIndex
	 * @param ratio
	 * @param inputResources
	 * @param outputResource
	 * @pre The given resources are available. The player has a settlement or city by a port of the given ratio that applies for the given resources.
	 * @post The given resources are exchanged between the player and the bank.
	 */
	public void maritimeTrade(int playerIndex, int ratio, String inputResource, String outputResource){
		
	}
	
	/**
	 * Creates a MonumentCommand object and executes it.
	 * @param playerIndex
	 * @pre The player of the given playerIndex has a monument card and it is their turn.
	 * @post The player gains a victory point.
	 */
	public void monument(int playerIndex){
		
	}
	
	/**
	 * Creates a OfferTradeCommand object and executes it.
     * @param playerIndex
     * @param offer
     * @param receiver
     * @pre playerIndex and receiver between 0 and 3 inclusive and not null; offer not null.
     * @post The trade is offered from the given player to the receiver.
	 */
	public void offerTrade(int playerIndex, ResourceList offer, int receiver){
		
	}
	
	/**
	 * Creates a RegisterCommand object and executes it.
	 * @param username
	 * @param password
	 * @pre A player with the given username does not already exist.
	 * @post A player with the given username and password is added to the list of users.
	 */
	public void register(String username, String password){
		
	}
	
	/**
	 * Creates a RoadBuildingCommand object and executes it.
	 * @param playerIndex
	 * @param spot1
	 * @param spot2
	 * @pre playerIndex between 0 and 3 inclusive, playerIndex and spot1 and spot2 are not null
	 * @post Two roads are placed for free for the player of the given playerIndex.
	 */
	public void roadBuilding(){
		
	}
	
	/**
	 * Creates a RobPlayerCommand object and executes it.
	 * @param playerIndex
	 * @param victimIndex
	 * @param location
	 * @pre The player of the given victimIndex has a resource to be robbed.
	 * @post The victim loses 1 random resource, which the robbing player gains.
	 */
	public void robPlayer(int playerIndex, int victimIndex, HexLocation location){
		
	}
	
	/**
	 * Creates a RollNumberCommand object and executes it.
	 * @param playerIndex
	 * @param number
	 * @pre playerIndex and number != null, number between 2 and 12 inclusive, playerIndex between 0 and 3 inclusive
	 * @post A random number between 2 and 12 is rolled. Player gain their corresponding resources.
	 */
	public void rollNumber(){
		
	}
	
	/**
	 * Creates a SendChatCommand object and executes it.
	 */
	public void sendChat(String message){
		
	}
	
	/**
	 * Creates a SoldierCommand object and executes it.
	 * @param playerIndex
     * @param victimIndex
     * @param location
	 * @pre The player has a soldier card, and the location is not the current location of the robber.
	 * @post The robber is moved to the given location.
	 */
	public void soldier(int playerIndex, int victimIndex, HexLocation location){
		
	}
	
	/**
	 * Creates a YearOfPlentyCommand object and executes it.
     * @param playerIndex
     * @param resource1
     * @param resource2
     * @pre playerIndex between 0 and 3 inclusive and not null, both resources must not be null and one of the key words for resources.
     * @post The player of the given playerIndex has received the specified resources from the other players. 
	 */
	public void yearOfPlenty(int playerIndex, String resource1, String resource2){
		
	}
	
	public void addGameToList(GameModel serverModel){
		gamesList.add(serverModel);
	}
	
	public ArrayList<GameModel> getGamesList() {
		return gamesList;
	}
}
