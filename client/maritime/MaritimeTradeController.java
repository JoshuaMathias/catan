package client.maritime;

import shared.definitions.*;
import client.base.*;
import client.facade.Facade;
import client.model.ResourceList;
import client.model.TurnTracker;


/**
 * Implementation for the maritime trade controller
 */
public class MaritimeTradeController extends Controller implements IMaritimeTradeController {

	private IMaritimeTradeOverlay tradeOverlay;
	private Facade clientFacade;
	private ResourceType getResource;
	private ResourceType giveResource;
	private int ratio = -1;
	private ResourceType[] enabledResources = {
			ResourceType.brick,
			ResourceType.sheep,
			ResourceType.ore,
			ResourceType.wheat,
			ResourceType.wood
	};
	
	public MaritimeTradeController(IMaritimeTradeView tradeView, IMaritimeTradeOverlay tradeOverlay) {
		
		super(tradeView);
		
		clientFacade = Facade.getSingleton();

		setTradeOverlay(tradeOverlay);
	}
	
	public IMaritimeTradeView getTradeView() {
		
		return (IMaritimeTradeView)super.getView();
	}
	
	public IMaritimeTradeOverlay getTradeOverlay() {
		return tradeOverlay;
	}

	public void setTradeOverlay(IMaritimeTradeOverlay tradeOverlay) {
		this.tradeOverlay = tradeOverlay;
	}

	@Override
	public void startTrade() {
		TurnTracker turnTracker = clientFacade.getClientModel().getTurnTracker();
		getTradeOverlay().setTradeEnabled(false);
		if(clientFacade.getPlayerIndex() != turnTracker.getCurrentTurn()){
			getTradeOverlay().hideGetOptions();
			getTradeOverlay().hideGiveOptions();
			getTradeOverlay().setStateMessage("Not Your Turn!");
		}
		else if(!turnTracker.getStatus().equals("Playing")){
			getTradeOverlay().hideGetOptions();
			getTradeOverlay().hideGiveOptions();
			getTradeOverlay().setStateMessage("Can't trade until finished 2 turns!");
		}
		else{
			getTradeOverlay().setStateMessage("Choose which resource to give");
		}
		
		getTradeOverlay().showModal();
	}

	@Override
	public void makeTrade() {
		reset();
		clientFacade.maritimeTrade(ratio, giveResource, getResource);
		getTradeOverlay().closeModal();
	}

	@Override
	public void cancelTrade() {
		reset();
		getTradeOverlay().closeModal();
	}

	@Override
	public void setGetResource(ResourceType resource) {

		getResource = resource;
		System.out.println("Resource to GET: " + resource);
		getTradeOverlay().selectGetOption(resource, 1);
		ResourceList bank = clientFacade.getBank();
		if(bank.hasOne(resource)){
			getResource = resource;
			getTradeOverlay().setStateMessage("Trade!");
			getTradeOverlay().setTradeEnabled(true);
		}
		else{
			getTradeOverlay().setStateMessage("Bank has no more of that resource");
		}
	}


	@Override
	public void setGiveResource(ResourceType resource) {
		giveResource = resource;
		System.out.println("Resource to GIVE: " + resource);
		ratio = clientFacade.getClientModel().canOfferBankTrade(clientFacade.getPlayerIndex(), resource);
		if (ratio != -1){
			getTradeOverlay().setStateMessage("Choose which resource to get");
			getTradeOverlay().selectGiveOption(resource, ratio);
			getTradeOverlay().showGetOptions(enabledResources);
		}
		else{
			getTradeOverlay().setStateMessage("Not enough of that resource");
		}
	}
		

	@Override
	public void unsetGetValue() {
		getResource = null;
		getTradeOverlay().showGetOptions(enabledResources);
	}

	@Override
	public void unsetGiveValue() {
		giveResource = null;
		ratio = -1;
		getTradeOverlay().showGiveOptions(enabledResources);
		getTradeOverlay().hideGetOptions();
	}

	public void reset(){
		getResource = null;
		giveResource = null;
		ratio = -1;
	}
	
}

