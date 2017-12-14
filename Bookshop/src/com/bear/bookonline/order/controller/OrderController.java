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
	 * 将图书加入购物车，同时生成订单
	 * @param model
	 * @param session
	 * @param id 图书id
	 * @return 首页
	 */
	@RequestMapping("/addShoppingcart")
	public String findByBookid(Model model,HttpSession session,@RequestParam("bookid") int id) {
		//获取登录的用户
		User user = (User) session.getAttribute("user");
		//调用Service层的方法，通过id将商品加入购物车
		this.orderServiceImpl.saveShopping(user, id);
		//将购物车订单集合存入session
		Set<Order> shoppingCartSet = (Set<Order>)session.getAttribute("shoppingcart");
		session.setAttribute("shoppingCartSet", shoppingCartSet);
		//统计购物车中的商品数量
		int size = 0;
		for(Order order : user.getOrderSet()) {
			size = order.getOrderdetailSet().size();
		}
		session.setAttribute("size", size);
		//统计购物车中所有商品的总价格
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
	 * 删除购物车中的商品
	 * @param orderdetailid 订单详情id值
	 * @param session
	 * @return 购物车页面
	 */
	@RequestMapping("/delete")
	public String findByBookId(@RequestParam("orderdetailid") int orderdetailid,HttpSession session) {
		//获取登录的用户
		User user = (User) session.getAttribute("user");
		//获取该用户的订单集合，并对订单中的记录进行遍历，删除对应的对象
		Set<Order> orderSet = user.getOrderSet();
		for(Order order:orderSet) {
			for (Orderdetail od:order.getOrderdetailSet()) {
				if(od.getOrderdetailid() == orderdetailid) {
					order.getOrderdetailSet().remove(od);
				}
			}
		}
		//通过orderdetailid查询出对应的orderdetail对象，同时将数据库中该对象的订单详情删除
		Orderdetail ord = this.orderServiceImpl.findByOrderDetailid(orderdetailid);
		this.orderServiceImpl.deleteByOrderDetail(ord);
		//将用户的订单集合存入session中
		Set<Order> shoppingCartSet = user.getOrderSet();
		session.setAttribute("shoppingCartSet", shoppingCartSet);
		//统计购物车中的商品数量
		int size = 0;
		for(Order order : user.getOrderSet()) {
			size = order.getOrderdetailSet().size();
		}
		session.setAttribute("size", size);
		//统计购物车中所有商品的总价格
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
	 * 点击购物车查看用户的购物车
	 * @param session
	 * @return 购物车页面
	 */
	@RequestMapping("/shopping")
	public String findOrder(HttpSession session) {
		//获取登录的用户
		User user = (User)session.getAttribute("user");
		//获取该用户的订单集合，并存入session中
		Set<Order> orderSet = user.getOrderSet();
		session.setAttribute("shoppingCartSet", orderSet);
		//统计购物车中的商品数量
		int size = 0;
		for(Order order : user.getOrderSet()) {
			size = order.getOrderdetailSet().size();
		}
		session.setAttribute("size", size);
		//统计购物车中所有商品的总价格
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
