package com.bear.bookonline.bookdetail.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.bookonline.bookdetail.dao.BookdetailDaoImpl;
import com.bear.bookonline.entity.Bookdetail;

@Service
@Transactional
public class BookdetailServiceImpl {
	
	@Resource
	private BookdetailDaoImpl bookdetailDaoImpl;
	
	/**
	 * 根据图书的名称查询记录
	 * @param bookname 图书的名称
	 * @return Bookdetail类的List集合
	 */
    public List<Bookdetail> findByName(String bookname){
    	return this.bookdetailDaoImpl.findByName(bookname);
    }
    
    /**
	 * 查询Bookdetail表的所有详细信息
	 * @return Bookdetail类的List集合
	 */
    public List<Bookdetail> findAll1(){
    	return this.bookdetailDaoImpl.findAll1();
    }
    
    /**
	 * 根据bookid查询Bookdetail表的信息
	 * @param bookid 图书的id值
	 * @return Bookdetail类的单个对象
	 */
    public Bookdetail findBookDetialById(int bookid) {
    	return this.bookdetailDaoImpl.findBookDetailById(bookid);
    }
    
    /**
	 * 管理员对数据库中的图书进行添加
	 * @param bd Bookdetail类的对象
	 * @param bookType 图书的类型名称
	 */
    public void saveBooks(Bookdetail bd,String bookType) {
    	this.bookdetailDaoImpl.saveBooks(bd,bookType);
    }
    
    /**
	 * 管理员对数据库中的图书进行删除
	 * @param bookid 图书详情的id值
	 */
    public void deletBooks(int bookid) {
    	this.bookdetailDaoImpl.deleteBooks(bookid);
    }
    
    /**
	 * 管理员对数据库中的图书进行修改
	 * @param bd Bookdetail类的对象
	 * @param typeid 图书类型的id值
	 */
    public void updateBooks(Bookdetail bd,int typeid) {
    	this.bookdetailDaoImpl.updateBooks(bd, typeid);
    }
    
    /**
     * 根据图书的id查询记录
     * @param bookid 图书id值
     * @return Bookdetail类的List集合
     */
    public List<Bookdetail> findAllBookdetail(int bookid){
    	return this.bookdetailDaoImpl.findAllBookdetail(bookid);
    }
}
