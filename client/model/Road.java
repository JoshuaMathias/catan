package client.model;

import shared.locations.EdgeLocation;

/**
 * This class represents an edge value.
 * @author Ife's group
 *
 */
public class Road {

	private int owner;
	private EdgeLocation location;
	
	public Road(int owner, EdgeLocation location){
		this.owner = owner;
		this.location = location;
	}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + owner;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
<<<<<<< HEAD
//		this.location = this.location.getNormalizedLocation();
=======
>>>>>>> parent of e8dfa0c... Fixed Place road problem
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Road other = (Road) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (owner != other.owner)
			return false;
		return true;
	}
	
	
}
