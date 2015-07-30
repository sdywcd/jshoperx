package com.jshoperx.dao.impl;

import com.jshoperx.dao.GroupOrderTDao;
import com.jshoperx.entity.GroupOrderT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("groupOrderTDao")
public class GroupOrderTDaoImpl extends BaseTDaoImpl<GroupOrderT> implements GroupOrderTDao{

	private static final Logger log = LoggerFactory.getLogger(GroupOrderTDaoImpl.class);



}
