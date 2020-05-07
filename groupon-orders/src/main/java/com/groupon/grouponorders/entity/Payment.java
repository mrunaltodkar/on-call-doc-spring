package com.groupon.grouponorders.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payment {
	
	private String address;
	private String cashOnDelivery;
	private CardDetails cardDetails;

	public Payment() {
		super();
		
	}

	public Payment(String address, String cashOnDelivery) {
		super();
		this.address = address;
		this.cashOnDelivery = cashOnDelivery;
	}

	public Payment(String address, CardDetails cardDetails) {
		super();
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
	




}
