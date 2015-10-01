package com.leo.service.interfaces;

import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.infrastructure.project.common.utilities.PageList;
import com.leo.dao.interfaces.IRoleDao;
import com.leo.model.models.Role;
import com.leo.service.models.RoleSearch;

public interface IRoleService extends IEnableEntityService<Integer, Role, IRoleDao> {

	public PageList<Role> listPage(RoleSearch search, int pageNo, int pageSize);
	public void saveAuthorize(Integer roleId, Integer[] authorityIds) throws ValidatException, EntityOperateException;
	
}