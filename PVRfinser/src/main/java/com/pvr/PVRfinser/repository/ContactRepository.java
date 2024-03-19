package com.pvr.PVRfinser.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pvr.PVRfinser.entity.User;

@Repository
public interface ContactRepository extends JpaRepository<User, Integer>{
	
	User findById(int id);
}
