package com.leo.web.models.extension;


import com.leo.model.models.Hospital;
import com.leo.web.models.HospitalEditModel;

public class HospitalModelExtension {
	
	public static Hospital toHospital(HospitalEditModel editModel){
		Hospital hospital = new Hospital();
		hospital.setId(editModel.getId());
		hospital.setName(editModel.getName());
		hospital.setAddress(editModel.getAddress());
		return hospital;
		
	}
	
}
