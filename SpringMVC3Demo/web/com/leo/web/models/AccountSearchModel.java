package com.leo.web.models;

public class AccountSearchModel {
	private String name;
	private String username;
	
	public void setName(String name){
		this.name=name;
	}
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getName(){
		return this.name;
	}
	public String getUsername(){
		return this.username;
	}
}
