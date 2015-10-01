package com.leo.web.models.extension;

import com.leo.model.models.Vaccine;
import com.leo.web.models.VaccineEditModel;

public class VaccineModelExtension {
	
	public static Vaccine toVaccine(VaccineEditModel editModel){
		Vaccine vaccine = new Vaccine();
		vaccine.setId(editModel.getId());
		vaccine.setName(editModel.getName());
		vaccine.setMfd(editModel.getMfd());
		vaccine.setExp(editModel.getExp());
		vaccine.setVaccineType(editModel.getVaccineType());
		vaccine.setAvailability(editModel.getAvailability());
		vaccine.setPrice(editModel.getPrice());
		vaccine.setDisease(editModel.getDisease());
		return vaccine;
	}
		
	public static VaccineEditModel toVaccineEdit(Vaccine vaccine){
		VaccineEditModel vem = new VaccineEditModel();
		vem.setId(vaccine.getId());
		vem.setName(vaccine.getName());
		vem.setMfd(vaccine.getMfd());
		vem.setExp(vaccine.getExp());
		vem.setVaccineType(vaccine.getVaccineType());
		vem.setAvailability(vaccine.getAvailability());
		vem.setPrice(vaccine.getPrice());
		vem.setDisease(vaccine.getDisease());
		return vem;
	}
	
	
}
