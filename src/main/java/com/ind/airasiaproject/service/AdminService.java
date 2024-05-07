package com.ind.airasiaproject.service;

import com.ind.airasiaproject.dto.Admin;
import com.ind.airasiaproject.response.ApplicationResponse;

public interface AdminService {
	
	public ApplicationResponse<Admin> fetchAdminByEmailForLoginService(String email, String password);
	

}
