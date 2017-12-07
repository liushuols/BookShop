package com.bear.bookonline.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	private Integer userid;
	private String username;
	private String userpwd;
	private String telephone;
	private String address;
	private String email;
	private Set<Order> orderSet = new HashSet<Order>();
	private Set<Log> logSet = new HashSet<Log>();
	private Cart shoppingcart;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(mappedBy="user", targetEntity=Order.class, cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	public Set<Order> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}
	
	@OneToMany(mappedBy="user", targetEntity=Log.class, cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
	public Set<Log> getLogSet() {
		return logSet;
	}
	public void setLogSet(Set<Log> logSet) {
		this.logSet = logSet;
	}
	
	@OneToOne(mappedBy="user")
	public Cart getShoppingcart() {
		return shoppingcart;
	}
	public void setShoppingcart(Cart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}
	
}
