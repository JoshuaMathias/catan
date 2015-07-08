package client.serverproxy;

import com.google.gson.Gson;

import client.model.ClientModel;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;
import client.model.ResourceList;
import client.poller.ServerPoller;

/**
 * Proxy Server for the Client to interact with the Server. Packages information into objects and strings for the ClientCommunicator to send to the Server
 * @author Ife's Group
 *
 */
public class ServerProxy {

	//This class might have to be a singleton
	private Gson g = new Gson();
	private String hostname = "";
	private ServerPoller poller; // Pretty sure that the server proxy will not have a poller but the poller will have
								// A serverproxy singleton 
	private ClientCommunicator clientComm;
	
	public ServerProxy(String hostname)
	{
		this.hostname = hostname;
		clientComm = new ClientCommunicator (hostname);
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param number
	 * @pre playerIndex and number != null, number between 2 and 12 inclusive, playerIndex between 0 and 3 inclusive
	 * @post Server receives information
	 */
	public void rollNumber(int playerIndex, int number) 
	{
		RollNumberParams rnp = new RollNumberParams();
		rnp.setNumber(number);
		rnp.setPlayerIndex(playerIndex);
		String input = g.toJson(rnp);
		System.out.println(clientComm.send("moves/rollNumber", input));
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
		RoadBuildingParams roadbuilding = new RoadBuildingParams();
		roadbuilding.setPlayerIndex(playerIndex);
		roadbuilding.setSpot1(spot1);
		roadbuilding.setSpot2(spot2);
		String input = g.toJson(roadbuilding);
		clientComm.send("moves/Road_Building", input);
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @pre playerIndex between 0 and 3 inclusive and not null
	 * @post Server receives information
	 */
	public void finishTurn(int playerIndex) 
	{
		FinishTurnParams finishturn = new FinishTurnParams ();
		finishturn.setPlayerIndex(playerIndex);
		String input = g.toJson(finishturn);
		clientComm.send("moves/finishTurn",input);
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @pre playerIndex between 0 and 3 inclusive and not null
	 * @post Server receives information
	 */
	public void buyDevCard(int playerIndex) 
	{
		BuyDevCardParams buydevcard = new BuyDevCardParams();
		buydevcard.setPlayerIndex(playerIndex);
		String input = g.toJson(buydevcard);
		clientComm.send("moves/buyDevCard",input);
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
		YearOfPlentyParams yearofplenty = new YearOfPlentyParams ();
		yearofplenty.setPlayerIndex(playerIndex);
		yearofplenty.setResource1(resource1);
		yearofplenty.setResource2(resource2);
		String input = g.toJson(yearofplenty);
		clientComm.send("moves/Year_of_Plenty",input);
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
		SoldierParams soldier = new SoldierParams();
		soldier.setPlayerIndex(playerIndex);
		soldier.setVictimIndex(victimIndex);
		soldier.setLocation(location);
		String input = g.toJson(soldier);
		clientComm.send("moves/Soldier",input);
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
		MonopolyParams monopoly = new MonopolyParams ();
		monopoly.setPlayerIndex(playerIndex);
		monopoly.setResource(resource);
		String input = g.toJson(monopoly);
		clientComm.send("moves/Monopoly", input);
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
		BuildRoadParams buildroad = new BuildRoadParams();
		buildroad.setPlayerIndex(playerIndex);
		buildroad.setRoadLocation(roadLocation);
		buildroad.setFree(free);
		String input = g.toJson(buildroad);
		clientComm.send("moves/buildRoad",input);
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
		BuildSettlementParams buildsettlement = new BuildSettlementParams ();
		buildsettlement.setPlayerIndex(playerIndex);
		buildsettlement.setFree(free);
		buildsettlement.setVertexLocation(vertexLocation);
		String input = g.toJson(buildsettlement);
		clientComm.send("moves/buildSettlement", input);
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
		BuildCityParams buildcity = new BuildCityParams();
		buildcity.setPlayerIndex(playerIndex);
		buildcity.setVertexLocation(vertexLocation);
		String input = g.toJson(buildcity);
		clientComm.send("moves/buildCity",input);
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
		OfferTradeParams offertrade = new OfferTradeParams();
		offertrade.setOffer(offer);
		offertrade.setPlayerIndex(playerIndex);
		offertrade.setReceiver(receiver);
		String input = g.toJson(offertrade);
		clientComm.send("moves/offerTrade",input);
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
		AcceptTradeParams accepttrade = new AcceptTradeParams();
		accepttrade.setPlayerIndex(playerIndex);
		accepttrade.setWillAccept(willAccept);
		String input = g.toJson(accepttrade);
		clientComm.send("moves/acceptTrade",input);
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
		DiscardCardsParams discardcards = new DiscardCardsParams();
		discardcards.setDiscardedCards(discardedCards);
		discardcards.setPlayerIndex(playerIndex);
		String input = g.toJson(discardcards);
		clientComm.send("moves/discardCards",input);
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @pre none
	 * @post Server receives information
	 */
	public ClientModel getClientModel(int version) 
	{
		ClientModel newclient = null;
		String JsonClient = clientComm.send("game/model?version="+version, "");
		if(!JsonClient.equals("\"true\"\r"))
		{
			newclient = g.fromJson(JsonClient, ClientModel.class);
		}
		return newclient;
	}
	
	
	//----------------------------------------------SETTING COOKIES---------------------------------------------------//
	
	
	public void register(String username, String password)
	{
		RegisterParams register = new RegisterParams(username,password);
		String input = g.toJson(register);
		clientComm.send("user/register", input);
	}
	
	public void login(String username, String password)
	{
		LoginParams login = new LoginParams(username,password);
		String input = g.toJson(login);
		clientComm.send("user/login",input);
	}
	
	public void createGame(boolean randomTiles,boolean randomNumbers,boolean randomPorts, String gameName)
	{
		CreateGamesParams creategame = new CreateGamesParams(randomTiles, randomNumbers, randomPorts, gameName);
		String input = g.toJson(creategame);
		clientComm.send("games/create", input);
	}
	
	public void joinGame(String gameId, String color)
	{
		JoinGameParams joingame = new JoinGameParams(gameId,color);
		String input = g.toJson(joingame);
		clientComm.send("games/join", input);
	}
	
	//We might want to return something here. 
	//List a list of games object so that a user may know what games are available.
	public void gamesList()
	{
		
	}

	public static void main(String arg[])
	{
		String u = "ogeorge";
		String p = "cookies";
		
		ServerProxy server = new ServerProxy("longbow");
		//server.register(u, p);
		server.login(u, p);
		//server.createGame(true,true,true,"test");
		server.joinGame("3", "red");
		server.buyDevCard(0);
		ClientModel yes = server.getClientModel(0);			//Will return null because of version number
	}
}
