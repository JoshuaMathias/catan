package testing.command;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.facade.ServerFacade;
import shared.gameModel.GameModel;
import shared.gameModel.Map;
import shared.gameModel.VertexObject;
import shared.locations.HexLocation;
import shared.locations.VertexDirection;
import shared.locations.VertexLocation;

public class BuildSettlementCommand {
	
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
		
		VertexLocation vertexLocation = new VertexLocation(new HexLocation(3,0), VertexDirection.E);
		
		serverFacade.buildSettlement(0, vertexLocation, true, 0);
		
		GameModel gameModel = serverFacade.getGamesList().get(0);
		
		Map map = gameModel.getMap();
		ArrayList<VertexObject> settlements = map.getSettlements();
		System.out.println(settlements.get(0).toString());
	}
}
