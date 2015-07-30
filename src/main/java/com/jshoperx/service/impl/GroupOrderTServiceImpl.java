package com.jshoperx.service.impl;

import com.jshoperx.entity.GroupOrderT;
import com.jshoperx.service.GroupOrderTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("groupOrderTService")
@Scope("prototype")
public class GroupOrderTServiceImpl extends BaseTServiceImpl<GroupOrderT>implements GroupOrderTService {


}
