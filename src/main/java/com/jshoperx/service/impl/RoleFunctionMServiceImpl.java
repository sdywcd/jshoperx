package com.jshoperx.service.impl;

import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.dao.RoleFunctionMDao;
import com.jshoperx.entity.RoleFunctionM;
import com.jshoperx.entity.RoleM;
import com.jshoperx.service.RoleFunctionMService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service("roleFunctionMService")
@Scope("prototype")
public class RoleFunctionMServiceImpl extends BaseTServiceImpl<RoleFunctionM>implements RoleFunctionMService {

	private Serial serial;

	private RoleFunctionMDao roleFunctionMDao;
	
	public RoleFunctionMDao getRoleFunctionMDao() {
		return roleFunctionMDao;
	}
	public void setRoleFunctionMDao(RoleFunctionMDao roleFunctionMDao) {
		this.roleFunctionMDao = roleFunctionMDao;
	}
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	
	/**
	 * 增加角色权限
	 * @param rm
	 */
	@Transactional
	public void addRoleFunctionM(RoleM rm,String functionids){
		if(StringUtils.isNotBlank(functionids)){
			String []strs=StringUtils.split(functionids,StaticKey.SPLITDOT);
			for(String functionid :strs){
				RoleFunctionM rfm=new RoleFunctionM();
				rfm.setId(this.getSerial().Serialid(Serial.ROLEFUNCTION));
				rfm.setRoleid(rm.getId());
				rfm.setFunctionid(functionid);
				this.getRoleFunctionMDao().save(rfm);
			}
		}
	}



	
}
