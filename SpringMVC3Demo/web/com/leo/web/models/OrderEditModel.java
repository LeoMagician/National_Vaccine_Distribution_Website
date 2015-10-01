package com.leo.web.models;

import java.util.Calendar;

public class OrderEditModel {
	
	private Integer id;		
	private Calendar date;
	private float priceTotal;
//	private List<Integer> orderItemId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		
}
