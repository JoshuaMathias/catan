package client.map;

import java.util.*;

import shared.definitions.*;
import shared.locations.EdgeDirection;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexDirection;
import shared.locations.VertexLocation;
import client.base.*;
import client.data.*;
import client.facade.Facade;
import client.model.*;
import client.model.Map;


/**
 * Implementation for the map controller
 */
public class MapController extends Controller implements IMapController {
	
	private IRobView robView;
	private Facade clientFacade;
	
	public MapController(IMapView view, IRobView robView) {
		
		super(view);
		
		setRobView(robView);
		
		clientFacade = Facade.getSingleton();
		
		clientFacade.setMapController(this);
		
		initFromModel();
	}
	
	public IMapView getView() {
		
		return (IMapView)super.getView();
	}
	
	private IRobView getRobView() {
		return robView;
	}
	private void setRobView(IRobView robView) {
		this.robView = robView;
	}
	
	public void initFromModel(ClientModel clientModel) {
		Map map = clientModel.getMap();
		
		getView().newMap();
		
		System.out.println("Beginning of initFromModel");
		
		//place hexes
		ArrayList<Hex> hexes = map.getHexes();
		for(Hex hex: hexes){
			getView().addHex(hex.getLocation(), hex.getResource());
			System.out.println(hex.toString());
			if(hex.getNumber() != 0){
				getView().addNumber(hex.getLocation(), hex.getNumber());
				System.out.println(hex.getLocation().toString());
				System.out.println(hex.getNumber());
			}
		}
		
		//place settlements
		ArrayList<VertexObject> settlements = map.getSettlements();
		ArrayList<Player> players = clientModel.getPlayers();
		for(VertexObject settlement: settlements){
			CatanColor color = players.get(settlement.getOwner()).getColor();
			getView().placeSettlement(settlement.getLocation(), color);
		}
		
		//place cities
		ArrayList<VertexObject> cities = map.getCities();
		for(VertexObject city: cities){
			CatanColor color = players.get(city.getOwner()).getColor();
			getView().placeCity(city.getLocation(), color);
		}
		
		//place roads
		ArrayList<Road> roads = map.getRoads();
		for(Road road: roads){
			CatanColor color = players.get(road.getOwner()).getColor();
			getView().placeRoad(road.getLocation(), color);
		}
		
		//place ports
		ArrayList<Port> ports = map.getPorts();
		for(Port port: ports){
			EdgeLocation side = new EdgeLocation(port.getLocation(), port.getDirection());
			System.out.println("Port: "+ side.toString());
			System.out.println(port.getResource());
			getView().addPort(side, port.getResource());
		}
		
		//place robber
		getView().placeRobber(map.getRobber());
		
		System.out.println("After initFromModel");
		
	}
		
	
	protected void initFromModel() {
		//<temp>
		
		Random rand = new Random();

		for (int x = 0; x <= 3; ++x) {
			
			int maxY = 3 - x;			
			for (int y = -3; y <= maxY; ++y) {				
				int r = rand.nextInt(HexType.values().length);
				HexType hexType = HexType.values()[r];
				HexLocation hexLoc = new HexLocation(x, y);
				getView().addHex(hexLoc, hexType);
				getView().placeRoad(new EdgeLocation(hexLoc, EdgeDirection.NW),
						CatanColor.red);
				getView().placeRoad(new EdgeLocation(hexLoc, EdgeDirection.SW),
						CatanColor.blue);
				getView().placeRoad(new EdgeLocation(hexLoc, EdgeDirection.S),
						CatanColor.orange);
				getView().placeSettlement(new VertexLocation(hexLoc,  VertexDirection.NW), CatanColor.green);
				getView().placeCity(new VertexLocation(hexLoc,  VertexDirection.NE), CatanColor.purple);
			}
			
			if (x != 0) {
				int minY = x - 3;
				for (int y = minY; y <= 3; ++y) {
					int r = rand.nextInt(HexType.values().length);
					HexType hexType = HexType.values()[r];
					HexLocation hexLoc = new HexLocation(-x, y);
					getView().addHex(hexLoc, hexType);
					getView().placeRoad(new EdgeLocation(hexLoc, EdgeDirection.NW),
							CatanColor.red);
					getView().placeRoad(new EdgeLocation(hexLoc, EdgeDirection.SW),
							CatanColor.blue);
					getView().placeRoad(new EdgeLocation(hexLoc, EdgeDirection.S),
							CatanColor.orange);
					getView().placeSettlement(new VertexLocation(hexLoc,  VertexDirection.NW), CatanColor.green);
					getView().placeCity(new VertexLocation(hexLoc,  VertexDirection.NE), CatanColor.purple);
				}
			}
		}
		
		PortType portType = PortType.brick;
		getView().addPort(new EdgeLocation(new HexLocation(0, 3), EdgeDirection.N), portType);
		getView().addPort(new EdgeLocation(new HexLocation(0, -3), EdgeDirection.S), portType);
		getView().addPort(new EdgeLocation(new HexLocation(-3, 3), EdgeDirection.NE), portType);
		getView().addPort(new EdgeLocation(new HexLocation(-3, 0), EdgeDirection.SE), portType);
		getView().addPort(new EdgeLocation(new HexLocation(3, -3), EdgeDirection.SW), portType);
		getView().addPort(new EdgeLocation(new HexLocation(3, 0), EdgeDirection.NW), portType);
		
		getView().placeRobber(new HexLocation(0, 0));
		
		getView().addNumber(new HexLocation(-2, 0), 2);
		getView().addNumber(new HexLocation(-2, 1), 3);
		getView().addNumber(new HexLocation(-2, 2), 4);
		getView().addNumber(new HexLocation(-1, 0), 5);
		getView().addNumber(new HexLocation(-1, 1), 6);
		getView().addNumber(new HexLocation(1, -1), 8);
		getView().addNumber(new HexLocation(1, 0), 9);
		getView().addNumber(new HexLocation(2, -2), 10);
		getView().addNumber(new HexLocation(2, -1), 11);
		getView().addNumber(new HexLocation(2, 0), 12);
		
		//</temp>
	}

	public boolean canPlaceRoad(EdgeLocation edgeLoc) {
		Road road = new Road(clientFacade.getPlayerIndex(),edgeLoc);
		return clientFacade.canBuildRoad(road);
	}

	public boolean canPlaceSettlement(VertexLocation vertLoc) {
		VertexObject settlement = new VertexObject(clientFacade.getPlayerIndex(), vertLoc);
		return clientFacade.canBuildSettlement(settlement);
	}

	public boolean canPlaceCity(VertexLocation vertLoc) {
		VertexObject city = new VertexObject(clientFacade.getPlayerIndex(), vertLoc);
		return clientFacade.canBuildCity(city);
	}

	public boolean canPlaceRobber(HexLocation hexLoc) {
		return clientFacade.canPlaceRobber(Facade.getSingleton().getDiceRoll(), hexLoc);
	}

	public void placeRoad(EdgeLocation edgeLoc) {
		clientFacade.buildRoad(edgeLoc, false);
		CatanColor color = clientFacade.getClientModel().getPlayers().get(clientFacade.getPlayerIndex()).getColor();
		getView().placeRoad(edgeLoc, color);
	}

	public void placeSettlement(VertexLocation vertLoc) {
		clientFacade.buildSettlement(vertLoc, false);
		CatanColor color = clientFacade.getClientModel().getPlayers().get(clientFacade.getPlayerIndex()).getColor();
		getView().placeSettlement(vertLoc, color);
	}

	public void placeCity(VertexLocation vertLoc) {
		clientFacade.buildCity(vertLoc);
		CatanColor color = clientFacade.getPlayerColor();
		getView().placeCity(vertLoc, color);
	}

	public void placeRobber(HexLocation hexLoc) {
		getView().placeRobber(hexLoc);
		clientFacade.setTempRobLoc(hexLoc);
		getRobView().showModal();
	}
	
	public void startMove(PieceType pieceType, boolean isFree, boolean allowDisconnected) {	
		if (pieceType==PieceType.ROAD) {
			
		} else if (pieceType==PieceType.SETTLEMENT) {
			
		} else if (pieceType==PieceType.CITY) {
			
		}
		getView().startDrop(pieceType, clientFacade.getPlayerColor(), true);
	}
	
	public void cancelMove() {
		
	}
	
	public void playSoldierCard() {	
		
	}
	
	public void playRoadBuildingCard() {	
		
	}
	
	public void robPlayer(RobPlayerInfo victim) {	
		Facade.getSingleton().robPlayer(victim.getPlayerIndex(), Facade.getSingleton().getTempRobLoc());
	}
	
}

