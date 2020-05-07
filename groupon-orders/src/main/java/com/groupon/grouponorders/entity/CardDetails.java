package com.groupon.grouponorders.entity;

public class CardDetails {
	
	private String cardHolderName;
	private String cardName;
	private String expiryDate;
	private String cvv;
	public CardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardDetails(String cardHolderName, String cardName, String expiryDate, String cvv) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardName = cardName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	

}
