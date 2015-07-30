package com.jshoperx.service;

import com.jshoperx.entity.RoleFunctionM;
import com.jshoperx.entity.RoleM;

public interface RoleFunctionMService extends BaseTService<RoleFunctionM> {

	
	public void addRoleFunctionM(RoleM rm,String functionids);
}
