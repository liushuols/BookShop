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
	 * ����bookid��ѯͼ����󣬲���ѯ������ͼ������ͼ��ϣ�����ѯ���Ķ������session��
	 * @param session
	 * @param bookid ͼ��id
	 * @return ��̨�޸�ͼ��ҳ
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
	 * ����typeid��ͼ����з����ѯ
	 * @param model
	 * @param typeid ͼ������id
	 * @return �б�ҳ
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
