package com.rs.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static final SessionFactory sessionFactory;    
	static {        
	try {            
	// Cr�ation de la SessionFactory � partir de hibernate.cfg.xml         
		sessionFactory = new Configuration().configure().buildSessionFactory();        
	} catch (Throwable ex) {
	System.err.println("Initial SessionFactory creation failed." + ex);         
	throw new ExceptionInInitializerError(ex);        
	}    
	}    
	//public static final ThreadLocal session = new ThreadLocal();    
	public static SessionFactory getSessionFactory() {        
	return sessionFactory;    
	}

}
