package client.model;

import shared.definitions.DevCardType;

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
	
	public boolean canPlayDevCard(DevCardType cardType){
		
		boolean canPlay = false;
		
		if(cardType == DevCardType.MONOPOLY) {
			
			if(monopoly > 0) {
				return true;
			}
		} else if(cardType == DevCardType.MONUMENT) { 
			
			if(monument > 0) {
				return true;
			}
		} else if(cardType == DevCardType.ROAD_BUILD) {
			
			if(roadBuilding > 0) {
				return true;
			}
		} else if(cardType == DevCardType.SOLDIER) {
			
			if(soldier > 0) {
				return true;
			}
		} else if(cardType == DevCardType.YEAR_OF_PLENTY) {
			
			if(yearOfPlenty > 0) {
				return true;
			}
		}
		
		return canPlay;
	}
}
