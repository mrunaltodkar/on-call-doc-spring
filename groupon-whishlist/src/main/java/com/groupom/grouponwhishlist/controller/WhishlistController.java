package com.groupom.grouponwhishlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.groupom.grouponwhishlist.entity.Coupons;
import com.groupom.grouponwhishlist.entity.Whishlist;

@Controller
public class WhishlistController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/whishlist/{couponid}")
	public ResponseEntity<Whishlist> getWhislistCoupon() {

		Coupons coupons = restTemplate.getForEntity("http://groupon-coupon/selectcoupon/{couponid}/", Coupons.class)
				.getBody();
		Whishlist whishlist = new Whishlist();
		whishlist.setCoupons(coupons);
		return new ResponseEntity<Whishlist>(whishlist, HttpStatus.CONTINUE);
	}

}
