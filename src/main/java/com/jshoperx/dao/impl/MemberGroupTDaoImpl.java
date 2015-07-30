package com.jshoperx.dao.impl;

import com.jshoperx.dao.MemberGroupTDao;
import com.jshoperx.entity.MemberGroupT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("memberGroupTDao")
public class MemberGroupTDaoImpl extends BaseTDaoImpl<MemberGroupT> implements MemberGroupTDao {
	private static final Logger log = LoggerFactory.getLogger(MemberGroupTDaoImpl.class);

}
