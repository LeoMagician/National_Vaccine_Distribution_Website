package com.leo.web.models;

import org.hibernate.validator.constraints.NotEmpty;

public class RoleEditModel {
	private Integer id;
	@NotEmpty(message="{name.not.empty}")
	private String name;	
	
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
}
