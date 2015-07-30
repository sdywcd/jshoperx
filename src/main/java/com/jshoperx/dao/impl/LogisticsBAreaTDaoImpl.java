package com.jshoperx.dao.impl;

import com.jshoperx.dao.LogisticsBAreaTDao;
import com.jshoperx.entity.LogisticsbusinessareaT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("logisticsBAreaTDao")
public class LogisticsBAreaTDaoImpl extends BaseTDaoImpl<LogisticsbusinessareaT> implements LogisticsBAreaTDao {

	private static final Logger log = LoggerFactory.getLogger(LogisticsBAreaTDaoImpl.class);


}