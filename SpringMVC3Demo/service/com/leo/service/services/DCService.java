package com.leo.service.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.infrastructure.project.base.service.services.EnableEntityService;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.infrastructure.project.common.utilities.PageList;
import com.infrastructure.project.common.utilities.PageListUtil;
import com.leo.dao.interfaces.IDCDAO;
import com.leo.model.models.Account;
import com.leo.model.models.DC;
import com.leo.model.models.State;
import com.leo.service.interfaces.IAccountService;
import com.leo.service.interfaces.IDCService;
import com.leo.service.interfaces.IStateService;

@Service("DCService")
public class DCService extends EnableEntityService<Integer, DC, IDCDAO> implements IDCService{
	
	@Autowired
	@Qualifier("StateService")
	protected IStateService stateService;
	
//	@Autowired
//    @Qualifier("AccountService")
//    protected IAccountService accountService;
	
	@Autowired
	public DCService(@Qualifier("DCDAO") IDCDAO dao){
		super(dao);
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public PageList<DC> listPage(int pageNo, int pageSize){
		Criteria countCriteria = entityDao.getCriteria();	
		Criteria listCriteria = entityDao.getCriteria();
        
//		listCriteria.createAlias("account", "a");
//		listCriteria.add(Restrictions.eq("a.id", accountId));
        listCriteria.setFirstResult((pageNo-1)*pageSize);  
        listCriteria.setMaxResults(pageSize);        			
		List<DC> items = listCriteria.list();
        countCriteria.setProjection(Projections.rowCount());
        Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
        return PageListUtil.getPageList(count, pageNo, items, pageSize);
	}
	
	@Override
	public void updateBind(Integer id, Integer stateId) throws ValidatException, EntityOperateException{
		DC dbdc = super.get(id);
		if(stateId != null && stateId>0 ){
			State dbState = stateService.get(stateId);
//			Account dbAccount = accountService.get(accountId);
			dbdc.setState(dbState);
//			dbdc.setAccount(dbAccount);
		}else{
			dbdc.setState(null);
//			dbdc.setAccount(null);
		}
		super.update(dbdc);
	}

}
