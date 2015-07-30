package com.jshoperx.dao.impl;

import com.jshoperx.dao.BrandTDao;
import com.jshoperx.entity.BrandT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("brandTDao")
public class BrandTDaoImpl extends BaseTDaoImpl<BrandT> implements BrandTDao {

	private static final Logger log = LoggerFactory.getLogger(BrandTDaoImpl.class);


}