package client.model;

import java.util.ArrayList;

import shared.definitions.ResourceType;
import shared.locations.EdgeDirection;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexDirection;
import shared.locations.VertexLocation;
/**
 * This class represents the game map.
 * @author Ife's group
 *
 */
public class Map {
	
	private ArrayList<Hex> hexes;
	private ArrayList<Port> ports;
	private ArrayList<Road> roads;
	private ArrayList<VertexObject> settlements;
	private ArrayList<VertexObject> cities;
	private int radius;
	private HexLocation robber; 
	
	public ArrayList<Hex> getHexes() {
		return hexes;
	}

	public void setHexes(ArrayList<Hex> hexes) {
		this.hexes = hexes;
	}

	public ArrayList<Port> getPorts() {
		return ports;
	}

	public void setPorts(ArrayList<Port> ports) {
		this.ports = ports;
	}

	public ArrayList<Road> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<Road> roads) {
		this.roads = roads;
	}

	public ArrayList<VertexObject> getSettlements() {
		return settlements;
	}

	public void setSettlements(ArrayList<VertexObject> settlements) {
		this.settlements = settlements;
	}

	public ArrayList<VertexObject> getCities() {
		return cities;
	}

	public void setCities(ArrayList<VertexObject> cities) {
		this.cities = cities;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public HexLocation getRobber() {
		return robber;
	}

	public void setRobber(HexLocation robber) {
		this.robber = robber;
	}
	
	public void addSettlement(VertexObject settlement){
		settlements.add(settlement);
	}
	
	public void removeSettlement(VertexObject settlement){
		//Implement This!!!!!!!!!!!!!!!!!!!!!!
	}
	
	public void addCity(VertexObject city){
		cities.add(city);
	}

	public void checkTradeRatio(int playerIndex, String resource) {
		
		Port port = null;
		
		for(int i = 0; i < ports.size(); i++) {
			
			if(ports.get(i).getResource().equals(resource)) {
				port = ports.get(i);
				break;
			}
		}
		
		for(int i = 0; i < settlements.size(); i++) {
			
			VertexObject settlement = settlements.get(i);
			
			if(playerIndex == settlement.getOwner()) {
				
				VertexLocation settlementLocation = settlement.getLocation();
				HexLocation settlementHexLocation = settlementLocation.getHexLoc();
				int settlementXLocation = settlementHexLocation.getX();
				int settlementYLocation = settlementHexLocation.getY();
				VertexDirection settlementDirection = settlementLocation.getDir();
				
				HexLocation portLocation = port.getLocation();
				int portXLocation = portLocation.getX();
				int portYLocation = portLocation.getY();
				EdgeDirection portDirection = port.getDirection();
				
				
				
			}
		}
		
		for(int i = 0; i < cities.size(); i++) {
			
			VertexObject city = cities.get(i);
			
			if(playerIndex == city.getOwner()) {
				
				VertexLocation cityLocation = city.getLocation();
				HexLocation cityHexLocation = cityLocation.getHexLoc();
				int cityXLocation = cityHexLocation.getX();
				int cityYLocation = cityHexLocation.getY();
				
				HexLocation portLocation = port.getLocation();
				int portXLocation = portLocation.getX();
				int portYLocation = portLocation.getY();
				
				
				
			}
		}
		
	}
	
	public boolean isSpotTaken(VertexLocation spot){
		spot = spot.getNormalizedLocation();
		
		for(int i = 0; i < settlements.size(); i++){
			VertexLocation spotCheck = settlements.get(i).getLocation().getNormalizedLocation();
			if(spot.equals(spotCheck)){
				return true;
			}
		}
		
		for(int i = 0; i < cities.size(); i++){
			VertexLocation spotCheck = cities.get(i).getLocation().getNormalizedLocation();
			if(spot.equals(spotCheck)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isSpotNeighbored(VertexLocation spot){
		spot = spot.getNormalizedLocation();
		HexLocation hexLoc = spot.getHexLoc();
		VertexDirection direction = spot.getDir();
		int x = hexLoc.getX();
		int y = hexLoc.getY();
		
		HexLocation hexLoc1;
		VertexLocation spot1;
		HexLocation hexLoc2;
		VertexLocation spot2;
		HexLocation hexLoc3;
		VertexLocation spot3;
		switch(direction){
			case East:
				hexLoc1 = new HexLocation(x, y);
				spot1 = new VertexLocation(hexLoc1, VertexDirection.NorthEast);
				
				hexLoc2 = new HexLocation(x, y);
				spot2 = new VertexLocation(hexLoc2, VertexDirection.SouthEast);
				
				hexLoc3 = new HexLocation(x+1, y);
				spot3 = new VertexLocation(hexLoc3, VertexDirection.NorthEast);
				break;
				
			case NorthEast:
				hexLoc1 = new HexLocation(x, y);
				spot1 = new VertexLocation(hexLoc1, VertexDirection.East);
				
				hexLoc2 = new HexLocation(x, y);
				spot2 = new VertexLocation(hexLoc2, VertexDirection.NorthWest);
				
				hexLoc3 = new HexLocation(x, y-1);
				spot3 = new VertexLocation(hexLoc3, VertexDirection.SouthEast);
				break;
				
			case NorthWest:
				hexLoc1 = new HexLocation(x, y);
				spot1 = new VertexLocation(hexLoc1, VertexDirection.West);
				
				hexLoc2 = new HexLocation(x, y);
				spot2 = new VertexLocation(hexLoc2, VertexDirection.NorthEast);
				
				hexLoc3 = new HexLocation(x, y-1);
				spot3 = new VertexLocation(hexLoc3, VertexDirection.West);
				break;
				
			case SouthEast:
				hexLoc1 = new HexLocation(x, y);
				spot1 = new VertexLocation(hexLoc1, VertexDirection.East);
				
				hexLoc2 = new HexLocation(x, y);
				spot2 = new VertexLocation(hexLoc2, VertexDirection.SouthWest);
				
				hexLoc3 = new HexLocation(x, y+1);
				spot3 = new VertexLocation(hexLoc3, VertexDirection.East);
				break;
			case SouthWest:
				hexLoc1 = new HexLocation(x, y);
				spot1 = new VertexLocation(hexLoc1, VertexDirection.West);
				
				hexLoc2 = new HexLocation(x, y);
				spot2 = new VertexLocation(hexLoc2, VertexDirection.SouthEast);
				
				hexLoc3 = new HexLocation(x, y+1);
				spot3 = new VertexLocation(hexLoc3, VertexDirection.West);
				break;
			case West:
				hexLoc1 = new HexLocation(x, y);
				spot1 = new VertexLocation(hexLoc1, VertexDirection.NorthWest);
				
				hexLoc2 = new HexLocation(x, y);
				spot2 = new VertexLocation(hexLoc2, VertexDirection.SouthWest);
				
				hexLoc3 = new HexLocation(x-1, y);
				spot3 = new VertexLocation(hexLoc3, VertexDirection.SouthWest);
				break;
			default: //should never be reached Maybe Throw an exception
				hexLoc1 = new HexLocation(x, y);
				spot1 = new VertexLocation(hexLoc1, VertexDirection.East);
				
				hexLoc2 = new HexLocation(x, y);
				spot2 = new VertexLocation(hexLoc2, VertexDirection.NorthWest);
				
				hexLoc3 = new HexLocation(x, y-1);
				spot3 = new VertexLocation(hexLoc3, VertexDirection.SouthEast);
				break;
		
		}
		if(isSpotTaken(spot1) || isSpotTaken(spot2) || isSpotTaken(spot3)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isSpotMySettlement(VertexLocation spot, int playerIndex) {
		
		spot = spot.getNormalizedLocation();
		
		for(int i = 0; i < settlements.size(); i++) {
			
			if(settlements.get(i).getOwner() == playerIndex) {
				
				VertexLocation settlementSpot = settlements.get(i).getLocation();
				settlementSpot = settlementSpot.getNormalizedLocation();
				
				if(settlementSpot == spot) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean haveRoadHere(Road road){
		
		for(Road roadCheck: roads){
			if(roadCheck.equals(road)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasNeighboringOwnRoad(VertexObject settlement){
		int playerIndex = settlement.getOwner();
		VertexLocation settlementSpot = settlement.getLocation();
		settlementSpot = settlementSpot.getNormalizedLocation();
		HexLocation hexLoc = settlementSpot.getHexLoc();
		VertexDirection direction = settlementSpot.getDir();
		
		int x = hexLoc.getX();
		int y = hexLoc.getY();
		
		HexLocation hexLoc1;
		EdgeLocation edge1;
		HexLocation hexLoc2;
		EdgeLocation edge2;
		HexLocation hexLoc3;
		EdgeLocation edge3;
		switch(direction){
		case East:
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.NorthEast);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.SouthEast);
			
			hexLoc3 = new HexLocation(x,y-1);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.South);
			break;
		case NorthEast:
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.North);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.NorthEast);
			
			hexLoc3 = new HexLocation(x,y-1);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.SouthEast);
			break;
		case NorthWest:
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.North);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.NorthWest);
			
			hexLoc3 = new HexLocation(x,y-1);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.SouthWest);
			break;
		case SouthEast:
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.South);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.SouthEast);
			
			hexLoc3 = new HexLocation(x,y+1);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.NorthEast);
			break;
		case SouthWest:
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.SouthWest);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.South);
			
			hexLoc3 = new HexLocation(x,y+1);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.NorthWest);
			break;
		case West:
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.NorthWest);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.SouthWest);
			
			hexLoc3 = new HexLocation(x-1,y);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.South);
			break;
		default: //Should never get here Throw Exception Maybe
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.NorthEast);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.SouthEast);
			
			hexLoc3 = new HexLocation(x,y-1);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.South);
			break;
		
		}
		edge1 = edge1.getNormalizedLocation();
		edge2 = edge2.getNormalizedLocation();
		edge3 = edge3.getNormalizedLocation();
		Road road1 = new Road(playerIndex, edge1);
		Road road2 = new Road(playerIndex, edge2);
		Road road3 = new Road(playerIndex, edge3);
		
		if(haveRoadHere(road1) || haveRoadHere(road2) || haveRoadHere(road3)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean hasNeighboringOwnRoad(Road road){
		
		int playerIndex = road.getOwner();
		EdgeLocation edgeSpot = road.getLocation();
		edgeSpot = edgeSpot.getNormalizedLocation();
		HexLocation hexLoc = edgeSpot.getHexLoc();
		EdgeDirection direction = edgeSpot.getDir();
		
		int x = hexLoc.getX();
		int y = hexLoc.getY();
		
		HexLocation hexLoc1;
		EdgeLocation edge1;
		HexLocation hexLoc2;
		EdgeLocation edge2;
		HexLocation hexLoc3;
		EdgeLocation edge3;
		HexLocation hexLoc4;
		EdgeLocation edge4;
		
		switch(direction) {
		case North:
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.NorthEast);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.NorthWest);
			
			hexLoc3 = new HexLocation(x,y-1);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.SouthWest);
			
			hexLoc4 = new HexLocation(x,y-1);
			edge4 = new EdgeLocation(hexLoc3, EdgeDirection.SouthEast);	
			break;
		case NorthEast:
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.North);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.SouthEast);
			
			hexLoc3 = new HexLocation(x+1,y-1);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.NorthWest);
			
			hexLoc4 = new HexLocation(x+1,y-1);
			edge4 = new EdgeLocation(hexLoc3, EdgeDirection.South);
			break;
		case NorthWest:	
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.North);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.SouthWest);
			
			hexLoc3 = new HexLocation(x-1,y);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.NorthEast);
			
			hexLoc4 = new HexLocation(x-1,y);
			edge4 = new EdgeLocation(hexLoc3, EdgeDirection.South);
			break;
		case SouthEast:
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.NorthEast);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.South);
			
			hexLoc3 = new HexLocation(x+1,y);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.North);
			
			hexLoc4 = new HexLocation(x+1,y);
			edge4 = new EdgeLocation(hexLoc3, EdgeDirection.SouthWest);
			break;
		case SouthWest:
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.South);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.NorthWest);
			
			hexLoc3 = new HexLocation(x-1,y+1);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.North);
			
			hexLoc4 = new HexLocation(x-1,y+1);
			edge4 = new EdgeLocation(hexLoc3, EdgeDirection.SouthEast);
			break;
		case South:
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.SouthEast);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.SouthWest);
			
			hexLoc3 = new HexLocation(x,y+1);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.NorthEast);
			
			hexLoc4 = new HexLocation(x,y+1);
			edge4 = new EdgeLocation(hexLoc3, EdgeDirection.NorthWest);
			break;
		default://May change this to an exception later
			hexLoc1 = new HexLocation(x,y);
			edge1 = new EdgeLocation(hexLoc1, EdgeDirection.North);
			
			hexLoc2 = new HexLocation(x,y);
			edge2 = new EdgeLocation(hexLoc2, EdgeDirection.SouthWest);
			
			hexLoc3 = new HexLocation(x-1,y);
			edge3 = new EdgeLocation(hexLoc3, EdgeDirection.NorthEast);
			
			hexLoc4 = new HexLocation(x-1,y);
			edge4 = new EdgeLocation(hexLoc3, EdgeDirection.South);
			break;
		}
		edge1 = edge1.getNormalizedLocation();
		edge2 = edge2.getNormalizedLocation();
		edge3 = edge3.getNormalizedLocation();
		edge4 = edge4.getNormalizedLocation();
		
		Road road1 = new Road(playerIndex, edge1);
		Road road2 = new Road(playerIndex, edge2);
		Road road3 = new Road(playerIndex, edge3);
		Road road4 = new Road(playerIndex, edge4);
		
		if(haveRoadHere(road1) || haveRoadHere(road2) || haveRoadHere(road3) || haveRoadHere(road4)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isRoadHere(EdgeLocation edge){
		edge = edge.getNormalizedLocation();
		EdgeLocation edgeCompare;
		for(Road road : roads){
			edgeCompare = road.getLocation();
			edgeCompare = edgeCompare.getNormalizedLocation(); //Might be Unnecessary
			if(edgeCompare.equals(edge)){
				return true;
			}
		}
		return false;
	}
	
	public void setRobberHexLocation(HexLocation newRobber) {
		this.robber = newRobber;
	}
	
	public HexLocation getRobberLocation() {
		return robber;
	}
	
	public ArrayList<VertexObject> getPlayerSettlementsCities(int playerIndex){
		ArrayList<VertexObject> toReturn = new ArrayList<>();
		
		for(VertexObject settlement: settlements){
			if(settlement.getOwner() == playerIndex){
				toReturn.add(settlement);
			}
		}
		
		for(VertexObject city: cities){
			if(city.getOwner() == playerIndex){
				toReturn.add(city);
			}
		}
		
		return toReturn;
	}
	
	public int matchSettlementToPortRatio(VertexLocation spot, ResourceType resource){
		spot = spot.getNormalizedLocation();
		VertexDirection spotDirection = spot.getDir();
		HexLocation hexLoc = spot.getHexLoc();
		
		EdgeLocation edge1;
		EdgeLocation edge2;
		switch(spotDirection){
		case East:
			edge1 = new EdgeLocation(hexLoc, EdgeDirection.NorthEast);
			edge2 = new EdgeLocation(hexLoc, EdgeDirection.SouthEast);
			break;
		case NorthEast:
			edge1 = new EdgeLocation(hexLoc, EdgeDirection.NorthEast);
			edge2 = new EdgeLocation(hexLoc, EdgeDirection.North);
			break;
		case NorthWest:
			edge1 = new EdgeLocation(hexLoc, EdgeDirection.North);
			edge2 = new EdgeLocation(hexLoc, EdgeDirection.NorthWest);
			break;
		case SouthEast:
			edge1 = new EdgeLocation(hexLoc, EdgeDirection.South);
			edge2 = new EdgeLocation(hexLoc, EdgeDirection.SouthEast);
			break;
		case SouthWest:
			edge1 = new EdgeLocation(hexLoc, EdgeDirection.South);
			edge2 = new EdgeLocation(hexLoc, EdgeDirection.SouthWest);
			break;
		case West:
			edge1 = new EdgeLocation(hexLoc, EdgeDirection.NorthWest);
			edge2 = new EdgeLocation(hexLoc, EdgeDirection.SouthWest);
			break;
		default://Might throw exception instead
			edge1 = new EdgeLocation(hexLoc, EdgeDirection.NorthEast);
			edge2 = new EdgeLocation(hexLoc, EdgeDirection.SouthEast);
			break;
		}
		edge1 = edge1.getNormalizedLocation();
		edge2 = edge2.getNormalizedLocation();
		EdgeLocation portEdgeLocation;
		
		for(Port port: ports){
			portEdgeLocation = new EdgeLocation(port.getLocation(), port.getDirection());
			portEdgeLocation = portEdgeLocation.getNormalizedLocation();
			if(portEdgeLocation.equals(edge1) || portEdgeLocation.equals(edge2)){
				if(port.getRatio() == 3){
					return 3;
				}
				else if(port.getResource() == resource){
					return 2;
				}
			}
		}
		return -1;
	}
}
