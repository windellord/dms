/**
 * 
 */
package dms.controller.listener;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import dms.model.User;

/**
 * @version 12.06.2014
 *
 */
public class LoginController {
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
	        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    } catch (Throwable ex) {
	        // Make sure you log the exception, as it might be swallowed
	        System.err.println("Initial SessionFactory creation failed." + ex);
	        throw new ExceptionInInitializerError(ex);
	    }
	}

	public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}

	
	public Collection<User> getUserList(){
		Session s = sessionFactory.openSession();
		
		Query nq = s.getNamedQuery("GetUsers");
		
		
		@SuppressWarnings("unchecked")
		List<User> l = nq.list();
		
		return l;
		
	}

}
