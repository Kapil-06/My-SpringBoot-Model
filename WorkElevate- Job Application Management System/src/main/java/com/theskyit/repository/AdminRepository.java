package com.theskyit.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.theskyit.model.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String>{

	Optional<Admin> findByUsername(String username);

	Optional<Admin> findByEmail(String email);

	Optional<Admin> findByResetToken(String token);

	Optional<Admin> findByEmailOrUsername(String email, String username);

}
