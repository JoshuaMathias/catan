package client.model;

import java.util.ArrayList;

import shared.definitions.ResourceType;
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
				String portDirection = port.getDirection();
				
				
				
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
	
	public boolean isRoadHere(Road road){
		return false;
		
	}
	
	public boolean hasNeighboringOwnRoad(VertexObject settlement){
		return false;
		
	}
	
	public boolean hasNeighboringOwnRoad(Road road){
		return false;
		
	}
	
	public void setRobberHexLocation(HexLocation newRobber) {
		this.robber = newRobber;
	}
	
	public HexLocation getRobberLocation() {
		return robber;
	}
}
