package com.groupon.groupon.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Doctor {
	private String email;
	private String password;
	private String doctorName;
	private String doctorQualification;
	private String doctorPrice;
	private String availability;
	private String address;
	private String patientEmail;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String email, String password, String doctorName, String doctorQualification, String doctorPrice,
			String availability, String address, String patientEmail) {
		super();
		this.email = email;
		this.password = password;
		this.doctorName = doctorName;
		this.doctorQualification = doctorQualification;
		this.doctorPrice = doctorPrice;
		this.availability = availability;
		this.address = address;
		this.patientEmail = patientEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorQualification() {
		return doctorQualification;
	}

	public void setDoctorQualification(String doctorQualification) {
		this.doctorQualification = doctorQualification;
	}

	public String getDoctorPrice() {
		return doctorPrice;
	}

	public void setDoctorPrice(String doctorPrice) {
		this.doctorPrice = doctorPrice;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	
	
}
