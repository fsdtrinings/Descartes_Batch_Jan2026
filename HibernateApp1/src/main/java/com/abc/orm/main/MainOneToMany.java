package com.abc.orm.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.orm.entity.AppOrder;
import com.abc.orm.entity.Customer;

import jakarta.persistence.ManyToMany;

public class MainOneToMany {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// ---- Create 2 orders ---
		
		int orderNumber = new Random().nextInt(500, 599);
		int amount = new Random().nextInt(50000);
		int cid = 101;
		
		AppOrder order1 = new AppOrder(orderNumber,LocalDate.of(2025, 8, 14).toString(), amount);
		
		
		Transaction t = session.beginTransaction();
			session.persist(order1); // saving order1
			
			AppOrder orderFromDB = session.get(AppOrder.class, orderNumber); // fetch order no 501 from DB
			// linking order with customer
			
			// a. Fetch desired customer from the DB
			Customer c = session.get(Customer.class, cid);
			
				
			//ordersOfCustomer.add(orderFromDB); // linking order
			orderFromDB.setCustomer(c);
			
			
			
			
		t.commit();
		
	}
	


}
