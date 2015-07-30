package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import server.facade.ServerFacade;
import shared.gameModel.GameModel;
import shared.params.CreateGamesParams;
import shared.params.JoinGameParams;
import shared.params.LoginParams;
import shared.params.RegisterParams;

import client.data.GameInfo;
import client.serverproxy.GamesList;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GamesHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// TODO
		System.out.println("GamesHandler called");
		String[] commandList = exchange.getRequestURI().toString().split("\\/");
		String command="";
		if (commandList.length > 2) {
			command = commandList[2];
		}
		try {
			boolean successful = true;
			Gson g = new Gson();
			System.out.println("Command: " + command);
			ServerFacade facade = ServerFacade.getSingleton();
			// JsonReader reader = new JsonReader(new InputStreamReader(
			// exchange.getRequestBody(), "UTF-8"));
			Headers responseHeaders = exchange.getResponseHeaders();
			responseHeaders.set("Content-Type",
					"application/x-www-form-urlencoded");
			responseHeaders.set("Content-Language", "en-US");
			String responseStr = "";
			if (command.equals("list")) {
				ArrayList<GameInfo> games = facade.GamesList();
				responseStr=g.toJson(games);
			} else {
				BufferedReader streamReader = new BufferedReader(
						new InputStreamReader(exchange.getRequestBody(),
								"UTF-8"));
				StringBuilder requestBuilder = new StringBuilder();
				String inputStr;
				while ((inputStr = streamReader.readLine()) != null) {
					requestBuilder.append(inputStr);
					requestBuilder.append('\r');
				}
				String requestJson = requestBuilder.toString();
				streamReader.close();
				switch (command) {
				case "create":
					System.out.println("create game handler");
					CreateGamesParams params = g.fromJson(requestJson,
							CreateGamesParams.class);
					GameInfo gameInfo = facade.createGame(
							params.isRandomTiles(), params.isRandomNumbers(),
							params.isRandomPorts(), params.getName());
					// Send gameInfo as response body
					responseStr = g.toJson(gameInfo);
					break;
				case "join":
					System.out.println("join game handler");
					String usercookie = "";
					// Get cookies and parse for user id. Only join if they have
					// a valid user id.
					Headers requestheader = exchange.getRequestHeaders();
					if(requestheader.containsKey("Cookie"))
					{
						List<String> cookies = requestheader.get("Cookie");
						if(cookies.size()>0)
						{
							usercookie = cookies.get(0);
						}
						else
						{
							successful=false;
							responseStr = "Don't have cookies. Make sure you sign in.";
							exchange.sendResponseHeaders(
									HttpURLConnection.HTTP_BAD_REQUEST,
									responseStr.length());
						}
					}
					else
					{
						successful = false;
						responseStr = "Don't have cookies. Make sure you sign in.";
						exchange.sendResponseHeaders(
								HttpURLConnection.HTTP_BAD_REQUEST,
								responseStr.length());
					}
					JoinGameParams joinParams = g.fromJson(requestJson,
							JoinGameParams.class);
//					System.out.println(URLDecoder.decode(usercookie, "UTF-8").replace("catan.user=", ""));
					User user = g.fromJson(URLDecoder.decode(usercookie, "UTF-8").replace("catan.user=", ""),User.class);
					if (!facade.joinGame(joinParams.getId(), joinParams.getColor(),user
							)) {
						successful=false;
					}
					
					// Send new game cookie
					 List<String> values = new ArrayList<>();
					 String cookieString = "catan.game="+joinParams.getId()+";Path=/;";
					 values.add(cookieString);
					 responseHeaders.put("Set-Cookie", values);
					break;
				}
			}
			if (responseStr.equals("")) {
				responseStr = "Success";
			}
			if (successful) {
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,
						responseStr.length());
			}

			OutputStream response = exchange.getResponseBody();
			response.write(responseStr.getBytes());
			response.close();
		} catch (Exception e) {
			System.out.println("Server error on command " + command);
			e.printStackTrace();
			String responseStr = "Failed";
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST,
					responseStr.length());
			return;
		}
	}

}
