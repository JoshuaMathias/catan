package server.facade;

public class ServerFacade {
	
	private static ServerFacade serverFacade;
	
	private ServerFacade(){
		
	}
	
	public static ServerFacade getSingleton(){
		if(serverFacade == null){
			serverFacade = new ServerFacade();
		}
		return serverFacade;
	}
// All methods return void only as placeholders. They should all return specific response types	
	/**
	 * 
	 */
	public void acceptTrade(){
		
	}
	
	/**
	 * 
	 */
	public void buildCity(){
		
	}
	
	/**
	 * 
	 */
	public void buildRoad(){
		
	}
	
	/**
	 * 
	 */
	public void buildSettlement(){
		
	}
	
	/**
	 * 
	 */
	public void buyDevCard(){
		
	}
	
	/**
	 * 
	 */
	public void createGame(){
		
	}
	
	/**
	 * 
	 */
	public void discardCards(){
		
	}
	
	/**
	 * 
	 */
	public void finishTurn(){
		
	}
	
	/**
	 * 
	 */
	public void GameModel(){
		
	}
	
	/**
	 * 
	 */
	public void GamesList(){
		
	}
	
	/**
	 * 
	 */
	public void joinGame(){
		
	}
	
	/**
	 * 
	 */
	public void logIn(){
		
	}
	
	/**
	 * 
	 */
	public void maritimeTrade(){
		
	}
	
	/**
	 * 
	 */
	public void monument(){
		
	}
	
	/**
	 * 
	 */
	public void offerTrade(){
		
	}
	
	/**
	 * 
	 */
	public void register(){
		
	}
	
	/**
	 * 
	 */
	public void roadBuilding(){
		
	}
	
	/**
	 * 
	 */
	public void robPlayer(){
		
	}
	
	/**
	 * 
	 */
	public void rollNumber(){
		
	}
	
	/**
	 * 
	 */
	public void sendChat(){
		
	}
	
	/**
	 * 
	 */
	public void soldier(){
		
	}
	
	/**
	 * 
	 */
	public void yearOfPlenty(){
		
	}
}
