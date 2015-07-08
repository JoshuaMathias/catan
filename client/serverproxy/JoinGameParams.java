package client.serverproxy;

public class JoinGameParams 
{
	private String id = "";
	private String color = "";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public JoinGameParams(String id, String color) 
	{
		this.id = id;
		this.color = color;
	}
	
}
