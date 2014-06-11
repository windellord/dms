/**
 * 
 */
package dms.controller.listener;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import dms.view.MainView;

/**
 * @author ffreu_000
 * @version Jun 12, 2014
 *
 */
public class LogoutListener implements ClickListener {

	private MainView mv;

	public LogoutListener(MainView mv) {
		this.mv = mv;
	}
	
	/* (non-Javadoc)
	 * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.ClickEvent)
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		mv.logOut();
	}

}
