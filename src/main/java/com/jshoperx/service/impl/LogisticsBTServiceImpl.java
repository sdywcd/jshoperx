package com.jshoperx.service.impl;

import com.jshoperx.entity.LogisticsBusinessT;
import com.jshoperx.service.LogisticsBTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("logisticsBTService")
@Scope("prototype")
public class LogisticsBTServiceImpl extends BaseTServiceImpl<LogisticsBusinessT>implements LogisticsBTService {

}
