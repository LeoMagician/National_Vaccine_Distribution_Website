package com.leo.web.models;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class AuthorityEditModel {

	private Integer id;
	@NotEmpty(message="{name.not.empty}")
	private String name;
	@NotNull(message="{position.not.null}")
	private int position;
	private String theValue;
	@NotEmpty(message="{url.not.empty}")
	private String url;
	@NotEmpty(message="{matchUrl.not.empty}")
	private String matchUrl;
	private String itemIcon;
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
	public void setUrl(String url){
		this.url=url;
	}
	public void setMatchUrl(String matchUrl){
		this.matchUrl=matchUrl;
	}
	public void setItemIcon(String itemIcon){
		this.itemIcon=itemIcon;
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
	public String getUrl(){
		return this.url;
	}
	public String getMatchUrl(){
		return this.matchUrl;
	}
	public String getItemIcon(){
		return this.itemIcon;
	}
	public Integer getParentId(){
		return this.parentId;
	}
	
}
