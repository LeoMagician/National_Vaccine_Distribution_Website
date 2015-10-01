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
import com.leo.dao.interfaces.IVaccineDAO;
import com.leo.model.models.Vaccine;
import com.leo.service.interfaces.IVaccineService;

@Service("VaccineService")
public class VaccineService extends EnableEntityService<Integer, Vaccine, IVaccineDAO> implements IVaccineService{

	@Autowired
	public VaccineService(@Qualifier("VaccineDAO") IVaccineDAO vaccineDAO){
		super(vaccineDAO);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public PageList<Vaccine> listPage(int pageNo, int pageSize) {		
		Criteria countCriteria = entityDao.getCriteria();	
		Criteria listCriteria = entityDao.getCriteria();		
          	
        listCriteria.setFirstResult((pageNo-1)*pageSize);  
        listCriteria.setMaxResults(pageSize);
        List<Vaccine> items = listCriteria.list();
        countCriteria.setProjection(Projections.rowCount());
        Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
        return PageListUtil.getPageList(count, pageNo, items, pageSize);
    }
	
	
	
}
