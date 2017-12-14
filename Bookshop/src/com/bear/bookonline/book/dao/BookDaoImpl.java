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
	 * ��Book���в�ѯ����ͼ�����Ϣ
	 * @return Book���List����
	 */
	public List<Book> findAll(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Book");
		return q.list();
	}
	
	/**
	 * ��Book����з�ҳ��ѯ
	 * @param offset �ӵڼ�����¼��ʼ
	 * @param length ÿҳ��ʾ������¼
	 * @return Book���List����
	 */
	public List<Book> queryForPage(int offset, int length) {
	    Query query= (Query) sessionFactory.getCurrentSession().createQuery("from Book");    
	    query.setFirstResult(offset);
	    query.setMaxResults(length);            
	    return query.list(); 
	}
	
	/**
	 * ��ѯ��¼����
	 * @return ��¼������ֵ
	 */
	public int getAllRowCount(){
	    int count=((Long) sessionFactory.getCurrentSession().createQuery( "select count(*) from Book").iterate().next()).intValue();
	    return count;  
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
	 * ����bookid��ѯBookdetail�����Ϣ
	 * @param bookid ͼ���idֵ
	 * @return Bookdetail��ĵ�������
	 */
	public Bookdetail findByDetailid(int bookid) {
		return this.sessionFactory.getCurrentSession().get(Bookdetail.class, bookid);
	}
}
