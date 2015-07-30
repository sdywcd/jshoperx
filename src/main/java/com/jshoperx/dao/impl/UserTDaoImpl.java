package com.jshoperx.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.jshoperx.dao.UserTDao;
import com.jshoperx.entity.UserT;


@Repository("userTDao")
public class UserTDaoImpl extends BaseTDaoImpl<UserT> implements UserTDao {

	private static final Log log = LogFactory.getLog(UserTDaoImpl.class);


}