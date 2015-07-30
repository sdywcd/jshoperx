package com.jshoperx.dao.impl;

import com.jshoperx.dao.OrderTDao;
import com.jshoperx.entity.OrderT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("orderTDao")
public class OrderTDaoImpl extends BaseTDaoImpl<OrderT> implements OrderTDao {

	private static final Logger log = LoggerFactory.getLogger(OrderTDaoImpl.class);


}