package com.bear.bookonline.book.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.Bookdetail;
import com.bear.bookonline.entity.Shoppingcart;

@Repository
public class BookDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public List<Book> findAll(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Book");
		return q.list();
	}
	
	public List<Book> queryForPage(int offset, int length) {
	    //查询所有的记录数
	    Query query= (Query) sessionFactory.getCurrentSession().createQuery("from Book");    
	    query.setFirstResult(offset);
	    query.setMaxResults(length);            
	    return query.list(); 
	}
	public void save(Book st){
		sessionFactory.getCurrentSession().save(st);
	}
	public void update(Book st) {   
	    sessionFactory.getCurrentSession().update(st);
	}
	public void delete(Book st) {      
	    sessionFactory.getCurrentSession().delete(st);
	}
	//查询记录总数
	public int getAllRowCount(){
	    int count=((Long) sessionFactory.getCurrentSession().createQuery( "select count(*) from Book").iterate().next()).intValue();
	    return count;  
	}
	//根据typeid查询记录
	public List<Book> QueryByTypeid(int typeid) {
	    Query q = this.sessionFactory.getCurrentSession().createQuery("from Book where typeid=?");
	    q.setParameter(0, typeid);
	    return q.list();
	}
	
	public List<BookType> findAllType(int typeid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType where typeid=?");
		q.setParameter(0, typeid);
		return q.list();
	}
	
	public List<Bookdetail> findBookDetailByBookid(int bookid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail where bookid=?");
		q.setParameter(0, bookid);
		return q.list();
	}
	
	public void saveShopping(Shoppingcart sc) {
		this.sessionFactory.getCurrentSession().save(sc);
	}
	
	public List<Bookdetail>findByName(String bookname){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail where bookname=?");
		q.setParameter(0, bookname);
		return q.list();
	}
	
	public Bookdetail findByDetailid(int bookid) {
		return this.sessionFactory.getCurrentSession().get(Bookdetail.class, bookid);
	}
}
