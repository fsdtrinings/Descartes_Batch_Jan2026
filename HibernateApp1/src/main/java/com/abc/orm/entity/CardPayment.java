package com.abc.orm.entity;

import jakarta.persistence.Entity;

 @Entity
 public class CardPayment extends Payment
{
	private String cardName;
	private long cardNumber;
	public CardPayment() {
		super();
	}
	public CardPayment(String paymentType, String paymentDateTime, String cardName,long cardNumber) {
		super(paymentType, paymentDateTime);
		this.cardName = cardName;
		this.cardNumber = cardNumber;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}


}