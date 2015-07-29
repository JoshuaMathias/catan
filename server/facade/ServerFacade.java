package server.facade;

import java.util.ArrayList;
import java.util.List;

import server.User;
import server.command.*;
import shared.gameModel.GameModel;
import shared.gameModel.Player;
import shared.gameModel.ResourceList;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;
import client.data.GameInfo;
import client.data.PlayerInfo;
import client.serverproxy.GamesList;
import client.data.*;

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
	public boolean acceptTrade(int playerIndex, boolean willAccept){
		return false;
	}
	
	/**
	 * Creates a BuildCityCommand object and executes it.
	 * @param playerIndex
	 * @param vertexLocation
	 * @param free
	 * @pre playerIndex between 0 and 3 inclusive and not null, vertexLocation not null
	 * @post City is placed. Player of given playerIndex loses 3 ore and 2 wheat.
	 */
	public boolean buildCity(int playerIndex, VertexLocation vertexLocation, int gameID){
		new BuildCityCommand(playerIndex, vertexLocation, gamesList.get(gameID)).execute();
		return false;
	}
	
    /**
     * Creates a BuildRoadCommand object and executes it.
     * @param playerIndex
     * @param roadLocation
     * @param free
     * @pre playerIndex between 0 and 3 inclusive and not null, roadLocation not null
     * @post Road is placed. Player of given playerIndex has 1 less brick and 1 less wood.
     */
	public boolean buildRoad(int playerIndex, EdgeLocation roadLocation, boolean free, int gameID){
		new BuildRoadCommand(playerIndex, roadLocation, free, gamesList.get(gameID)).execute();
		return false;
	}
	
    /**
     * Creates a BuildSettlementCommand object and executes it.
     * @param playerIndex
     * @param vertexLocation
     * @param free
     * @pre playerIndex between 0 and 3 inclusive and not null, vertexLocation not null
     * @post Settlement for player of given playerIndex is placed. Player loses 1 wood, 1 brick, 1 wool, and 1 wheat.
     */
	public boolean buildSettlement(int playerIndex, VertexLocation vertexLocation, boolean free, int gameID){
		new BuildSettlementCommand(playerIndex, vertexLocation, free, gamesList.get(gameID)).execute();
		return false;
	}
	
    /**
     * Creates a BuildSettlementCommand object and executes it.
     * @param playerIndex
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post The given player receives a random dev card and loses 1 ore, 1 wool, and 1 wheat.
     */
	public boolean buyDevCard(int playerIndex){
		return false;
	}
	
	/**
	 * Creates a CreateGameCommand object and executes it.
	 * @param randomTiles
	 * @param randomNumbers
	 * @param randomPorts
	 * @param gameName
	 * @pre A game is created and added to the games list using the given parameters.
	 */
	public GameInfo createGame(boolean randomTiles,boolean randomNumbers,boolean randomPorts, String gameName){
		new CreateGameCommand(randomTiles, randomNumbers, randomPorts, gameName).execute();
		ArrayList<PlayerInfo> players = new ArrayList<PlayerInfo>(4);
		while(players.size() < 4) players.add(null);
		return new GameInfo(gamesList.size()-1,gameName,players);
	}
	
	/**
	 * Creates a DiscardCardsCommand object and executes it.
	 * @param playerIndex
     * @param discardedCards
     * @pre playerIndex between 0 and 3 inclusive and not null, discardedCards not null
     * @post The player no longer has the specified discardedCards.
	 */
	public boolean discardCards(int playerIndex, ResourceList discardedCards){
		return false;
	}
	
	/**
	 * Creates a FinishTurnCommand object and executes it.
	 * @param sender
     * @pre playerIndex between 0 and 3 inclusive and not null
     * @post The player's turn has ended and the next player's turn has begun.
	 */
	public boolean finishTurn(){
		return false;
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
	 * Retures the list of games as GameInfo objects.
	 * @return The list of games as a GamesList.
	 * @pre There is at least 1 game.
	 * @post The games list is returned.
	 */
	public ArrayList<GameInfo> GamesList(){
		ArrayList<GameInfo> infoList = new ArrayList<GameInfo>();
		System.out.println("Number of games: "+gamesList.size());
		for (int i=0; i<gamesList.size(); i++) {
			ArrayList<Player> players = gamesList.get(i).getPlayers();
			ArrayList<PlayerInfo> playerInfos = new ArrayList<PlayerInfo>();
			for (int j=0; j<4; j++) {
				Player currentPlayer = null;
				if (j<players.size()) {
					currentPlayer = players.get(j);
				} else {
					currentPlayer = new Player();
				}
				playerInfos.add(new PlayerInfo(currentPlayer.getPlayerID(), currentPlayer.getPlayerIndex(), currentPlayer.getName(), currentPlayer.getColor()));
			}
			gamesList.get(i).getPlayers();
			GameInfo info = new GameInfo(i, gamesList.get(i).getGameName(), playerInfos);
			infoList.add(info);
		}
		return infoList;
	}
	
	/**
	 * Creates a JoinGameCommand object and executes it.
	 * @param gameID
	 * @param color
	 * @pre A game with the given ID exists. The given color is available. There aren't 4 other players already in the game.
	 * @post The player has joined the game.
	 */
	public boolean joinGame(String gameId, String color, int userID){
		return false;
	}
	
	/**
	 * Creates a LogInCommand object and executes it.
	 * @param username
	 * @param password
	 * @pre A user with the given username and password exists.
	 * @post The player is logged in as the user with the given username.
	 */
    public int logIn(String username, String password){
        for (int i=0; i<users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
                System.out.println("Login of "+username+" successful");
                return i;
            }
        }
        return -1;
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
	public boolean maritimeTrade(int playerIndex, int ratio, String inputResource, String outputResource){
		return false;
	}
	
	/**
	 * Creates a MonumentCommand object and executes it.
	 * @param playerIndex
	 * @pre The player of the given playerIndex has a monument card and it is their turn.
	 * @post The player gains a victory point.
	 */
	public boolean monument(int playerIndex){
		return false;
	}
	
	/**
	 * Creates a OfferTradeCommand object and executes it.
     * @param playerIndex
     * @param offer
     * @param receiver
     * @pre playerIndex and receiver between 0 and 3 inclusive and not null; offer not null.
     * @post The trade is offered from the given player to the receiver.
	 */
	public boolean offerTrade(int playerIndex, ResourceList offer, int receiver){
		return false;
	}
	
	/**
	 * Creates a RegisterCommand object and executes it.
	 * @param username
	 * @param password
	 * @pre A player with the given username does not already exist.
	 * @post A player with the given username and password is added to the list of users.
	 */
    public int register(String username, String password){
        System.out.println("Register in facade");
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return -1;
            }
        }
        User newUser = new User(username,password);
        users.add(newUser);
        System.out.println("Registration of "+username+" successful");
        return users.size()-1;
    }
	
	/**
	 * Creates a RoadBuildingCommand object and executes it.
	 * @param sender
	 * @param spot1
	 * @param spot2
	 * @pre playerIndex between 0 and 3 inclusive, playerIndex and spot1 and spot2 are not null
	 * @post Two roads are placed for free for the player of the given playerIndex.
	 */
	public boolean roadBuilding(int playerIndex, EdgeLocation spot1, EdgeLocation spot2){
		return false;
	}
	
	/**
	 * Creates a RobPlayerCommand object and executes it.
	 * @param playerIndex
	 * @param victimIndex
	 * @param location
	 * @pre The player of the given victimIndex has a resource to be robbed.
	 * @post The victim loses 1 random resource, which the robbing player gains.
	 */
		
	public boolean robPlayer(int playerIndex, int victimIndex, HexLocation location){
		return false;

	}
	
	/**
	 * Creates a RollNumberCommand object and executes it.
	 * @param sender
	 * @param number
	 * @pre playerIndex and number != null, number between 2 and 12 inclusive, playerIndex between 0 and 3 inclusive
	 * @post A random number between 2 and 12 is rolled. Player gain their corresponding resources.
	 */
	public boolean rollNumber(){
		return false;
	}
	
	/**
	 * Creates a SendChatCommand object and executes it.
	 */
	public boolean sendChat(String message){
		return false;
	}
	
	/**
	 * Creates a SoldierCommand object and executes it.
	 * @param playerIndex
     * @param victimIndex
     * @param location
	 * @pre The player has a soldier card, and the location is not the current location of the robber.
	 * @post The robber is moved to the given location.
	 */
	public boolean soldier(int playerIndex, int victimIndex, HexLocation location){
		return false;
	}
	
	/**
	 * Creates a YearOfPlentyCommand object and executes it.
     * @param playerIndex
     * @param resource1
     * @param resource2
     * @pre playerIndex between 0 and 3 inclusive and not null, both resources must not be null and one of the key words for resources.
     * @post The player of the given playerIndex has received the specified resources from the other players. 
	 */
	public boolean yearOfPlenty(int playerIndex, String resource1, String resource2){
		return false;
	}
	
	public void addGameToList(GameModel serverModel){
		gamesList.add(serverModel);
	}
	
	public ArrayList<GameModel> getGamesList() {
		return gamesList;
	}
	
	public boolean cookiesExist(User user,int gameIndex)
	{
		boolean result = true;
		
		for(User temp: users)
		{
			if(temp.getUsername())
		}
		
		if(gamesList.size()-1<gameIndex)
		{
			result = false;
		}
		
		return result;
	}
}
