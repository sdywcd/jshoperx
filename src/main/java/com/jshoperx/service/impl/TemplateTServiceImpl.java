package com.jshoperx.service.impl;

import com.jshoperx.entity.TemplateT;
import com.jshoperx.service.TemplateTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Service("templateTService")
@Scope("prototype")
public class TemplateTServiceImpl extends BaseTServiceImpl<TemplateT> implements TemplateTService {

}
