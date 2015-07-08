package client.facade;

import client.model.ClientModel;
import client.poller.ServerPoller;
import client.serverproxy.ServerProxy;

/**
 * Encapsulating class for the ClientModel, ServerPoller, and ServerProxy. The GUI calls methods on this class.
 * @author Ife's Group
 *
 */
public class Facade {
	private ClientModel model;
	private ServerProxy proxy;
	private ServerPoller poller;
	
	/*
	 * 
	 */
	public Facade() {
		model=new ClientModel();
		proxy=new ServerProxy("localhost");
		poller=new ServerPoller(proxy, this);
	
	}

	public ClientModel getModel() {
		return model;
	}

	public void setModel(ClientModel model) {
		this.model = model;
	}

	public ServerProxy getProxy() {
		return proxy;
	}

	public void setProxy(ServerProxy proxy) {
		this.proxy = proxy;
	}

	public ServerPoller getPoller() {
		return poller;
	}

	public void setPoller(ServerPoller poller) {
		this.poller = poller;
	}
	
}
