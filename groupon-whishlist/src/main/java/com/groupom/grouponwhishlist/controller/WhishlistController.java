package com.groupom.grouponwhishlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.groupom.grouponwhishlist.entity.Whishlist;
import com.groupom.grouponwhishlist.service.WhishlistService;

@Controller
public class WhishlistController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WhishlistService whishlistService;

	@PostMapping("/addwhishlist")
	public ResponseEntity<Whishlist> getWhislistCoupon(@RequestBody Whishlist whishlist) throws Exception {
		whishlistService.addWhishlistDetails(whishlist);

		return new ResponseEntity<Whishlist>(HttpStatus.CREATED);
	}

	@GetMapping("/mywhishlist/{email}")
	public ResponseEntity<Whishlist> showWhishlist(@PathVariable String email) throws Exception {
		Whishlist status = whishlistService.findWhislistByEmail(email);
		return new ResponseEntity<Whishlist>(status, HttpStatus.FOUND);

	}

}
