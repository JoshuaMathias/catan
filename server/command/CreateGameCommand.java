package server.command;

import server.facade.ServerFacade;

/**
 * 
 * @author Ife's Group
 *
 */
public class CreateGameCommand implements Command {

	private ServerFacade serverFacade;
	private boolean randomTiles;
	private boolean randomNumbers;
	private boolean randomPorts; 
	private String gameName;
	
	public CreateGameCommand(boolean randomTiles,boolean randomNumbers,boolean randomPorts, String gameName){
		serverFacade = ServerFacade.getSingleton();
		this.randomTiles = randomTiles;
		this.randomNumbers = randomNumbers;
		this.randomPorts = randomPorts;
		this.gameName = gameName;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	private void createTiles(){
		
	}
	
	private void setNumbers(){
		
	}
	
	private void createPorts(){
		
	}
}
