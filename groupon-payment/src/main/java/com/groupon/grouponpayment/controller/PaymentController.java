package com.groupon.grouponpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
		
		System.out.println(payment);
		Payment status = paymentService.addPaymentDetails(payment);
		if (status != null) {
			return new ResponseEntity<Payment>(status, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Payment>(HttpStatus.NO_CONTENT);
	}

}
