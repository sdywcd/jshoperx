package com.jshoperx.service.impl;

import com.jshoperx.entity.GroupCartT;
import com.jshoperx.service.GroupCartService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("groupCartService")
@Scope("prototype")
public class GroupCartServiceImpl extends BaseTServiceImpl<GroupCartT> implements GroupCartService {

}
