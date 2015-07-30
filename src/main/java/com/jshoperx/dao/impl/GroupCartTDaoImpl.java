package com.jshoperx.dao.impl;

import com.jshoperx.dao.GroupCartDao;
import com.jshoperx.entity.GroupCartT;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
@Repository("groupCartDao")
public class GroupCartTDaoImpl extends BaseTDaoImpl<GroupCartT> implements GroupCartDao {

	private static final Logger log = LoggerFactory.getLogger(GroupCartTDaoImpl.class);


}
