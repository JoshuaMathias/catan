package client.model;
/**
 * This class represents a player.
 * @author Ife's group
 *
 */
public class Player {

	private int cities;
	private String color;
	private boolean discarded;
	private int momuments;
	private String name;
	private DevCardList newDevCards;
	private DevCardList oldDevCards;
	private int playerIndex;
	private boolean playedDevCard;
	private int playerID;
	private ResourceList resources;
	private int roads;
	private int settlements;
	private int soldiers;
	private int victoryPoints;
	
	public int getCities() {
		return cities;
	}
	public void setCities(int cities) {
		this.cities = cities;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isDiscarded() {
		return discarded;
	}
	public void setDiscarded(boolean discarded) {
		this.discarded = discarded;
	}
	public int getMomuments() {
		return momuments;
	}
	public void setMomuments(int momuments) {
		this.momuments = momuments;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DevCardList getNewDevCards() {
		return newDevCards;
	}
	public void setNewDevCards(DevCardList newDevCards) {
		this.newDevCards = newDevCards;
	}
	public DevCardList getOldDevCards() {
		return oldDevCards;
	}
	public void setOldDevCards(DevCardList oldDevCards) {
		this.oldDevCards = oldDevCards;
	}
	public int getPlayerIndex() {
		return playerIndex;
	}
	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}
	public boolean isPlayedDevCard() {
		return playedDevCard;
	}
	public void setPlayedDevCard(boolean playedDevCard) {
		this.playedDevCard = playedDevCard;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public ResourceList getResources() {
		return resources;
	}
	public void setResources(ResourceList resources) {
		this.resources = resources;
	}
	public int getRoads() {
		return roads;
	}
	public void setRoads(int roads) {
		this.roads = roads;
	}
	public int getSettlements() {
		return settlements;
	}
	public void setSettlements(int settlements) {
		this.settlements = settlements;
	}
	public int getSoldiers() {
		return soldiers;
	}
	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}
	public int getVictoryPoints() {
		return victoryPoints;
	}
	public void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}
}
