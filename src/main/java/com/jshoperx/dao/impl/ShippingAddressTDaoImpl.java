package com.jshoperx.dao.impl;

import com.jshoperx.dao.ShippingAddressTDao;
import com.jshoperx.entity.ShippingAddressT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("shippingAddressTDao")
public class ShippingAddressTDaoImpl extends BaseTDaoImpl<ShippingAddressT> implements ShippingAddressTDao {


	private static final Logger log = LoggerFactory.getLogger(ShippingAddressTDaoImpl.class);


}