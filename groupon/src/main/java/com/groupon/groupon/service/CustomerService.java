package com.groupon.groupon.service;

import org.springframework.stereotype.Service;

import com.groupon.groupon.entity.Customer;

@Service
public interface CustomerService {
	public Customer addCustomerDeatils(Customer customer);

	public Customer findByEmail(String email);

}
