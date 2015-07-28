package server;

import java.io.IOException;

import server.facade.ServerFacade;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GameHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("GameHandler called");
		String command = exchange.getRequestURI().toString().substring(6);
		System.out.println("Command: "+command);
		ServerFacade facade = ServerFacade.getSingleton();
		switch (command) {
			case "model":
				facade.GameModel();
				break;
		}
	}

}
