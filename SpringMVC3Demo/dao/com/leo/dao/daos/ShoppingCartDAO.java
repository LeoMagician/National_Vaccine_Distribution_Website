package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.EnableEntityDao;
import com.leo.dao.interfaces.IShoppingCartDAO;
import com.leo.model.models.ShoppingCart;

@Repository("ShoppingCartDAO")
public class ShoppingCartDAO extends EnableEntityDao<Integer, ShoppingCart> implements IShoppingCartDAO{

}
