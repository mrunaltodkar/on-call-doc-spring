package com.groupom.grouponwhishlist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.groupom.grouponwhishlist.entity.Whishlist;

public interface WhishlistRepository extends MongoRepository<Whishlist, String> {

	Whishlist findByEmail(String email);

}
