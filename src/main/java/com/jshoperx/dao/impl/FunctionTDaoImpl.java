package com.jshoperx.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshoperx.dao.FunctionTDao;
import com.jshoperx.entity.FunctionT;
@Repository("functionTDao")
public class FunctionTDaoImpl extends BaseTDaoImpl<FunctionT> implements FunctionTDao {
    private static final Logger log = LoggerFactory.getLogger(FunctionTDaoImpl.class);


}
