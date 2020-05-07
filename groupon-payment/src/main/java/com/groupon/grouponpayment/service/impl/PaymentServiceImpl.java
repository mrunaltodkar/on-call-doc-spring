package com.groupon.grouponpayment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupon.grouponpayment.entity.Payment;
import com.groupon.grouponpayment.repository.PaymentRepository;
import com.groupon.grouponpayment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment addPaymentDetails(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

	@Override
	public Payment findByEmail(String payment) {
		// TODO Auto-generated method stub
		return paymentRepository.findByEmail(payment);
	}


}
