package com.abc.orm.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.abc.orm.entity.AppOrder;
import com.abc.orm.entity.Customer;

public class HQLDemos {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		/*
		String hql = "From Customer as c where c.customerName like :pattern";
		String pattern = "%esh";
		
		Query q  = session.createQuery(hql);
		q.setParameter("pattern", pattern);
		
		List<Customer> list = q.getResultList();
		
		for (Customer customer : list) {
			System.out.println(customer);
		}
		*/
		
		System.out.println(" ----------------- Inner Query get Customer by Order No -------------------------------------------");
		
		// -----------  Inner Query --------------------------
		// select * from apporder where customer_id in (select cid from dekcustomers where city = 'Delhi');
		//select * from dekcustomers where cid in (select customer_id from apporder where ordernumber = 521);
	
		  String hql2 = "From Customer as c where c.cid in (select o.customer.cid from AppOrder o where o.orderNumber = :orderNo)";
		  int orderNo = 521;
		  
		  Query q2 = session.createQuery(hql2,Customer.class);
		  q2.setParameter("orderNo", orderNo);
		  
		  Customer c = (Customer)q2.uniqueResult();
		  
		  System.out.println(c);
		 
		 
	}
}
