package client.model;

import shared.locations.VertexLocation;

/**
 * This class represents a vertex in the map, with an edge and an owner if there is one.
 * @author Ife's group
 *
 */
public class VertexObject {

	private int owner;
	private VertexLocation location;
	
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public VertexLocation getLocation() {
		return location;
	}
	public void setLocation(VertexLocation location) {
		this.location = location;
	}

}
