package server.command;

import server.facade.ServerFacade;
import shared.gameModel.GameModel;
import shared.locations.VertexLocation;

/**
 * 
 * @author Ife's Group
 *
 */
public class BuildSettlementCommand implements Command {

	ServerFacade serverFacade;
	int playerIndex;
	VertexLocation vertexLocation;
	boolean free;
	
	public BuildSettlementCommand(int playerIndex,
			VertexLocation vertexLocation, boolean free) {
		// TODO Auto-generated constructor stub
		this.serverFacade = ServerFacade.getSingleton();
		this.playerIndex = playerIndex;
		this.vertexLocation = vertexLocation;
		this.free = free;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
//		serverFacade.getGameByCookie();
		GameModel serverModel = new ServerModel();
	}

}
