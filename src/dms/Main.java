/**
 * 
 */
package dms;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dms.model.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Query;

/**
 * @author Mici
 * @version 12.06.2014
 *
 */
public class Main {

	private static final Logger log = Logger.getLogger(Main.class);
	
	static SimpleDateFormat dateForm = new SimpleDateFormat("dd.MM.yyyy");
	static SimpleDateFormat timeForm = new SimpleDateFormat("dd.MM.yyyy mm:hh");	
	
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

	private Main() {
		super();
	}

	public static void main(String[] args) {
		log.setLevel(Level.ALL);
		try {
			log.info("Starting \"Mapping Perstistent Classes and Associations\" (task1)");
			task01();
			log.info("Starting \"Working with JPA-QL and the Hibernate Criteria API\" (task2)");
			task02a();
			task02b();
			task02c();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void fillDB(EntityManager em) throws ParseException {
		// dateForm.parse("01.01.1930")
	}

	/**
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	public static void task01() throws ParseException, InterruptedException {
		//Benutzer
		String[] fname={"Aiden","Jackson","Ethan","Liam","Jerome"};

		String[] pass={"abc123","asdf1234","huan123","ghjk6789","bluemchen98"};
		
		
		for(int i=0;i<5;i++) {
			User user = new User();
			user.setName(fname[i]);
			user.setPassword(pass[i]);	
		
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
		
			session.save(user);
			tx.commit();
		}
		
	}

	public static void task02a() throws ParseException {
		System.out.println("\n\nQuery 2a:\n-------------");
		Session s = sessionFactory.openSession();
		
		Query nq = s.getNamedQuery("GetUsers");
		
		
		@SuppressWarnings("unchecked")
		List<User> l = nq.list();
		
		
	}

	public static void task02b() throws ParseException {
		
	}

	public static void task02c() throws ParseException {
		//System.out.println("\n\nQuery 2c:\n-------------");
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

}