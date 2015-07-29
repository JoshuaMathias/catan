package server.command;

import java.util.ArrayList;

import server.facade.ServerFacade;
import shared.gameModel.GameModel;
import shared.gameModel.Map;
import shared.gameModel.Player;
import shared.gameModel.ResourceList;
import shared.gameModel.TurnTracker;
import shared.gameModel.VertexObject;
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
		ArrayList<Player> playerList = serverModel.getPlayers();
		ResourceList bank = serverModel.getBank();
	
		Player player = playerList.get(playerIndex);
		
		if(free == false) {
			updatePlayerResources(player);
			updateBankResources(bank);
		}
		
		player.decrementSettlement();
		Map map = serverModel.getMap();
		map.addSettlement(new VertexObject(playerIndex,vertexLocation));
	}
	
	private void updatePlayerResources(Player player) {
		
		ResourceList playerResourceList = player.getResources();
		int currentWood = playerResourceList.getWood();
		int currentWheat = playerResourceList.getWheat();
		int currentBrick = playerResourceList.getBrick();
		int currentSheep = playerResourceList.getSheep();
		
		playerResourceList.setWood(currentWood - 1);
		playerResourceList.setWheat(currentWheat - 1);
		playerResourceList.setBrick(currentBrick - 1);
		playerResourceList.setSheep(currentSheep - 1);
	}
	
	private void updateBankResources(ResourceList bank) {
		
		int currentBankWood = bank.getWood();
		int currentBankWheat = bank.getWheat();
		int currentBankBrick = bank.getBrick();
		int currentBankSheep = bank.getSheep();
		
		bank.setWood(currentBankWood + 1);
		bank.setWheat(currentBankWheat + 1);
		bank.setBrick(currentBankBrick + 1);
		bank.setSheep(currentBankSheep + 1);
	}

}
