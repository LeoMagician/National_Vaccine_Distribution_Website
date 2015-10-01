package com.leo.service.interfaces;

import com.infrastructure.project.base.service.interfaces.IChainEntityService;
import com.infrastructure.project.common.utilities.PageList;
import com.leo.dao.interfaces.IAuthorityDao;
import com.leo.model.models.Authority;
import com.leo.service.models.AuthoritySearch;

public interface IAuthorityService extends IChainEntityService<Integer, Authority, IAuthorityDao> {

	public PageList<Authority> listPage(AuthoritySearch search, int pageNo, int pageSize);
	
}