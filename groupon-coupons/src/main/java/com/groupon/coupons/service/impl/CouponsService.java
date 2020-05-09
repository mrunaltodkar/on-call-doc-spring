package com.groupon.coupons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupon.coupons.entity.Coupons;
import com.groupon.coupons.repository.CouponsRepository;
import com.groupon.coupons.service.CouponService;

@Service
public class CouponsService implements CouponService {
	
	@Autowired
	private CouponsRepository couponsRepository;

	@Override
	public Coupons findByCouponId(long couponId) {
		
		return couponsRepository.findByCouponId(couponId);
	}

	@Override
	public List<Coupons> findByAll() {
		
		return couponsRepository.findAll();
	}

}
