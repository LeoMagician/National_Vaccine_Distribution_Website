package com.leo.web.models.extension;

import com.leo.model.models.Role;
import com.leo.web.models.RoleBindModel;

public class RoleBindModelExtension {
	
	public static RoleBindModel toRoleBindModel(Role role){
		RoleBindModel ret=new RoleBindModel();
		ret.setName(role.getName());
		
		return ret;
	}
	
}
