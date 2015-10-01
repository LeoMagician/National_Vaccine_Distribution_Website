package com.leo.service.interfaces;

import com.infrastructure.project.base.service.interfaces.IChainEntityService;
import com.infrastructure.project.common.utilities.PageList;
import com.leo.dao.interfaces.IOrganizationDao;
import com.leo.model.models.Organization;

public interface IOrganizationService extends IChainEntityService<Integer, Organization, IOrganizationDao> {

	public PageList<Organization> listPage(String name, int pageNo, int pageSize);
	
}