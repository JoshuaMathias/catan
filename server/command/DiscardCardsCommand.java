package server.command;

import shared.gameModel.GameModel;
import shared.gameModel.Player;
import shared.gameModel.ResourceList;

/**
 * 
 * @author Ife's Group
 *
 */
public class DiscardCardsCommand implements Command {

	private int playerIndex;
	private ResourceList discardedCards;
	private GameModel serverModel;
	
	public DiscardCardsCommand(int playerIndex, ResourceList discardedCards, GameModel serverModel){
		this.playerIndex = playerIndex;
		this.discardedCards = discardedCards;
		this.serverModel = serverModel;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Player player = serverModel.getPlayers().get(playerIndex);
		ResourceList playerResources = player.getResources();
		int BrickToDiscard = discardedCards.getBrick();
		int WheatToDiscard = discardedCards.getWheat();
		int OreToDiscard = discardedCards.getOre();
		int WoodToDiscard = discardedCards.getWood();
		int SheepToDiscard = discardedCards.getSheep();
		
		playerResources.setBrick(playerResources.getBrick() - BrickToDiscard);
		playerResources.setWheat(playerResources.getWheat() - WheatToDiscard);
		playerResources.setOre(playerResources.getOre() - OreToDiscard);
		playerResources.setWood(playerResources.getWood() - WoodToDiscard);
		playerResources.setSheep(playerResources.getSheep() - SheepToDiscard);
		
		ResourceList bank = serverModel.getBank();
		bank.setBrick(bank.getBrick() + BrickToDiscard);
		bank.setWheat(bank.getWheat() + WheatToDiscard);
		bank.setOre(bank.getOre() + OreToDiscard);
		bank.setWood(bank.getWood() + WoodToDiscard);
		bank.setSheep(bank.getSheep() + SheepToDiscard);
		
		player.setDiscarded(true);
	}

}
