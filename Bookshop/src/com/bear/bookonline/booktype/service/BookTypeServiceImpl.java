package com.bear.bookonline.booktype.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.bookonline.booktype.dao.BookTypeDaoImpl;
import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.Bookdetail;

@Service
@Transactional
public class BookTypeServiceImpl {
	
	@Resource
	private BookTypeDaoImpl bookTypeDaoImpl;
	
	/**
	 * 根据typeid查询booktype表的信息
	 * @param typeid 图书类型的id值
	 * @return BookType类的List集合
	 */
    public List<BookType> findAllType(int typeid){
    	return this.bookTypeDaoImpl.findAllType(typeid);
    }
    
    /**
	 * 根据类型名称typename查询记录
	 * @param typename 图书所属的类型名
	 * @return BookType类的单个对象
	 */
    public BookType findAllType1(String typename){
    	return (BookType) this.bookTypeDaoImpl.findAllType1(typename);
    }
    
    /**
	 * 查询booktype表的所有详细信息
	 * @return BookType类的List集合
	 */
    public List<BookType> findAllType1(){
    	return this.bookTypeDaoImpl.findAllType1();
    }
    
    /**
	 * 根据typeid查询Book表的信息
	 * @param typeid 图书类型的id值
	 * @return Book类的List集合
	 */
    public List <Book> QueryByTypeid(int typeid){
        return bookTypeDaoImpl.QueryByTypeid(typeid);
    }
    
    /**
	 * 根据bookid查询Bookdetail表的信息
	 * @param bookid 图书的id值
	 * @return Bookdetail类的单个对象
	 */
    public Bookdetail findBookDetialById(int bookid) {
    	return this.bookTypeDaoImpl.findBookDetailById(bookid);
    }
}
