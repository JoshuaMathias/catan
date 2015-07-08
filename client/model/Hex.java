package client.model;

import shared.definitions.HexType;
import shared.locations.HexLocation;

/**
 * This class represents a hex in the map.
 * @author Ife's group
 *
 */
public class Hex {

	private HexLocation location;
	private HexType resource;
	private int number;
	
	public HexLocation getLocation() {
		return location;
	}
	public void setLocation(HexLocation location) {
		this.location = location;
	}
	public HexType getResource() {
		return resource;
	}
	public void setResource(HexType resource) {
		this.resource = resource;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
