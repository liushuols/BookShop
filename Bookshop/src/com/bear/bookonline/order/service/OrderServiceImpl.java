package com.bear.bookonline.order.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.bookonline.entity.Orderdetail;
import com.bear.bookonline.entity.User;
import com.bear.bookonline.order.dao.OrderDaoImpl;

@Service
@Transactional
public class OrderServiceImpl {
	
	@Resource
	private OrderDaoImpl orderDaoImpl;
	
	/**
	 * 将用户购买的产品加入购物车，同时生成订单
	 * @param user 登录的用户
	 * @param id 图书的id值
	 */
   public void saveShopping(User user,int id) {
   	this.orderDaoImpl.saveShopping(user,id);
   }
   
   /**
  	* 删除订单中的记录
  	* @param od 订单详情类的对象
    */
    public void deleteByOrderDetail(Orderdetail od) {
      this.orderDaoImpl.deleteByOrderDetail(od);
    }
 
   /**
  	* 根据orderdetailid查询Orderdetail表的信息
  	* @param bookid 订单详情的id值
  	* @return Orderdetail类的单个对象
  	*/
    public Orderdetail findByOrderDetailid(int id) {
    	return this.orderDaoImpl.findByOrderDetailid(id);
    }
}
