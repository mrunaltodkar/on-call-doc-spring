package com.groupon.groupon.entity;

public class Coupons {

	private long couponId;
	private String couponName;
	private String couponDescription;
	private String couponRate;

	public Coupons() {
		super();
	}

	public Coupons(long couponId, String couponName, String couponDescription, String couponRate) {
		super();
		this.couponId = couponId;
		this.couponName = couponName;
		this.couponDescription = couponDescription;
		this.couponRate = couponRate;
	}

	public long getCouponId() {
		return couponId;
	}

	public void setCouponId(long couponId) {
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

	public String getCouponRate() {
		return couponRate;
	}

	public void setCouponRate(String couponRate) {
		this.couponRate = couponRate;
	}

	@Override
	public String toString() {
		return "Coupons [couponId=" + couponId + ", couponName=" + couponName + ", couponDescription="
				+ couponDescription + ", couponRate=" + couponRate + "]";
	}

}
