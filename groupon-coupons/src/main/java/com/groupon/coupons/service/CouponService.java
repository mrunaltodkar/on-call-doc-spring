package com.groupon.coupons.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupon.coupons.entity.Coupons;

@Service
public interface CouponService {
	
	public Coupons findByCouponId(long couponId);

	public List<Coupons> findByAll();
	

}
