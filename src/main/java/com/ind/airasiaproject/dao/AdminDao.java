package com.ind.airasiaproject.dao;

import com.ind.airasiaproject.dto.Admin;

public interface AdminDao {
	
	
	public Admin fetchAdminByEmailForLoginDao(String email);
	
}
