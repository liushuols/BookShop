package com.bear.bookonline.admin.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bear.bookonline.admin.dao.AdminLoginDaoImpl;
import com.bear.bookonline.entity.Admin;

@Service
@Transactional
public class AdminLoginServiceImpl {
	
	@Resource
	private AdminLoginDaoImpl adminLoginDaoImpl;
	
	public List<Admin> findAllAdmin() {
		return this.adminLoginDaoImpl.findAllAdmin();
	}
}
