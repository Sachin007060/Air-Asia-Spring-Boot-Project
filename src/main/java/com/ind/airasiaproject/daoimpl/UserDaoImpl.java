package com.ind.airasiaproject.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ind.airasiaproject.dao.UserDao;
import com.ind.airasiaproject.dto.User;
import com.ind.airasiaproject.repository.UserRepository;


@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User userRegisterDao(User user) {
		return repository.save(user);
	}

	@Override
	public User fetchUserByEmailForLoginDao(String email) {
		return repository.findByUserEmail(email);
	}
	
}
