package com.leo.model.models;

import java.util.HashSet;
import java.util.Set;

import com.infrastructure.project.base.model.interfaces.ICUDEable;
import com.infrastructure.project.base.model.models.EnableEntity;

public class Hospital extends EnableEntity<Integer> implements ICUDEable{
		
	private String address;
	private State state;	
	private Set<Account> accounts = new HashSet();
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}		
	
}
