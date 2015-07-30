package com.jshoperx.dao.impl;

import com.jshoperx.dao.GoodsTwocodeRelationshipTDao;
import com.jshoperx.entity.GoodsTwocodeRpT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("goodsTwocodeRelationshipTDao")
public class GoodsTwocodeRelationshipTDaoImpl extends
		BaseTDaoImpl<GoodsTwocodeRpT> implements GoodsTwocodeRelationshipTDao {
	private static final Logger log = LoggerFactory
			.getLogger(GoodsTwocodeRelationshipTDaoImpl.class);

}
