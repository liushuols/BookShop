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
	 * ��ѯ���ݿ��е������û�
	 * @return �û��б�
	 */
	public List<User> findAllUser(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from User");
		return q.list();
	}
	
	/**
	 * ע��ʱ�����û���Ϣ�����ݿ�
	 * @param user ע����û�
	 */
	public void saveUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}
}
