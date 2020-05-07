package com.groupon.groupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupon.groupon.entity.Customer;
import com.groupon.groupon.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/signup")
	public ResponseEntity<Customer> signUpDetailsOfCustomer(@RequestBody Customer customer) {

		Customer status = customerService.addCustomerDeatils(customer);

		return new ResponseEntity<Customer>(status, HttpStatus.CREATED);

	}

	@GetMapping("/signin/{email}/{password}")
	public ResponseEntity<Customer> logInDetailsForUser(@PathVariable String email, @PathVariable String password) {

		Customer customer = customerService.findByEmail(email);

		if (customer == null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.NOT_FOUND);

		}
		if ((customer.getEmail().equals(email) && (customer.getPassword().equals(password)))) {

			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}

		return new ResponseEntity<Customer>(HttpStatus.UNAUTHORIZED);

	}
}
