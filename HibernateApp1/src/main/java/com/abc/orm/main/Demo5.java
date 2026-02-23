package com.abc.orm.main;

import org.hibernate.Session;

import com.abc.orm.entity.Customer;

public class Demo5 {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Customer c = session.get(Customer.class,107);
		Customer c2 = session.get(Customer.class,101);
		
		
		//session.clear();
		
	
		//session.evict(c);
		
		//session.close();
		System.out.println(c.getCustomerName()); // Direct value 
		

		System.out.println(c.getProfile()); // one to one relationship 
		// --------------
		System.out.println(c.getAllOrders());
		
		session.close();
	}

}
