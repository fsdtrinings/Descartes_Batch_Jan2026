package com.abc.orm.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.abc.orm.entity.AppOrder;
import com.abc.orm.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Day5_HQL_Projection {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		//queryFromEmbeddedValue(session);
		//getHouseNumberFromCustomerId(session);
		//getHouseNumberAndPhoneNumberByCustomerid(session);
		//getAllOrders_ByCustomerId(session);
		//getCustomerHouseDetails_basedonOrderId(session);
		getCustomerHouseDetails_basedonOrderId_Projection(session);
	}//end main
	
	
	
	
		
	public static void getAllOrders_ByCustomerId(Session session)
	{
		String hql = "From AppOrder order where "
				+ "order.customer.cid = 4001";
		
		List<AppOrder> list = session.createQuery(hql,AppOrder.class).list();
		
		for(AppOrder order : list)
		{
			System.out.println(order);
		}
		
	}
	
	
	public static void getCustomerHouseDetails_basedonOrderId(Session session)
	{
		String hql = "Select o.customer.houseAddress.houseDetails , o.customer.phoneNumber"
				+ " From AppOrder o "
				+ " where o.orderNumber = 5000";
		
		
		
		List<Object[]> rows = session.createQuery(hql)
			       .getResultList();
		
		System.out.println(rows.size()+"\n");
		for (Object row[] : rows) {
			System.out.println(row[0]+" "+row[1]);
		}
	}
	
	public static void getAllOrders_ByCityName(Session session)
	{
		String hql = "From AppOrder order where "
				+ "order.customer.houseAddress.city = :filterCity";
	
		
	}
	
	
	
	public static void getHouseNumberAndPhoneNumberByCustomerid(Session session)
	{
		String hql = "select c.houseAddress.houseDetails , c.phoneNumber from Customer c"
				+ "   where c.houseAddress.city = 'Delhi'";
		
		/*List<Object[]> rows = session.createQuery(hql)
		       .setParameter("filterId", 4001).getResultList();
		       */
		
		List<Object[]> rows = session.createQuery(hql)
			       .getResultList();
		/*row is the array of column values*/       
		
		
		for (Object row[] : rows) {
			System.out.println(row[0]+" "+row[1]);
		}
		
	}
	
	public static void getHouseNumberFromCustomerId(Session session)
	{
		String hql = "select c.houseAddress.houseDetails from Customer c"
				+ "   where c.cid = :filterId";
		
		String houseNumber = session.createQuery(hql, String.class)
		       .setParameter("filterId", 4001).getSingleResult();
		       
		System.out.println(houseNumber);
		
			
	}
	
	
	public static void queryFromEmbeddedValue(Session session)
	{
		String hql = "From Customer c where c.houseAddress.city = :filtercity";
		
		List<Customer> list = session.createQuery(hql, Customer.class)
		       .setParameter("filtercity", "Delhi")
		       .list();
		
		iterateListOfCustomer(list);
			
	}
	
	public static void iterateListOfCustomer(List<Customer> list)
	{
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	
	
	
	
	
	
	public static void getCustomerHouseDetails_basedonOrderId_Projection(Session session)
	{
		String hql = "Select new com.abc.orm.main.MyDTOClass("
				+ "o.customer.houseAddress.houseDetails,"
				+ "o.customer.phoneNumber) "
				+ " From AppOrder o "
				+ " where o.orderNumber = 5000";
		
		
		
		List<MyDTOClass> rows = session.createQuery(hql)
			       .getResultList();
		
		System.out.println(rows.size()+"\n");
		for (MyDTOClass row : rows) {
			System.out.println(row.getHouseDetails()+" "+row.getPhoneNumber());
		}
	}
	
}//end class




@Data
@AllArgsConstructor
@NoArgsConstructor
class MyDTOClass 
{
	String houseDetails;
	long phoneNumber;

}


