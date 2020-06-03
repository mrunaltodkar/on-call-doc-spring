package com.groupom.grouponwhishlist.service;

import org.springframework.stereotype.Service;

import com.groupom.grouponwhishlist.entity.Whishlist;

@Service
public interface WhishlistService {
	Whishlist addWhishlistDetails(Whishlist whishlist);

	Whishlist findWhislistByEmail(String email);
}
