package server.command;

import shared.gameModel.GameModel;
import shared.gameModel.ResourceList;
import shared.gameModel.TradeOffer;

/**
 * 
 * @author Ife's Group
 *
 */
public class OfferTradeCommand implements Command {

	int sender;
	ResourceList offer;
	int receiver;
	GameModel serverModel;
	
	public OfferTradeCommand(int sender, ResourceList offer, int receiver,
			GameModel serverModel) {
		super();
		this.sender = sender;
		this.offer = offer;
		this.receiver = receiver;
		this.serverModel = serverModel;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		TradeOffer tradeOffer = new TradeOffer();
		tradeOffer.setSender(sender);
		tradeOffer.setReceiver(receiver);
		tradeOffer.setOffer(offer);
		serverModel.setTradeOffer(tradeOffer);
	}

}
