package com.groupon.groupon.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.groupon.groupon.entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	Customer findByEmail(String email);
}
