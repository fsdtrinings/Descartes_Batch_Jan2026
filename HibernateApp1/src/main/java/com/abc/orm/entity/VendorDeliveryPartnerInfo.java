package com.abc.orm.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class VendorDeliveryPartnerInfo
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordId;
	
	@ManyToOne
	@JoinColumn(name = "vendorCode")
	private Vendor vendor;
	@ManyToOne
	@JoinColumn(name="dpCode")
	private DeliveryPartner deliveryPartner;
	
	
	private int count;


	public VendorDeliveryPartnerInfo(Vendor vendor, DeliveryPartner deliveryPartner, int count) {
		super();
		this.vendor = vendor;
		this.deliveryPartner = deliveryPartner;
		this.count = count;
	}
	
	
	
}
