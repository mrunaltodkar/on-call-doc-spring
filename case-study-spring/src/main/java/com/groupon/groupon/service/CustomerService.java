package com.groupon.groupon.service;

import org.springframework.stereotype.Service;

import com.groupon.groupon.entity.CardDetails;
import com.groupon.groupon.entity.Customer;
import com.groupon.groupon.entity.Payment;

@Service
public interface CustomerService {
	public Customer addCustomerDetails(Customer customer);
	
	public boolean deleteCustomerDetails(String email);
	
	public Customer findByEmail(String email);

}
