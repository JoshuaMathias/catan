package client.login;

import client.base.*;
import client.facade.Facade;
import client.misc.*;

import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


/**
 * Implementation for the login controller
 */
public class LoginController extends Controller implements ILoginController {

	private IMessageView messageView;
	private IAction loginAction;
	private Facade clientFacade;
	
	/**
	 * LoginController constructor
	 * 
	 * @param view Login view
	 * @param messageView Message view (used to display error messages that occur during the login process)
	 */
	public LoginController(ILoginView view, IMessageView messageView) {

		super(view);
		
		this.messageView = messageView;
		clientFacade = Facade.getSingleton();
	}
	
	public ILoginView getLoginView() {
		
		return (ILoginView)super.getView();
	}
	
	public IMessageView getMessageView() {
		
		return messageView;
	}
	
	/**
	 * Sets the action to be executed when the user logs in
	 * 
	 * @param value The action to be executed when the user logs in
	 */
	public void setLoginAction(IAction value) {
		
		loginAction = value;
	}
	
	/**
	 * Returns the action to be executed when the user logs in
	 * 
	 * @return The action to be executed when the user logs in
	 */
	public IAction getLoginAction() {
		
		return loginAction;
	}

	@Override
	public void start() {
		
		getLoginView().showModal();
	}

	@Override
	public void signIn() {
		
		// TODO: log in user
		

		// If log in succeeded
		getLoginView().closeModal();
		loginAction.execute();
	}

	@Override
	public void register() {
		
<<<<<<< HEAD
		// TODO: register new user (which, if successful, also logs them in)
		
		String username = getLoginView().getRegisterUsername();
		String password = getLoginView().getRegisterPassword();
		String passwordRepeat = getLoginView().getRegisterPasswordRepeat();
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(passwordRepeat);
		
		if(password.equals(passwordRepeat)){
			if(clientFacade.register(username, password)){
				
			}
		}
		else{
			//Error Message about passwords not matching
		}
		
=======
		//register new user (which, if successful, also logs them in)
		Facade.getSingleton().register(, password);
>>>>>>> 4c6063abc126dedc2ead380c71a4dc11b1e465fd
		// If register succeeded
//		getLoginView().closeModal();
//		loginAction.execute();
	}

}

