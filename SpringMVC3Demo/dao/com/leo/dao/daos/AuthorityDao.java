package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.ChainEntityDao;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.leo.dao.interfaces.IAuthorityDao;
import com.leo.model.models.Authority;

@Repository("AuthorityDao")
public class AuthorityDao extends ChainEntityDao<Integer, Authority> implements IAuthorityDao {

	@Override
	public void delete(Authority authority) throws EntityOperateException, ValidatException{
		super.checkNull(authority);
		super.checkUpdatable(authority);
		if(authority.getChildren()!=null && !authority.getChildren().isEmpty())
    		throw new ValidatException("The entity has children can't be delete!");
		else if(authority.getRoles()!=null && !authority.getRoles().isEmpty())
			throw new ValidatException("the entity had been authorized can't be delete!");
    	else
    		super.getSession().delete(authority);
	}

}
