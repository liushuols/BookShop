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
	 * ��ѯBookdetail���������ϸ��Ϣ
	 * @param session
	 * @return ��̨��ҳ
	 */
	@RequestMapping("/list1")
	public String findAll1(HttpSession session) {
		List<Bookdetail> detailList1 = this.bookdetailServiceImpl.findAll1();
		session.setAttribute("detailList1", detailList1);
		return "adminIndex";
	}

	/**
	 * ͨ��bookid��ѯBookdetail�����ϸ��Ϣ
	 * @param model
	 * @param bookid ͼ��id
	 * @return ͼ������ҳ
	 */
	@RequestMapping("/findAllBookDetail")
	public String findAllBookDetail(Model model,@RequestParam("bookid") int bookid) {
		List<Bookdetail> detailList = this.bookdetailServiceImpl.findAllBookdetail(bookid);
		model.addAttribute("detailList", detailList);
		return "xiangqing";
	}
	
	/**
	 * ͨ��ͼ�����Ʋ�ѯ��¼
	 * @param session
	 * @param bookname ͼ������
	 * @return ͼ������ҳ
	 */
	@RequestMapping("/findByName")
	public String selectBook(HttpSession session,@RequestParam("bookname") String bookname) {
		List<Bookdetail> detailList = this.bookdetailServiceImpl.findByName(bookname);
		session.setAttribute("detailList", detailList);
		return "xiangqing";
	}
	
	/**
	 * ����Ա�����ݿ��е�ͼ��������
	 * @param session
	 * @param bookImg1 ͼ��ͼƬ 
	 * @param bookName ͼ������
	 * @param bookType ͼ������
	 * @param bookIntroduce ͼ����
	 * @param bookPrice ͼ��۸�
	 * @param bookPublisher ͼ�������
	 * @return ��̨�б�ҳ
	 */
	@RequestMapping("/addBook")
	public String addBooks(HttpSession session,@RequestParam("bookImg1") String bookImg1,@RequestParam("bookName") String bookName,
			@RequestParam("bookType") String bookType,@RequestParam("bookIntroduce") String bookIntroduce,
			@RequestParam("bookPrice") double bookPrice,@RequestParam("bookPublisher") String bookPublisher) {
		//�����л�ȡ��������ֵ����һ��������
		Bookdetail bd = new Bookdetail();
		bd.setBookimg1(bookImg1);
		bd.setBookname(bookName);
		bd.setIntroduce(bookIntroduce);
		bd.setBookprice(bookPrice);
		bd.setBookpublisher(bookPublisher);
		//���ö��󱣴浽���ݿ⣬ͬʱ�����ͼ�������
		this.bookdetailServiceImpl.saveBooks(bd, bookType);
		session.setAttribute("bd", bd);
		//�ڷ��غ�̨��ҳ֮ǰ���½��в�ѯ
		List<Bookdetail> detailList1 = this.bookdetailServiceImpl.findAll1();
		session.setAttribute("detailList1", detailList1);
		return "adminList";
	}
	
	/**
	 * ����Ա�����ݿ��е�ͼ�����ɾ��
	 * @param session
	 * @param bookid ͼ��id
	 * @return ��̨�б�ҳ
	 */
	@RequestMapping("adminDelete")
	public String adminRemoveBooks(HttpSession session,@RequestParam("bookid") int bookid) {
		//���÷��������ݿ���е�ͼ�����ɾ��
		this.bookdetailServiceImpl.deletBooks(bookid);
		//�ڷ��غ�̨��ҳ֮ǰ���½��в�ѯ
		List<Bookdetail> detailList1 = this.bookdetailServiceImpl.findAll1();
		session.setAttribute("detailList1", detailList1);
		return "adminList";
	}
	
	/**
	 * ����Ա�����ݿ��е�ͼ������޸�
	 * @param session
	 * @param name ͼ������
	 * @param img1 ͼ��ͼƬ
	 * @param introduce ͼ����
	 * @param typeid ͼ������id
	 * @param price ͼ��۸�
	 * @param publisher ͼ�������
	 * @return ��̨�б�ҳ
	 */
	@RequestMapping("/updateBooks")
	public String editBooks(HttpSession session,@RequestParam("bookName") String name,@RequestParam("bookimg1") String img1,@RequestParam("introduce") String introduce,
			@RequestParam("bookType") int typeid,@RequestParam("bookPrice") double price,@RequestParam("bookPublisher") String publisher) {
		//��ȡsession�е�ͼ�����
		Bookdetail bd = (Bookdetail) session.getAttribute("book");
		//�����л�ȡ���Ĳ������´���Bookdetail������
		bd.setBookimg1(img1);
		bd.setBookname(name);
		bd.setIntroduce(introduce);
		bd.setBookprice(price);
		bd.setBookpublisher(publisher);
		//���޸�֮��Ķ��󱣴浽���ݿ⣬ͬʱ�޸ĸ�ͼ�������
		this.bookdetailServiceImpl.updateBooks(bd, typeid);
		session.setAttribute("bd", bd);
		//�ڷ��غ�̨��ҳ֮ǰ���½��в�ѯ
		List<Bookdetail> detailList1 = this.bookdetailServiceImpl.findAll1();
		session.setAttribute("detailList1", detailList1);
		return "adminList";
	}
}
