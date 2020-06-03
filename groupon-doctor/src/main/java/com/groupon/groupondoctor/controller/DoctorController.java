package com.groupon.groupondoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.groupon.groupondoctor.entity.Doctor;
import com.groupon.groupondoctor.entity.DoctorList;
import com.groupon.groupondoctor.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * @Autowired private DoctorList doctorList;
	 */

	@PostMapping("/signup/doctor")
	public ResponseEntity<Doctor> signUpDoctor(@RequestBody Doctor doctor) throws Exception {

		Doctor status = doctorService.addDoctor(doctor);

		return new ResponseEntity<Doctor>(status, HttpStatus.CREATED);

	}

	@PostMapping("/signin/doctor")
	public ResponseEntity<Doctor> signinDoctor(@RequestBody Doctor doctor) throws Exception {

		Doctor status = doctorService.findDoctorByEmail(doctor.getEmail());
		if (status == null) {
			System.out.println("Nothing");
			return new ResponseEntity<Doctor>(HttpStatus.NO_CONTENT);
		}
		if ((status.getEmail().equals(doctor.getEmail()) && (status.getPassword().equals(doctor.getPassword())))) {
			return new ResponseEntity<Doctor>(status, HttpStatus.FOUND);

		}

		return new ResponseEntity<Doctor>(HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/doctorlist")
	public ResponseEntity<DoctorList> listOfDoctors() throws Exception {

		List<Doctor> listOfDoctors = doctorService.findAllDoctors();
		DoctorList doctorList = new DoctorList();
		doctorList.setDoctors(listOfDoctors);

		if (listOfDoctors == null) {
			return new ResponseEntity<DoctorList>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<DoctorList>(doctorList, HttpStatus.FOUND);

	}

	@GetMapping("/doctorbyemail")
	public Doctor doctorByEmail(String doctorEmail) throws Exception {
		Doctor status = doctorService.findDoctorByEmail(doctorEmail);
		return status;

	}

	@GetMapping("/bookeddoctor/{doctorEmail}")
	public ResponseEntity<Doctor> bookedDoctor(@PathVariable String doctorEmail) throws Exception {

		Doctor status =
				doctorByEmail(doctorEmail);
		
		

		return new ResponseEntity<Doctor>(status, HttpStatus.FOUND);

	}

}
