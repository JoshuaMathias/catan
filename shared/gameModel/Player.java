package shared.gameModel;

import shared.definitions.CatanColor;

/**
 * This class represents a player.
 * @author Ife's group
 *
 */
public class Player {

	private int cities = 4;
	private CatanColor color;
	private boolean discarded = false;
	private int momuments = 0;
	private String name;
	private DevCardList newDevCards = new DevCardList(false);
	private DevCardList oldDevCards = new DevCardList(false);
	private int playerIndex;
	private boolean playedDevCard = false;
	private static int currentID=0;
	private int playerID;
	private ResourceList resources = new ResourceList(0,0,0,0,0);
	private int roads = 15;
	private int settlements = 5;
	private int soldiers = 0;
	private int victoryPoints = 0;
	
	public Player() {
		playerID=currentID++;
	}
	
	public int getCities() {
		return cities;
	}
	public void setCities(int cities) {
		this.cities = cities;
	}
	public CatanColor getColor() {
		return color;
	}
	public void setColor(CatanColor color) {
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
	
	public int getResourceCardNum(){
		return resources.getTotal();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cities;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (discarded ? 1231 : 1237);
		result = prime * result + momuments;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((newDevCards == null) ? 0 : newDevCards.hashCode());
		result = prime * result
				+ ((oldDevCards == null) ? 0 : oldDevCards.hashCode());
		result = prime * result + (playedDevCard ? 1231 : 1237);
		result = prime * result + playerID;
		result = prime * result + playerIndex;
		result = prime * result
				+ ((resources == null) ? 0 : resources.hashCode());
		result = prime * result + roads;
		result = prime * result + settlements;
		result = prime * result + soldiers;
		result = prime * result + victoryPoints;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (cities != other.cities)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (discarded != other.discarded)
			return false;
		if (momuments != other.momuments)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (newDevCards == null) {
			if (other.newDevCards != null)
				return false;
		} else if (!newDevCards.equals(other.newDevCards))
			return false;
		if (oldDevCards == null) {
			if (other.oldDevCards != null)
				return false;
		} else if (!oldDevCards.equals(other.oldDevCards))
			return false;
		if (playedDevCard != other.playedDevCard)
			return false;
		if (playerID != other.playerID)
			return false;
		if (playerIndex != other.playerIndex)
			return false;
		if (resources == null) {
			if (other.resources != null)
				return false;
		} else if (!resources.equals(other.resources))
			return false;
		if (roads != other.roads)
			return false;
		if (settlements != other.settlements)
			return false;
		if (soldiers != other.soldiers)
			return false;
		if (victoryPoints != other.victoryPoints)
			return false;
		return true;
	}
}
