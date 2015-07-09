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
			case NorthEast: direction = "NE"; 
				break;
			case NorthWest: direction = "NW"; 
				break;
			case SouthEast: direction = "SE"; 
				break;
			case SouthWest: direction = "SW"; 
				break;
			case East: direction = "E"; 
				break;
			case West: direction = "W"; 
				break;
		}
	}
}
