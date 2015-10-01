package com.leo.service.interfaces;

import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.infrastructure.project.common.utilities.PageList;
import com.leo.dao.interfaces.IDCDAO;
import com.leo.model.models.DC;

public interface IDCService extends IEnableEntityService<Integer, DC, IDCDAO>{
	
	public PageList<DC> listPage(int pageNo, int pageSize);
	public void updateBind(Integer id, Integer stateId) throws ValidatException, EntityOperateException;
}
