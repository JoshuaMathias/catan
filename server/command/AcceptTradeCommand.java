package server.command;

import java.util.ArrayList;

import shared.gameModel.GameModel;
import shared.gameModel.MessageLine;
import shared.gameModel.Player;
import shared.gameModel.ResourceList;
import shared.gameModel.TradeOffer;

/**
 * 
 * @author Ife's Group
 *
 */
public class AcceptTradeCommand implements Command {

	private int playerIndex;
	private boolean willAccept;
	private GameModel serverModel;
	
	public AcceptTradeCommand(int playerIndex, boolean willAccept, GameModel serverModel){
		this.playerIndex = playerIndex;
		this.willAccept = willAccept;
		this.serverModel = serverModel;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if (willAccept){
			TradeOffer tradeOffer = serverModel.getTradeOffer();
			ResourceList offerList = tradeOffer.getOffer();
			
			ArrayList<Player> players = serverModel.getPlayers();
			
			Player sender = players.get(tradeOffer.getSender());
			Player reciever = players.get(playerIndex);
			
			ResourceList senderResources = sender.getResources();
			ResourceList recieverResources = reciever.getResources();
			
			int offerBrick = offerList.getBrick();
			int offerWheat = offerList.getWheat();
			int offerSheep = offerList.getSheep();
			int offerOre = offerList.getOre();
			int offerWood = offerList.getWood();
			
			senderResources.setBrick(senderResources.getBrick() - offerBrick);
			recieverResources.setBrick(recieverResources.getBrick() + offerBrick);
			
			senderResources.setWheat(senderResources.getWheat() - offerWheat);
			recieverResources.setWheat(recieverResources.getWheat() + offerWheat);
			
			senderResources.setSheep(senderResources.getSheep() - offerSheep);
			recieverResources.setSheep(recieverResources.getSheep() + offerSheep);
			
			senderResources.setOre(senderResources.getOre() - offerOre);
			recieverResources.setOre(recieverResources.getOre() + offerOre);
			
			senderResources.setWood(senderResources.getWood() - offerWood);
			recieverResources.setWood(recieverResources.getWood() + offerWood);
			
			
			MessageLine line = new MessageLine();
			line.setMessage("The trade was accepted");
			line.setSource(reciever.getName());
			serverModel.getLog().addLine(line);
		}
		else{
			Player reciever = serverModel.getPlayers().get(playerIndex);
			MessageLine line = new MessageLine();
			line.setMessage("The trade was rejected");
			line.setSource(reciever.getName());
			serverModel.getLog().addLine(line);
		}
		serverModel.setTradeOffer(null);
	}

}
