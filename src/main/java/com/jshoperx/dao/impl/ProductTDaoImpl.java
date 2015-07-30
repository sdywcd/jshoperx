package com.jshoperx.dao.impl;

import com.jshoperx.dao.ProductTDao;
import com.jshoperx.entity.ProductT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("productTDao")
public class ProductTDaoImpl extends BaseTDaoImpl<ProductT> implements ProductTDao {
	private static final Logger log = LoggerFactory.getLogger(ProductTDaoImpl.class);
	

	
	
}