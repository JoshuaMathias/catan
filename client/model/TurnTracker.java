package client.model;
/**
 * This class is for keeping track of the turns.
 * @author Ife's group
 *
 */
public class TurnTracker {

	private int currentTurn; //playerIndex of who's turn it is
	private String status;
	private int longestRoad = -1;
	private int largestArmy = -1;
	
	public int getCurrentTurn() {
		return currentTurn;
	}
	public void setCurrentTurn(int currentTurn) {
		this.currentTurn = currentTurn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLongestRoad() {
		return longestRoad;
	}
	public void setLongestRoad(int longestRoad) {
		this.longestRoad = longestRoad;
	}
	public int getLargestArmy() {
		return largestArmy;
	}
	public void setLargestArmy(int largestArmy) {
		this.largestArmy = largestArmy;
	}
	
	
}
