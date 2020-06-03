package com.groupon.groupondoctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupon.groupondoctor.entity.Doctor;
import com.groupon.groupondoctor.repository.DoctorRepository;
import com.groupon.groupondoctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {

		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> findAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor findDoctorByEmail(String email) {

		return doctorRepository.findByEmail(email);
	}

}
