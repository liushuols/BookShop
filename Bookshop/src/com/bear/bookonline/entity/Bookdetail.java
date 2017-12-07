package com.bear.bookonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="bookdetail")
public class Bookdetail {
	
	private Integer bookid;
	private String bookname;
	private Integer bookcount;
	private double bookprice;
	private String introduce;
	private String bookpublisher;
	private String bookimg1;
	private String bookimg2;
	private String bookimg3;
	private String bookimg4;
	private String bookaddshoppingcart;
	private Book book;
	
	@Id
	@GeneratedValue(generator="foreign")
	@GenericGenerator(name="foreign",strategy="foreign",parameters={@Parameter(name="property",value="book")})
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Integer getBookcount() {
		return bookcount;
	}
	public void setBookcount(Integer bookcount) {
		this.bookcount = bookcount;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getBookpublisher() {
		return bookpublisher;
	}
	public void setBookpublisher(String bookpublisher) {
		this.bookpublisher = bookpublisher;
	}
	public String getBookimg1() {
		return bookimg1;
	}
	public void setBookimg1(String bookimg1) {
		this.bookimg1 = bookimg1;
	}
	public String getBookimg2() {
		return bookimg2;
	}
	public void setBookimg2(String bookimg2) {
		this.bookimg2 = bookimg2;
	}
	public String getBookimg3() {
		return bookimg3;
	}
	public void setBookimg3(String bookimg3) {
		this.bookimg3 = bookimg3;
	}
	public String getBookimg4() {
		return bookimg4;
	}
	public void setBookimg4(String bookimg4) {
		this.bookimg4 = bookimg4;
	}
	public String getBookaddshoppingcart() {
		return bookaddshoppingcart;
	}
	public void setBookaddshoppingcart(String bookaddshoppingcart) {
		this.bookaddshoppingcart = bookaddshoppingcart;
	}
	
	@OneToOne(mappedBy="bookdetail")
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
