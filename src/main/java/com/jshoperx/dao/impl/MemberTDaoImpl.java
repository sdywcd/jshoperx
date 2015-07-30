package com.jshoperx.dao.impl;

import com.jshoperx.dao.MemberTDao;
import com.jshoperx.entity.MemberT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("memberTDao")
public class MemberTDaoImpl extends BaseTDaoImpl<MemberT> implements MemberTDao {
	private static final Logger log = LoggerFactory.getLogger(MemberTDaoImpl.class);


}
