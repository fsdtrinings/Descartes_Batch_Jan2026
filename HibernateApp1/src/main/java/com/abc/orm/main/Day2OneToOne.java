package com.abc.orm.main;


import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.abc.orm.entity.Address;
import com.abc.orm.entity.Customer;
import com.abc.orm.entity.Profile;


public class Day2OneToOne {

	public static void main(String[] args) {
		
		int id = 101;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		createCustomer(session,id);
		updateOfficeAddress(session, id);
		
	}

	public static void updateOfficeAddress(Session hibernate,int id) {

		Transaction t = hibernate.beginTransaction();

		Customer c = hibernate.get(Customer.class, id);
		Address officeAddress = new Address("G/ABC-123", "Delhi", "India", 2200258);
		c.setOfficeAddress(officeAddress);

		hibernate.persist(c); // after java specification , JPA
		
		t.commit();
	}

	public static void createCustomer(Session hibernate,int id) {

		Transaction t = hibernate.beginTransaction();

		Customer c = new Customer();
		c.setCid(id);
		
		String name = "Ganesh";
		c.setCustomerName(name);
		c.setEmail(name + "@gmail.com");
		c.setPhoneNumber(357841323L);

		Address a1 = new Address("A-123", "Delhi", "India", 110028);
		c.setHouseAddress(a1);

		Address officeAddress = new Address("H/MBC-123", "Delhi", "India", 1100258);
		c.setOfficeAddress(officeAddress);
		hibernate.persist(c); // after java specification , JPA

		
		int profileId = new Random().nextInt(600,699);
		Profile p = new Profile(profileId, "Ganesh Kumar", 0, "12/12/1999");
		hibernate.persist(p);
		
		Profile profileFromDB = hibernate.get(Profile.class, profileId);
		c.setProfile(profileFromDB);
		
		
		t.commit();

		System.out.println("Data saved in the database");

	}

}
