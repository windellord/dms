package dms.view;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import dms.view.composites.LoginComposite;
import dms.view.composites.MainComposite;
import dms.view.composites.RegisterComposite;

/**
 * Vaadin UI that uses the Custom Components from escheduler.view.composites to display 
 * the User Interface
 *
 * @author Freudensprung Fabian
 * @version Jun 1, 2014
 */
/**
 * @author Freudensprung Fabian
 * @version Jun 11, 2014
 *
 */
@Theme("escheduler")
public class MainView extends UI{
	
	private boolean loggedIn = false;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MainView.class)
	public static class Servlet extends VaadinServlet {
	}

	/**
	 * Initialises the UI on first run
	 */
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		layout.setSizeFull();		
		
		LoginComposite composite = new LoginComposite(this);
		layout.addComponent(composite);

	}
	
	/**
	 * Open login.
	 */
	public void openLogin() {
		setContent(new LoginComposite(this));
	}

	/**
	 * Open main.
	 *
	 * @param user the user
	 */
	public void openMain() {
		setLoggedIn(true);
		setContent(new MainComposite(this));
	}


	
	/**
	 * Open register composite
	 */
	public void openRegister() {
		setContent(new RegisterComposite(this));
	}

	/**
	 * Checks if is logged in.
	 *
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * Sets the logged in.
	 *
	 * @param loggedIn the loggedIn to set
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	/**
	 * Log out.
	 */
	public void logOut() {
		setContent(new LoginComposite(this));
	}
}