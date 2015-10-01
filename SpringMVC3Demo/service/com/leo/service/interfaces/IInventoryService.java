package com.leo.service.interfaces;

import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.utilities.PageList;
import com.leo.dao.interfaces.IInventoryDAO;
import com.leo.model.models.Inventory;

public interface IInventoryService extends IEnableEntityService<Integer, Inventory, IInventoryDAO>{
	public PageList<Inventory> listPage(int pageNo, int pageSize);
}
