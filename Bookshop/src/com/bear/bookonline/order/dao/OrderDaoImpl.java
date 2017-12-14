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
	 * 将用户购买的产品加入购物车，同时生成订单
	 * @param user 登录的用户
	 * @param id 图书的id值
	 */
	public void saveShopping(User user,int id) {
		//获得Session
		Session session = sessionFactory.getCurrentSession();
		Order order = null;
		//获得登录用户的订单集合，判断该用户是否有订单。若没有，进行创建；若有，进行遍历
		if(user.getOrderSet().size()<=0) {
			order = new Order();
		}else {
			for(Order o : user.getOrderSet()) {		
					order = o;
			}
			
		}
		//将用户和购物车之间建立联系
		order.setUser(user);	
		user.getOrderSet().add(order);
		//将用户的订单保存到数据库，同时更新用户的信息
		session.update(user);	
		session.save(order);
		//通过图书的id值查询出Bookdetail的对象
		Bookdetail bookdetail = this.findByDetailid(id);
		//创建Orderdetail对象，给对象的每个属性进行赋值
		Orderdetail orderdetail = new Orderdetail();
		orderdetail.setUsername(user.getUsername());
		orderdetail.setBookname(bookdetail.getBookname());
		orderdetail.setBookcount(bookdetail.getBookcount());
		orderdetail.setBookprice(bookdetail.getBookprice());
		//将订单和订单详情之间建立联系
		orderdetail.setOrder(order);
		order.getOrderdetailSet().add(orderdetail);
		//将订单详情保存到数据库。同时更新该用户的订单
		session.save(orderdetail);
		session.update(order);
	}
	
	/**
	 * 删除订单中的记录
	 * @param od 订单详情类的对象
	 */
	public void deleteByOrderDetail(Orderdetail od) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(od);
	}
	
	/**
	 * 根据orderdetailid查询Orderdetail表的信息
	 * @param bookid 订单详情的id值
	 * @return Orderdetail类的单个对象
	 */
	public Orderdetail findByOrderDetailid(int id) {
		return this.sessionFactory.getCurrentSession().get(Orderdetail.class, id);
	}
	
	/**
	 * 根据bookid查询Bookdetail表的信息
	 * @param bookid 图书的id值
	 * @return Bookdetail类的单个对象
	 */
	public Bookdetail findByDetailid(int bookid) {
		return this.sessionFactory.getCurrentSession().get(Bookdetail.class, bookid);
	}
}
