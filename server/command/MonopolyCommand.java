package server.command;

import shared.definitions.ResourceType;
import shared.gameModel.GameModel;

public class MonopolyCommand implements Command {

	private int playerIndex;
	private ResourceType resource;
	private GameModel serverModel;
	
	public MonopolyCommand(int playerIndex, ResourceType resource,
			GameModel serverModel) {
		super();
		this.playerIndex = playerIndex;
		this.resource = resource;
		this.serverModel = serverModel;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
