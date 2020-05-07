package com.groupon.grouponpayment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.groupon.grouponpayment.entity.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

	public Payment findByEmail(String email);
	
	
}
