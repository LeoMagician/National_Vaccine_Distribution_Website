package com.leo.web.jsonmodels;

public class BaseBtn {
	private String type;
	private String name;
	
	public void setType(String type){
		this.type=type;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public String getType(){
		return this.type;
	}
	public String getName(){
		return this.name;
	}
}
