package com.leo.web.models.extension;

import com.leo.model.models.Role;
import com.leo.service.models.RoleSearch;
import com.leo.web.models.RoleEditModel;
import com.leo.web.models.RoleSearchModel;

public class RoleModelExtension {
	public static RoleSearch toRoleSearch(RoleSearchModel searchModel){
		RoleSearch ret=new RoleSearch();
		ret.setName(searchModel.getName());
		
		return ret;
	}
	
	public static Role toRole(RoleEditModel editModel){
		Role role=new Role();
		role.setId(editModel.getId());
		role.setName(editModel.getName());
		return role;
	}
	

	public static RoleEditModel toRoleEdit(Role model) {
		RoleEditModel role=new RoleEditModel();
		role.setId(model.getId());
		role.setName(model.getName());
		return role;
		
	}
}
