package client.model;

import java.util.ArrayList;

import shared.definitions.ResourceType;
import shared.locations.HexLocation;
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
				
				EdgeLocation settlementLocation = settlement.getLocation();
				int settlementXLocation = settlementLocation.getX();
				int settlementYLocation = settlementLocation.getY();
				String settlementDirection = settlementLocation.getDirection();
				
				HexLocation portLocation = port.getLocation();
				int portXLocation = portLocation.getX();
				int portYLocation = portLocation.getY();
				String portDirection = port.getDirection();
				
				
				
			}
		}
		
		for(int i = 0; i < cities.size(); i++) {
			
			VertexObject city = cities.get(i);
			
			if(playerIndex == city.getOwner()) {
				
				EdgeLocation cityLocation = city.getLocation();
				int cityXLocation = cityLocation.getX();
				int cityYLocation = cityLocation.getY();
				
				HexLocation portLocation = port.getLocation();
				int portXLocation = portLocation.getX();
				int portYLocation = portLocation.getY();
				
				
				
			}
		}
		
	}
}
