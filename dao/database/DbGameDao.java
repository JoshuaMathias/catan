package dao.database;

import java.util.List;

import server.command.Command;
import shared.gameModel.GameModel;
import dao.IGameDao;

public class DbGameDao implements IGameDao {

	@Override
	public void addGame(GameModel game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getGame(int gameID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GameModel> getAllGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGame(int gameID, GameModel game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeGame(int gameID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCommand(Command command, int gameID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Command> getCommands(int gameID) {
		// TODO Auto-generated method stub
		return null;
	}

}
