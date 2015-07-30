package com.jshoperx.dao.impl;

import com.jshoperx.dao.OrderSnapshotTDao;
import com.jshoperx.entity.OrderSnapshotT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
@Repository("orderSnapshotTDao")
public class OrderSnapshotTDaoImpl extends BaseTDaoImpl<OrderSnapshotT> implements
		OrderSnapshotTDao {

	private static final Logger log = LoggerFactory.getLogger(OrderSnapshotTDaoImpl.class);


}
