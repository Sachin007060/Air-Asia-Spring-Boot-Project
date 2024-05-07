package com.ind.airasiaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ind.airasiaproject.dto.Admin;
import com.ind.airasiaproject.response.ApplicationResponse;
import com.ind.airasiaproject.service.AdminService;

@RestController
@RequestMapping(value="/admin") // if the two controller has same API name than it will give ambiguity problem and that problem is solved using @RequestMappin..
public class Admincontroller {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/loginAdmin/{email}/{password}")
	public ApplicationResponse<Admin> fetchAdminByEmailForLoginService(@PathVariable String email, @PathVariable  String password) {
		return adminService.fetchAdminByEmailForLoginService(email, password);	
	}
}
