package com.bear.bookonline.bookdetail.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.bookdetail.service.BookdetailServiceImpl;
import com.bear.bookonline.entity.Bookdetail;

@Controller
@RequestMapping("book")
public class BookdetailController {
	
	@Resource
	private BookdetailServiceImpl bookdetailServiceImpl;
	
	/**
	 * 查询Bookdetail类的所有详细信息
	 * @param session
	 * @return 后台首页
	 */
	@RequestMapping("/list1")
	public String findAll1(HttpSession session) {
		List<Bookdetail> detailList1 = this.bookdetailServiceImpl.findAll1();
		session.setAttribute("detailList1", detailList1);
		return "adminIndex";
	}

	/**
	 * 通过bookid查询Bookdetail类的详细信息
	 * @param model
	 * @param bookid 图书id
	 * @return 图书详情页
	 */
	@RequestMapping("/findAllBookDetail")
	public String findAllBookDetail(Model model,@RequestParam("bookid") int bookid) {
		List<Bookdetail> detailList = this.bookdetailServiceImpl.findAllBookdetail(bookid);
		model.addAttribute("detailList", detailList);
		return "xiangqing";
	}
	
	/**
	 * 通过图书名称查询记录
	 * @param session
	 * @param bookname 图书名称
	 * @return 图书详情页
	 */
	@RequestMapping("/findByName")
	public String selectBook(HttpSession session,@RequestParam("bookname") String bookname) {
		List<Bookdetail> detailList = this.bookdetailServiceImpl.findByName(bookname);
		session.setAttribute("detailList", detailList);
		return "xiangqing";
	}
	
	/**
	 * 管理员对数据库中的图书进行添加
	 * @param session
	 * @param bookImg1 图书图片 
	 * @param bookName 图书名称
	 * @param bookType 图书类型
	 * @param bookIntroduce 图书简介
	 * @param bookPrice 图书价格
	 * @param bookPublisher 图书出版社
	 * @return 后台列表页
	 */
	@RequestMapping("/addBook")
	public String addBooks(HttpSession session,@RequestParam("bookImg1") String bookImg1,@RequestParam("bookName") String bookName,
			@RequestParam("bookType") String bookType,@RequestParam("bookIntroduce") String bookIntroduce,
			@RequestParam("bookPrice") double bookPrice,@RequestParam("bookPublisher") String bookPublisher) {
		//将表单中获取到的属性值存入一个对象中
		Bookdetail bd = new Bookdetail();
		bd.setBookimg1(bookImg1);
		bd.setBookname(bookName);
		bd.setIntroduce(bookIntroduce);
		bd.setBookprice(bookPrice);
		bd.setBookpublisher(bookPublisher);
		//将该对象保存到数据库，同时保存该图书的类型
		this.bookdetailServiceImpl.saveBooks(bd, bookType);
		session.setAttribute("bd", bd);
		//在返回后台首页之前重新进行查询
		List<Bookdetail> detailList1 = this.bookdetailServiceImpl.findAll1();
		session.setAttribute("detailList1", detailList1);
		return "adminList";
	}
	
	/**
	 * 管理员对数据库中的图书进行删除
	 * @param session
	 * @param bookid 图书id
	 * @return 后台列表页
	 */
	@RequestMapping("adminDelete")
	public String adminRemoveBooks(HttpSession session,@RequestParam("bookid") int bookid) {
		//调用方法对数据库表中的图书进行删除
		this.bookdetailServiceImpl.deletBooks(bookid);
		//在返回后台首页之前重新进行查询
		List<Bookdetail> detailList1 = this.bookdetailServiceImpl.findAll1();
		session.setAttribute("detailList1", detailList1);
		return "adminList";
	}
	
	/**
	 * 管理员对数据库中的图书进行修改
	 * @param session
	 * @param name 图书名称
	 * @param img1 图书图片
	 * @param introduce 图书简介
	 * @param typeid 图书类型id
	 * @param price 图书价格
	 * @param publisher 图书出版社
	 * @return 后台列表页
	 */
	@RequestMapping("/updateBooks")
	public String editBooks(HttpSession session,@RequestParam("bookName") String name,@RequestParam("bookimg1") String img1,@RequestParam("introduce") String introduce,
			@RequestParam("bookType") int typeid,@RequestParam("bookPrice") double price,@RequestParam("bookPublisher") String publisher) {
		//获取session中的图书参数
		Bookdetail bd = (Bookdetail) session.getAttribute("book");
		//将表单中获取到的参数重新存入Bookdetail对象中
		bd.setBookimg1(img1);
		bd.setBookname(name);
		bd.setIntroduce(introduce);
		bd.setBookprice(price);
		bd.setBookpublisher(publisher);
		//将修改之后的对象保存到数据库，同时修改该图书的类型
		this.bookdetailServiceImpl.updateBooks(bd, typeid);
		session.setAttribute("bd", bd);
		//在返回后台首页之前重新进行查询
		List<Bookdetail> detailList1 = this.bookdetailServiceImpl.findAll1();
		session.setAttribute("detailList1", detailList1);
		return "adminList";
	}
}
