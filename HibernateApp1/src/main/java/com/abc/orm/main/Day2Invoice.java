package com.abc.orm.main;

import java.beans.Customizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import com.abc.orm.entity.Customer;
import com.abc.orm.entity.Invoice;

import org.hibernate.Transaction;

public class Day2Invoice {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		int cid = 4002;
		//	getAllInvoicesByCustomerId(cid, session);
		addInvoice(session,cid);
	}

	
	public static void getAllInvoicesByCustomerId(int cid,Session session)
	{
		Customer c = session.get(Customer.class, cid);
		
		List<Invoice> allInvoices = c.getInvoice();
		
		for (Invoice invoice : allInvoices) {
			System.out.println(invoice);
		}
		
	}
	
	
	
	public static void addInvoice(Session session, int cid) {
		Invoice i1 = new Invoice("b-123");
		Invoice i2 = new Invoice("b-124");
		Invoice i3 = new Invoice("b-125");
		

		List<Invoice> list = Arrays.asList(i1, i2, i3);
		

		Transaction t = session.beginTransaction();
		List<Invoice> invoiceFromDB = session.get(Customer.class, cid).getInvoice();

		for (Invoice i : list) {

			if (invoiceFromDB == null) {
				invoiceFromDB = new ArrayList<>();

			}

			invoiceFromDB.add(i);
		}
		t.commit();
	}

}
