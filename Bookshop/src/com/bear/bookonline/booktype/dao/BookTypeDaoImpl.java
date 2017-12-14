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
	 * ����typeid��ѯbooktype�����Ϣ
	 * @param typeid ͼ�����͵�idֵ
	 * @return BookType���List����
	 */
	public List<BookType> findAllType(int typeid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType where typeid=?");
		q.setParameter(0, typeid);
		return q.list();
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
	
	/**
	 * ��ѯbooktype���������ϸ��Ϣ
	 * @return BookType���List����
	 */
	public List<BookType> findAllType1(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType");
		return q.list();
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
	 * ����typeid��ѯBook�����Ϣ
	 * @param typeid ͼ�����͵�idֵ
	 * @return Book���List����
	 */
	public List<Book> QueryByTypeid(int typeid) {
	    Query q = this.sessionFactory.getCurrentSession().createQuery("from Book where typeid=?");
	    q.setParameter(0, typeid);
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
}
