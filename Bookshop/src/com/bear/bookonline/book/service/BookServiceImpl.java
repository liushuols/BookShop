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
	 * 从Book表中查询所有图书的信息
	 * @return Book类的List集合
	 */
	public List<Book> listAll(){
		return this.bookDaoImpl.findAll();
	}
	
	/**
	 * 对Book表进行分页查询
	 * @param currentPage 当前页
	 * @param pageSize 每页的记录数
	 * @return Page类的对象
	 */
	public Page queryForPage(int currentPage,int pageSize) {
        Page page = new Page();       
        //总记录数
        int allRow = bookDaoImpl.getAllRowCount();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Book> list = bookDaoImpl.queryForPage(offset, pageSize); 
        //给Page类的每个属性进行赋值
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);    
        return page;
    }
	
	/**
	 * 查询记录总数
	 * @return 记录总数的值
	 */
    public int ServicegetCount(){
        return bookDaoImpl.getAllRowCount();
    }
    
    /**
	 * 查询Bookdetail表的所有详细信息
	 * @return Bookdetail类的List集合
	 */
    public List<Bookdetail> findAll1(){
    	return this.bookDaoImpl.findAll1();
    }

    /**
	 * 根据bookid查询Bookdetail表的信息
	 * @param bookid 图书的id值
	 * @return Bookdetail类的单个对象
	 */
    public Bookdetail findByDetailid(int bookid) {
    	return this.bookDaoImpl.findByDetailid(bookid);
    }
}
