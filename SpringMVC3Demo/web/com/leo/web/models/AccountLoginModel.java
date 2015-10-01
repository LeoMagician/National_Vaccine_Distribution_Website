package com.leo.web.models;

import org.hibernate.validator.constraints.NotEmpty;

public class AccountLoginModel {
	
	@NotEmpty(message="{username.not.empty}")
	private String username;
	@NotEmpty(message="{password.not.empty}")	
	private String password;
	
	public void setUsername(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
}
