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
	 * ��ѯ���ݿ��е������û�
	 * @return �û��б�
	 */
	public List<User> listAllUser(){
		return this.userRegistDaoImpl.findAllUser();
	}
	
	/**
	 * ע��ʱ�����û���Ϣ�����ݿ�
	 * @param user ע����û�
	 */
	public void saveUser(User user) {
		this.userRegistDaoImpl.saveUser(user);
	}
}
