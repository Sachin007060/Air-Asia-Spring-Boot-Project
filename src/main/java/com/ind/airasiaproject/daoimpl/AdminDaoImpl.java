package com.ind.airasiaproject.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ind.airasiaproject.dao.AdminDao;
import com.ind.airasiaproject.dto.Admin;
import com.ind.airasiaproject.repository.AdminRepository;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin fetchAdminByEmailForLoginDao(String email) {
		return adminRepository.findByAdminEmail(email);
	}
	
}
