package com.jshoperx.dao.impl;

import com.jshoperx.dao.LogisticsBTDao;
import com.jshoperx.entity.LogisticsBusinessT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("logisticsBTDao")
public class LogisticsBTDaoImpl extends BaseTDaoImpl<LogisticsBusinessT> implements LogisticsBTDao {


	private static final Logger log = LoggerFactory.getLogger(GoodsAttributeTDaoImpl.class);


}