package client.model;
/**
 * This class represents a player.
 * @author Ife's group
 *
 */
public class Player {

	private int cities = 0;
	private String color;
	private boolean discarded = false;
	private int momuments = 0;
	private String name;
	private DevCardList newDevCards = new DevCardList(false);
	private DevCardList oldDevCards = new DevCardList(false);
	private int playerIndex;
	private boolean playedDevCard = false;
	private int playerID;
	private ResourceList resources = new ResourceList(0,0,0,0,0);
	private int roads = 0;
	private int settlements = 0;
	private int soldiers = 0;
	private int victoryPoints = 0;
	
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
	
	public void incrementSettlement(){
		settlements++;
	}
	
	public void decrementSettlement(){
		settlements--;
	}
	
	public void incrementCity(){
		cities++;
	}
	
	public void decrementCity(){
		cities--;
	}
}
