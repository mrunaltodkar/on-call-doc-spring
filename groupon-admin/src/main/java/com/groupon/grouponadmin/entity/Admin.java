package com.groupon.grouponadmin.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Admin {
	
	private String adminEmail;
	private String adminPassword;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String adminEmail, String adminPassword) {
		super();
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	

}
