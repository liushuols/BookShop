package com.bear.bookonline.book.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.bear.bookonline.book.dao.BookDaoImpl;
import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.Bookdetail;
import com.bear.bookonline.entity.Page;
import com.bear.bookonline.entity.User;
import com.bear.bookonline.entity.Cart;
import com.bear.bookonline.entity.Orderdetail;

@Service
@Transactional
public class BookServiceImpl {
	
	@Resource
	private BookDaoImpl bookDaoImpl;
	
	/**
	 * ��Book���в�ѯ����ͼ�����Ϣ
	 * @return Book���List����
	 */
	public List<Book> listAll(){
		return this.bookDaoImpl.findAll();
	}
	
	/**
	 * ��Book����з�ҳ��ѯ
	 * @param currentPage ��ǰҳ
	 * @param pageSize ÿҳ�ļ�¼��
	 * @return Page��Ķ���
	 */
	public Page queryForPage(int currentPage,int pageSize) {
        Page page = new Page();       
        //�ܼ�¼��
        int allRow = bookDaoImpl.getAllRowCount();
        //��ǰҳ��ʼ��¼
        int offset = page.countOffset(currentPage,pageSize);  
        //��ҳ��ѯ�����
        List<Book> list = bookDaoImpl.queryForPage(offset, pageSize); 
        //��Page���ÿ�����Խ��и�ֵ
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);    
        return page;
    }
	
	/**
	 * ��ѯ��¼����
	 * @return ��¼������ֵ
	 */
    public int ServicegetCount(){
        return bookDaoImpl.getAllRowCount();
    }
    
    /**
	 * ��ѯBookdetail���������ϸ��Ϣ
	 * @return Bookdetail���List����
	 */
    public List<Bookdetail> findAll1(){
    	return this.bookDaoImpl.findAll1();
    }

    /**
	 * ����bookid��ѯBookdetail�����Ϣ
	 * @param bookid ͼ���idֵ
	 * @return Bookdetail��ĵ�������
	 */
    public Bookdetail findByDetailid(int bookid) {
    	return this.bookDaoImpl.findByDetailid(bookid);
    }
}
