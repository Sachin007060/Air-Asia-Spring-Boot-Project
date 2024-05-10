package com.ind.airasiaproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ind.airasiaproject.dao.UserDao;
import com.ind.airasiaproject.dto.User;
import com.ind.airasiaproject.response.ApplicationResponse;
import com.ind.airasiaproject.service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private ApplicationResponse<User> aResponse;
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private HttpSession httpSession;

	@Override
	public ApplicationResponse<User> userRegisterService(User user) {
		
		User user2= dao.userRegisterDao(user);
		
		if(user2!=null) {
			aResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			aResponse.setMessage("User--Registered--Successfully");
			aResponse.setDescription("You can follow below data what is addeded inside table");
			aResponse.setData(user2);
			return aResponse;
		}else {
			aResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			aResponse.setMessage("User---Not--Registered");
			aResponse.setDescription("Check sql query or database..");
			aResponse.setData(null);
			return aResponse;
		}
		
	}

	@Override
	public ApplicationResponse<User> fetchUserByEmailForLoginService(String email, String password){
		
		User user = dao.fetchUserByEmailForLoginDao(email);
		
		if(user!=null) {
			
			if(user.getUserPassword().equals(password)) {
				httpSession.setAttribute("userSession", email);
				aResponse.setStatusCode(HttpStatus.FOUND.value());
				aResponse.setMessage("User--logged--In--Successfully");
				aResponse.setDescription(("User session is created");
				aResponse.setData(user);
				return aResponse;
			}else {
				aResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				aResponse.setMessage("User--logged--In--Successfully");
				aResponse.setDescription(("User session is created");
				aResponse.setData(user);
				return aResponse;
			}
			
		}else {
			
		}
		return null;
	}

}
