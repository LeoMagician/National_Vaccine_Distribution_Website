package com.leo.service.interfaces;

import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.leo.dao.interfaces.IQuotaDAO;
import com.leo.model.models.Quota;

public interface IQuotaService extends IEnableEntityService<Integer, Quota ,IQuotaDAO>{
	
	
	public Quota listQuotas(int stateId, String vaccineId) throws ValidatException, EntityOperateException;

}
