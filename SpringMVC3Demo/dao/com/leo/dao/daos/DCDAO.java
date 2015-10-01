package com.leo.dao.daos;

import org.springframework.stereotype.Repository;
import com.infrastructure.project.base.dao.daos.EnableEntityDao;
import com.leo.dao.interfaces.IDCDAO;
import com.leo.model.models.DC;

@Repository("DCDAO")
public class DCDAO extends EnableEntityDao<Integer, DC> implements IDCDAO{

}
