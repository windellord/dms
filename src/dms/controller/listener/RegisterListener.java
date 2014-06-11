package dms.controller.listener;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import dms.view.MainView;
import dms.view.composites.RegisterComposite;

/**
 * Listener that handles button clicks from escheduler.view.composite.RegisterComposite 
 * by using methods from escheduler.controller.RegisterController to add new users to the DB
 * 
 * @author Freudensprung Fabian
 * @version Jun 1, 2014
 */
public class RegisterListener implements ClickListener {

	private MainView mv;
	
	/**
	 * Constructor of RegisterListener
	 * 
	 * @param c MainView containing the Composites
	 */
	public RegisterListener(MainView c) {
		mv = c;
	}
	
	/* (non-Javadoc)
	 * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.ClickEvent)
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		String caption=event.getButton().getCaption();
		//Checks if the Button pressed was on the LoggedOutComposite or on the RegisterComposite by checking the caption
		if(caption=="Register") {
			mv.openRegister();
		}
		else {
			if(caption=="Submit Registration") {
				//Extracts the values from the form
				RegisterComposite rcomp = (RegisterComposite)mv.getContent();
				String pass1 = rcomp.getPass1().getValue();
				String pass2 = rcomp.getPass2().getValue();
				String user = rcomp.getUser().getValue();
				//Checks if a password has been entered
				if(pass1==null || pass1=="" || pass2==null || pass2=="") {
					rcomp.setError("Please enter a password");
				}
				else {
					//Checks if the user entered the same password
					if(pass1.equals(pass2)) {
						//Check if the registration succeeded
						mv.openMain();
					}
					else {
						rcomp.setError("The Passwords don't match!");
					}
				}
				
				
			}	
		}
			
	}

}
