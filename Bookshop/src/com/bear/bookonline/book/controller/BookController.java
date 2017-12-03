package com.bear.bookonline.book.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.book.service.BookServiceImpl;
import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.Bookdetail;
import com.bear.bookonline.entity.Page;
import com.bear.bookonline.entity.Shoppingcart;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Resource
	private BookServiceImpl bookServiceImpl;
	
	@RequestMapping("/list")
	public String findAll(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) {   
	    String pageNo = request.getParameter("pageNo");
	    if (pageNo == null) {
	        pageNo = "1";
	    }
	    Page page = bookServiceImpl.queryForPage(Integer.valueOf(pageNo), 3);
	    request.setAttribute("page", page);
	    List<Book> list = page.getList();
	    modelMap.put("list", list);
	    return "index";
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
		List shoppingCartList = (List)session.getAttribute("shoppingCartList");
		if(shoppingCartList == null) {
			shoppingCartList = new ArrayList<>();
		}
		Bookdetail bd = this.bookServiceImpl.findByDetailid(id);
		shoppingCartList.add(bd);
		session.setAttribute("shoppingCartList", shoppingCartList);
		return "xiangqing";
	}
	
	@RequestMapping("/findByName")
	public String selectBook(Model model,@RequestParam("bookname") String bookname) {
		List<Bookdetail> detailList = this.bookServiceImpl.findByName(bookname);
		model.addAttribute("detailList", detailList);
		return "xiangqing";
	}
	
	@RequestMapping("/delete")
	public String findByBookId(@RequestParam("bookid") int bookid,HttpSession session) {
		List<Bookdetail> shoppingCartList = (List<Bookdetail>)session.getAttribute("shoppingCartList");
		if (shoppingCartList != null) {
			for(int i =0;i<shoppingCartList.size();i++) {
				if(bookid == (shoppingCartList.get(i)).getBookid()) {
					shoppingCartList.remove(i);
				}
			}
		}
		session.setAttribute("shoppingCartList", shoppingCartList);
		return "gouwuche";
	}
}
