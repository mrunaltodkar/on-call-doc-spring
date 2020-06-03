package com.groupon.groupondoctor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.groupon.groupondoctor.entity.Doctor;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {

	Doctor findByEmail(String email);
}
