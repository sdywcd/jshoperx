package com.jshoperx.dao.impl;

import com.jshoperx.dao.GoodsCategoryTDao;
import com.jshoperx.entity.GoodsCategoryT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("goodsCategoryTDao")
public class GoodsCategoryTDaoImpl extends BaseTDaoImpl<GoodsCategoryT> implements GoodsCategoryTDao {
	

	private static final Logger log = LoggerFactory.getLogger(GoodsCategoryTDaoImpl.class);

	
}
