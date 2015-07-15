package client.domestic;

import java.util.ArrayList;

import shared.definitions.*;
import client.base.*;
import client.data.PlayerInfo;
import client.facade.Facade;
import client.misc.*;
import client.model.Player;


/**
 * Domestic trade controller implementation
 */
public class DomesticTradeController extends Controller implements IDomesticTradeController {

	private IDomesticTradeOverlay tradeOverlay;
	private IWaitView waitOverlay;
	private IAcceptTradeOverlay acceptOverlay;
	private Facade clientFacade;


	/**
	 * DomesticTradeController constructor
	 * 
	 * @param tradeView Domestic trade view (i.e., view that contains the "Domestic Trade" button)
	 * @param tradeOverlay Domestic trade overlay (i.e., view that lets the user propose a domestic trade)
	 * @param waitOverlay Wait overlay used to notify the user they are waiting for another player to accept a trade
	 * @param acceptOverlay Accept trade overlay which lets the user accept or reject a proposed trade
	 */
	public DomesticTradeController(IDomesticTradeView tradeView, IDomesticTradeOverlay tradeOverlay,
									IWaitView waitOverlay, IAcceptTradeOverlay acceptOverlay) {

		super(tradeView);
		
		setTradeOverlay(tradeOverlay);
		setWaitOverlay(waitOverlay);
		setAcceptOverlay(acceptOverlay);
		
		clientFacade = Facade.getSingleton();
		clientFacade.setDomesticTradeController(this);
	}
	
	public IDomesticTradeView getTradeView() {
		
		return (IDomesticTradeView)super.getView();
	}

	public IDomesticTradeOverlay getTradeOverlay() {
		return tradeOverlay;
	}

	public void setTradeOverlay(IDomesticTradeOverlay tradeOverlay) {
		this.tradeOverlay = tradeOverlay;
	}

	public IWaitView getWaitOverlay() {
		return waitOverlay;
	}

	public void setWaitOverlay(IWaitView waitView) {
		this.waitOverlay = waitView;
	}

	public IAcceptTradeOverlay getAcceptOverlay() {
		return acceptOverlay;
	}

	public void setAcceptOverlay(IAcceptTradeOverlay acceptOverlay) {
		this.acceptOverlay = acceptOverlay;
	}

	@Override
	public void startTrade() {
		
		if(clientFacade.getTurnTracker().getCurrentTurn()==clientFacade.getPlayerIndex()&&
				clientFacade.getTurnTracker().getStatus().equals("Playing"))
		{
			getTradeOverlay().setCancelEnabled(true);
			getTradeOverlay().setStateMessage("Set the trade you want to make");
			
			ArrayList<Player> playerList = clientFacade.getPlayers();
			PlayerInfo[] values = new PlayerInfo[playerList.size()];
			for (int i = 0; i<playerList.size();i++ )
			{
				Player temp = playerList.get(i);
				if(!clientFacade.getName().equals(temp.getName()))
				{
					PlayerInfo input = new PlayerInfo();
					
					input.setColorEnum(temp.getColor());
					input.setPlayerIndex(temp.getPlayerIndex());
					input.setName(temp.getName());
					input.setId(temp.getPlayerID());
					
					values[i] = input;
				}
			}
			
			//Can make trade
			
			getTradeOverlay().setPlayers(values);
			getTradeOverlay().setPlayerSelectionEnabled(true);
			getTradeOverlay().setResourceAmount(ResourceType.sheep, "This is Resource Amount");
			getTradeOverlay().setResourceAmountChangeEnabled(ResourceType.brick, true, true);
			getTradeOverlay().setResourceSelectionEnabled(true);
			getTradeOverlay().showModal();
		}
		else if(clientFacade.getTurnTracker().getCurrentTurn()!=clientFacade.getPlayerIndex()&&
				clientFacade.getTurnTracker().getStatus().equals("Playing"))
		{
			PlayerInfo[] values = new PlayerInfo[0];
			getTradeOverlay().setPlayers(values);
			getTradeOverlay().reset();
			getTradeOverlay().setCancelEnabled(true);
			
			
			//Can't make trade
			//getTradeOverlay().
			getTradeOverlay().setStateMessage("Not your turn");
			getTradeOverlay().showModal();
		}		
		
//		getWaitOverlay().showModal();
//		getAcceptOverlay().showModal();
		
	}

	@Override
	public void decreaseResourceAmount(ResourceType resource) {

	}

	@Override
	public void increaseResourceAmount(ResourceType resource) {

	}

	@Override
	public void sendTradeOffer() {

		getTradeOverlay().closeModal();
//		getWaitOverlay().showModal();
	}

	@Override
	public void setPlayerToTradeWith(int playerIndex) {

	}

	@Override
	public void setResourceToReceive(ResourceType resource) {

	}

	@Override
	public void setResourceToSend(ResourceType resource) {

	}

	@Override
	public void unsetResource(ResourceType resource) {		

	}

	@Override
	public void cancelTrade() {

		getTradeOverlay().closeModal();
	}

	@Override
	public void acceptTrade(boolean willAccept) {

		getAcceptOverlay().closeModal();
	}

}

