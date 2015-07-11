package shared.locations;

/**
 * Represents the location of an edge on a hex map
 */
public class EdgeLocation
{
	
	private HexLocation hexLoc;
	private EdgeDirection direction;
	//private String direction;
	private int x;
	private int y;
	
	public EdgeLocation(HexLocation hexLoc, EdgeDirection dir)
	{
		setHexLoc(hexLoc);
		setDir(dir);
	}
	
	public HexLocation getHexLoc()
	{
		setXYHexLoc();
		return hexLoc;
	}
	
	private void setHexLoc(HexLocation hexLoc)
	{
		if(hexLoc == null)
		{
			throw new IllegalArgumentException("hexLoc cannot be null");
		}
		this.hexLoc = hexLoc;
		this.x = hexLoc.getX();
		this.y = hexLoc.getY();
	}
	
	private void setXYHexLoc(){
		HexLocation location = new HexLocation(x, y);
		setHexLoc(location);
	}
	
	public EdgeDirection getDir()
	{
		setXYHexLoc();
		return direction;
	}
	
	private void setDir(EdgeDirection dir)
	{
		setXYHexLoc();
		this.direction = dir;
	}
	
	@Override
	public String toString()
	{
		setXYHexLoc();
		return "EdgeLocation [hexLoc=" + hexLoc + ", dir=" + direction + "]";
	}
	
	@Override
	public int hashCode()
	{
		setXYHexLoc();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((hexLoc == null) ? 0 : hexLoc.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		setXYHexLoc();
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		EdgeLocation other = (EdgeLocation)obj;
		if(direction != other.direction)
			return false;
		if(hexLoc == null)
		{
			if(other.hexLoc != null)
				return false;
		}
		else if(!hexLoc.equals(other.hexLoc))
			return false;
		return true;
	}
	
	/**
	 * Returns a canonical (i.e., unique) value for this edge location. Since
	 * each edge has two different locations on a map, this method converts a
	 * hex location to a single canonical form. This is useful for using hex
	 * locations as map keys.
	 * 
	 * @return Normalized hex location
	 */
	public EdgeLocation getNormalizedLocation()
	{
		setXYHexLoc();
		// Return an EdgeLocation that has direction NW, N, or NE
		
		switch (direction)
		{
			case NW:
			case N:
			case NE:
				return this;
			case SW:
			case S:
			case SE:
				return new EdgeLocation(hexLoc.getNeighborLoc(direction),
										direction.getOppositeDirection());
			default:
				assert false;
				return null;
		}
	}
}

