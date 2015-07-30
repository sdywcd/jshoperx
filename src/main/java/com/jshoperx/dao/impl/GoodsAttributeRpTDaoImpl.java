package com.jshoperx.dao.impl;

import com.jshoperx.dao.GoodsAttributeRpTDao;
import com.jshoperx.entity.GoodsAttributeRpT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
@Repository("goodsAttributeRpTDao")
public class GoodsAttributeRpTDaoImpl extends BaseTDaoImpl<GoodsAttributeRpT>  implements GoodsAttributeRpTDao {
	private static final Logger log = LoggerFactory.getLogger(GoodsAttributeRpTDaoImpl.class);


}
