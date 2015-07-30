package com.jshoperx.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshoperx.dao.TemplatethemeTDao;
import com.jshoperx.entity.TemplatethemeT;


@Repository("templatethemeTDao")
public class TemplatethemeTDaoImpl extends BaseTDaoImpl<TemplatethemeT> implements TemplatethemeTDao {
	
	private static final Logger log = LoggerFactory.getLogger(TemplatethemeTDaoImpl.class);
	
	
}