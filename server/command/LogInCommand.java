package server.command;

/**
 * 
 * @author Ife's Group
 *
 */
public class LogInCommand implements Command {
	String username;
	String password;
	
	public LogInCommand(String username, String password) {
		this.username=username;
		this.password=password;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}



}
