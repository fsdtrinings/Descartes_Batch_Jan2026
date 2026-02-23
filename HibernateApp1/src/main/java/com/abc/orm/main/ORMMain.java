package com.abc.orm.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;

import com.abc.orm.entity.Customer;

import jakarta.persistence.Query;

public class ORMMain {

	public static void main(String[] args) {
		
		
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		
		
		// --- Save data ---- 
		doSave(session);
		
		//doFetchCustomer(dbConnection, 102);

		//doUpdate(session);
		//fetchCustomersBasedOnName(session);
	}
	
	
	public static void fetchCustomersBasedOnName(Session session)
	{
		// select * from Customer where customerName like "A%";
		
		String filterName = "Alok";
		String hqlQuery = "From Customer as c where c.customerName = :abc";
		
		Query q = session.createQuery(hqlQuery);
		q.setParameter("abc", filterName);
		
		List<Customer> allCustomers = q.getResultList();
		for (Customer customer : allCustomers) {
			System.out.println(customer);
		}
		
	}
	
	public static void doUpdate(Session session)
	{
		Transaction t = session.beginTransaction();
		
		Customer c = doFetchCustomer(session,104);
		c.setEmail("kavita123@outlook.com");
		
		t.commit();
	}
	
	public static Customer getCustomer()
	{
		return new Customer(101,"kavita","kavita@outlook.com",856954123L,"New Delhi");
	}
	
	public static Customer doFetchCustomer(Session hibernate,int customerId)
	{
		Customer fromDB = hibernate.get(Customer.class , customerId);
		System.out.println(fromDB);
		return fromDB;
	}
	
	public static void doSave(Session hibernate)
	{
		Transaction t = hibernate.beginTransaction();
			Customer c = getCustomer();
			hibernate.persist(c); // after java specification , JPA
		t.commit();
		
		
		System.out.println("Data saved in the database");
	}
	
}






















