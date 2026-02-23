package com.abc.orm.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class DeliveryPartner {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int dpid;
	private String dpName;
	
	@OneToMany(mappedBy = "deliveryPartner")
	@ToString.Exclude
	List<VendorDeliveryPartnerInfo> vendorInfo;
	
	
	public DeliveryPartner(String dpName) {
		super();
		this.dpName = dpName;
	}
	
	

	
	
}
