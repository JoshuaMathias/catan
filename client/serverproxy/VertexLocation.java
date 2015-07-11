package client.serverproxy;
import shared.locations.VertexDirection;

public class VertexLocation 
{
	private int x = -1;
	private int y = -1;
	String direction = "";
	
	public VertexLocation(int x, int y, VertexDirection dir)
	{
		this.x=x;
		this.y=y;
		switch (dir)
		{
			case NE: direction = "NE"; 
				break;
			case NW: direction = "NW"; 
				break;
			case SE: direction = "SE"; 
				break;
			case SW: direction = "SW"; 
				break;
			case E: direction = "E"; 
				break;
			case W: direction = "W"; 
				break;
		}
	}
}
