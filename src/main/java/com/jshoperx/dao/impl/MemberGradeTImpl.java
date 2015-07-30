package com.jshoperx.dao.impl;

import com.jshoperx.dao.MemberGradeTDao;
import com.jshoperx.entity.MemberGradeT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("memberGradeTDao")
public class MemberGradeTImpl extends BaseTDaoImpl<MemberGradeT> implements MemberGradeTDao {
    private static final Logger log = LoggerFactory.getLogger(MemberGradeTImpl.class);
	
	
}