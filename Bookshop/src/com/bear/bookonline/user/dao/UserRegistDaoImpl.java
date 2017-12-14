package com.bear.bookonline.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bear.bookonline.entity.User;

@Repository
public class UserRegistDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 查询数据库中的所有用户
	 * @return 用户列表
	 */
	public List<User> findAllUser(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from User");
		return q.list();
	}
	
	/**
	 * 注册时保存用户信息到数据库
	 * @param user 注册的用户
	 */
	public void saveUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}
}
