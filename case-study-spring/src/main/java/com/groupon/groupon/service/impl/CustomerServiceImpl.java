package com.groupon.groupon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.groupon.groupon.entity.CardDetails;
import com.groupon.groupon.entity.Customer;
import com.groupon.groupon.entity.Payment;
import com.groupon.groupon.repository.CustomerRepository;
import com.groupon.groupon.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomerDetails(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	public boolean deleteCustomerDetails(String email) {
		return customerRepository.deleteByEmail(email);

	}

}
