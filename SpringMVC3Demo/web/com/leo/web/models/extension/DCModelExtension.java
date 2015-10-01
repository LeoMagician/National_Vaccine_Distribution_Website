package com.leo.web.models.extension;

import com.leo.model.models.DC;
import com.leo.web.models.DCEditModel;

public class DCModelExtension {
	
	public static DC toDC(DCEditModel editModel){
		DC dc = new DC();
		dc.setId(editModel.getId());
		dc.setName(editModel.getName());
		dc.setAddress(editModel.getAddress());
		return dc;
		
	}
	
}
