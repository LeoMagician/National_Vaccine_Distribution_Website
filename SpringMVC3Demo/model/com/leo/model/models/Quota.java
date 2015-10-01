package com.leo.model.models;

import java.io.Serializable;

import com.infrastructure.project.base.model.interfaces.ICUDEable;
import com.infrastructure.project.base.model.models.EnableEntity;

public class Quota extends EnableEntity<Integer> implements ICUDEable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private State state;
	private Vaccine vaccine;
	private String stateId;
	private String vaccineId;
	private int quota;
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	public int getQuota() {
		return quota;
	}
	public void setQuota(int quota) {
		this.quota = quota;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(String vaccineId) {
		this.vaccineId = vaccineId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	
}
