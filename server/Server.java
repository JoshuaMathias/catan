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
	public ClientModel getClientModel(int version) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createGame(boolean randomTiles, boolean randomNumbers,
			boolean randomPorts, String gameName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void joinGame(String gameId, String color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gamesList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendChat(int playerIndex, String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void monument(int playerIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void robPlayer(int playerIndex, int victimIndex, HexLocation location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maritimeTrade(int playerIndex, int ratio, String inputResource,
			String outputResource) {
		// TODO Auto-generated method stub
		
	}

}
