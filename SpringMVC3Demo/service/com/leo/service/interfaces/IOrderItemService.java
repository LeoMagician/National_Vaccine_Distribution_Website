package com.leo.service.interfaces;

import java.util.List;

import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.leo.dao.interfaces.IOrderItemDAO;
import com.leo.model.models.OrderItem;

public interface IOrderItemService extends IEnableEntityService<Integer, OrderItem, IOrderItemDAO>{
	
	public void updateBind(Integer id, Integer vaccineId) throws ValidatException, EntityOperateException;
	public void orderBind(Integer id, Integer orderId) throws ValidatException, EntityOperateException;
	public List<OrderItem> listOrderItem(int cartid) throws ValidatException, EntityOperateException;

}
