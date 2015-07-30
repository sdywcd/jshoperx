
package com.jshoperx.dao.impl;

import com.jshoperx.dao.MemberRechargeRecordsTDao;
import com.jshoperx.entity.MemberRechargeRecordsT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("memberRechargeRecordsTDao")
public class MemberRechargeRecordsTDaoImpl extends BaseTDaoImpl<MemberRechargeRecordsT> implements MemberRechargeRecordsTDao {
	private static final Logger log = LoggerFactory.getLogger(MemberRechargeRecordsTDaoImpl.class);
	

}

