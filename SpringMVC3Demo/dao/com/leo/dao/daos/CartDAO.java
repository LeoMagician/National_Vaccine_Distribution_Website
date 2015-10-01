package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.EnableEntityDao;
import com.leo.dao.interfaces.ICartDAO;
import com.leo.model.models.Cart;

@Repository("CartDAO")
public class CartDAO extends EnableEntityDao<Integer, Cart> implements ICartDAO{

}
