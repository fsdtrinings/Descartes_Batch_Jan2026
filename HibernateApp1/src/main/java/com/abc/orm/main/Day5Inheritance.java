package com.abc.orm.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.orm.entity.Address;
import com.abc.orm.entity.AppOrder;
import com.abc.orm.entity.CardPayment;
import com.abc.orm.entity.Customer;
import com.abc.orm.entity.Payment;
import com.abc.orm.entity.UPIPayment;

public class Day5Inheritance {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		//Customer c = fromNewCustomer();
		Customer c = fromExistingCustomer(session, 4003);
		
		int d = new Random().nextInt(1,31);
		int month = new Random().nextInt(1,12);
		
		String date = d+"/"+month+"/2025";
		
	//	Payment payment = new UPIPayment(new Random().nextInt(5010,5999), date,"Paytm-UPI");
		
		Payment payment = new CardPayment("CardPayment",date,"Visa" , 741258963L);
		
		
		AppOrder order1 = new AppOrder(date,new Random().nextInt(1000, 8000));
		order1.setCustomer(c);
		order1.setPaymemtType(payment);
		
		List<AppOrder> list = new ArrayList<>();
		list.add(order1);
		
		c.setAllOrders(list);
		
		
		session.persist(order1);
		
		
		t.commit();
		
	}
	
	public static Customer fromExistingCustomer(Session session,int cid)
	{
		return session.get(Customer.class, cid);
	}
	
	public static Customer fromNewCustomer()
	{
		String customerName = "Kavita";
		long phoneNumber = new Random().nextLong(9000000,9999999);
		
		Customer c = new Customer(customerName,phoneNumber);
		Address address = new Address("ABC-123","Gurgaon", "India",780058L);
		c.setEmail(customerName+"@gmail.com");
		
		return c;
	}

}
