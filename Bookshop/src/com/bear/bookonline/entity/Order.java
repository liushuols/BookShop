package com.bear.bookonline.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	private Integer orderid;
	private String username;
	private User user;
	private Set<Orderdetail> orderdetailSet = new HashSet<Orderdetail>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@ManyToOne(cascade = CascadeType.MERGE,optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy="order", targetEntity=Orderdetail.class, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Orderdetail> getOrderdetailSet() {
		return orderdetailSet;
	}
	public void setOrderdetailSet(Set<Orderdetail> orderdetailSet) {
		this.orderdetailSet = orderdetailSet;
	}
	
	
	
}
