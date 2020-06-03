package com.groupon.grouponpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.groupon.grouponpayment.entity.Payment;
import com.groupon.grouponpayment.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/payment")
	public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {

		Payment newPayment = paymentService.addPaymentDetails(payment);

		return new ResponseEntity<Payment>(newPayment, HttpStatus.CREATED);

	}

	@GetMapping("/mypayments/{email}")
	public ResponseEntity<Payment> myPayments(@PathVariable String email) {

		Payment status = paymentService.findByEmail(email);
		if (status == null) {

			return new ResponseEntity<Payment>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Payment>(status, HttpStatus.FOUND);
	}

}
