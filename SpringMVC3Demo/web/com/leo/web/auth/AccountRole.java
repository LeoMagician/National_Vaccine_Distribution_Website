package com.leo.web.auth;

import java.util.List;

public class AccountRole {
	
	private Integer id;
	private String name;
	private List<AuthorityMenu> authorityMenus;
	private List<PermissionMenu> permissionMenus;
	
	public AccountRole(Integer id, String name){
		this.id=id;
		this.name=name;
	}
	
	public void setId(Integer id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setPermissionMenus(List<PermissionMenu> permissionMenus){
		this.permissionMenus=permissionMenus;
	}
	public void setAuthorityMenus(List<AuthorityMenu> authorityMenus){
		this.authorityMenus=authorityMenus;
	}
	
	public Integer getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public List<PermissionMenu> getPermissionMenus(){
		return this.permissionMenus;
	}
	public List<AuthorityMenu> getAuthorityMenus(){
		return this.authorityMenus;
	}
	
}
