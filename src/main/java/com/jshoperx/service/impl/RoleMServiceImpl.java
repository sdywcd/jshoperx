package com.jshoperx.service.impl;

import com.jshoperx.entity.RoleM;
import com.jshoperx.service.RoleMService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("roleMService")
@Scope("prototype")
public class RoleMServiceImpl extends BaseTServiceImpl<RoleM>implements RoleMService {
	
}
