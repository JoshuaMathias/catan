package server.command;

import server.facade.ServerFacade;

/**
 * 
 * @author Ife's Group
 *
 */
public class RegisterCommand implements Command {
	String username;
	String password;
	
	public RegisterCommand(String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	@Override
	public void execute() {
		//TODO
	}

}
