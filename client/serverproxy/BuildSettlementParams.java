package client.serverproxy;

import client.model.EdgeLocation;

/**
 * Class for sending data for a build settlement or build city request.
 * @author Ife's Group
 *
 */
public class BuildSettlementParams {
	private String type="buildSettlement";
	private int playerIndex = -1;
	private EdgeLocation vertexLocation;
	private boolean free = false;
	
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
	public EdgeLocation getVertexLocation() {
		return vertexLocation;
	}
	public void setVertexLocation(EdgeLocation vertexLocation) {
		this.vertexLocation = vertexLocation;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	
}
