package testing.command;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.facade.ServerFacade;

public class DiscardCardsCommand {

	private ServerFacade serverFacade;
	
	@Before 
	public void setUp() {
		
		serverFacade = ServerFacade.getSingleton();
	}
	
	@After
	public void tearDown() {
		return;
	}
	
	@Test
	public void test() {
		
	}

}
