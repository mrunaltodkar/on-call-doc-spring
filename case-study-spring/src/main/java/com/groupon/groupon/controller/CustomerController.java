package com.groupon.groupon.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.groupon.groupon.entity.Coupons;
import com.groupon.groupon.entity.Customer;
import com.groupon.groupon.entity.Payment;
import com.groupon.groupon.entity.Whishlist;
import com.groupon.groupon.service.CustomerService;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RestTemplate restTemplate;

	private String email;

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

			this.email = email;
			System.out.println(this.email);

			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}

		return new ResponseEntity<Customer>(HttpStatus.UNAUTHORIZED);

	}

	@GetMapping("/selectcoupon/{couponid}")
	public ResponseEntity<Coupons> selectedCoupon(@PathVariable String couponId) {

		Coupons coupons = restTemplate.getForEntity("http://groupon-coupon/selectcoupon/{couponid}/", Coupons.class)
				.getBody();

		return new ResponseEntity<Coupons>(coupons, HttpStatus.CONTINUE);

	}

	@PostMapping("/whishlist/{couponid}")
	public ResponseEntity<Whishlist> whishlistCoupon(@PathVariable String couponId) {

		Customer customer = customerService.findByEmail(this.email);

		Whishlist whishlist = restTemplate
				.getForEntity("http://groupon-whishlist/whishlist/{couponid}", Whishlist.class).getBody();

		customer.setWhishlist(whishlist);
		return new ResponseEntity<Whishlist>(whishlist, HttpStatus.CREATED);

	}

	@PostMapping("/payment")
	public ResponseEntity<Payment> payment(@RequestBody Payment payment) {
		System.out.println(this.email);
		Customer customer = customerService.findByEmail(this.email);
		/*
		 * Payment payment1 =
		 * restTemplate.getForEntity("http://groupon-payment/payment", Payment.class,
		 * payment) .getBody();
		 */

		Payment payment1 = restTemplate.postForObject("http://groupon-payment/payment", payment, Payment.class);
		customer.setPayment(payment1);
		return new ResponseEntity<Payment>(payment1, HttpStatus.CONTINUE);

	}

}
