package com.leo.web.models.extension;

import com.leo.model.models.Organization;
import com.leo.web.models.OrganizationEditModel;

public class OrganizationModelExtension {
	
	public static Organization toOrganization(OrganizationEditModel editModel){
		Organization ret =new Organization();
		ret.setId(editModel.getId());
		ret.setName(editModel.getName());
		ret.setPosition(editModel.getPosition());
		ret.setTheValue(editModel.getTheValue());
		
		if(editModel.getParentId()!=null && editModel.getParentId()>0){
			Organization parent=new Organization();
			parent.setId(editModel.getParentId());
			ret.setParent(parent);
		}
		
		return ret;
	}
	
	public static OrganizationEditModel toOrganizationEditModel(Organization model){
		OrganizationEditModel ret=new OrganizationEditModel();
		ret.setId(model.getId());
		ret.setName(model.getName());
		ret.setPosition(model.getPosition());
		ret.setTheValue(model.getTheValue());
		
		if(model.getParent()!=null)
			ret.setParentId(model.getParent().getId());
		
		return ret;
	}
	
}