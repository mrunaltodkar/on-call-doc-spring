package com.groupon.grouponpayment.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payment {
	
	private String address;
	private String email;
	private String cashOnDelivery;
	private CardDetails cardDetails;

	public Payment() {
		super();
		
	}

	public Payment(String email,String address, String cashOnDelivery) {
		super();
		this.email=email;
		this.address = address;
		this.cashOnDelivery = cashOnDelivery;
	}

	public Payment(String email,String address, CardDetails cardDetails) {
		super();
		this.email=email;
		this.address = address;
		this.cardDetails = cardDetails;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCashOnDelivery() {
		return cashOnDelivery;
	}

	public void setCashOnDelivery(String cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
	}

	public CardDetails getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	




}
