package client.model;

import shared.definitions.ResourceType;
import shared.locations.EdgeDirection;
import shared.locations.HexLocation;

/**
 * This class represents a port.
 * @author Ife's group
 *
 */
public class Port {

	private ResourceType resource;
	private HexLocation location;
	private EdgeDirection direction;
	private int ratio;

	public ResourceType getResource() {
		return resource;
	}
	public void setResource(ResourceType resource) {
		this.resource = resource;
	}
	public HexLocation getLocation() {
		return location;
	}
	public void setLocation(HexLocation location) {
		this.location = location;
	}
	public EdgeDirection getDirection() {
		return direction;
	}
	public void setDirection(EdgeDirection direction) {
		this.direction = direction;
	}
	public int getRatio() {
		return ratio;
	}
	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

}
