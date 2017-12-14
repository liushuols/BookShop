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
	 * ���û�����Ĳ�Ʒ���빺�ﳵ��ͬʱ���ɶ���
	 * @param user ��¼���û�
	 * @param id ͼ���idֵ
	 */
   public void saveShopping(User user,int id) {
   	this.orderDaoImpl.saveShopping(user,id);
   }
   
   /**
  	* ɾ�������еļ�¼
  	* @param od ����������Ķ���
    */
    public void deleteByOrderDetail(Orderdetail od) {
      this.orderDaoImpl.deleteByOrderDetail(od);
    }
 
   /**
  	* ����orderdetailid��ѯOrderdetail�����Ϣ
  	* @param bookid ���������idֵ
  	* @return Orderdetail��ĵ�������
  	*/
    public Orderdetail findByOrderDetailid(int id) {
    	return this.orderDaoImpl.findByOrderDetailid(id);
    }
}
