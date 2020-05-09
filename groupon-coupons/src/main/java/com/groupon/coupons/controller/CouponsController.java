package com.groupon.coupons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.groupon.coupons.entity.Coupons;
import com.groupon.coupons.service.impl.CouponsService;

@Controller
public class CouponsController {

	@Autowired
	private CouponsService couponsService;

	@GetMapping("/selectcoupon/{couponid}")
	public ResponseEntity<Coupons> selectedCoupon(@PathVariable String couponId) {

		long couponId1 = Long.parseLong(couponId);

		Coupons coupons = couponsService.findByCouponId(couponId1);
		return new ResponseEntity<Coupons>(coupons, HttpStatus.CONTINUE);

	}

	@GetMapping("/allcoupons")
	public ResponseEntity<List<Coupons>> showAllCoupons() {

		List<Coupons> listCoupons = couponsService.findByAll();
		return new ResponseEntity<List<Coupons>>(listCoupons, HttpStatus.FOUND);
	}

}
