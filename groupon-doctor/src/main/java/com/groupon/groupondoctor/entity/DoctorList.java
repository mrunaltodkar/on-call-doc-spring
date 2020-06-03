package com.groupon.groupondoctor.entity;

import java.util.ArrayList;
import java.util.List;

public class DoctorList {
	private List<Doctor> doctors;

	public DoctorList() {
		super();
		doctors = new ArrayList<>();
	}

	public DoctorList(List<Doctor> doctors) {
		super();
		this.doctors = doctors;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	

}
