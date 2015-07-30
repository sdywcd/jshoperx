package com.jshoperx.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshoperx.entity.UserT;
import com.jshoperx.service.UsertService;

@Service("usertService")
@Scope("prototype")
public class UsertServiceImpl extends BaseTServiceImpl<UserT>implements UsertService {


}
