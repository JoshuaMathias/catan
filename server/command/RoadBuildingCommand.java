package server.command;

import shared.gameModel.DevCardList;
import shared.gameModel.GameModel;
import shared.gameModel.Player;
import shared.gameModel.Road;
import shared.locations.EdgeLocation;

/**
 * 
 * @author Ife's Group
 *
 */
public class RoadBuildingCommand implements Command {
	
	private int sender;
	private EdgeLocation spot1;
	private EdgeLocation spot2;
	private GameModel serverModel;
	
	public RoadBuildingCommand(int sender, EdgeLocation spot1,
			EdgeLocation spot2, GameModel serverModel) {
		super();
		this.sender = sender;
		this.spot1 = spot1;
		this.spot2 = spot2;
		this.serverModel = serverModel;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		DevCardList deck = serverModel.getDeck();
		Player player = serverModel.getPlayers().get(sender);
		DevCardList playerOldDevCards = player.getOldDevCards();
		
		deck.setRoadBuilding(deck.getRoadBuilding() + 1);
		playerOldDevCards.setRoadBuilding(playerOldDevCards.getRoadBuilding() - 1);
		
		serverModel.getMap().addRoad(new Road(sender, spot1));
		serverModel.getMap().addRoad(new Road(sender, spot2));
		
		player.setRoads(player.getRoads() - 2);
		
		player.setPlayedDevCard(true);
	}

}
