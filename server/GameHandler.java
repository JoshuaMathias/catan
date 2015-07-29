package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

import server.facade.ServerFacade;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GameHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// TODO Auto-generated method stub
		ServerFacade facade = ServerFacade.getSingleton();
		Gson g = new Gson();
		System.out.println("GameHandler called");
		
		String command = exchange.getRequestURI().toString().substring(6);
		System.out.println("Command: "+command);
		
		String[] uriRestparams = command.split("=");
		
		Headers requestheader = exchange.getRequestHeaders();
		
		String usercookie = "";
		String gamecookie = "";
		String responseStr = "";
		
		if(requestheader.containsKey("Cookie"))
		{
			List<String> cookies = requestheader.get("Cookie");
			if(cookies.size()==2)
			{
				usercookie = cookies.get(0);
				gamecookie = cookies.get(1);
			}
			else
			{
				responseStr = "Dont have cookies, make sure you sign in";
				exchange.sendResponseHeaders(
						HttpURLConnection.HTTP_BAD_REQUEST,
						responseStr.length());
				//set up error response
			}
		}
		else
		{
			responseStr = "Dont have cookies, make sure you sign in";
			exchange.sendResponseHeaders(
					HttpURLConnection.HTTP_BAD_REQUEST,
					responseStr.length());
			//set up error response
		}
		
		switch (uriRestparams[0]) {
			case "model":
				facade.GameModel();
				
				
				break;
			case "model?version":
				int version = Integer.parseInt(uriRestparams[1]);
				
				
				break;
		}
		
		Headers responseHeaders = exchange.getResponseHeaders();
		responseHeaders.set("Content-Type",
				"application/x-www-form-urlencoded");
		responseHeaders.set("Content-Language", "en-US");
		
	}

}
