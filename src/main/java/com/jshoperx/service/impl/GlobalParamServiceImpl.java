package com.jshoperx.service.impl;

import com.jshoperx.entity.GlobalParamM;
import com.jshoperx.service.GlobalParamService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service("globalParamService")
@Scope("prototype")
public class GlobalParamServiceImpl extends BaseTServiceImpl<GlobalParamM>
		implements GlobalParamService {
	
}
