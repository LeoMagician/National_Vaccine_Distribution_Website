package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.EnableEntityDao;
import com.leo.dao.interfaces.IQuotaDAO;
import com.leo.model.models.Quota;

@Repository("QuotaDAO")
public class QuotaDAO extends EnableEntityDao<Integer, Quota> implements IQuotaDAO{

}
