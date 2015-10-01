package com.leo.web.models;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class VaccineEditModel {
	
	private Integer id;
	@NotEmpty(message="{name.not.empty}")
	private String name;
	@NotEmpty(message="{mfd.not.empty}")
	private String mfd;    
	@NotEmpty(message="{exp.not.empty}")
    private String exp;
	@NotEmpty(message="{vaccineType.not.empty}")
    private String vaccineType;
	@NotNull(message="{availability.not.null}")
    private int availability;
	@NotNull(message="{price.not.null}")
    private float price;
	@NotEmpty(message="{disease.not.empty}")
    private String disease;
	
	public void setId(Integer id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}	
	
	public Integer getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getMfd() {
		return mfd;
	}
	public void setMfd(String mfd) {
		this.mfd = mfd;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getVaccineType() {
		return vaccineType;
	}
	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	
}
