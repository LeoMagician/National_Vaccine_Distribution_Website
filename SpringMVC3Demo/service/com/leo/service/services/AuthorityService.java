package com.leo.service.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.infrastructure.project.base.service.services.ChainEntityService;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.infrastructure.project.common.utilities.PageList;
import com.infrastructure.project.common.utilities.PageListUtil;
import com.leo.dao.interfaces.IAuthorityDao;
import com.leo.model.models.Authority;
import com.leo.service.interfaces.IAuthorityService;
import com.leo.service.models.AuthoritySearch;

@Service("AuthorityService")
public class AuthorityService extends ChainEntityService<Integer, Authority, IAuthorityDao> implements IAuthorityService {
	
	@Autowired
	public AuthorityService(@Qualifier("AuthorityDao")IAuthorityDao authorityDao){
		super(authorityDao);
	}
	
	@Override
	public void update(Authority model) throws ValidatException, EntityOperateException{
		Authority dbModel=super.get(model.getId());
		dbModel.setName(model.getName());
		dbModel.setPosition(model.getPosition());
		dbModel.setTheValue(model.getTheValue());
		dbModel.setUrl(model.getUrl());
		dbModel.setMatchUrl(model.getMatchUrl());
		dbModel.setItemIcon(model.getItemIcon());
		dbModel.setParent(model.getParent());
		super.update(dbModel);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public PageList<Authority> listPage(AuthoritySearch search, int pageNo, int pageSize) {		
		Criteria countCriteria = entityDao.getCriteria();
		Criteria listCriteria = entityDao.getCriteria();
		
        if(search!=null){
        	if(search.getName()!=null && !search.getName().isEmpty()){
        		countCriteria.add(Restrictions.eq("name", search.getName())); 
        		listCriteria.add(Restrictions.eq("name", search.getName())); 
        	}
        }
          	
        listCriteria.setFirstResult((pageNo-1)*pageSize);  
        listCriteria.setMaxResults(pageSize);
        List<Authority> items = listCriteria.list();
        countCriteria.setProjection(Projections.rowCount());
        Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
        return PageListUtil.getPageList(count, pageNo, items, pageSize);
    }

}
