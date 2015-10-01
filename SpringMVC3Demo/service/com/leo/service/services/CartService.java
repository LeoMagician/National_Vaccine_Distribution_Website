package com.leo.service.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.infrastructure.project.base.service.services.EnableEntityService;
import com.infrastructure.project.common.utilities.PageList;
import com.infrastructure.project.common.utilities.PageListUtil;
import com.leo.dao.interfaces.ICartDAO;
import com.leo.model.models.Cart;
import com.leo.model.models.OrderItem;
import com.leo.service.interfaces.ICartService;


@Service("CartService")
public class CartService extends EnableEntityService<Integer, Cart, ICartDAO> implements ICartService{
	
	@Autowired
	public CartService(@Qualifier("CartDAO") ICartDAO dao){
		super(dao);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public PageList<Cart> listPage(int pageNo, int pageSize,String accountid) {		
		Criteria countCriteria = entityDao.getCriteria();	
		Criteria listCriteria = entityDao.getCriteria();		
          					
		listCriteria.add(Restrictions.eq("accountId", accountid));
        listCriteria.setFirstResult((pageNo-1)*pageSize);  
        listCriteria.setMaxResults(pageSize);
        List<Cart> items = listCriteria.list();
        countCriteria.setProjection(Projections.rowCount());
        Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
        return PageListUtil.getPageList(count, pageNo, items, pageSize);
    }
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cart> listCarts(){
		
		Criteria listCriteria = entityDao.getCriteria();							
        
        List<Cart> items = listCriteria.list();
        return items;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cart> listRecieveCarts(){
		Criteria listCriteria = entityDao.getCriteria();							
        
		listCriteria.add(Restrictions.eq("hosEnable", false));
        List<Cart> items = listCriteria.list();
        return items;
	}
	
	
}
