package com.groupon.groupon.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Whishlist {
	
	private Coupons coupons;
	
	public Whishlist(Coupons coupons) {
		super();
		this.coupons = coupons;
	}

	public Whishlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coupons getCoupons() {
		return coupons;
	}

	public void setCoupons(Coupons coupons) {
		this.coupons = coupons;
	}
	
	
	
	
	

}
