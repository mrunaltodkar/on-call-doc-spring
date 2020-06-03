package com.groupon.groupon.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

	private String username;
	private String password;
	private long number;
	private String email;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password, long number, String email) {
		super();
		this.username = username;
		this.password = password;
		this.number = number;
		this.email = email;
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

}
