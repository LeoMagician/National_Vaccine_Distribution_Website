package com.leo.model.models;

import java.util.HashSet;
import java.util.Set;

import com.infrastructure.project.base.model.interfaces.ICUDEable;
import com.infrastructure.project.base.model.models.EnableEntity;

public class Vaccine extends EnableEntity<Integer> implements ICUDEable{
	
    private String mfd;    
    private String exp;
    private String vaccineType;
    private int availability;
    private float price;
    private String disease;
    private Set<Quota> quotas = new HashSet();   
    private Inventory inventory;
    private int hosInventory;
    
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
	public Set<Quota> getQuotas() {
		return quotas;
	}
	public void setQuotas(Set<Quota> quotas) {
		this.quotas = quotas;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public int getHosInventory() {
		return hosInventory;
	}
	public void setHosInventory(int hosInventory) {
		this.hosInventory = hosInventory;
	}	    
	
}
