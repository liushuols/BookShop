package com.bear.bookonline.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.bookonline.entity.User;
import com.bear.bookonline.user.dao.UserRegistDaoImpl;

@Service
@Transactional
public class UserRegistServiceImpl {
	
	@Resource
	private UserRegistDaoImpl userRegistDaoImpl;
	
	/**
	 * 查询数据库中的所有用户
	 * @return 用户列表
	 */
	public List<User> listAllUser(){
		return this.userRegistDaoImpl.findAllUser();
	}
	
	/**
	 * 注册时保存用户信息到数据库
	 * @param user 注册的用户
	 */
	public void saveUser(User user) {
		this.userRegistDaoImpl.saveUser(user);
	}
}
