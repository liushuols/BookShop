package com.bear.bookonline.booktype.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.booktype.service.BookTypeServiceImpl;
import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.Bookdetail;

@Controller
@RequestMapping("book")
public class BookTypeController {
	
	@Resource
	private BookTypeServiceImpl bookTypeServiceImpl;
	
	/**
	 * 根据bookid查询图书对象，并查询出所有图书的类型集合，将查询出的对象存入session中
	 * @param session
	 * @param bookid 图书id
	 * @return 后台修改图书页
	 */
	@RequestMapping("/list2")
	public String selectAllType(HttpSession session,@RequestParam("bookid") int bookid) {
		Bookdetail book = this.bookTypeServiceImpl.findBookDetialById(bookid);
		List<BookType> typeList = this.bookTypeServiceImpl.findAllType1();
		session.setAttribute("typeList", typeList);
		session.setAttribute("book", book);
		return "adminUpdate";
	}
	
	/**
	 * 根据typeid对图书进行分类查询
	 * @param model
	 * @param typeid 图书类型id
	 * @return 列表页
	 */
	@RequestMapping("/findByTypeid")
	public String findByTypeid(Model model,@RequestParam("typeid") int typeid) {
		List<Book> sublist = this.bookTypeServiceImpl.QueryByTypeid(typeid);
		List<BookType> typeList = this.bookTypeServiceImpl.findAllType(typeid);
		model.addAttribute("sublist", sublist);
		model.addAttribute("typeList", typeList);
		return "liebiao";
	}
}
