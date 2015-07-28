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
	private GameModel serverModel;
	
	public BuildSettlementCommand(int playerIndex,
			VertexLocation vertexLocation, boolean free, GameModel serverModel) {
		// TODO Auto-generated constructor stub
		this.serverFacade = ServerFacade.getSingleton();
		this.playerIndex = playerIndex;
		this.vertexLocation = vertexLocation;
		this.free = free;
		this.serverModel = serverModel;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
	}

}
