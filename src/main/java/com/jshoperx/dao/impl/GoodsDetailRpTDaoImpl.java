package com.jshoperx.dao.impl;

import com.jshoperx.dao.GoodsDetailRpTDao;
import com.jshoperx.entity.GoodsDetailRpT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("goodsDetailRpTDao")
public class GoodsDetailRpTDaoImpl extends BaseTDaoImpl<GoodsDetailRpT>
		implements GoodsDetailRpTDao {
	private static final Logger log = LoggerFactory
			.getLogger(ArticleCategoryTDaoImpl.class);


}
