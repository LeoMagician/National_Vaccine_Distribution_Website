package com.leo.service.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.infrastructure.project.base.service.services.EnableEntityService;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.infrastructure.project.common.utilities.PageList;
import com.infrastructure.project.common.utilities.PageListUtil;
import com.leo.dao.interfaces.IHospitalDAO;
import com.leo.model.models.Hospital;
import com.leo.model.models.State;
import com.leo.service.interfaces.IAccountService;
import com.leo.service.interfaces.IHospitalService;
import com.leo.service.interfaces.IStateService;

@Service("HospitalService")
public class HospitalService extends EnableEntityService<Integer, Hospital, IHospitalDAO> implements IHospitalService{
	
	@Autowired
	@Qualifier("StateService")
	protected IStateService stateService;
	
	@Autowired
	@Qualifier("AccountService")
	protected IAccountService accountService;
	
	@Autowired
	public HospitalService(@Qualifier("HospitalDAO") IHospitalDAO hospitalDAO){
		super(hospitalDAO);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public PageList<Hospital> listPage(int pageNo, int pageSize){
		Criteria countCriteria = entityDao.getCriteria();	
		Criteria listCriteria = entityDao.getCriteria();
        
//		listCriteria.createAlias("account", "acc");
//		listCriteria.add(Restrictions.eq("acc.id", userid));
        listCriteria.setFirstResult((pageNo-1)*pageSize);  
        listCriteria.setMaxResults(pageSize);        			
		List<Hospital> items = listCriteria.list();
        countCriteria.setProjection(Projections.rowCount());
        Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
        return PageListUtil.getPageList(count, pageNo, items, pageSize);
	}
	
	@Override
	public void updateBind(Integer id, Integer stateId) throws ValidatException, EntityOperateException{
		Hospital dbHospital = super.get(id);
		if(stateId != null && stateId>0){
			State dbState = stateService.get(stateId);
			dbHospital.setState(dbState);
		}else
			dbHospital.setState(null);
		super.update(dbHospital);
	}
	
	
//	@Override
//	public void hospitalBind(Integer id, Integer accountlId) throws ValidatException, EntityOperateException{
//		Hospital dbHospital=super.get(id);
//		if(accountlId!=null && accountlId>0){
//			Account account=accountService.get(accountlId);
//			dbHospital.setAccount(account);
//		}
//		else
//			dbHospital.setAccount(null);
//		super.update(dbHospital);
//	}
	
}
