package com.abc.orm.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.orm.entity.DeliveryPartner;
import com.abc.orm.entity.Vendor;
import com.abc.orm.entity.VendorDeliveryPartnerInfo;

public class CompositeKeyMain {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		
		Vendor v1 = new Vendor("MohanWorks", "Noida");
		Vendor v2 = new Vendor("RamWorks", "Delhi");
		
		DeliveryPartner dp1 = new DeliveryPartner("Mike");
		DeliveryPartner dp2 = new DeliveryPartner("jenny");
		DeliveryPartner dp3 = new DeliveryPartner("peter");
		
		VendorDeliveryPartnerInfo data1 = new VendorDeliveryPartnerInfo(v1, dp1, 90);
		VendorDeliveryPartnerInfo data2 = new VendorDeliveryPartnerInfo(v1, dp2, 9);
		VendorDeliveryPartnerInfo data3 = new VendorDeliveryPartnerInfo(v2, dp1, 190);
		VendorDeliveryPartnerInfo data4 = new VendorDeliveryPartnerInfo(v2, dp2,80);
		VendorDeliveryPartnerInfo data5 = new VendorDeliveryPartnerInfo(v2, dp3,8);
		
		Transaction t = session.beginTransaction();
		
		
		session.persist(v1);
		session.persist(v2);
		
		session.persist(dp1);
		session.persist(dp2);
		session.persist(dp3);
		
		session.persist(data1);
		session.persist(data2);
		session.persist(data3);
		session.persist(data4);
		session.persist(data5);
		
		
		t.commit();		
		
		
	}
}
