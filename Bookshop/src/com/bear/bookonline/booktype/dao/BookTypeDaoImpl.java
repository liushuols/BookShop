package com.bear.bookonline.booktype.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.Bookdetail;

@Repository
public class BookTypeDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 根据typeid查询booktype表的信息
	 * @param typeid 图书类型的id值
	 * @return BookType类的List集合
	 */
	public List<BookType> findAllType(int typeid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType where typeid=?");
		q.setParameter(0, typeid);
		return q.list();
	}
	
	/**
	 * 根据typeid查询booktype表的信息
	 * @param typeid 图书类型的id值
	 * @return BookType类的单个对象
	 */
	public BookType findAllType2(int typeid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType where typeid=?");
		q.setParameter(0, typeid);
		return (BookType) q.uniqueResult();
	}
	
	/**
	 * 查询booktype表的所有详细信息
	 * @return BookType类的List集合
	 */
	public List<BookType> findAllType1(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType");
		return q.list();
	}
	
	/**
	 * 根据类型名称typename查询记录
	 * @param typename 图书所属的类型名
	 * @return BookType类的单个对象
	 */
	public BookType findAllType1(String typename){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType where typename=?");
		q.setParameter(0, typename);
		return (BookType) q.uniqueResult();
	}
	
	/**
	 * 根据typeid查询Book表的信息
	 * @param typeid 图书类型的id值
	 * @return Book类的List集合
	 */
	public List<Book> QueryByTypeid(int typeid) {
	    Query q = this.sessionFactory.getCurrentSession().createQuery("from Book where typeid=?");
	    q.setParameter(0, typeid);
	    return q.list();
	}
	
	/**
	 * 根据bookid查询Bookdetail表的信息
	 * @param bookid 图书的id值
	 * @return Bookdetail类的单个对象
	 */
	public Bookdetail findBookDetailById(int bookid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail where bookid=?");
		q.setParameter(0, bookid);
		return (Bookdetail) q.uniqueResult();
	}
}
