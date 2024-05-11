package com.ind.airasiaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ind.airasiaproject.dto.User;
import com.ind.airasiaproject.response.ApplicationResponse;
import com.ind.airasiaproject.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUserDetails")
	public ApplicationResponse<User> userRegisterService(@RequestBody User user){
		return userService.userRegisterService(user);
	}
}
