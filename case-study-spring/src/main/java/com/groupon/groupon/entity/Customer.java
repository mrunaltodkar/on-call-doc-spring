package com.groupon.groupon.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

	private Long U_id;
	private String username;
	private String password;
	private long number;
	private String email;
	private Payment payment;
	private Whishlist whishlist;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password, long number, String email, Payment payment, Whishlist whishlist) {
		super();
		this.username = username;
		this.password = password;
		this.number = number;
		this.email = email;
		this.payment = payment;
		this.whishlist = whishlist;
	}

	public Long getU_id() {
		return U_id;
	}

	public void setU_id(Long u_id) {
		U_id = u_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Whishlist getWhishlist() {
		return whishlist;
	}

	public void setWhishlist(Whishlist whishlist) {
		this.whishlist = whishlist;
	}

	@Override
	public String toString() {
		return "Customer [U_id=" + U_id + ", username=" + username + ", password=" + password + ", number=" + number
				+ ", email=" + email + ", payment=" + payment + ", whishlist=" + whishlist + "]";
	}

}
