package com.groupon.grouponorders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.groupon.grouponorders.entity.Orders;
import com.groupon.grouponorders.entity.Payment;
import com.groupon.grouponorders.service.OrdersService;

@RestController
public class OrdersController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private OrdersService ordersService;

	
}
