package com.ind.airasiaproject.service;

import com.ind.airasiaproject.dto.User;
import com.ind.airasiaproject.response.ApplicationResponse;


public interface UserService {
	
	public ApplicationResponse<User> userRegisterService(User user);

	public ApplicationResponse<User> fetchUserByEmailForLoginService(String email, String password);
	
}