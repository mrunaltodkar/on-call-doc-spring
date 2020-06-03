package com.groupon.groupondoctor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupon.groupondoctor.entity.Doctor;

@Service
public interface DoctorService {

	public Doctor addDoctor(Doctor doctor);

	public List<Doctor> findAllDoctors();
	
	public Doctor findDoctorByEmail(String email);

}
