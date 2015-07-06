package client.model;
/**
 * This class represents a vertex in the map, with an edge and an owner if there is one.
 * @author Ife's group
 *
 */
public class VertexObject {

	private int owner;
	private EdgeLocation location;
	
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public EdgeLocation getLocation() {
		return location;
	}
	public void setLocation(EdgeLocation location) {
		this.location = location;
	}

}
