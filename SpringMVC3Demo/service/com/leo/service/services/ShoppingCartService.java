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
import com.leo.dao.interfaces.IShoppingCartDAO;
import com.leo.model.models.Cart;
import com.leo.model.models.ShoppingCart;
import com.leo.model.models.Vaccine;
import com.leo.service.interfaces.ICartService;
import com.leo.service.interfaces.IShoppingCartService;
import com.leo.service.interfaces.IVaccineService;

@Service("ShoppingCartService")
public class ShoppingCartService extends EnableEntityService<Integer, ShoppingCart, IShoppingCartDAO> implements IShoppingCartService{
		
	@Autowired
	@Qualifier("VaccineService")
	protected IVaccineService vaccineService;
	
	@Autowired
	@Qualifier("CartService")
	protected ICartService cartService;
	
	@Autowired
	public ShoppingCartService(@Qualifier("ShoppingCartDAO") IShoppingCartDAO shoppingCartDAO){
		super(shoppingCartDAO);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public PageList<ShoppingCart> listPage(int pageNo, int pageSize) {		
		Criteria countCriteria = entityDao.getCriteria();	
		Criteria listCriteria = entityDao.getCriteria();		
          						
        listCriteria.setFirstResult((pageNo-1)*pageSize);  
        listCriteria.setMaxResults(pageSize);
        List<ShoppingCart> items = listCriteria.list();
        countCriteria.setProjection(Projections.rowCount());
        Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
        return PageListUtil.getPageList(count, pageNo, items, pageSize);
    }
	
	@Override	
	public void updateBind(Integer id, Integer vaccineId) throws ValidatException, EntityOperateException{
		
		ShoppingCart dbOi = super.get(id);		
		if(vaccineId != null && vaccineId >0){
			Vaccine vaccine = vaccineService.get(vaccineId);
			dbOi.setVaccine(vaccine);			
		}else{
			dbOi.setVaccine(null);			
		}
		super.update(dbOi);		
		
	}
	
	@Override
	public void orderBind(Integer id, Integer orderId) throws ValidatException, EntityOperateException{
		ShoppingCart sc = super.get(id);
		System.out.println("test!!!!!!!:"+sc.getPrice());
		if(orderId != null && orderId > 0){
			Cart cart = cartService.get(orderId);	
			sc.setCart(cart);
			System.out.println("test!!!!!!!:"+sc.getCart().getId());
		}else{
			sc.setCart(null);
		}
//		super.update(dbOi);
		super.saveOrUpdate(sc);
		
	}
	
}
