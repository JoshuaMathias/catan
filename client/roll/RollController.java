package client.roll;

import java.util.Random;

import client.base.*;
import client.facade.Facade;


/**
 * Implementation for the roll controller
 */
public class RollController extends Controller implements IRollController {

	private IRollResultView resultView;
	private Facade clientFacade;
	
	/**
	 * RollController constructor
	 * 
	 * @param view Roll view
	 * @param resultView Roll result view
	 */
	public RollController(IRollView view, IRollResultView resultView) {
		
		super(view);
		
		setResultView(resultView);
		clientFacade = Facade.getSingleton();
		
		clientFacade.setRollController(this);
	}
	
	public void startRollGui() {
		getRollView().showModal();
	}
	
	public IRollResultView getResultView() {
		return resultView;
	}
	public void setResultView(IRollResultView resultView) {
		this.resultView = resultView;
	}

	public IRollView getRollView() {
		return (IRollView)getView();
	}
	
	@Override
	public void rollDice() {
		
		getRollView().closeModal();
		
		Random random = new Random();
		int randomNum = random.nextInt((6 - 1) + 1) + 1;
		int randomNum2 = random.nextInt((6 - 1) + 1) + 1;
		
		int finalRandomNum = randomNum + randomNum2;	
		
//		if (finalRandomNum == 7){finalRandomNum = 6;}
		
//		finalRandomNum = 7;
		
		//clientFacade.setDiceRoll(finalRandomNum);//Do we need this?
		clientFacade.rollNumber(finalRandomNum);
		
		resultView.setRollValue(finalRandomNum);
		getResultView().showModal();
	}

}

