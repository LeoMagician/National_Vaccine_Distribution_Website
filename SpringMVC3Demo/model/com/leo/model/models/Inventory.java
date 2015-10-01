package com.leo.model.models;

import com.infrastructure.project.base.model.interfaces.ICUDEable;
import com.infrastructure.project.base.model.models.EnableEntity;

public class Inventory extends EnableEntity<Integer> implements ICUDEable{
		
	
    private Vaccine vaccine;
    private int number;
    
	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
    
    
	
}
