package com.leo.web.models;

import javax.validation.constraints.NotNull;

public class CartEditModel {
	
	private Integer id;
	private String name;
	private Integer vaccineId;
	private float price;	
	@NotNull(message="{number.not.null}")
	private int number;
		
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
