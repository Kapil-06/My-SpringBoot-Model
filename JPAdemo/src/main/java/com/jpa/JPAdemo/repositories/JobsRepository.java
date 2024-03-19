package com.jpa.JPAdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.JPAdemo.entity.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Integer> {

}
