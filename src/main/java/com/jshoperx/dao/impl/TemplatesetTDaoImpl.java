package com.jshoperx.dao.impl;

import com.jshoperx.dao.TemplatesetTDao;
import com.jshoperx.entity.TemplatesetT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("templatesetTDao")
public class TemplatesetTDaoImpl extends BaseTDaoImpl<TemplatesetT> implements TemplatesetTDao {
	
	private static final Logger log = LoggerFactory.getLogger(TemplatesetTDaoImpl.class);
	

	
}