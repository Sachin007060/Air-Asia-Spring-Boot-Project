package com.ind.airasiaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ind.airasiaproject.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public Admin findByAdminEmail(String email);
	
}