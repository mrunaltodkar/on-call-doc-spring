package com.groupon.groupon.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.groupon.groupon.entity.CardDetails;
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

	private String email = "";

	@PostMapping("/signup")
	public ResponseEntity<Customer> signUpDetailsOfCustomer(@RequestBody Customer customer) {

		Customer customerFind = customerService.findByEmail(customer.getEmail());
		if (customerFind != null) {
			return new ResponseEntity<Customer>(HttpStatus.CONFLICT);
		}

		Whishlist whishlist = new Whishlist();

		Payment payment = new Payment();
		CardDetails cardDetails = new CardDetails();
		payment.setCardDetails(cardDetails);

		Coupons coupons = new Coupons();
		whishlist.setCoupons(coupons);
		customer.setPayment(payment);
		customer.setWhishlist(whishlist);
		Customer status = customerService.addCustomerDetails(customer);

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

		Customer customer = customerService.findByEmail(this.email);
		System.out.println(this.email);
		System.out.println(customer.getPayment().getCardDetails().getCardHolderName());

		HttpEntity<Payment> requestEntity = new HttpEntity<Payment>(payment);

		Payment payment1 = restTemplate
				.exchange("http://groupon-payment/payment", HttpMethod.POST, requestEntity, Payment.class).getBody();

		customer.setPayment(payment1);
		if (customerService.deleteCustomerDetails(this.email)) {
			customerService.addCustomerDetails(customer);
			System.out.println("deleted");
		}

		return new ResponseEntity<Payment>(payment1, HttpStatus.CREATED);

	}

	/*
	 * @PostMapping("/payment") public ResponseEntity<Payment> payment1(@RequestBody
	 * Payment payment) {
	 * 
	 * Customer customer = customerService.findByEmail(this.email);
	 * System.out.println(this.email);
	 * System.out.println(customer.getPayment().getCardDetails().getCardHolderName()
	 * );
	 * 
	 * HttpEntity<Payment> requestEntity = new HttpEntity<Payment>(payment);
	 * 
	 * Payment payment1 = restTemplate .exchange("http://groupon-payment/payment",
	 * HttpMethod.POST, requestEntity, Payment.class).getBody();
	 * 
	 * System.out.println(payment1.getCardDetails().getCardHolderName());
	 * 
	 * CardDetails cardDetails = new CardDetails();
	 * cardDetails.setCardHolderName(payment1.getCardDetails().getCardHolderName());
	 * cardDetails.setCardName(payment1.getCardDetails().getCardName());
	 * cardDetails.setCvv(payment1.getCardDetails().getCvv());
	 * cardDetails.setExpiryDate(payment1.getCardDetails().getExpiryDate());
	 * 
	 * Payment payment2 = new Payment(); payment2.setAddress(payment1.getAddress());
	 * payment2.setEmail(payment1.getEmail());
	 * payment2.setCashOnDelivery(payment.getCashOnDelivery());
	 * 
	 * payment2.setCardDetails(cardDetails); customer.setPayment(payment2);
	 * customerService.addCustomerDetails(customer);
	 * 
	 * return new ResponseEntity<Payment>(payment1, HttpStatus.CREATED);
	 * 
	 * }
	 */

}
