package client.model;

import shared.locations.HexLocation;

/**
 * This class represents a port.
 * @author Ife's group
 *
 */
public class Port {

	private String resource;
	private HexLocation location;
	private String direction;
	private int ratio;

	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public HexLocation getLocation() {
		return location;
	}
	public void setLocation(HexLocation location) {
		this.location = location;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getRatio() {
		return ratio;
	}
	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

}
