package com.jshoperx.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshoperx.dao.GoodsGroupTDao;
import com.jshoperx.entity.GoodsGroupT;
@Repository("goodsGroupTDao")
public class GoodsGroupTDaoImpl extends BaseTDaoImpl<GoodsGroupT> implements GoodsGroupTDao {
	private static final Logger log = LoggerFactory.getLogger(GoodsGroupTDaoImpl.class);
	


}
