package client.discard;

import shared.definitions.*;
import client.base.*;
import client.facade.Facade;
import client.misc.*;
import client.model.ClientModel;
import client.model.Player;
import client.model.ResourceList;


/**
 * Discard controller implementation
 */
public class DiscardController extends Controller implements IDiscardController {

	private IWaitView waitView;
	private Facade clientFacade;
	private ResourceList resources;
	private ResourceList resourcesToDiscard;
	
	
	/**
	 * DiscardController constructor
	 * 
	 * @param view View displayed to let the user select cards to discard
	 * @param waitView View displayed to notify the user that they are waiting for other players to discard
	 */
	public DiscardController(IDiscardView view, IWaitView waitView) {
		
		super(view);
		
		clientFacade = Facade.getSingleton();
		clientFacade.setDiscardController(this);
		
		this.waitView = waitView;
	}

	public IDiscardView getDiscardView() {
		return (IDiscardView)super.getView();
	}
	
	public IWaitView getWaitView() {
		return waitView;
	}

	@Override
	public void increaseAmount(ResourceType resource) {
		System.out.println("Increasing " + resource);
	}

	@Override
	public void decreaseAmount(ResourceType resource) {
		System.out.println("decreasing " + resource);
	}

	@Override
	public void discard() {
		getDiscardView().closeModal();
	}

	public void beginDiscarding(){
		getDiscardView().showModal();
		getDiscardView().setDiscardButtonEnabled(false);
		ClientModel clientModel = clientFacade.getClientModel();
		Player player = clientModel.getPlayers().get(clientFacade.getPlayerIndex());
		resources = player.getResources();
	
		getDiscardView().setResourceMaxAmount(ResourceType.wheat, resources.getWheat());
		getDiscardView().setResourceMaxAmount(ResourceType.sheep, resources.getSheep());
		getDiscardView().setResourceMaxAmount(ResourceType.wood, resources.getWood());
		getDiscardView().setResourceMaxAmount(ResourceType.ore, resources.getOre());
		getDiscardView().setResourceMaxAmount(ResourceType.brick, resources.getBrick());
//		getDiscardView().setResourceDiscardAmount(ResourceType.sheep, 5);
//		getDiscardView().setStateMessage("You Suck");
		
		
	}
}

