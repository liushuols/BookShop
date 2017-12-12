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
	
	public BookType findAllType1(String typename){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType where typename=?");
		q.setParameter(0, typename);
		return (BookType) q.uniqueResult();
	}
	
	public List<Bookdetail> findBookDetailByBookid(int bookid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail where bookid=?");
		q.setParameter(0, bookid);
		return q.list();
	}
	
	public void saveShopping(User user,int id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = null;
		if(user.getOrderSet().size()<=0) {
			order = new Order();
		}else {
			for(Order o : user.getOrderSet()) {		
					order = o;
			}
			
		}
		
		order.setUser(user);	
		user.getOrderSet().add(order);
		
		session.update(user);	
		session.save(order);
		
		Bookdetail bookdetail = this.findByDetailid(id);
		
		Orderdetail orderdetail = new Orderdetail();
		orderdetail.setUsername(user.getUsername());
		orderdetail.setBookname(bookdetail.getBookname());
		orderdetail.setBookcount(bookdetail.getBookcount());
		orderdetail.setBookprice(bookdetail.getBookprice());
		
		orderdetail.setOrder(order);
		order.getOrderdetailSet().add(orderdetail);
		
		session.save(orderdetail);
		session.update(order);
		
		
	}
	
	public List<Bookdetail> findAll1(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail");
		return q.list();
	}
	
	public List<Bookdetail>findByName(String bookname){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail where bookname=?");
		q.setParameter(0, bookname);
		return q.list();
	}
	
	public Bookdetail findByDetailid(int bookid) {
		return this.sessionFactory.getCurrentSession().get(Bookdetail.class, bookid);
	}
	
	public void deleteByOrderDetail(Orderdetail od) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(od);
	}
	
	public Orderdetail findByOrderDetailid(int id) {
		return this.sessionFactory.getCurrentSession().get(Orderdetail.class, id);
	}
	
	public void saveBooks(Bookdetail bd,String bookType) {
		Session session = this.sessionFactory.getCurrentSession();
		
		BookType bt = this.findAllType1(bookType);
		
		Book book = new Book();
		book.setName(bd.getBookname());
		book.setPicture(bd.getBookimg1());
		book.setPrice(bd.getBookprice());
		book.setPublisher(bd.getBookpublisher());
		book.setBookType(bt);
		
		book.setBookdetail(bd);
		bd.setBook(book);
		
		session.save(bd);
		session.save(book);

	}
	
	public void deleteBooks(int bookid) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Bookdetail where bookid=?");
		q.setParameter(0, bookid);
		Bookdetail bd = (Bookdetail) q.uniqueResult();
		
		session.delete(bd);
	}
}
