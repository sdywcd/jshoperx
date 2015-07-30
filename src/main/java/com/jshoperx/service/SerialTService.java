package com.jshoperx.service;

import com.jshoperx.entity.SerialT;

public interface SerialTService extends BaseTService<SerialT> {


	/**
	 * 查找新的逻辑id
	 * 
	 * @param biz
	 * @return
	 */
	public SerialT findBybaseid(String biz);

	/**
	 * 更新新的逻辑id
	 * 
	 * @param transientInstance
	 * @return
	 */
	public int updateBybaseid(SerialT transientInstance);

	/**
	 * 获取最新的主键id
	 * 
	 * @return
	 */
	public SerialT SerialTlastId(String serialkey);

}
