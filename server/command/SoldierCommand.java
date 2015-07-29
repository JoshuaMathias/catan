package server.command;

import shared.gameModel.DevCardList;
import shared.gameModel.GameModel;
import shared.gameModel.Player;
import shared.locations.HexLocation;

/**
 * 
 * @author Ife's Group
 *
 */
public class SoldierCommand implements Command {

	int playerIndex;
	int victimIndex;
	HexLocation location;
	GameModel serverModel;
	
	public SoldierCommand(int playerIndex, int victimIndex, HexLocation location, GameModel serverModel) {
		super();
		this.playerIndex = playerIndex;
		this.victimIndex = victimIndex;
		this.location = location;
		this.serverModel = serverModel;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		new RobPlayerCommand(playerIndex, victimIndex, location, serverModel).execute();
		
		Player player = serverModel.getPlayers().get(playerIndex);
		DevCardList playerOldDevCardList = player.getOldDevCards();
		playerOldDevCardList.setSoldier(playerOldDevCardList.getSoldier() - 1);
		player.setPlayedDevCard(true);
	}

}
