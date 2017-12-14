package com.bear.bookonline.book.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.Bookdetail;
import com.bear.bookonline.entity.Cart;
import com.bear.bookonline.entity.CartItem;
import com.bear.bookonline.entity.Order;
import com.bear.bookonline.entity.Orderdetail;
import com.bear.bookonline.entity.User;

@Repository
public class BookDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 从Book表中查询所有图书的信息
	 * @return Book类的List集合
	 */
	public List<Book> findAll(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Book");
		return q.list();
	}
	
	/**
	 * 对Book表进行分页查询
	 * @param offset 从第几条记录开始
	 * @param length 每页显示几条记录
	 * @return Book类的List集合
	 */
	public List<Book> queryForPage(int offset, int length) {
	    Query query= (Query) sessionFactory.getCurrentSession().createQuery("from Book");    
	    query.setFirstResult(offset);
	    query.setMaxResults(length);            
	    return query.list(); 
	}
	
	/**
	 * 查询记录总数
	 * @return 记录总数的值
	 */
	public int getAllRowCount(){
	    int count=((Long) sessionFactory.getCurrentSession().createQuery( "select count(*) from Book").iterate().next()).intValue();
	    return count;  
	}
	
	/**
	 * 查询Bookdetail表的所有详细信息
	 * @return Bookdetail类的List集合
	 */
	public List<Bookdetail> findAll1(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail");
		return q.list();
	}

	/**
	 * 根据bookid查询Bookdetail表的信息
	 * @param bookid 图书的id值
	 * @return Bookdetail类的单个对象
	 */
	public Bookdetail findByDetailid(int bookid) {
		return this.sessionFactory.getCurrentSession().get(Bookdetail.class, bookid);
	}
}
