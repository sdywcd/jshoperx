package com.jshoperx.dao.impl;

import com.jshoperx.dao.ProductSpecificationsTDao;
import com.jshoperx.entity.ProductSpecificationsT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("productSpecificationsTDao")
public class ProductSpecificationsTDaoImpl extends BaseTDaoImpl<ProductSpecificationsT> implements ProductSpecificationsTDao{
	
	private static final Logger log = LoggerFactory.getLogger(ProductSpecificationsTDaoImpl.class);

}