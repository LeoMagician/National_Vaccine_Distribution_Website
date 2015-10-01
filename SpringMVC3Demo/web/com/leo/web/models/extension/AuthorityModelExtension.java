package com.leo.web.models.extension;

import com.leo.model.models.Authority;
import com.leo.service.models.AuthoritySearch;
import com.leo.web.models.AuthorityEditModel;
import com.leo.web.models.AuthoritySearchModel;

public class AuthorityModelExtension {
	public static AuthoritySearch toAuthoritySearch(AuthoritySearchModel searchModel){
		AuthoritySearch ret=new AuthoritySearch();
		ret.setName(searchModel.getName());
		
		return ret;
	}
	
	public static Authority toAuthority(AuthorityEditModel editModel){
		Authority ret =new Authority();
		ret.setId(editModel.getId());
		ret.setName(editModel.getName());
		ret.setPosition(editModel.getPosition());
		ret.setTheValue(editModel.getTheValue());
		ret.setUrl(editModel.getUrl());
		ret.setMatchUrl(editModel.getMatchUrl());
		ret.setItemIcon(editModel.getItemIcon());
		
		if(editModel.getParentId()!=null && editModel.getParentId()!=null && editModel.getParentId()>0){
			Authority parent=new Authority();
			parent.setId(editModel.getParentId());
			ret.setParent(parent);
		}
		
		return ret;
	}
	
	public static AuthorityEditModel toAuthorityEditModel(Authority model){
		AuthorityEditModel ret=new AuthorityEditModel();
		ret.setId(model.getId());
		ret.setName(model.getName());
		ret.setPosition(model.getPosition());
		ret.setTheValue(model.getTheValue());
		ret.setUrl(model.getUrl());
		ret.setMatchUrl(model.getMatchUrl());
		ret.setItemIcon(model.getItemIcon());
		
		if(model.getParent()!=null)
			ret.setParentId(model.getParent().getId());
		
		return ret;
	}
}