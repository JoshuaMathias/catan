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
	 * @pre playerIndex and number != null, number between 2 and 12 inclusive, playerIndex between 0 and 3 inclusive
	 * @post Server receives information
	 */
	public void rollNumber(int playerIndex, int number) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param spot1
	 * @param spot2
	 * @pre playerIndex between 0 and 3 inclusive, playerIndex and spot1 and spot2 are not null
	 * @post Server receives information
	 */
	public void roadBuilding(int playerIndex, EdgeLocation spot1, EdgeLocation spot2) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @pre playerIndex between 0 and 3 inclusive and not null
	 * @post Server receives information
	 */
	public void finishTurn(int playerIndex) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @pre playerIndex between 0 and 3 inclusive and not null
	 * @post Server receives information
	 */
	public void buyDevCard(int playerIndex) {

	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param resource1
	 * @param resource2
	 * @pre playerIndex between 0 and 3 inclusive and not null, both resources must not be null and one of the key words for resources
	 * @post Server receives information
	 */
	public void yearOfPlenty(int playerIndex, String resource1, String resource2) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param victimIndex
	 * @param location
	 * @pre 
	 * @post Server receives information
	 */
	public void soldier(int playerIndex, int victimIndex, HexLocation location) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param resource
	 * @param playerIndex
	 * @pre
	 * @post Server receives information
	 */
	public void monopoly(String resource, int playerIndex) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param roadLocation
	 * @param free
	 * @pre
	 * @post Server receives information
	 */
	public void buildRoad(int playerIndex, EdgeLocation roadLocation, boolean free) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param vertexLocation
	 * @param free
	 * @pre
	 * @post Server receives information
	 */
	public void buildSettlement(int playerIndex, EdgeLocation vertexLocation, boolean free) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param vertexLocation
	 * @param free
	 * @pre
	 * @post Server receives information
	 */
	public void buildCity(int playerIndex, EdgeLocation vertexLocation, boolean free) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param offer
	 * @param receiver
	 * @pre
	 * @post Server receives information
	 */
	public void offerTrade(int playerIndex, ResourceList offer, int receiver) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param willAccept
	 * @pre
	 * @post Server receives information
	 */
	public void acceptTrade(int playerIndex, boolean willAccept) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @param playerIndex
	 * @param discardedCards
	 * @pre
	 * @post Server receives information
	 */
	public void discardCards(int playerIndex, ResourceList discardedCards) {
		
	}
	
	/**
	 * Creates appropriate communication class and generates command string for Client Communicator. Sends to Server via Client Communicator.
	 * @pre
	 * @post Server receives information
	 */
	public void getClientModel() {
		
	}

}
