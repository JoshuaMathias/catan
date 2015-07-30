package server.command;

import shared.gameModel.DevCardList;
import shared.gameModel.GameModel;
import shared.gameModel.MessageLine;
import shared.gameModel.Player;

/**
 * 
 * @author Ife's Group
 *
 */
public class MonumentCommand implements Command {

	private Player player;
	private DevCardList deck;
	private GameModel serverModel;
	
	public MonumentCommand(int playerIndex, GameModel serverModel) {
		
		this.deck = serverModel.getDeck();
		this.player = serverModel.getPlayers().get(playerIndex);
		this.serverModel = serverModel;
	}
	
	@Override
	public void execute() {
		
		DevCardList oldDevCards = player.getOldDevCards();
		int oldDevMonumentAmount= oldDevCards.getMonument();
		if(oldDevMonumentAmount > 0) {
			
			oldDevMonumentAmount -= 1;
			oldDevCards.setMonument(oldDevMonumentAmount);
		} 
		else {
			
			DevCardList newDevCards = player.getNewDevCards();
			int newDevMonumentAmount = newDevCards.getMonument();
			newDevMonumentAmount -= 1;
			newDevCards.setMonument(newDevMonumentAmount);
		}
		
		int victoryPoints = player.getVictoryPoints();
		victoryPoints += 1;
		player.setVictoryPoints(victoryPoints);
		
		/*int monumentAmount = deck.getMonument();
		monumentAmount += 1;
		deck.setMonument(monumentAmount);*/
		
		MessageLine line = new MessageLine();
		String username = player.getName();
		line.setMessage(username + " played a Monument card");
		line.setSource(username);
		serverModel.getLog().addLine(line);
	}

}
