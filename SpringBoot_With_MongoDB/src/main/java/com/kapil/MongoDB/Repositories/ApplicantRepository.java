package com.kapil.MongoDB.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kapil.MongoDB.Models.Applicant;

public interface ApplicantRepository extends MongoRepository<Applicant, Integer> {

}
