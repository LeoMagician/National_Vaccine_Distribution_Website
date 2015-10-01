package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.EnableEntityDao;
import com.leo.dao.interfaces.IHospitalDAO;
import com.leo.model.models.Hospital;

@Repository("HospitalDAO")
public class HospitalDAO extends EnableEntityDao<Integer, Hospital> implements IHospitalDAO{
	
}
