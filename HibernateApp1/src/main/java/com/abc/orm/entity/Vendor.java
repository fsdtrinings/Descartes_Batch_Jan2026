package com.abc.orm.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // custom :- sequence , works best for Oracle , DB2 , Postgres SQl , Durby
	private int vendorId;
	
	@OneToMany(mappedBy = "vendor")
	@ToString.Exclude
	List<VendorDeliveryPartnerInfo> deliveryinfo;
	
	
	private String vendorName;
	private String location;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "VendorDetails",
		joinColumns  = @JoinColumn(name = "vendor_id"),
		inverseJoinColumns = @JoinColumn(name = "product_code")
			)
	@ToString.Exclude
	private List<Product> productList;

	public Vendor(String vendorName, String location) {
		super();
		this.vendorName = vendorName;
		this.location = location;
	}
	
	

	
	
}









