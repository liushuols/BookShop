package com.bear.bookonline.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.bookonline.entity.User;
import com.bear.bookonline.user.dao.UserRegistDaoImpl;

@Service
@Transactional(readOnly=true)
public class UserRegistServiceImpl {
	
	@Resource
	private UserRegistDaoImpl userRegistDaoImpl;
	
	public List<User> listAllUser(){
		return this.userRegistDaoImpl.findAllUser();
	}
	
	public void saveUser(User user) {
		this.userRegistDaoImpl.saveUser(user);
	}
}
