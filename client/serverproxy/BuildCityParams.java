package client.serverproxy;

import client.serverproxy.VertexLocation;

public class BuildCityParams {
	private String type="buildCity";
	private int playerIndex=-1;
	private VertexLocation vertexLocation;
	
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
	public VertexLocation getVertexLocation() {
		return vertexLocation;
	}
	public void setVertexLocation(VertexLocation vertexLocation) {
		this.vertexLocation = vertexLocation;
	}

}
