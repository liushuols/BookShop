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
	
	/**
	 * 分页显示图书
	 * @param request
	 * @param response
	 * @param session
	 * @return 首页
	 */
	@RequestMapping("/list")
	public String findAll(HttpServletRequest request,HttpServletResponse response,HttpSession session) {  
		//获取页码参数
	    String pageNo = request.getParameter("pageNo");
	    //判断页码是否为空
	    if (pageNo == null) {
	        pageNo = "1";
	    }
	    //调用Service层方法，并传入实际参数
	    Page page = bookServiceImpl.queryForPage(Integer.valueOf(pageNo), 6);
	    //将对象存进session中
	    request.setAttribute("page", page);
	    List<Book> list = page.getList();
	    session.setAttribute("list", list);
	    return "index";
	}
}
