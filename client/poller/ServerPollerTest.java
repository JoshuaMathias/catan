package client.poller;
import static org.junit.Assert.*;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.facade.Facade;
import client.model.ClientModel;
import client.poller.ServerPoller.updateTask;

public class ServerPollerTest {
	private Facade facade;
	private ClientModel model;
	
	@Before 
	public void setUp() {
		facade=new Facade("localhost");
	}
	
	@Test
	public void testPoller() {
		ClientModel model=facade.getModel();
		model.setWinner(2);
		Timer timer=new Timer();
//		timer.schedule(new pollTask(), 1100);
//		timer.schedule(new testPollerTask(), 0, interval*1000);
	}
	
	public class pollTask extends TimerTask {

		@Override
		public void run() {
			assertTrue(model.getWinner()==3);
		}
		
	}
	
	@After
	public void tearDown() {
		model=null;
		return;
	}
}
