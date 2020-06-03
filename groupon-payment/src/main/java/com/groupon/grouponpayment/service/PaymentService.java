package com.groupon.grouponpayment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupon.grouponpayment.entity.Payment;

@Service
public interface PaymentService {

	public Payment addPaymentDetails(Payment payment);

	public Payment findByEmail(String email);

	public List<Payment> findALLPaymentDetails(String email);

	public Payment updatePayementDetails(Payment payment);

}
