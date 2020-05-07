package com.groupon.grouponorders.service;

import org.springframework.stereotype.Service;

import com.groupon.grouponorders.entity.Orders;

@Service
public interface OrdersService {
	public Orders addOrderDetails(Orders orders);

}
