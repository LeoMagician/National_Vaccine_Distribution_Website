package com.leo.web.models;

import java.util.Calendar;

public class PHDOrderModel {
	
	private int id;
	private String hosName;
	private boolean registerStatus;
	private String accountName;
	private Calendar date;
	private float priceTotal;
	private String orderStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHosName() {
		return hosName;
	}
	public void setHosName(String hosName) {
		this.hosName = hosName;
	}
	public boolean isRegisterStatus() {
		return registerStatus;
	}
	public void setRegisterStatus(boolean registerStatus) {
		this.registerStatus = registerStatus;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public float getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(float priceTotal) {
		this.priceTotal = priceTotal;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
}
