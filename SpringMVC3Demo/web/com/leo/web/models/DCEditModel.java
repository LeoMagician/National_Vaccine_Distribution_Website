package com.leo.web.models;

import org.hibernate.validator.constraints.NotEmpty;

public class DCEditModel {
	
	private Integer id;
	@NotEmpty(message="{name.not.empty}")
	private String name;	
	private String address;
	private int stateId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	
	

}
