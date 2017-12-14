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
	 * ����ͼ������Ʋ�ѯ��¼
	 * @param bookname ͼ�������
	 * @return Bookdetail���List����
	 */
    public List<Bookdetail> findByName(String bookname){
    	return this.bookdetailDaoImpl.findByName(bookname);
    }
    
    /**
	 * ��ѯBookdetail���������ϸ��Ϣ
	 * @return Bookdetail���List����
	 */
    public List<Bookdetail> findAll1(){
    	return this.bookdetailDaoImpl.findAll1();
    }
    
    /**
	 * ����bookid��ѯBookdetail�����Ϣ
	 * @param bookid ͼ���idֵ
	 * @return Bookdetail��ĵ�������
	 */
    public Bookdetail findBookDetialById(int bookid) {
    	return this.bookdetailDaoImpl.findBookDetailById(bookid);
    }
    
    /**
	 * ����Ա�����ݿ��е�ͼ��������
	 * @param bd Bookdetail��Ķ���
	 * @param bookType ͼ�����������
	 */
    public void saveBooks(Bookdetail bd,String bookType) {
    	this.bookdetailDaoImpl.saveBooks(bd,bookType);
    }
    
    /**
	 * ����Ա�����ݿ��е�ͼ�����ɾ��
	 * @param bookid ͼ�������idֵ
	 */
    public void deletBooks(int bookid) {
    	this.bookdetailDaoImpl.deleteBooks(bookid);
    }
    
    /**
	 * ����Ա�����ݿ��е�ͼ������޸�
	 * @param bd Bookdetail��Ķ���
	 * @param typeid ͼ�����͵�idֵ
	 */
    public void updateBooks(Bookdetail bd,int typeid) {
    	this.bookdetailDaoImpl.updateBooks(bd, typeid);
    }
    
    /**
     * ����ͼ���id��ѯ��¼
     * @param bookid ͼ��idֵ
     * @return Bookdetail���List����
     */
    public List<Bookdetail> findAllBookdetail(int bookid){
    	return this.bookdetailDaoImpl.findAllBookdetail(bookid);
    }
}
