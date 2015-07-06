package client.serverproxy;

import client.model.EdgeLocation;

public class BuildCityParams {
	private String type="buildCity";
	private int playerIndex=-1;
	private EdgeLocation vertexLocation;
	
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

}
