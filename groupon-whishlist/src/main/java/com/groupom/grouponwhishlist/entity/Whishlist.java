package com.groupom.grouponwhishlist.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Whishlist {
	
	private Coupons coupons;
	private String email;

	public Whishlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Whishlist(Coupons coupons, String email) {
		super();
		this.coupons = coupons;
		this.email = email;
	}

	public Coupons getCoupons() {
		return coupons;
	}

	public void setCoupons(Coupons coupons) {
		this.coupons = coupons;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	

}
