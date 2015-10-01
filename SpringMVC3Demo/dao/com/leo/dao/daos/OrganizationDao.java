package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.ChainEntityDao;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.leo.dao.interfaces.IOrganizationDao;
import com.leo.model.models.Organization;

@Repository("OrganizationDao")
public class OrganizationDao extends ChainEntityDao<Integer, Organization> implements IOrganizationDao {

	@Override
	public void delete(Organization organization) throws EntityOperateException, ValidatException{
		super.checkNull(organization);
		super.checkUpdatable(organization);
		if(organization.getChildren()!=null && !organization.getChildren().isEmpty())
    		throw new ValidatException("The entity has children can't be delete!");
    	else
    		super.getSession().delete(organization);
	}

}
