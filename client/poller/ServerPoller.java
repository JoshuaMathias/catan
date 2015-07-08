package client.poller;

import java.util.Timer;
import java.util.TimerTask;

import client.facade.Facade;
import client.model.ClientModel;
import client.serverproxy.ServerProxy;

/**
 * This class is for regularly updating the ClientModel of the game.
 * @author Ife's Group
 *
 */
public class ServerPoller {

	private int modelVersion;
	private ServerProxy proxy;
	private int interval;
	private Timer timer;
	private Facade facade;
	
	public ServerPoller(ServerProxy proxy, Facade facade) {
		this.proxy=proxy;
		this.facade=facade;
		interval=1;
		timer=new Timer();
		timer.schedule(new updateTask(), 0, interval*1000);
	}
	
	public class updateTask extends TimerTask {

		@Override
		public void run() {
			updateClientModel();
		}
		
	}
	/**
	 * Returns the ClientModel.
	 * @return ClientModel
	 * @pre Need for the client model.
	 * @post The client model is returned.
	 */
	public ClientModel getClientModel() {
		return proxy.getClientModel(modelVersion);
	}
	
	/**
	 * Regularly updates the client model.
	 * @pre There is a change in the client model.
	 * @post The client model is updated.
	 */
	public void updateClientModel() {
		modelVersion=facade.getVersion();
		ClientModel model=facade.getClientModel(modelVersion);
		facade.updateClientModel(model);
	}
}
