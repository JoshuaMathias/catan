package client.serverproxy;

import shared.locations.EdgeDirection;

public class EdgeLocation 
{

	private int x = -1;
	private int y = -1;
	String direction = "";
	
	public EdgeLocation(int x, int y, EdgeDirection dir)
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
			case North: direction = "N"; 
				break;
			case South: direction = "S"; 
				break;
		}
	}
}
