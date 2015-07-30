package com.jshoperx.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshoperx.entity.SystemMailT;
import com.jshoperx.service.SystemMailTService;

@Service("systemMailTService")
@Scope("prototype")
public class SystemMailTServiceImpl extends BaseTServiceImpl<SystemMailT>implements SystemMailTService {



}
