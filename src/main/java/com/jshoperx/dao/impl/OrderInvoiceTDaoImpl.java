package com.jshoperx.dao.impl;

import com.jshoperx.dao.OrderInvoiceTDao;
import com.jshoperx.entity.OrderInvoiceT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("orderInvoiceTDao")
public class OrderInvoiceTDaoImpl extends BaseTDaoImpl<OrderInvoiceT> implements OrderInvoiceTDao {

	private static final Logger log = LoggerFactory.getLogger(OrderInvoiceTDaoImpl.class);


}