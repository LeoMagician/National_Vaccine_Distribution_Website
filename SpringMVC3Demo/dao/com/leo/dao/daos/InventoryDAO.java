package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.EnableEntityDao;
import com.leo.dao.interfaces.IInventoryDAO;
import com.leo.model.models.Inventory;

@Repository("InventoryDAO")
public class InventoryDAO extends EnableEntityDao<Integer, Inventory> implements IInventoryDAO{
	
}
