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
			case RED:
				color = "red";
				break;
			case ORANGE:
				color = "orange";
				break;
			case YELLOW:
				color = "yellow";
				break;
			case BLUE:
				color = "blue";
				break;
			case GREEN:
				color = "green";
				break;
			case PURPLE:
				color = "purple";
				break;
			case PUCE:
				color = "puce";
				break;
			case WHITE:
				color = "white";
				break;
			case BROWN:
				color = "brown";
		}
	}
	
	public void ColorToEnum(String color) {
		switch (color) {
			case "red":
				colorEnum = CatanColor.RED;
				break;
			case "orange":
				colorEnum = CatanColor.ORANGE;
				break;
			case "yellow":
				colorEnum = CatanColor.YELLOW;
				break;
			case "blue":
				colorEnum = CatanColor.BLUE;
				break;
			case "green":
				colorEnum = CatanColor.GREEN;
				break;
			case "purple":
				colorEnum = CatanColor.PURPLE;
				break;
			case "puce":
				colorEnum = CatanColor.PUCE;
				break;
			case "white":
				colorEnum = CatanColor.WHITE;
				break;
			case "brown":
				colorEnum = CatanColor.BROWN;
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

