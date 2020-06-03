package com.groupon.grouponadmin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupon.grouponadmin.entity.Admin;

@RestController
public class AdminController {

	@GetMapping("/adminlogin")
	public ResponseEntity<Admin> signin() {
		Admin admin = new Admin();
		admin.setAdminEmail("admin@coupons.com");
		admin.setAdminPassword("admin@123");

		return new ResponseEntity<Admin>(admin, HttpStatus.OK);

	}

}
