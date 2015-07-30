package com.jshoperx.dao.impl;

import com.jshoperx.dao.DeliverAddressTDao;
import com.jshoperx.entity.DeliverAddressT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * DeliverAddressT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshoperx.entity.DeliverAddressT
 * @author MyEclipse Persistence Tools
 */
@Repository("deliverAddressTDao")
public class DeliverAddressTDaoImpl extends BaseTDaoImpl<DeliverAddressT> implements DeliverAddressTDao {

	private static final Logger log = LoggerFactory.getLogger(DeliverAddressTDaoImpl.class);


}