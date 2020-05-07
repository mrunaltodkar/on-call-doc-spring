package com.groupon.grouponorders.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Orders {

	private Long order_id;
	private long finalPrice;
	private long count;
	private Payment payment;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Long order_id, long finalPrice, long count) {
		super();

		this.finalPrice = finalPrice;
		this.count = count;
	}

	public Payment getPayment() {
		return payment;
	}

	public long getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(long finalPrice) {
		this.finalPrice = finalPrice;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", finalPrice=" + finalPrice + ", count=" + count + "]";
	}

}
