package com.abc.orm.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="RecordType")  
// column created by hibernate in order to
//represent the row type , usually contains the class name
public abstract class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentNumber;
	private String paymentType;
	private String paymentDateTime;

	public Payment() {
		super();
	}

	public Payment(String paymentType, String paymentDateTime) {
		super();
		this.paymentType = paymentType;
		this.paymentDateTime = paymentDateTime;
	}

	public String getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(String paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}





