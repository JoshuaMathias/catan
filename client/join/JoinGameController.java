package client.join;

import java.util.ArrayList;

import shared.definitions.CatanColor;
import client.base.*;
import client.data.*;
import client.facade.Facade;
import client.misc.*;
import client.serverproxy.GamesList;


/**
 * Implementation for the join game controller
 */
public class JoinGameController extends Controller implements IJoinGameController {

	private INewGameView newGameView;
	private ISelectColorView selectColorView;
	private IMessageView messageView;
	private IAction joinAction;
	private Facade clientFacade;
	
	/**
	 * JoinGameController constructor
	 * 
	 * @param view Join game view
	 * @param newGameView New game view
	 * @param selectColorView Select color view
	 * @param messageView Message view (used to display error messages that occur while the user is joining a game)
	 */
	public JoinGameController(IJoinGameView view, INewGameView newGameView, 
								ISelectColorView selectColorView, IMessageView messageView) {

		super(view);

		setNewGameView(newGameView);
		setSelectColorView(selectColorView);
		setMessageView(messageView);
		clientFacade = Facade.getSingleton();
	}
	
	public IJoinGameView getJoinGameView() {
		
		return (IJoinGameView)super.getView();
	}
	
	/**
	 * Returns the action to be executed when the user joins a game
	 * 
	 * @return The action to be executed when the user joins a game
	 */
	public IAction getJoinAction() {
		
		return joinAction;
	}

	/**
	 * Sets the action to be executed when the user joins a game
	 * 
	 * @param value The action to be executed when the user joins a game
	 */
	public void setJoinAction(IAction value) {	
		
		joinAction = value;
	}
	
	public INewGameView getNewGameView() {
		
		return newGameView;
	}

	public void setNewGameView(INewGameView newGameView) {
		
		this.newGameView = newGameView;
	}
	
	public ISelectColorView getSelectColorView() {
		
		return selectColorView;
	}
	public void setSelectColorView(ISelectColorView selectColorView) {
		
		this.selectColorView = selectColorView;
	}
	
	public IMessageView getMessageView() {
		
		return messageView;
	}
	public void setMessageView(IMessageView messageView) {
		
		this.messageView = messageView;
	}

	@Override
	public void start() {
		GamesList hub = clientFacade.gamesList();
		ArrayList<GameInfo> games = hub.getGames();
		
		for(int i= 0;i<games.size();i++)
		{
			ArrayList <PlayerInfo> newlist = new ArrayList<PlayerInfo>();
			for(int j = 0;j<4;j++)
			{
				if(!games.get(i).getPlayers().get(j).getName().isEmpty())
				{
					newlist.add(games.get(i).getPlayers().get(j));
				}
			}
			games.get(i).setPlayers(newlist);
		}
		
		GameInfo[] gamesarray = new GameInfo[games.size()];
		games.toArray(gamesarray);
		
		PlayerInfo localPlayer = new PlayerInfo ();
		localPlayer.setName(clientFacade.getName());

		getJoinGameView().setGames(gamesarray, localPlayer);
		getJoinGameView().showModal();
	}
	
	 

	@Override
	public void startCreateNewGame() {
		
		getNewGameView().showModal();
	}

	@Override
	public void cancelCreateNewGame() {
		
		getNewGameView().closeModal();
	}

	@Override
	public void createNewGame() {
		clientFacade.createGame(getNewGameView().getRandomlyPlaceHexes(), 
				getNewGameView().getRandomlyPlaceNumbers(), getNewGameView().getUseRandomPorts(),
				getNewGameView().getTitle());
		getNewGameView().closeModal();
		start();
	}

	@Override
	public void startJoinGame(GameInfo game) {
		
		//Necassary because json fills the players list with empty players
		ArrayList <PlayerInfo> newlist = new ArrayList<PlayerInfo>();
		for(int j = 0;j<game.getPlayers().size();j++)
		{
			if(!game.getPlayers().get(j).getName().isEmpty())
			{
				newlist.add(game.getPlayers().get(j));
			}
		}
		game.setPlayers(newlist);
		
		//Greying out the color options already taken by other players
		for(int i = 0; i<game.getPlayers().size();i++)
		{
			PlayerInfo temp = game.getPlayers().get(i);
			if(!temp.getName().equals(clientFacade.getName())){
				System.out.println(temp.getColor()+temp.getName());
				getSelectColorView().setColorEnabled(temp.getColor(), false);
			}
		}
		getSelectColorView().showModal();
	}

	@Override
	public void cancelJoinGame() {
	
		getJoinGameView().closeModal();
	}

	@Override
	public void joinGame(CatanColor color) {
		
		
		
		// If join succeeded
		getSelectColorView().closeModal();
		getJoinGameView().closeModal();
		joinAction.execute();
	}

}

