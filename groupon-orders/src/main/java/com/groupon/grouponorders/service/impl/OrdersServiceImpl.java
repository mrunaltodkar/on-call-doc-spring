package com.groupon.grouponorders.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupon.grouponorders.entity.Orders;
import com.groupon.grouponorders.respository.OrdersRepository;
import com.groupon.grouponorders.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersRepository orderRepository;

	@Override
	public Orders addOrderDetails(Orders orders) {
		return orderRepository.save(orders);
	}

}
