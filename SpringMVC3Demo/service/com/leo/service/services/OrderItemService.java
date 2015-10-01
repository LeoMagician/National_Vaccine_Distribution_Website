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
import com.leo.dao.interfaces.IOrderItemDAO;
import com.leo.model.models.OrderItem;
import com.leo.model.models.Vaccine;
import com.leo.service.interfaces.ICartService;
import com.leo.service.interfaces.IOrderItemService;
import com.leo.service.interfaces.IVaccineService;

@Service("OrderItemService")
public class OrderItemService extends EnableEntityService<Integer, OrderItem, IOrderItemDAO> implements IOrderItemService{

	@Autowired
	@Qualifier("VaccineService")
	protected IVaccineService vaccineService;
	
	@Autowired
	@Qualifier("CartService")
	protected ICartService cartService;
	
	@Autowired
	public OrderItemService(@Qualifier("OrderItemDAO") IOrderItemDAO dao) {
		super(dao);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public PageList<OrderItem> listPage(int pageNo, int pageSize) {		
		Criteria countCriteria = entityDao.getCriteria();	
		Criteria listCriteria = entityDao.getCriteria();		
          				
		listCriteria.add(Restrictions.isNull("cartId"));
        listCriteria.setFirstResult((pageNo-1)*pageSize);  
        listCriteria.setMaxResults(pageSize);
        List<OrderItem> items = listCriteria.list();
        countCriteria.setProjection(Projections.rowCount());
        Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
        return PageListUtil.getPageList(count, pageNo, items, pageSize);
    }
	
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderItem> listOrderItem(int cartid) {		
		
		Criteria listCriteria = entityDao.getCriteria();		
          				
		listCriteria.add(Restrictions.eq("cartId",String.valueOf(cartid)));
       
        List<OrderItem> items = listCriteria.list();
        
        return items;
    }
	
	
	@Override
	public void updateBind(Integer id, Integer vaccineId) throws ValidatException, EntityOperateException{
		
		OrderItem dbOi = super.get(id);
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
		OrderItem dbOi = super.get(id);
		super.delete(dbOi);
//		System.out.println("test!!!!!!!:"+dbOi.getId());
//		
//		if(orderId != null && orderId > 0){
////			Cart cart = cartService.get(orderId);
////			dbOi.setCart(cart);
//			dbOi.setCartId(String.valueOf(orderId));
//			dbOi.setAmount(250);
//		}
//		else{
//			dbOi.setCartId(null);
//		}
//		System.out.println("test!!!!!!!:"+dbOi.getCartId());
////		super.update(dbOi);
//		super.saveOrUpdate(dbOi);
	}
	
}
