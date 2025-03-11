package com.theskyit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.theskyit.model.SkyITContact;

@Repository
public interface SkyITContactRepository extends MongoRepository<SkyITContact, String>{

	

	

}
