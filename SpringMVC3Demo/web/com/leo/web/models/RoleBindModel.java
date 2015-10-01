package com.leo.web.models;

import com.infrastructure.project.common.extension.ArrayHelper;

public class RoleBindModel {

	private String name;	
	private Integer[] authorityIds;

	public void setName(String name){
		this.name=name;
	}		
	public void setAuthorityIds(Integer[] authorityIds){
		this.authorityIds=authorityIds;
	}
		
	public String getName(){
		return this.name;
	}
	public Integer[] getAuthorityIds(){
		return this.authorityIds;
	}
	
	public String getAuthorityIdsString(){
		return ArrayHelper.toString(authorityIds, ",");
	}
	
}
