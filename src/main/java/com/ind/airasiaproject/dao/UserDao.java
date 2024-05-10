package com.ind.airasiaproject.dao;

import com.ind.airasiaproject.dto.User;

public interface UserDao {
	
	public User userRegisterDao(User user);

	public User fetchUserByEmailForLoginDao(String email);
	
}
