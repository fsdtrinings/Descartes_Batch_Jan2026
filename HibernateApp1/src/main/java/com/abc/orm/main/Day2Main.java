package com.abc.orm.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.orm.entity.Address;
import com.abc.orm.entity.Customer;

public class Day2Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//createCustomer(session);
		updateOfficeAddress(session,4000,"Delhi");
		updateOfficeAddress(session,4001,"Delhi");
		updateOfficeAddress(session,4002,"Mumbai");
		updateOfficeAddress(session,4003,"Delhi");
		
		
	}

	public static void updateOfficeAddress(Session hibernate,int id,String cityName) {

		Transaction t = hibernate.beginTransaction();

		
		
		Customer c = hibernate.get(Customer.class, id);
		Address officeAddress = new Address("G/ABC-123", cityName, "India", 2200258);
		c.setOfficeAddress(officeAddress);
		
		Address houseAddress = new Address("G/ABC-123", cityName, "India", 2200258);
		c.setHouseAddress(houseAddress);
		
		

		
		
		
		hibernate.persist(c); // after java specification , JPA
		
		t.commit();
	}

	public static void createCustomer(Session hibernate) {

		Transaction t = hibernate.beginTransaction();

		Customer c = new Customer();
		c.setCid(106);
		String name = "Bhavesh";
		c.setCustomerName(name);
		c.setEmail(name + "@gmail.com");
		c.setPhoneNumber(2558541323L);

		Address a1 = new Address("H-123", "Delhi", "India", 4200258);
		c.setHouseAddress(a1);

		Address officeAddress = new Address("H/MBC-123", "Delhi", "India", 1400258);
		c.setOfficeAddress(officeAddress);

		hibernate.persist(c); // after java specification , JPA
		t.commit();

		System.out.println("Data saved in the database");

	}

}
