package com.jshoperx.dao.impl;

import com.jshoperx.dao.SiteNavigationTDao;
import com.jshoperx.entity.SiteNavigationT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("siteNavigationTDao")
public class SiteNavigationTDaoImpl extends BaseTDaoImpl<SiteNavigationT> implements SiteNavigationTDao {
	

	private static final Logger log = LoggerFactory.getLogger(SiteNavigationTDaoImpl.class);
	

}