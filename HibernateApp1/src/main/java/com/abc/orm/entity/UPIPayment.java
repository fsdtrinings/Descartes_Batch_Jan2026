package com.abc.orm.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

 @Entity
 @DiscriminatorValue("Paytm-UPI")
 public class UPIPayment extends Payment
{
	private long upiId;
	
	public UPIPayment() {	
	}
	
	public UPIPayment(long upiId,String paymentDate,String paymentType) {
		super(paymentType,paymentDate);
		this.upiId = upiId;
	}
	
	public long getUpiId() {
		return upiId;
	}
	public void setUpiId(long upiId) {
		this.upiId = upiId;
	}
	
}