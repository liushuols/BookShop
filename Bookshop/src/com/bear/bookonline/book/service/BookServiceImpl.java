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
import com.bear.bookonline.entity.Shoppingcart;

@Service
@Transactional(readOnly=true)
public class BookServiceImpl {
	
	@Resource
	private BookDaoImpl bookDaoImpl;
	
	public List<Book> listAll(){
		return this.bookDaoImpl.findAll();
	}
	
	public Page queryForPage(int currentPage,int pageSize) {
        Page page = new Page();       
        //总记录数
        int allRow = bookDaoImpl.getAllRowCount();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Book> list = bookDaoImpl.queryForPage(offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);    
        return page;
    }
     public void Servicesave(Book st){
  	   bookDaoImpl.save(st);
     }
    public void Serviceupdate(Book st){
  	  bookDaoImpl.update(st);
    }
    public void Servicedelete(Book st){
  	  bookDaoImpl.delete(st);
    }
    public int ServicegetCount(){
        return bookDaoImpl.getAllRowCount();
    }
    public List <Book> QueryByTypeid(int typeid){
        return bookDaoImpl.QueryByTypeid(typeid);
    }
    
    public List<BookType> findAllType(int typeid){
    	return this.bookDaoImpl.findAllType(typeid);
    }
    
    public List<Bookdetail> findAllBookDetail(int bookid){
    	return this.bookDaoImpl.findBookDetailByBookid(bookid);
    }
    
    public void saveShopping(Shoppingcart sc) {
    	this.bookDaoImpl.saveShopping(sc);
    }
    
    public List<Bookdetail> findByName(String bookname){
    	return this.bookDaoImpl.findByName(bookname);
    }
    
    public Bookdetail findByDetailid(int bookid) {
    	return this.bookDaoImpl.findByDetailid(bookid);
    }
}
