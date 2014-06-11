/**
 * 
 */
package dms.view.composites;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;

import dms.view.MainView;

/**
 * @author Freudensprung Fabian
 * @version Jun 11, 2014
 *
 */
public class MainComposite extends CustomComponent {

	private AbsoluteLayout mainLayout;
	private AbsoluteLayout innerLayout;
	private Label content;
	private MainView mv;

	public MainComposite() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
	}

	/**
	 * @param mainView
	 */
	public MainComposite(MainView mv) {
		this.mv = mv;
	}

	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// innerLayout
		innerLayout = new AbsoluteLayout();
		innerLayout.setImmediate(false);
		innerLayout.setWidth("100.0%");
		innerLayout.setHeight("100.0%");
		mainLayout.addComponent(innerLayout,"top:50.0px;right:20.0%;bottom:50.0px;left:20.0%;");
		
		content = new Label("You are logged in! Her would be the content");
		mainLayout.addComponent(innerLayout,"top:10.0px;right:5.0%;left:5.0%;");
		
		return mainLayout;
	}

}
