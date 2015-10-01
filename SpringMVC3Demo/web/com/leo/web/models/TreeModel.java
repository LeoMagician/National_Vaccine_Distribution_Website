package com.leo.web.models;

import java.util.List;

public class TreeModel {
	
	private String id;
	private String value;
	private String text;	
	private boolean checked;
	private boolean selected;
	private boolean collpase;
	private List<TreeModel> children;
	
	public TreeModel(){}
	
	/*public TreeModel(String id, String value, String text, boolean checked, boolean selected){
		this.id=id;
		this.value=value;
		this.text=text;
		this.checked=checked;
		this.selected=selected;
		this.collpase=false;
		this.children=null;
	}*/
	
	public TreeModel(String id, String value, String text, boolean checked, boolean selected, boolean collpase, List<TreeModel> children){
		this.id=id;
		this.value=value;
		this.text=text;
		this.checked=checked;
		this.selected=selected;
		this.collpase=collpase;
		this.children=children;
	}
	
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return this.id;
	}
	
	public void setValue(String value){
		this.value=value;
	}
	public String getValue(){
		return this.value;
	}
	
	public void setText(String text){
		this.text=text;
	}
	public String getText(){
		return this.text;
	}
	
	public void setChecked(boolean checked){
		this.checked=checked;
	}
	public boolean getChecked(){
		return this.checked;
	}
	
	public void setSelected(boolean selected){
		this.selected=selected;
	}
	public boolean getSelected(){
		return this.selected;
	}
	
	public void setCollpase(boolean collpase){
		this.collpase=collpase;
	}
	public boolean getCollpase(){
		return this.collpase;
	}
	
	public void setChildren(List<TreeModel> children){
		this.children=children;
	}
	public List<TreeModel> getChildren(){
		return this.children;
	}

}
