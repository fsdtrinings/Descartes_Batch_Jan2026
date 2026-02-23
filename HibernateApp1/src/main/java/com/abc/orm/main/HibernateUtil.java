package com.abc.orm.main;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*class is responsible to load the hibernate cfg file*/

public class HibernateUtil 
{
	 private static SessionFactory sessionFactory;

	    static {
	        try {
	    		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	    		sessionFactory = cfg.buildSessionFactory();
	    		System.out.println("INFO : Session Factory Created :-  "+sessionFactory);
	    		
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to initialize Hibernate SessionFactory");
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}//end class
