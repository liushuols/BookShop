package com.bear.bookonline.admin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bear.bookonline.entity.Admin;
import com.bear.bookonline.entity.User;

@Repository
public class AdminLoginDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 查询数据库中的所有管理员
	 * @return 管理员列表集合
	 */
	public List<Admin> findAllAdmin(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Admin");
		return q.list();
	}
}
