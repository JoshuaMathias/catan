package server.command;

import java.util.Random;

import shared.gameModel.GameModel;
import shared.gameModel.MessageLine;
import shared.gameModel.Player;
import shared.gameModel.ResourceList;
import shared.locations.HexLocation;

/**
 * 
 * @author Ife's Group
 *
 */
public class RobPlayerCommand implements Command {

	private int playerIndex; 
	private int victimIndex; 
	private HexLocation robber;
	private GameModel serverModel;
	
	private Player player;
	private Player victim;
	
	public RobPlayerCommand(int playerIndex, int victimIndex,
			HexLocation robber, GameModel serverModel) {
		super();
		this.playerIndex = playerIndex;
		this.victimIndex = victimIndex;
		this.robber = robber;
		this.serverModel = serverModel;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(victimIndex != -1){
			Random random = new Random();
			
			victim = serverModel.getPlayers().get(victimIndex);
			ResourceList victimResources = victim.getResources();
			
			player = serverModel.getPlayers().get(playerIndex);
			ResourceList playerResources = player.getResources();
			
			boolean noneOfThatResource = false;
			do{
				int resourceToSteal = random.nextInt(5);
				switch(resourceToSteal){
				case 0:
					if(victimResources.getWood() < 1){
						noneOfThatResource = true;
					}
					else{
						victimResources.setWood(victimResources.getWood() - 1);
						playerResources.setWood(playerResources.getWood() + 1);
						noneOfThatResource = false;
					}
					break;
				case 1:
					if(victimResources.getWheat() < 1){
						noneOfThatResource = true;
					}
					else{
						victimResources.setWheat(victimResources.getWheat() - 1);
						playerResources.setWheat(playerResources.getWheat() + 1);
						noneOfThatResource = false;
					}
					break;
				case 2:
					if(victimResources.getOre() < 1){
						noneOfThatResource = true;
					}
					else{
						victimResources.setOre(victimResources.getOre() - 1);
						playerResources.setOre(playerResources.getOre() + 1);
						noneOfThatResource = false;
					}
					break;
				case 3:
					if(victimResources.getBrick() < 1){
						noneOfThatResource = true;
					}
					else{
						victimResources.setBrick(victimResources.getBrick() - 1);
						playerResources.setBrick(playerResources.getBrick() + 1);
						noneOfThatResource = false;
					}
					break;
				case 4:
					if(victimResources.getSheep() < 1){
						noneOfThatResource = true;
					}
					else{
						victimResources.setSheep(victimResources.getSheep() - 1);
						playerResources.setSheep(playerResources.getSheep() + 1);
						noneOfThatResource = false;
					}
					break;
				}
			}while(noneOfThatResource);
			
			MessageLine line = new MessageLine();
			String username = player.getName();
			line.setMessage(username + " moved the robber and robbed from " + victim.getName());
			line.setSource(username);
			serverModel.getLog().addLine(line);
		}
		else{
			MessageLine line = new MessageLine();
			String username = player.getName();
			line.setMessage(username + " moved the robber, but did not rob from anybody");
			line.setSource(username);
			serverModel.getLog().addLine(line);
		}
		
		
		serverModel.getMap().setRobber(robber);
		
		serverModel.getTurnTracker().setStatus("Playing");
	}

	
}
