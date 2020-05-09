package com.groupon.coupons.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.groupon.coupons.entity.Coupons;


@Repository
public interface CouponsRepository extends MongoRepository<Coupons,String>{
	
	Coupons findByCouponId(long couoponID);
	

}
