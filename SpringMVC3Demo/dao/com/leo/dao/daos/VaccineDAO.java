package com.leo.dao.daos;

import org.springframework.stereotype.Repository;

import com.infrastructure.project.base.dao.daos.EnableEntityDao;
import com.leo.dao.interfaces.IVaccineDAO;
import com.leo.model.models.Vaccine;

@Repository("VaccineDAO")
public class VaccineDAO extends EnableEntityDao<Integer, Vaccine> implements IVaccineDAO{

}
