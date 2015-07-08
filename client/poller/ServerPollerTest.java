package client.poller;
import static org.junit.Assert.*;

import java.util.Timer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.facade.Facade;
import client.model.ClientModel;
import client.poller.ServerPoller.updateTask;

public class ServerPollerTest {
	private Facade facade;
	
	@Before 
	public void setUp() {
		facade=new Facade("localhost");
	}
	
	@Test
	public void testPoller() {
		ClientModel model=facade.getClientModel(1);
		model.setWinner(2);
		Timer timer=new Timer();
//		timer.schedule(new testPollerTask(), 0, interval*1000);
	}
	
	@After
	public void tearDown() {
		facade = null;
		return;
	}
}