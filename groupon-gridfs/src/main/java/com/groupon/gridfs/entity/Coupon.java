package com.groupon.gridfs.entity;

import java.io.File;

public class Coupon {

	private File filePath;
	private String couponId;
	private String couponName;
	private String couponDescription;
	private String couponPrice;

	public Coupon() {
		super();
	}

	public Coupon(File filePath, String couponId, String couponName, String couponDescription, String couponPrice) {
		super();
		this.filePath = filePath;
		this.couponId = couponId;
		this.couponName = couponName;
		this.couponDescription = couponDescription;
		this.couponPrice = couponPrice;
	}

	public File getFilePath() {
		return filePath;
	}

	public void setFilePath(File filePath) {
		this.filePath = filePath;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getCouponDescription() {
		return couponDescription;
	}

	public void setCouponDescription(String couponDescription) {
		this.couponDescription = couponDescription;
	}

	public String getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(String couponPrice) {
		this.couponPrice = couponPrice;
	}

	public Coupon(String couponId) {
		super();
		this.couponId = couponId;
	}
	
	public Object getId() {
		return couponId;
	}
	
	

}
