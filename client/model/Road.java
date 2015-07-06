package client.model;
/**
 * This class represents an edge value.
 * @author Ife's group
 *
 */
public class Road {

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
