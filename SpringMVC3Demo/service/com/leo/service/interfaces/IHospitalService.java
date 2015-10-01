package com.leo.service.interfaces;

import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.infrastructure.project.common.utilities.PageList;
import com.leo.dao.interfaces.IHospitalDAO;
import com.leo.model.models.Hospital;

public interface IHospitalService extends IEnableEntityService<Integer, Hospital, IHospitalDAO>{
	public PageList<Hospital> listPage(int pageNo, int pageSize);
	public void updateBind(Integer id, Integer stateId) throws ValidatException, EntityOperateException;
//	public void hospitalBind(Integer id, Integer hospitalId) throws ValidatException, EntityOperateException;
}
