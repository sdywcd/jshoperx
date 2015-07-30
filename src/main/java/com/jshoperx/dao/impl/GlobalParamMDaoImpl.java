package com.jshoperx.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshoperx.dao.GlobalParamMDao;
import com.jshoperx.entity.GlobalParamM;


@Repository("globalParamMDao")
public class GlobalParamMDaoImpl extends BaseTDaoImpl<GlobalParamM> implements GlobalParamMDao {
	

	private static final Logger log = LoggerFactory.getLogger(GlobalParamMDaoImpl.class);
	

	
}