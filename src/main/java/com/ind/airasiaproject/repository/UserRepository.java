package com.ind.airasiaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ind.airasiaproject.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUserEmail(String email);
	
}
