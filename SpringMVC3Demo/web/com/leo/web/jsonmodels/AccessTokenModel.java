package com.leo.web.jsonmodels;

public class AccessTokenModel {
	private String access_token;
	private Integer expires_in;
	
	public void setAccess_token(String access_token){
		this.access_token=access_token;
	}
	public void setExpires_in(Integer expires_in){
		this.expires_in=expires_in;
	}
	
	public String getAccess_token(){
		return this.access_token;
	}
	public Integer getExpires_in(){
		return this.expires_in;
	}
}
