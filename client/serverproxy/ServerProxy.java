package client.serverproxy;

import client.model.EdgeLocation;
import client.model.HexLocation;
import client.model.ResourceList;
import client.poller.ClientPoller;

/**
 * Proxy Server for the Client to interact with the Server
 * @author Ife's Group
 *
 */
public class ServerProxy {

	private ClientPoller poller;
	private ClientCommunicator clientComm;
	
	/**
	 * 
	 * @param num1
	 * @param num2
	 */
	public RollNumberParams rollNumber(int num1,int num2) {
		return null;
		
	}
	
	public RoadBuildingParams roadBuilding(int num, EdgeLocation loc, EdgeLocation loc_2) {
		return null;
		
	}
	
	public void finishTurn(int playerId) {
		
	}
	
	public void buyDevCard(int num) {
		
	}
	
	public void yearOfPlenty(int num, String s, String s2) {
		
	}
	
	public void soldier(int num1, int num2, HexLocation location) {
		
	}
	
	public void monopoly(String name, int num) {
		
	}
	
	public void buildRoad(int num, EdgeLocation location, boolean exist) {
		
	}
	
	public void buildSettlement(int num, EdgeLocation location, boolean exist) {
		
	}
	
	public void buildCity(int num, EdgeLocation location, boolean exist) {
		
	}
	
	public void offerTrade(int num, ResourceList resource, int num2) {
		
	}
	
	public void acceptTrade(int num, boolean accept) {
		
	}
	
	public void discardCards(int num, ResourceList resource) {
		
	}
	
	public void getClientModel() {
		
	}

}
