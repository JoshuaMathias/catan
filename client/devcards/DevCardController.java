package client.devcards;

import shared.definitions.DevCardType;
import shared.definitions.ResourceType;
import client.base.*;
import client.facade.Facade;
import client.model.DevCardList;


/**
 * "Dev card" controller implementation
 */
public class DevCardController extends Controller implements IDevCardController {

	private IBuyDevCardView buyCardView;
	private IAction soldierAction;
	private IAction roadAction;
	private Facade clientFacade;
	
	/**
	 * DevCardController constructor
	 * 
	 * @param view "Play dev card" view
	 * @param buyCardView "Buy dev card" view
	 * @param soldierAction Action to be executed when the user plays a soldier card.  It calls "mapController.playSoldierCard()".
	 * @param roadAction Action to be executed when the user plays a road building card.  It calls "mapController.playRoadBuildingCard()".
	 */
	public DevCardController(IPlayDevCardView view, IBuyDevCardView buyCardView, 
								IAction soldierAction, IAction roadAction) {

		super(view);
		
		this.buyCardView = buyCardView;
		this.soldierAction = soldierAction;
		this.roadAction = roadAction;
		
		clientFacade = Facade.getSingleton();
	}

	public IPlayDevCardView getPlayCardView() {
		return (IPlayDevCardView)super.getView();
	}

	public IBuyDevCardView getBuyCardView() {
		return buyCardView;
	}

	@Override
	public void startBuyCard() {
		if(clientFacade.canBuyDevCard()){
			getBuyCardView().showModal();
		}
	}

	@Override
	public void cancelBuyCard() {
		
		getBuyCardView().closeModal();
	}

	@Override
	public void buyCard() {
		clientFacade.buyDevCard();
		getBuyCardView().closeModal();
	}

	@Override
	public void startPlayCard() {
		DevCardList playerDevCards = clientFacade.getPlayerDevCards();
		
		//Set Number of each card
		getPlayCardView().setCardAmount(DevCardType.MONOPOLY, playerDevCards.getMonopoly());
		getPlayCardView().setCardAmount(DevCardType.MONUMENT, playerDevCards.getMonument());
		getPlayCardView().setCardAmount(DevCardType.ROAD_BUILD, playerDevCards.getRoadBuilding());
		getPlayCardView().setCardAmount(DevCardType.SOLDIER, playerDevCards.getSoldier());
		getPlayCardView().setCardAmount(DevCardType.YEAR_OF_PLENTY, playerDevCards.getYearOfPlenty());
		
		DevCardList playerOldDevCards = clientFacade.getPlayerOldDevCards();
		
		//Set enabled or disabled
		boolean isPlayerTurn = (clientFacade.getTurnTracker().getCurrentTurn() == clientFacade.getPlayerIndex());
		boolean playing = clientFacade.getTurnTracker().getStatus().equals("Playing");
		boolean playedDevCard = clientFacade.getPlayer().isPlayedDevCard();
		
		if(isPlayerTurn && playing && !playedDevCard){
			
			getPlayCardView().setCardAmount(DevCardType.MONOPOLY, playerOldDevCards.getMonopoly());
			getPlayCardView().setCardAmount(DevCardType.MONUMENT, playerOldDevCards.getMonument());
			getPlayCardView().setCardAmount(DevCardType.ROAD_BUILD, playerOldDevCards.getRoadBuilding());
			getPlayCardView().setCardAmount(DevCardType.SOLDIER, playerOldDevCards.getSoldier());
			getPlayCardView().setCardAmount(DevCardType.YEAR_OF_PLENTY, playerOldDevCards.getYearOfPlenty());
			
		}

		getPlayCardView().showModal();
	}

	@Override
	public void cancelPlayCard() {

		getPlayCardView().closeModal();
	}

	@Override
	public void playMonopolyCard(ResourceType resource) {
		
	}

	@Override
	public void playMonumentCard() {
		
	}

	@Override
	public void playRoadBuildCard() {
		
		roadAction.execute();
	}

	@Override
	public void playSoldierCard() {
		
		soldierAction.execute();
	}

	@Override
	public void playYearOfPlentyCard(ResourceType resource1, ResourceType resource2) {
		
	}

}

