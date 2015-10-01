package com.leo.web.models;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class OrganizationEditModel {

	private Integer id;
	@NotEmpty(message="{name.not.empty}")
	private String name;	
	@NotNull(message="{position.not.null}")
	private int position;
	private String theValue;
	private Integer parentId;

	public void setId(Integer id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}	
	public void setPosition(int position){
		this.position=position;
	}
	public void setTheValue(String theValue){
		this.theValue=theValue;
	}
	public void setParentId(Integer parentId){
		this.parentId=parentId;
	}
	
	public Integer getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public int getPosition(){
		return this.position;
	}
	public String getTheValue(){
		return this.theValue;
	}
	public Integer getParentId(){
		return this.parentId;
	}
	
}
