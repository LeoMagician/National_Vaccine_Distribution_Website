package com.leo.service.interfaces;

import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.utilities.PageList;
import com.leo.dao.interfaces.IVaccineDAO;
import com.leo.model.models.Vaccine;

public interface IVaccineService extends IEnableEntityService<Integer, Vaccine, IVaccineDAO>{
	
	public PageList<Vaccine> listPage(int pageNo, int pageSize);
	
}
