package com.jshoperx.service.impl;

import com.jshoperx.dao.SerialTDao;
import com.jshoperx.entity.SerialT;
import com.jshoperx.service.SerialTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service("serialTService")
@Scope("prototype")
public class SerialTServiceImpl extends BaseTServiceImpl<SerialT>implements SerialTService {
	@Resource
	private SerialTDao serialTDao;

	public SerialT findBybaseid(String biz) {
		return this.serialTDao.findBybaseid(biz);
	}

	public int updateBybaseid(SerialT transientInstance) {
		return this.serialTDao.updateBybaseid(transientInstance);
	}

	@Transactional
	@Override
	public SerialT SerialTlastId(String serialkey) {
		SerialT st = this.serialTDao.findBybaseid(serialkey);
		if (st != null) {
			this.serialTDao.updateBybaseid(st);
		}
		return st;

	}

}
