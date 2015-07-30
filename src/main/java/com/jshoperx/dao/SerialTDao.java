package com.jshoperx.dao;

import com.jshoperx.entity.SerialT;

public interface SerialTDao extends BaseTDao<SerialT> {

	/**
	 * 查找新的逻辑id
	 * @param biz
	 * @return
	 */
	public  SerialT findBybaseid(String biz);
	/**
	 * 更新新的逻辑id
	 * @param transientInstance
	 * @return
	 */
	public  int updateBybaseid(SerialT transientInstance);
}
