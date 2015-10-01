package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.EnableEntityDao;
import com.leo.dao.interfaces.IStateDAO;
import com.leo.model.models.State;

@Repository("StateDAO")
public class StateDAO extends EnableEntityDao<Integer, State> implements IStateDAO{
	
}
