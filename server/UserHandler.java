package server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import server.facade.ServerFacade;
import shared.params.LoginParams;
import shared.params.RegisterParams;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class UserHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// TODO Auto-generated method stub
		String command = exchange.getRequestURI().toString().substring(6);
		try {
			System.out.println("UserHandler called");
			Gson g = new Gson();
			System.out.println("Command: " + command);
			ServerFacade facade = ServerFacade.getSingleton();
			JsonReader reader = new JsonReader(new InputStreamReader(
					exchange.getRequestBody(), "UTF-8"));
			JsonElement elem = new JsonParser().parse(reader);
			switch (command) {
			case "register":
				RegisterParams params = g.fromJson(elem, RegisterParams.class);
				if (!facade
						.register(params.getUsername(), params.getPassword())) {
					exchange.sendResponseHeaders(
							HttpURLConnection.HTTP_BAD_REQUEST, -1);
					return;
				}
				break;
			case "login":
				LoginParams lParams = g.fromJson(elem, LoginParams.class);
				if (!facade
						.logIn(lParams.getUsername(), lParams.getPassword())) {
					exchange.sendResponseHeaders(
							HttpURLConnection.HTTP_BAD_REQUEST, -1);
					return;
				}
				break;
			}

		} catch (Exception e) {
			System.out.println("Server error on command " + command);
			e.printStackTrace();
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, -1);
			return;
		}
		System.out.println("End of user handler");
		String responseStr="Success";
		exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, responseStr.length());
		OutputStream response = exchange.getResponseBody();
		response.write(responseStr.getBytes());
		response.close();
	}

}
