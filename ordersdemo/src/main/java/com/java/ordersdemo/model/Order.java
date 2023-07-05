package com.java.ordersdemo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ord_name")
	private String ord_name;
	@Column(name = "ord_id")
	private int ord_id;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "price_item")
	private int price_item;
	@Column(name = "tord")
	private int tord;
	@Column(name = "gst")
	private int gst;
//	@Column(name = "ttax")
//	private int ttax;
	@Column(name = "tpit")
	private int tpit;
	
	public Order() {

	}

	public Order(String ord_name, int ord_id, int quantity, int price_item, int tord, int gst) {
		super();
		this.ord_name = ord_name;
		this.ord_id = ord_id;
		this.quantity = quantity;
		this.price_item = price_item;
		this.tord = quantity*price_item;
		this.gst = (gst/100)*price_item;
//		this.ttax = ttax;
		this.tpit=price_item+gst;
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public String getord_name() {
		return ord_name;
	}

	public void setord_name(String ord_name) {
		this.ord_name = ord_name;
	}
	public long getord_id() {
		return ord_id;
	}

	public void setord_id(int ord_id) {
		this.ord_id = ord_id;
	}

	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}

	public int getprice_item() {
		return price_item;
	}

	public void setprice_item(int price_item ) {
		this.price_item = price_item;
	}

	public int gettord() {
		return quantity*price_item;
	}

	public void settord(int tord) {
		this.tord=quantity*price_item;;
	}

	public int getgst() {
		return (gst/100)*price_item;
	}

	public void setgst(int gst) {
		this.gst = (gst/100)*price_item;
	}

//	public int getttax() {
//		return ttax;
//	}
//
//	public void setttax(int ttax) {
//		this.ttax = ttax;
//	}

	

	public int gettpit() {
		return price_item+gst+quantity;
	}

	public void settpit(int tpit) {
		this.tpit = price_item+gst+quantity;
	}
}
