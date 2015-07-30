package com.jshoperx.service.impl;

import com.jshoperx.entity.FunctionT;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.jshoperx.service.FunctionTService;
@Service("functionMService")
@Scope("prototype")
public class FunctionTServiceImpl extends BaseTServiceImpl<FunctionT> implements
        FunctionTService {


}
