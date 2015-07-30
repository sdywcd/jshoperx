package com.jshoperx.dao.impl;

import com.jshoperx.dao.GoodsTDao;
import com.jshoperx.entity.GoodsT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("goodsTDao")
public class GoodsTDaoImpl extends BaseTDaoImpl<GoodsT> implements GoodsTDao {


	private static final Logger log = LoggerFactory.getLogger(GoodsTDaoImpl.class);


}