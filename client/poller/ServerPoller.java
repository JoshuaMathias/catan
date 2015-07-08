package client.poller;

import client.model.ClientModel;

/**
 * This class is for regularly updating the ClientModel of the game.
 * @author Ife's Group
 *
 */
public class ServerPoller {

	private int modelVersion;
	
	/**
	 * Returns the ClientModel.
	 * @return ClientModel
	 * @pre Need for the client model.
	 * @post The client model is returned.
	 */
	public ClientModel getClientModel() {
		return null;
	}
	
	/**
	 * Regularly updates the client model.
	 * @pre There is a change in the client model.
	 * @post The client model is updated.
	 */
	public void updateClientModel() {
		
	}
}
