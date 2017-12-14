package com.bear.bookonline.order.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.bear.bookonline.entity.Bookdetail;
import com.bear.bookonline.entity.Order;
import com.bear.bookonline.entity.Orderdetail;
import com.bear.bookonline.entity.User;

@Repository
public class OrderDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * ���û�����Ĳ�Ʒ���빺�ﳵ��ͬʱ���ɶ���
	 * @param user ��¼���û�
	 * @param id ͼ���idֵ
	 */
	public void saveShopping(User user,int id) {
		//���Session
		Session session = sessionFactory.getCurrentSession();
		Order order = null;
		//��õ�¼�û��Ķ������ϣ��жϸ��û��Ƿ��ж�������û�У����д��������У����б���
		if(user.getOrderSet().size()<=0) {
			order = new Order();
		}else {
			for(Order o : user.getOrderSet()) {		
					order = o;
			}
			
		}
		//���û��͹��ﳵ֮�佨����ϵ
		order.setUser(user);	
		user.getOrderSet().add(order);
		//���û��Ķ������浽���ݿ⣬ͬʱ�����û�����Ϣ
		session.update(user);	
		session.save(order);
		//ͨ��ͼ���idֵ��ѯ��Bookdetail�Ķ���
		Bookdetail bookdetail = this.findByDetailid(id);
		//����Orderdetail���󣬸������ÿ�����Խ��и�ֵ
		Orderdetail orderdetail = new Orderdetail();
		orderdetail.setUsername(user.getUsername());
		orderdetail.setBookname(bookdetail.getBookname());
		orderdetail.setBookcount(bookdetail.getBookcount());
		orderdetail.setBookprice(bookdetail.getBookprice());
		//�������Ͷ�������֮�佨����ϵ
		orderdetail.setOrder(order);
		order.getOrderdetailSet().add(orderdetail);
		//���������鱣�浽���ݿ⡣ͬʱ���¸��û��Ķ���
		session.save(orderdetail);
		session.update(order);
	}
	
	/**
	 * ɾ�������еļ�¼
	 * @param od ����������Ķ���
	 */
	public void deleteByOrderDetail(Orderdetail od) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(od);
	}
	
	/**
	 * ����orderdetailid��ѯOrderdetail�����Ϣ
	 * @param bookid ���������idֵ
	 * @return Orderdetail��ĵ�������
	 */
	public Orderdetail findByOrderDetailid(int id) {
		return this.sessionFactory.getCurrentSession().get(Orderdetail.class, id);
	}
	
	/**
	 * ����bookid��ѯBookdetail�����Ϣ
	 * @param bookid ͼ���idֵ
	 * @return Bookdetail��ĵ�������
	 */
	public Bookdetail findByDetailid(int bookid) {
		return this.sessionFactory.getCurrentSession().get(Bookdetail.class, bookid);
	}
}
