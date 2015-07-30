package com.jshoperx.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshoperx.dao.GoodsCardsTDao;
import com.jshoperx.entity.GoodsCardsT;

@Repository("goodsCardsTDao")
public class GoodsCardsTDaoImpl extends BaseTDaoImpl<GoodsCardsT> implements GoodsCardsTDao{
	private static final Logger log = LoggerFactory.getLogger(GoodsCardsTDaoImpl.class);

}
