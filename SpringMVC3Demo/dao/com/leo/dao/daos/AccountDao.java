package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.EnableEntityDao;
import com.leo.dao.interfaces.IAccountDao;
import com.leo.model.models.Account;

@Repository("AccountDao")
public class AccountDao extends EnableEntityDao<Integer, Account> implements IAccountDao {


}
