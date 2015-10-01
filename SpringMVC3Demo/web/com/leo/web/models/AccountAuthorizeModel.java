package com.leo.web.models;

public class AccountAuthorizeModel {

	private String name;
	private String username;
	private Integer roleId;
	private Integer organizationId;

	public void setName(String name){
		this.name=name;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setRoleId(Integer roleId){
		this.roleId=roleId;
	}
	public void setOrganizationId(Integer organizationId){
		this.organizationId=organizationId;
	}
	
	public String getName(){
		return this.name;
	}
	public String getUsername(){
		return this.username;
	}
	public Integer getRoleId(){
		return this.roleId;
	}
	public Integer getOrganizationId(){
		return this.organizationId;
	}
	
}
