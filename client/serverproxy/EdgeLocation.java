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
			case NE: direction = "NE"; 
				break;
			case NW: direction = "NW"; 
				break;
			case SE: direction = "SE"; 
				break;
			case SW: direction = "SW"; 
				break;
			case N: direction = "N"; 
				break;
			case S: direction = "S"; 
				break;
		}
	}
}
