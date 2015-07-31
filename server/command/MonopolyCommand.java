package server.command;

import java.util.ArrayList;

import shared.definitions.ResourceType;
import shared.gameModel.GameModel;
import shared.gameModel.Player;
import shared.gameModel.ResourceList;

public class MonopolyCommand implements Command {

	private int playerIndex;
	private ResourceType resource;
	private GameModel serverModel;
	
	private Player monopolyPlayer;
	private ResourceList monopolyPlayerResources;
	
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
		ArrayList<Player> players = serverModel.getPlayers();
		this.monopolyPlayer = players.get(playerIndex);
		this.monopolyPlayerResources = this.monopolyPlayer.getResources();
		
		for(Player player: players){
			if(player.getPlayerIndex() != playerIndex){
				stealResources(player);
			}
		}
	}

	private void stealResources(Player player) {
		// TODO Auto-generated method stub
		ResourceList playerResources = player.getResources();
		
		switch(resource){
		case brick:
			
			break;
		case ore:
			break;
		case sheep:
			break;
		case wheat:
			break;
		case wood:
			break;
		default:
			break;
		
		}
	}

}
