package com.bear.bookonline.bookdetail.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.Bookdetail;

@Repository
public class BookdetailDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 根据bookid查询Bookdetail表的信息
	 * @param bookid 图书的id值
	 * @return Bookdetail类的List集合
	 */
	public List<Bookdetail> findBookDetailByBookid(int bookid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail where bookid=?");
		q.setParameter(0, bookid);
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
	
	/**
	 * 查询Bookdetail表的所有详细信息
	 * @return Bookdetail类的List集合
	 */
	public List<Bookdetail> findAll1(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail");
		return q.list();
	}
	
	/**
	 * 根据图书的名称查询记录
	 * @param bookname 图书的名称
	 * @return Bookdetail类的List集合
	 */
	public List<Bookdetail>findByName(String bookname){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail where bookname=?");
		q.setParameter(0, bookname);
		return q.list();
	}
	
	/**
	 * 管理员对数据库中的图书进行添加
	 * @param bd Bookdetail类的对象
	 * @param bookType 图书的类型名称
	 */
	public void saveBooks(Bookdetail bd,String bookType) {
		//获得Session
		Session session = this.sessionFactory.getCurrentSession();
		//通过图书的类型名称查询记录
		BookType bt = this.findAllType1(bookType);
		//创建Book类的对象，并给其所有属性赋值
		Book book = new Book();
		book.setName(bd.getBookname());
		book.setPicture(bd.getBookimg1());
		book.setPrice(bd.getBookprice());
		book.setPublisher(bd.getBookpublisher());
		book.setBookType(bt);
		//将图书和图书详情之间建立联系
		book.setBookdetail(bd);
		bd.setBook(book);
		//保存图书的对象和图书详情的对象到数据库中
		session.save(bd);
		session.save(book);
	}
	
	/**
	 * 管理员对数据库中的图书进行删除
	 * @param bookid 图书详情的id值
	 */
	public void deleteBooks(int bookid) {
		Session session = this.sessionFactory.getCurrentSession();
		//根据图书详情的id值查询出对应的对象
		Query q = session.createQuery("from Bookdetail where bookid=?");
		q.setParameter(0, bookid);
		Bookdetail bd = (Bookdetail) q.uniqueResult();
		//将该对象删除
		session.delete(bd);
	}
	
	/**
	 * 管理员对数据库中的图书进行修改
	 * @param bd Bookdetail类的对象
	 * @param typeid 图书类型的id值
	 */
	public void updateBooks(Bookdetail bd,int typeid) {
		//获得session
		Session session = this.sessionFactory.getCurrentSession();
		//通过图书类型的id值查询记录
		BookType bt = this.findAllType2(typeid);
		//通过Bookdetail的对象获取Book对象，并给Book对象中的属性重新赋值
		Book book = bd.getBook();
		book.setName(bd.getBookname());
		book.setPicture(bd.getBookimg1());
		book.setPrice(bd.getBookprice());
		book.setPublisher(bd.getBookpublisher());
		book.setBookType(bt);
		//将图书和图书详情之间建立联系
		book.setBookdetail(bd);
		bd.setBook(book);
		//更新图书的对象和图书详情的对象
		session.update(bd);
		session.update(book);
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
	 * 根据typeid查询booktype表的信息
	 * @param typeid 图书类型的id值
	 * @return BookType类的单个对象
	 */
	public BookType findAllType2(int typeid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType where typeid=?");
		q.setParameter(0, typeid);
		return (BookType) q.uniqueResult();
	}
	
	public List<Bookdetail> findAllBookdetail(int bookid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail where bookid=?");
		q.setParameter(0, bookid);
		return q.list();
	}
}
