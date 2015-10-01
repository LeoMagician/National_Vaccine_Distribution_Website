package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.EnableEntityDao;
import com.leo.dao.interfaces.IOrderItemDAO;
import com.leo.model.models.OrderItem;

@Repository("OrderItemDAO")
public class OrderItemDAO extends EnableEntityDao<Integer, OrderItem> implements IOrderItemDAO{

}
