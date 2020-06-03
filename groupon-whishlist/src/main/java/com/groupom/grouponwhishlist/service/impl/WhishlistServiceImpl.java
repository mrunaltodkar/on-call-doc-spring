package com.groupom.grouponwhishlist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupom.grouponwhishlist.entity.Whishlist;
import com.groupom.grouponwhishlist.repository.WhishlistRepository;
import com.groupom.grouponwhishlist.service.WhishlistService;

@Service
public class WhishlistServiceImpl implements WhishlistService {

	@Autowired
	private WhishlistRepository whishlistRepository;

	@Override
	public Whishlist addWhishlistDetails(Whishlist whishlist) {
		return whishlistRepository.save(whishlist);
	}

	@Override
	public Whishlist findWhislistByEmail(String email) {
		return whishlistRepository.findByEmail(email);
	}

}
