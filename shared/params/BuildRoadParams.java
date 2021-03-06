package shared.params;

import client.serverproxy.EdgeLocation;

/**
 * 
 * Class for sending data for a build road request.
 * @author Ife's Group
 *
 */
public class BuildRoadParams {
	private String type="buildRoad";
	private int playerIndex=-1;
	private EdgeLocation roadLocation;
	private boolean free=false;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPlayerIndex() {
		return playerIndex;
	}
	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}
	public EdgeLocation getRoadLocation() {
		return roadLocation;
	}
	public void setRoadLocation(EdgeLocation roadLocation) {
		this.roadLocation = roadLocation;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	
}
