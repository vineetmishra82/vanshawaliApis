package com.kpts.vanshawali.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kpts.vanshawali.models.Vyakti;

@Repository
public interface VyaktiRepo extends MongoRepository<Vyakti, String> {

}
