package com.leo.service.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.infrastructure.project.base.service.services.EnableEntityService;
import com.infrastructure.project.common.utilities.PageList;
import com.infrastructure.project.common.utilities.PageListUtil;
import com.leo.dao.interfaces.IStateDAO;
import com.leo.model.models.State;
import com.leo.service.interfaces.IStateService;

@Service("StateService")
public class StateService extends EnableEntityService<Integer, State, IStateDAO> implements IStateService{

	
	@Autowired
	public StateService(@Qualifier("StateDAO") IStateDAO stateDAO){
		super(stateDAO);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public PageList<State> listPage(int pageNo, int pageSize) {		
		Criteria countCriteria = entityDao.getCriteria();	
		Criteria listCriteria = entityDao.getCriteria();
          	
        listCriteria.setFirstResult((pageNo-1)*pageSize);  
        listCriteria.setMaxResults(pageSize);
        List<State> items = listCriteria.list();
        countCriteria.setProjection(Projections.rowCount());
        Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
        return PageListUtil.getPageList(count, pageNo, items, pageSize);
    }
	
	@Override
	@SuppressWarnings("unchecked")
	public List<State> listState(){
		Criteria listCriteria = entityDao.getCriteria();
		List<State> items = listCriteria.list();
		return items;
	}	
	
}
