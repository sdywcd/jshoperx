package com.jshoperx.dao.impl;

import com.jshoperx.dao.GoodsTypeBrandTDao;
import com.jshoperx.entity.GoodsTypeBrandT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("goodsTypeBrandTDao")
public class GoodsTypeBrandTDaoImpl extends BaseTDaoImpl<GoodsTypeBrandT> implements GoodsTypeBrandTDao {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsTypeBrandTDaoImpl.class);
	

}