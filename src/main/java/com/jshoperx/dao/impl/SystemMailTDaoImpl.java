package com.jshoperx.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshoperx.dao.SystemMailTDao;
import com.jshoperx.entity.SystemMailT;


@Repository("systemMailTDao")
public class SystemMailTDaoImpl extends BaseTDaoImpl<SystemMailT> implements SystemMailTDao {
	
	private static final Logger log = LoggerFactory.getLogger(SystemMailTDaoImpl.class);

	
}
