package client.serverproxy;

import client.model.ClientModel;
import client.model.EdgeLocation;
import client.model.HexLocation;
import client.model.ResourceList;
import client.poller.ClientPoller;

/**
 * Proxy Server for the Client to interact with the Server. Packages information into objects and strings for the ClientCommunicator to send to the Server
 * @author Ife's Group
 *
 */
public class ServerProxy {

	private ClientPoller poller;
	private ClientCommunicator clientComm;
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param number
	 * @pre
	 * @post
	 */
	public void rollNumber(int playerIndex,int number) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param spot1
	 * @param spot2
	 * @pre
	 * @post
	 */
	public void roadBuilding(int playerIndex, EdgeLocation spot1, EdgeLocation spot2) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @pre
	 * @post
	 */
	public void finishTurn(int playerIndex) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @pre
	 * @post
	 */
	public void buyDevCard(int playerIndex) {
		//package input Params info
		//make String command
		//clientComm.send(command, info)
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param resource1
	 * @param resource2
	 * @pre
	 * @post
	 */
	public void yearOfPlenty(int playerIndex, String resource1, String resource2) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param victimIndex
	 * @param location
	 * @pre
	 * @post
	 */
	public void soldier(int playerIndex, int victimIndex, HexLocation location) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param resource
	 * @param playerIndex
	 * @pre
	 * @post
	 */
	public void monopoly(String resource, int playerIndex) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param roadLocation
	 * @param free
	 * @pre
	 * @post
	 */
	public void buildRoad(int playerIndex, EdgeLocation roadLocation, boolean free) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param vertexLocation
	 * @param free
	 * @pre
	 * @post
	 */
	public void buildSettlement(int playerIndex, EdgeLocation vertexLocation, boolean free) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param vertexLocation
	 * @param free
	 * @pre
	 * @post
	 */
	public void buildCity(int playerIndex, EdgeLocation vertexLocation, boolean free) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param offer
	 * @param receiver
	 * @pre
	 * @post
	 */
	public void offerTrade(int playerIndex, ResourceList offer, int receiver) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param willAccept
	 * @pre
	 * @post
	 */
	public void acceptTrade(int playerIndex, boolean willAccept) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param discardedCards
	 * @pre
	 * @post
	 */
	public void discardCards(int playerIndex, ResourceList discardedCards) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @pre
	 * @post
	 */
	public void getClientModel() {
		
	}

}
