package com.groupon.groupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.groupon.groupon.entity.Admin;
import com.groupon.groupon.entity.Coupons;
import com.groupon.groupon.entity.Customer;
import com.groupon.groupon.entity.Doctor;
import com.groupon.groupon.entity.DoctorList;
import com.groupon.groupon.entity.Payment;
import com.groupon.groupon.entity.Whishlist;
import com.groupon.groupon.service.CustomerService;

@CrossOrigin("*")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MongoOperations mongoOperations;

	private String email = "";

	@PostMapping("/signup")
	public ResponseEntity<Customer> signUpDetailsOfCustomer(@RequestBody Customer customer) {

		Customer customerFind = customerService.findByEmail(customer.getEmail());
		if (customerFind != null) {
			return new ResponseEntity<Customer>(HttpStatus.CONFLICT);
		}

		Customer status = customerService.addCustomerDetails(customer);

		return new ResponseEntity<Customer>(status, HttpStatus.CREATED);

	}

	@PostMapping("/signin")
	public ResponseEntity<Customer> logInDetailsForUser(@RequestBody Customer customerui) {
		if (customerui.getEmail() == "admin@coupons.com") {

			adminLogin();

		}

		Customer customer = customerService.findByEmail(customerui.getEmail());

		if (customer == null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.NOT_FOUND);

		}
		if ((customer.getEmail().equals(customerui.getEmail())
				&& (customer.getPassword().equals(customerui.getPassword())))) {

			this.email = customer.getEmail();

			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}

		return new ResponseEntity<Customer>(HttpStatus.UNAUTHORIZED);

	}

	@PostMapping("/adminsignin")
	public ResponseEntity<Admin> adminLogin() {

		Admin admin1 = restTemplate.getForEntity("http://groupon-admin/adminsignin", Admin.class).getBody();

		return new ResponseEntity<Admin>(admin1, HttpStatus.OK);

	}

	@PostMapping("/payment")
	public ResponseEntity<Payment> payment(@RequestBody Payment payment) throws Exception {

		payment.setEmail(this.email);

		HttpEntity<Payment> requestEntity = new HttpEntity<Payment>(payment);

		Payment payment1 = restTemplate
				.exchange("http://groupon-payment/payment", HttpMethod.POST, requestEntity, Payment.class).getBody();
		return new ResponseEntity<Payment>(payment1, HttpStatus.ACCEPTED);
	}

	@GetMapping("/mypayments")
	public ResponseEntity<Payment> myPayments() throws Exception {

		Payment myPayments = restTemplate.getForEntity("http://groupon-payment/mypayments/" + this.email, Payment.class)
				.getBody();

		return new ResponseEntity<Payment>(myPayments, HttpStatus.FOUND);

	}

	@PostMapping("/addwhishlist")
	public ResponseEntity<Whishlist> addToWhishlist(@RequestBody Coupons coupons) {

		Whishlist whishlist = new Whishlist(); // creating new wishlist
		whishlist.setCoupons(coupons);
		whishlist.setEmail(this.email);

		HttpEntity<Whishlist> requestEntity = new HttpEntity<Whishlist>(whishlist);

		Whishlist status = restTemplate
				.exchange("http://groupon-whishlist/addwhishlist", HttpMethod.POST, requestEntity, Whishlist.class)
				.getBody();

		return new ResponseEntity<Whishlist>(status, HttpStatus.CREATED);

	}

	@GetMapping("/mywhishlist")
	public ResponseEntity<Coupons> showWhislistItems() {

		Whishlist whishlist = restTemplate
				.getForEntity("http://groupon-whishlist/mywhishlist" + this.email, Whishlist.class).getBody();

		return new ResponseEntity<Coupons>(whishlist.getCoupons(), HttpStatus.FOUND);

	}

	@GetMapping("/doctorlist")
	public ResponseEntity<DoctorList> listOfDoctors() throws Exception {

		DoctorList status = restTemplate.getForEntity("http://groupon-doctor/doctorlist", DoctorList.class).getBody();

		if (status == null) {
			return new ResponseEntity<DoctorList>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<DoctorList>(status, HttpStatus.FOUND);

	}

	@PostMapping("/bookeddoctor")
	public ResponseEntity<Doctor> bookedDoctor(@RequestBody Doctor doctorEmail) {
		
		Doctor status = restTemplate.getForEntity("http://groupon-doctor/bookeddoctor/"+doctorEmail.getEmail(), Doctor.class).getBody();

		return new ResponseEntity<Doctor>(HttpStatus.OK);

	}

	@GetMapping("/selectcoupon/{couponid}")
	public ResponseEntity<Coupons> selectedCoupon(@PathVariable String couponId) {

		Coupons coupons = restTemplate.getForEntity("http://groupon-coupon/selectcoupon/{couponid}/", Coupons.class)
				.getBody();

		return new ResponseEntity<Coupons>(coupons, HttpStatus.CONTINUE);

	}

}
