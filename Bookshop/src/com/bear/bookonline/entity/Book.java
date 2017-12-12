package com.bear.bookonline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	private Integer id;
	private String name;
	private double price;
	private String publisher;
	private String picture;
	private BookType bookType;
	private Bookdetail bookdetail;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@ManyToOne
	@JoinColumn(name="typeid")
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bookid")
	public Bookdetail getBookdetail() {
		return bookdetail;
	}
	public void setBookdetail(Bookdetail bookdetail) {
		this.bookdetail = bookdetail;
	}
	
}
