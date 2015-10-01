package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.EnableEntityDao;
import com.leo.dao.interfaces.IRoleDao;
import com.leo.model.models.Role;

@Repository("RoleDao")
public class RoleDao extends EnableEntityDao<Integer, Role> implements IRoleDao {


}
