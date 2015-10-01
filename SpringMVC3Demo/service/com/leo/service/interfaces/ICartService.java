package com.leo.service.interfaces;

import java.util.List;

import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.utilities.PageList;
import com.leo.dao.interfaces.ICartDAO;
import com.leo.model.models.Cart;

public interface ICartService extends IEnableEntityService<Integer, Cart, ICartDAO>{

	public PageList<Cart> listPage(int pageNo, int pageSize,String accountid);
	public List<Cart> listCarts();
	public List<Cart> listRecieveCarts();
}
