package com.jshoperx.service.impl;

import com.jshoperx.entity.UserRoleM;
import com.jshoperx.service.UserRoleMService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Service("userRoleMService")
@Scope("prototype")
public class UserRoleMServiceImpl extends BaseTServiceImpl<UserRoleM> implements UserRoleMService {

}
