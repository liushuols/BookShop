package com.bear.bookonline.order.controller;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.entity.Order;
import com.bear.bookonline.entity.Orderdetail;
import com.bear.bookonline.entity.User;
import com.bear.bookonline.order.service.OrderServiceImpl;

@Controller
@RequestMapping("book")
public class OrderController {
	
	@Resource
	private OrderServiceImpl orderServiceImpl;
	
	/**
	 * ��ͼ����빺�ﳵ��ͬʱ���ɶ���
	 * @param model
	 * @param session
	 * @param id ͼ��id
	 * @return ��ҳ
	 */
	@RequestMapping("/addShoppingcart")
	public String findByBookid(Model model,HttpSession session,@RequestParam("bookid") int id) {
		//��ȡ��¼���û�
		User user = (User) session.getAttribute("user");
		//����Service��ķ�����ͨ��id����Ʒ���빺�ﳵ
		this.orderServiceImpl.saveShopping(user, id);
		//�����ﳵ�������ϴ���session
		Set<Order> shoppingCartSet = (Set<Order>)session.getAttribute("shoppingcart");
		session.setAttribute("shoppingCartSet", shoppingCartSet);
		//ͳ�ƹ��ﳵ�е���Ʒ����
		int size = 0;
		for(Order order : user.getOrderSet()) {
			size = order.getOrderdetailSet().size();
		}
		session.setAttribute("size", size);
		//ͳ�ƹ��ﳵ��������Ʒ���ܼ۸�
		for(Order order : user.getOrderSet()) {
			double sum = 0;
			for(Orderdetail od : order.getOrderdetailSet()) {
				sum = sum + od.getTotalprice();
			}
			session.setAttribute("totalPrice",sum);
		}
		return "redirect:list";
	}

	/**
	 * ɾ�����ﳵ�е���Ʒ
	 * @param orderdetailid ��������idֵ
	 * @param session
	 * @return ���ﳵҳ��
	 */
	@RequestMapping("/delete")
	public String findByBookId(@RequestParam("orderdetailid") int orderdetailid,HttpSession session) {
		//��ȡ��¼���û�
		User user = (User) session.getAttribute("user");
		//��ȡ���û��Ķ������ϣ����Զ����еļ�¼���б�����ɾ����Ӧ�Ķ���
		Set<Order> orderSet = user.getOrderSet();
		for(Order order:orderSet) {
			for (Orderdetail od:order.getOrderdetailSet()) {
				if(od.getOrderdetailid() == orderdetailid) {
					order.getOrderdetailSet().remove(od);
				}
			}
		}
		//ͨ��orderdetailid��ѯ����Ӧ��orderdetail����ͬʱ�����ݿ��иö���Ķ�������ɾ��
		Orderdetail ord = this.orderServiceImpl.findByOrderDetailid(orderdetailid);
		this.orderServiceImpl.deleteByOrderDetail(ord);
		//���û��Ķ������ϴ���session��
		Set<Order> shoppingCartSet = user.getOrderSet();
		session.setAttribute("shoppingCartSet", shoppingCartSet);
		//ͳ�ƹ��ﳵ�е���Ʒ����
		int size = 0;
		for(Order order : user.getOrderSet()) {
			size = order.getOrderdetailSet().size();
		}
		session.setAttribute("size", size);
		//ͳ�ƹ��ﳵ��������Ʒ���ܼ۸�
		for(Order order : user.getOrderSet()) {
			double sum = 0;
			for(Orderdetail od : order.getOrderdetailSet()) {
				sum = sum + od.getTotalprice();
			}
			session.setAttribute("totalPrice",sum);
		}
		return "gouwuche";
	}
	
	/**
	 * ������ﳵ�鿴�û��Ĺ��ﳵ
	 * @param session
	 * @return ���ﳵҳ��
	 */
	@RequestMapping("/shopping")
	public String findOrder(HttpSession session) {
		//��ȡ��¼���û�
		User user = (User)session.getAttribute("user");
		//��ȡ���û��Ķ������ϣ�������session��
		Set<Order> orderSet = user.getOrderSet();
		session.setAttribute("shoppingCartSet", orderSet);
		//ͳ�ƹ��ﳵ�е���Ʒ����
		int size = 0;
		for(Order order : user.getOrderSet()) {
			size = order.getOrderdetailSet().size();
		}
		session.setAttribute("size", size);
		//ͳ�ƹ��ﳵ��������Ʒ���ܼ۸�
		for(Order order : user.getOrderSet()) {
			double sum = 0;
			for(Orderdetail od : order.getOrderdetailSet()) {
				sum = sum + od.getTotalprice();
			}
			session.setAttribute("totalPrice",sum);
		}
		return "gouwuche";
	}
}
