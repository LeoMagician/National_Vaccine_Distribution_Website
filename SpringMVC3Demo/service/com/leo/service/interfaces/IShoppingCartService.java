package com.leo.service.interfaces;

import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.leo.dao.interfaces.IShoppingCartDAO;
import com.leo.model.models.ShoppingCart;

public interface IShoppingCartService extends IEnableEntityService<Integer, ShoppingCart, IShoppingCartDAO>{
	public void updateBind(Integer id, Integer vaccineId) throws ValidatException, EntityOperateException;
	public void orderBind(Integer id, Integer orderId) throws ValidatException, EntityOperateException;
}
