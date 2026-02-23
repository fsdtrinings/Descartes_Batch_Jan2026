package com.abc.orm.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.orm.entity.Product;
import com.abc.orm.entity.Vendor;

public class M2M_Main {

	public static void main(String[] args) {
		 //createM2M();
		readM2M();
	}

	public static void readM2M() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Vendor vendor = session.get(Vendor.class, 1);
		List<Product> vendorProducts = vendor.getProductList();
		System.out.println(vendorProducts);

		Transaction t = session.beginTransaction();
		Product p = new Product("Dump", "Dump", 0);
		vendorProducts.add(p);
		vendor.setProductList(vendorProducts);
		
		// 4. IMPORTANT: Explicitly tell session to persist/merge the changes
		//session.merge(vendor); 
		session.persist(vendor);
		t.commit();

		session.close();

	}

	public static void createM2M() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Product p1 = new Product("Pen", "pens", 50);
		Product p2 = new Product("gelPen", "pens", 70);
		Product p3 = new Product("DrawingPen", "pens", 60);
		Product p4 = new Product("InkPen", "pens", 500);
		Product p5 = new Product("Laptop", "Computer", 50000);

		
		Vendor v1 = new Vendor("Rameshpens", "Noida");
		Vendor v2 = new Vendor("sureshArtWorks", "Delhi");

		List<Product> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		v1.setProductList(list);
		
		v2.setProductList(Arrays.asList(p1, p4));

		Transaction t = session.beginTransaction();

		session.persist(v1);
		session.persist(v2);

		t.commit();

		System.out.println("---- End, data saved  --- ");
	}

}
