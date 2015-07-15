package client.maritime;

import shared.definitions.*;
import client.base.*;
import client.facade.Facade;
import client.model.ResourceList;


/**
 * Implementation for the maritime trade controller
 */
public class MaritimeTradeController extends Controller implements IMaritimeTradeController {

	private IMaritimeTradeOverlay tradeOverlay;
	private Facade clientFacade;
	private ResourceType getResource;
	private ResourceType giveResource;
	
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
		
		getTradeOverlay().showModal();
	}

	@Override
	public void makeTrade() {

		getTradeOverlay().closeModal();
	}

	@Override
	public void cancelTrade() {

		getTradeOverlay().closeModal();
	}

	@Override
	public void setGetResource(ResourceType resource) {
		getResource = resource;
		
	}

	@Override
	public void setGiveResource(ResourceType resource) {
		giveResource = resource;
	}

	@Override
	public void unsetGetValue() {

	}

	@Override
	public void unsetGiveValue() {

	}

}

