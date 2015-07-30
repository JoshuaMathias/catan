package server.command;

import shared.gameModel.DevCardList;
import shared.gameModel.GameModel;
import shared.gameModel.Player;

/**
 * 
 * @author Ife's Group
 *
 */
public class MonumentCommand implements Command {

	private Player player;
	private DevCardList deck;
	
	public MonumentCommand(int playerIndex, GameModel serverModel) {
		
		this.deck = serverModel.getDeck();
		this.player = serverModel.getPlayers().get(playerIndex);
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
	}

}
