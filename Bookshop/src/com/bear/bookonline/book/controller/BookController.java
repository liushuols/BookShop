package com.bear.bookonline.book.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.book.service.BookServiceImpl;
import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.Bookdetail;
import com.bear.bookonline.entity.CartItem;
import com.bear.bookonline.entity.Order;
import com.bear.bookonline.entity.Orderdetail;
import com.bear.bookonline.entity.Page;
import com.bear.bookonline.entity.User;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Resource
	private BookServiceImpl bookServiceImpl;
	
	@RequestMapping("/list")
	public String findAll(HttpServletRequest request,HttpServletResponse response,HttpSession session) {   
	    String pageNo = request.getParameter("pageNo");
	    if (pageNo == null) {
	        pageNo = "1";
	    }
	    Page page = bookServiceImpl.queryForPage(Integer.valueOf(pageNo), 3);
	    request.setAttribute("page", page);
	    List<Book> list = page.getList();
	    session.setAttribute("list", list);
	    return "index";
	}
	
	@RequestMapping("/list1")
	public String findAll1(HttpSession session) {
		List<Orderdetail> detailList1 = this.bookServiceImpl.findAll1();
		session.setAttribute("detailList1", detailList1);
		return "adminIndex";
	}
	
	
	@RequestMapping("/findByTypeid")
	public String findByTypeid(Model model,@RequestParam("typeid") int typeid) {
		List<Book> sublist = this.bookServiceImpl.QueryByTypeid(typeid);
		List<BookType> typeList = this.bookServiceImpl.findAllType(typeid);
		model.addAttribute("sublist", sublist);
		model.addAttribute("typeList", typeList);
		return "liebiao";
	}
	
	@RequestMapping("/findAllBookDetail")
	public String findAllBookDetail(Model model,@RequestParam("bookid") int bookid) {
		List<Bookdetail> detailList = this.bookServiceImpl.findAllBookDetail(bookid);
		model.addAttribute("detailList", detailList);
		return "xiangqing";
	}
	
	@RequestMapping("/addShoppingcart")
	public String findByBookid(Model model,HttpSession session,@RequestParam("bookid") int id) {
		User user = (User) session.getAttribute("user");
		this.bookServiceImpl.saveShopping(user, id);
		
		Set<Order> shoppingCartSet = (Set<Order>)session.getAttribute("shoppingcart");
		session.setAttribute("shoppingCartSet", shoppingCartSet);
		
		for(Order order : shoppingCartSet) {
			int size = order.getOrderdetailSet().size();
			session.setAttribute("size", size);
		}	
		
		for(Order order : user.getOrderSet()) {
			double sum = 0;
			for(Orderdetail od : order.getOrderdetailSet()) {
				sum = sum + od.getTotalprice();
			}
			session.setAttribute("totalPrice",sum);
		}
		
		return "redirect:list";
	}
	
	@RequestMapping("/findByName")
	public String selectBook(HttpSession session,@RequestParam("bookname") String bookname) {
		List<Bookdetail> detailList = this.bookServiceImpl.findByName(bookname);
		session.setAttribute("detailList", detailList);
		return "xiangqing";
	}
	
	@RequestMapping("/delete")
	public String findByBookId(@RequestParam("orderdetailid") int orderdetailid,HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		Set<Order> orderSet = user.getOrderSet();
		for(Order order:orderSet) {
			for (Orderdetail od:order.getOrderdetailSet()) {
				if(od.getOrderdetailid() == orderdetailid) {
					order.getOrderdetailSet().remove(od);
				}
			}
		}
		
		Orderdetail ord = this.bookServiceImpl.findByOrderDetailid(orderdetailid);
		this.bookServiceImpl.deleteByOrderDetail(ord);
		
		Set<Order> shoppingCartSet = user.getOrderSet();
		session.setAttribute("shoppingCartSet", shoppingCartSet);

		for(Order order : user.getOrderSet()) {
			int size = order.getOrderdetailSet().size();
			session.setAttribute("size", size);
		}	
		
		for(Order order : user.getOrderSet()) {
			double sum = 0;
			for(Orderdetail od : order.getOrderdetailSet()) {
				sum = sum + od.getTotalprice();
				session.setAttribute("totalPrice",sum);
			}
		}
		
		return "gouwuche";
	}
	
	@RequestMapping("/shopping")
	public String findOrder(HttpSession session) {
		User user = (User)session.getAttribute("user");
		Set<Order> orderSet = user.getOrderSet();
		session.setAttribute("shoppingCartSet", orderSet);
		
		for(Order order : user.getOrderSet()) {
			int size = order.getOrderdetailSet().size();
			session.setAttribute("size", size);
		}	
		
		for(Order order : user.getOrderSet()) {
			double sum = 0;
			for(Orderdetail od : order.getOrderdetailSet()) {
				sum = sum + od.getTotalprice();
				session.setAttribute("totalPrice",sum);
			}
		}
		
		return "gouwuche";
	}
}
