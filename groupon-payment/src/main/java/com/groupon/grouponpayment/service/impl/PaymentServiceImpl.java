package com.groupon.grouponpayment.service.impl;

import java.util.List;

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
		return paymentRepository.save(payment);
	}

	@Override
	public Payment findByEmail(String payment) {

		return paymentRepository.findByEmail(payment);
	}

	@Override
	public List<Payment> findALLPaymentDetails(String email) {

		return paymentRepository.findAll();
	}

	@Override
	public Payment updatePayementDetails(Payment payment) {
		return paymentRepository.save(payment);
	}

}
