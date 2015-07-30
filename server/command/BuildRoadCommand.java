package server.command;

import java.util.ArrayList;

import shared.gameModel.GameModel;
import shared.gameModel.Map;
import shared.gameModel.MessageLine;
import shared.gameModel.Player;
import shared.gameModel.ResourceList;
import shared.gameModel.Road;
import shared.locations.EdgeLocation;

/**
 * 
 * @author Ife's Group
 *
 */
public class BuildRoadCommand implements Command {

	private int playerIndex;
	private EdgeLocation roadLocation;
	private boolean free;
	private GameModel serverModel;
	private Player player;
	
	public BuildRoadCommand(int playerIndex, EdgeLocation roadLocation, boolean free, GameModel serverModel) {
		
		this.playerIndex = playerIndex;
		this.roadLocation = roadLocation;
		this.free = free;
		this.serverModel = serverModel;

	}
	
	@Override
	public void execute() {

		ArrayList<Player> playerList = serverModel.getPlayers();
		player = playerList.get(playerIndex);
		
		if(free == false) {
			updatePlayerResources();
			updateBankResources();
		}
		
		int currentRoads = player.getRoads();
		int updatedRoads = currentRoads - 1;
		
		player.setRoads(updatedRoads);
		
		Map map = serverModel.getMap();
		ArrayList<Road> roads = map.getRoads();
		
		roads.add(new Road(playerIndex, roadLocation.getNormalizedLocation()));
		map.setRoads(roads);
		
		MessageLine line = new MessageLine();
		String username = player.getName();
		line.setMessage(username + " layed a road");
		line.setSource(username);
		serverModel.getLog().addLine(line);
	}
	
	private void updatePlayerResources() {
		
		ResourceList playerResourceList = player.getResources();
		int currentBrick = playerResourceList.getBrick();
		int currentWood = playerResourceList.getWood();
		
		int updatedBrick = currentBrick - 1;
		int updatedWood = currentWood - 1;
		
		playerResourceList.setBrick(updatedBrick);
		playerResourceList.setWood(updatedWood);
	}
	
	private void updateBankResources() {
		
		ResourceList bank = serverModel.getBank();
		int currentBrick = bank.getBrick();
		int currentWood = bank.getWood();
		
		int updatedBrick = currentBrick + 1;
		int updatedWood = currentWood + 1;
		
		bank.setBrick(updatedBrick);
		bank.setWood(updatedWood);
	}

}
