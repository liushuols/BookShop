package com.bear.bookonline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.engine.internal.Cascade;
import org.hibernate.event.spi.SaveOrUpdateEvent;

@Entity
@Table(name="cartitem")
public class CartItem {
	
	private int  id;
	private Bookdetail bookdetail;
	private Cart cart;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="bookid")
	public Bookdetail getBookdetail() {
		return bookdetail;
	}

	public void setBookdetail(Bookdetail bookdetail) {
		this.bookdetail = bookdetail;
	}

	
	@ManyToOne
	@JoinColumn(name="cartid")
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
}
