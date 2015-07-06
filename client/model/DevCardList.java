package client.model;
/**
 * This class represents a list of development cards.
 * @author Ife's group
 *
 */
public class DevCardList {

	private int monopoly;
	private int monument;
	private int roadBuilding;
	private int soldier;
	private int yearOfPlenty;
	
	public boolean canBuyDevCard(){
		int total = monopoly + monument + roadBuilding + soldier + yearOfPlenty;
		if (total > 0){
			return true;
		}
		else{
			return false;
		}
	}
}
