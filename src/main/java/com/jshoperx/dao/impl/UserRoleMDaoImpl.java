package com.jshoperx.dao.impl;

import com.jshoperx.dao.UserRoleMDao;
import com.jshoperx.entity.UserRoleM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("userRoleMDao")
public class UserRoleMDaoImpl extends BaseTDaoImpl<UserRoleM> implements UserRoleMDao{
	private static final Logger log = LoggerFactory.getLogger(UserRoleMDaoImpl.class);

	

}