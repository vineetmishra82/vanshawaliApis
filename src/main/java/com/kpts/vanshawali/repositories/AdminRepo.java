package com.kpts.vanshawali.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kpts.vanshawali.models.Admin;

@Repository
public interface AdminRepo extends MongoRepository<Admin, String> {

}
