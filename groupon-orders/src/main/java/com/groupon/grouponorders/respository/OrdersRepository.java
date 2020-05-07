package com.groupon.grouponorders.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.groupon.grouponorders.entity.Orders;

@Repository
public interface OrdersRepository extends MongoRepository<Orders, String> {

}
