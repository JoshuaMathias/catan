package client.model;

import java.util.ArrayList;

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
}
