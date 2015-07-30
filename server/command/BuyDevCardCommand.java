package server.command;

import java.util.Random;

import shared.definitions.DevCardType;
import shared.gameModel.DevCardList;
import shared.gameModel.GameModel;
import shared.gameModel.MessageLine;
import shared.gameModel.Player;
import shared.gameModel.ResourceList;

/**
 * 
 * @author Ifes Group
 *
 */
public class BuyDevCardCommand implements Command {

	int playerIndex;
	GameModel serverModel;
	
	public BuyDevCardCommand(int playerIndex, GameModel serverModel){
		this.playerIndex = playerIndex;
		this.serverModel = serverModel;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Random random = new Random();
//		int cardType = random.nextInt(25); //25 development cards possible
		Player player = serverModel.getPlayers().get(playerIndex);
		DevCardList deck = serverModel.getDeck();
		
		// sheep wheat ore
		ResourceList playerResources = player.getResources();
		playerResources.setSheep(playerResources.getSheep() - 1);
		playerResources.setWheat(playerResources.getWheat() - 1);
		playerResources.setOre(playerResources.getOre() - 1);
		
		ResourceList bank = serverModel.getBank();
		bank.setSheep(bank.getSheep() + 1);
		bank.setWheat(bank.getWheat() + 1);
		bank.setOre(bank.getOre() + 1);
		
		
		boolean noCardsLeftOfThatType = false;
		do{
			int cardType = random.nextInt(25); //25 development cards possible
			if(cardType < 5){
				//Monument victory Point
				if(deck.getMonument() < 1){
					noCardsLeftOfThatType = true;
				}
				else{
					deck.setMonument(deck.getMonument() - 1);
					player.addNewDevCard(DevCardType.MONUMENT);
					noCardsLeftOfThatType = false;
				}
			}
			else if(cardType >= 5 && cardType < 7){
				//RoadBuilding
				if(deck.getRoadBuilding() < 1){
					noCardsLeftOfThatType = true;
				}
				else{
					deck.setRoadBuilding(deck.getRoadBuilding() - 1);
					player.addNewDevCard(DevCardType.ROAD_BUILD);
					noCardsLeftOfThatType = false;
				}
			}
			else if(cardType >= 7 && cardType < 9){
				//YearOfPlenty
				if(deck.getYearOfPlenty() < 1){
					noCardsLeftOfThatType = true;
				}
				else{
					deck.setYearOfPlenty(deck.getYearOfPlenty() - 1);
					player.addNewDevCard(DevCardType.YEAR_OF_PLENTY);
					noCardsLeftOfThatType = false;
				}
			}
			else if(cardType >= 9 && cardType < 11){
				//Monopoly
				if(deck.getMonopoly() < 1){
					noCardsLeftOfThatType = true;
				}
				else{
					deck.setMonopoly(deck.getMonopoly() - 1);
					player.addNewDevCard(DevCardType.MONOPOLY);
					noCardsLeftOfThatType = false;
				}
			}
			else{
				//Soldier Card
				if(deck.getSoldier() < 1){
					noCardsLeftOfThatType = true;
				}
				else{
					deck.setSoldier(deck.getSoldier() - 1);
					player.addNewDevCard(DevCardType.SOLDIER);
					noCardsLeftOfThatType = false;
				}
			}
		}while(noCardsLeftOfThatType);
		
		
		MessageLine line = new MessageLine();
		String username = player.getName();
		if(username.toLowerCase().equals("ife") || username.toLowerCase().equals("ogeorge")){
			line.setMessage("Ife is a development card slut");
		}
		else{
			line.setMessage(username + " bought a development card");
		}
//		line.setMessage(username + " bought a development card");
		line.setSource(username);
		serverModel.getLog().addLine(line);
	}

}
