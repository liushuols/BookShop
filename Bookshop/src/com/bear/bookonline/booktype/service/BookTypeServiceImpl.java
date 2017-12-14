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
	 * ����typeid��ѯbooktype�����Ϣ
	 * @param typeid ͼ�����͵�idֵ
	 * @return BookType���List����
	 */
    public List<BookType> findAllType(int typeid){
    	return this.bookTypeDaoImpl.findAllType(typeid);
    }
    
    /**
	 * ������������typename��ѯ��¼
	 * @param typename ͼ��������������
	 * @return BookType��ĵ�������
	 */
    public BookType findAllType1(String typename){
    	return (BookType) this.bookTypeDaoImpl.findAllType1(typename);
    }
    
    /**
	 * ��ѯbooktype���������ϸ��Ϣ
	 * @return BookType���List����
	 */
    public List<BookType> findAllType1(){
    	return this.bookTypeDaoImpl.findAllType1();
    }
    
    /**
	 * ����typeid��ѯBook�����Ϣ
	 * @param typeid ͼ�����͵�idֵ
	 * @return Book���List����
	 */
    public List <Book> QueryByTypeid(int typeid){
        return bookTypeDaoImpl.QueryByTypeid(typeid);
    }
    
    /**
	 * ����bookid��ѯBookdetail�����Ϣ
	 * @param bookid ͼ���idֵ
	 * @return Bookdetail��ĵ�������
	 */
    public Bookdetail findBookDetialById(int bookid) {
    	return this.bookTypeDaoImpl.findBookDetailById(bookid);
    }
}
