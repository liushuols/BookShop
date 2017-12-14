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
	 * ����bookid��ѯBookdetail�����Ϣ
	 * @param bookid ͼ���idֵ
	 * @return Bookdetail���List����
	 */
	public List<Bookdetail> findBookDetailByBookid(int bookid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail where bookid=?");
		q.setParameter(0, bookid);
		return q.list();
	}
	
	/**
	 * ����bookid��ѯBookdetail�����Ϣ
	 * @param bookid ͼ���idֵ
	 * @return Bookdetail��ĵ�������
	 */
	public Bookdetail findBookDetailById(int bookid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail where bookid=?");
		q.setParameter(0, bookid);
		return (Bookdetail) q.uniqueResult();
	}
	
	/**
	 * ��ѯBookdetail���������ϸ��Ϣ
	 * @return Bookdetail���List����
	 */
	public List<Bookdetail> findAll1(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail");
		return q.list();
	}
	
	/**
	 * ����ͼ������Ʋ�ѯ��¼
	 * @param bookname ͼ�������
	 * @return Bookdetail���List����
	 */
	public List<Bookdetail>findByName(String bookname){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Bookdetail where bookname=?");
		q.setParameter(0, bookname);
		return q.list();
	}
	
	/**
	 * ����Ա�����ݿ��е�ͼ��������
	 * @param bd Bookdetail��Ķ���
	 * @param bookType ͼ�����������
	 */
	public void saveBooks(Bookdetail bd,String bookType) {
		//���Session
		Session session = this.sessionFactory.getCurrentSession();
		//ͨ��ͼ����������Ʋ�ѯ��¼
		BookType bt = this.findAllType1(bookType);
		//����Book��Ķ��󣬲������������Ը�ֵ
		Book book = new Book();
		book.setName(bd.getBookname());
		book.setPicture(bd.getBookimg1());
		book.setPrice(bd.getBookprice());
		book.setPublisher(bd.getBookpublisher());
		book.setBookType(bt);
		//��ͼ���ͼ������֮�佨����ϵ
		book.setBookdetail(bd);
		bd.setBook(book);
		//����ͼ��Ķ����ͼ������Ķ������ݿ���
		session.save(bd);
		session.save(book);
	}
	
	/**
	 * ����Ա�����ݿ��е�ͼ�����ɾ��
	 * @param bookid ͼ�������idֵ
	 */
	public void deleteBooks(int bookid) {
		Session session = this.sessionFactory.getCurrentSession();
		//����ͼ�������idֵ��ѯ����Ӧ�Ķ���
		Query q = session.createQuery("from Bookdetail where bookid=?");
		q.setParameter(0, bookid);
		Bookdetail bd = (Bookdetail) q.uniqueResult();
		//���ö���ɾ��
		session.delete(bd);
	}
	
	/**
	 * ����Ա�����ݿ��е�ͼ������޸�
	 * @param bd Bookdetail��Ķ���
	 * @param typeid ͼ�����͵�idֵ
	 */
	public void updateBooks(Bookdetail bd,int typeid) {
		//���session
		Session session = this.sessionFactory.getCurrentSession();
		//ͨ��ͼ�����͵�idֵ��ѯ��¼
		BookType bt = this.findAllType2(typeid);
		//ͨ��Bookdetail�Ķ����ȡBook���󣬲���Book�����е��������¸�ֵ
		Book book = bd.getBook();
		book.setName(bd.getBookname());
		book.setPicture(bd.getBookimg1());
		book.setPrice(bd.getBookprice());
		book.setPublisher(bd.getBookpublisher());
		book.setBookType(bt);
		//��ͼ���ͼ������֮�佨����ϵ
		book.setBookdetail(bd);
		bd.setBook(book);
		//����ͼ��Ķ����ͼ������Ķ���
		session.update(bd);
		session.update(book);
	}
	
	/**
	 * ������������typename��ѯ��¼
	 * @param typename ͼ��������������
	 * @return BookType��ĵ�������
	 */
	public BookType findAllType1(String typename){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType where typename=?");
		q.setParameter(0, typename);
		return (BookType) q.uniqueResult();
	}
	
	/**
	 * ����typeid��ѯbooktype�����Ϣ
	 * @param typeid ͼ�����͵�idֵ
	 * @return BookType��ĵ�������
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
