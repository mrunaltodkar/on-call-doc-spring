package com.groupon.grouponpayment.service;

import org.springframework.stereotype.Service;

import com.groupon.grouponpayment.entity.Payment;

@Service
public interface PaymentService {
	
	
	public Payment addPaymentDetails(Payment payment);
	public Payment findByEmail(String payment);
	

}
