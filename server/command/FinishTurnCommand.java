package server.command;

import java.util.ArrayList;

import shared.gameModel.DevCardList;
import shared.gameModel.GameModel;
import shared.gameModel.Player;
import shared.gameModel.TurnTracker;

/**
 * 
 * @author Ife's Group
 *
 */
public class FinishTurnCommand implements Command {

	private GameModel serverModel;
	
	public FinishTurnCommand(GameModel serverModel){
		this.serverModel = serverModel;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		TurnTracker turnTracker = serverModel.getTurnTracker();
		int currentTurn = turnTracker.getCurrentTurn();
		String status = turnTracker.getStatus();
		
		switch(status){
		case "FirstRound":
			if(currentTurn >= 3){
				turnTracker.setStatus("SecondRound");
			}
			break;
		case "SecondRound":
			if(currentTurn >= 3){
				turnTracker.setStatus("Playing");
			}
			break;
		case "Playing":
			newToOldDevCards(currentTurn);//moves new devcards out of newDevCardList and into oldDevCardList
		}
		turnTracker.nextTurn();
		
		resetDiscarded();
		
		// increment/decrement 2 points as appropriate
		int longestRoad = serverModel.checkLongestRoad();
		if(longestRoad != -1){
			int previousLongestRoad = turnTracker.getLongestRoad();
			turnTracker.setLongestRoad(longestRoad);
			if(previousLongestRoad != longestRoad){
				Player player = serverModel.getPlayers().get(longestRoad);
				player.setVictoryPoints(player.getVictoryPoints() + 2);
				if(previousLongestRoad != -1){
					Player previousPlayer = serverModel.getPlayers().get(previousLongestRoad);
					previousPlayer.setVictoryPoints(previousPlayer.getVictoryPoints() - 2);
				}
			}
			
			
		}
		
		// increment/decrement 2 points as appropriate
		int largestArmy = serverModel.checkLargestArmy();
		if(largestArmy != -1){
			int previousLargestArmy = turnTracker.getLargestArmy();
			turnTracker.setLargestArmy(largestArmy);
			if(previousLargestArmy != largestArmy){
				Player player = serverModel.getPlayers().get(largestArmy);
				player.setVictoryPoints(player.getVictoryPoints() + 2);
				if(previousLargestArmy != -1){
					Player previousPlayer = serverModel.getPlayers().get(previousLargestArmy);
					previousPlayer.setVictoryPoints(previousPlayer.getVictoryPoints() - 2);
				}
			}
			
		}
	}

	private void resetDiscarded() {
		// TODO Auto-generated method stub
		ArrayList<Player> players = serverModel.getPlayers();
		for (Player player: players){
			player.setDiscarded(false);
		}
	}

	private void newToOldDevCards(int currentTurn) {
		// TODO Auto-generated method stub
		Player player = serverModel.getPlayers().get(currentTurn);
		player.setPlayedDevCard(false);
		
		DevCardList newDevCards = player.getNewDevCards();
		DevCardList oldDevCards = player.getOldDevCards();
		
		oldDevCards.setMonopoly(oldDevCards.getMonopoly() + newDevCards.getMonopoly());
		oldDevCards.setMonument(oldDevCards.getMonument() + newDevCards.getMonument());
		oldDevCards.setRoadBuilding(oldDevCards.getRoadBuilding() + newDevCards.getRoadBuilding());
		oldDevCards.setSoldier(oldDevCards.getSoldier() + newDevCards.getSoldier());
		oldDevCards.setYearOfPlenty(oldDevCards.getYearOfPlenty() + newDevCards.getYearOfPlenty());
	}

}
