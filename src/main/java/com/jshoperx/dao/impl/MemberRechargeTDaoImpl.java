
package com.jshoperx.dao.impl;

import com.jshoperx.dao.MemberRechargeTDao;
import com.jshoperx.entity.MemberRechargeT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
@Repository("memberRechargeTDao")
public class MemberRechargeTDaoImpl extends BaseTDaoImpl<MemberRechargeT> implements MemberRechargeTDao {
	private static final Logger log = LoggerFactory.getLogger(MemberRechargeTDaoImpl.class);

}
