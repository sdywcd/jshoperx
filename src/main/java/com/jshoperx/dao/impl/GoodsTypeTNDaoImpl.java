package com.jshoperx.dao.impl;

import com.jshoperx.dao.GoodsTypeTNDao;
import com.jshoperx.entity.GoodsTypeTN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("goodsTypeTNDao")
public class GoodsTypeTNDaoImpl extends BaseTDaoImpl<GoodsTypeTN> implements GoodsTypeTNDao {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsTypeTNDaoImpl.class);

	
}