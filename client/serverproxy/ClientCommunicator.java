package client.serverproxy;

import client.model.ClientModel;

/**
 * Packages and sends commands to the Server from the ServerProxy
 * @author Ife's Group
 *
 */
public class ClientCommunicator {
	
	/**
	 * packages information from ServerProxy and sends to Server
	 * @param command
	 * @param params
	 * @pre command is a valid command that the Server would understand. Params must not be null and all can do methods applying to the command in the client model have returned true
	 * @post sends the command and params to the server
	 */
	public ClientModel send(String command, Object params){
		return null;
		
	}
}
