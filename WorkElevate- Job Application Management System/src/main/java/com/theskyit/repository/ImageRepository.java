package com.theskyit.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.theskyit.model.Image;

@Repository
public interface ImageRepository extends MongoRepository<Image, String>{

	List<Image> findAllById();

	

	
}
