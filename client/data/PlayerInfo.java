package client.data;

import client.facade.Facade;
import shared.definitions.*;

/**
 * Used to pass player information into views<br>
 * <br>
 * PROPERTIES:<br>
 * <ul>
 * <li>Id: Unique player ID</li>
 * <li>PlayerIndex: Player's order in the game [0-3]</li>
 * <li>Name: Player's name (non-empty string)</li>
 * <li>Color: Player's color (cannot be null)</li>
 * </ul>
 * 
 */
public class PlayerInfo
{
	
	private int id;
	private int playerIndex;
	private String name;
	private CatanColor colorEnum = null;
	private String color = null;
	
	public PlayerInfo()
	{
		setId(-1);
		setPlayerIndex(-1);
		setName("");
//		setColorEnum(CatanColor.WHITE);
//		color="white";
	}
	
	public void EnumToColor(CatanColor colorEnum) {
		switch (colorEnum) {
			case red:
				color = "red";
			case orange:
				color = "orange";
			case yellow:
				color = "yellow";
			case blue:
				color = "blue";
			case green:
				color = "green";
			case purple:
				color = "purple";
			case puce:
				color = "puce";
			case white:
				color = "white";
			case brown:
				color = "brown";
		}
	}
	
	public void ColorToEnum(String color) {
		switch (color) {
			case "red":
				colorEnum = CatanColor.red;
			case "orange":
				colorEnum = CatanColor.orange;
			case "yellow":
				colorEnum = CatanColor.yellow;
			case "blue":
				colorEnum = CatanColor.blue;
			case "green":
				colorEnum = CatanColor.green;
			case "purple":
				colorEnum = CatanColor.purple;
			case "puce":
				colorEnum = CatanColor.puce;
			case "white":
				colorEnum = CatanColor.white;
			case "brown":
				colorEnum = CatanColor.brown;
		}
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getPlayerIndex()
	{
		return playerIndex;
	}
	
	public void setPlayerIndex(int playerIndex)
	{
		this.playerIndex = playerIndex;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	public String getColor() {
		EnumToColor(colorEnum);
		return color;
	}

	public void setColor(String color) {
		ColorToEnum(color);		
		this.color = color;
	}

	public CatanColor getColorEnum()
	{
		ColorToEnum(color);
		return colorEnum;
	}
	
	public void setColorEnum(CatanColor color)
	{
		EnumToColor(colorEnum);
		this.colorEnum = color;
	}

	@Override
	public int hashCode()
	{
		return 31 * this.id;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final PlayerInfo other = (PlayerInfo) obj;
		
		return this.id == other.id;
	}
}

