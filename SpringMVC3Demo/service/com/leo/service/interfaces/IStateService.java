package com.leo.service.interfaces;

import java.util.List;

import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.utilities.PageList;
import com.leo.dao.interfaces.IStateDAO;
import com.leo.model.models.State;

public interface IStateService extends IEnableEntityService<Integer, State, IStateDAO>{

	public PageList<State> listPage(int pageNo, int pageSize);
	public List<State> listState();
	
}
