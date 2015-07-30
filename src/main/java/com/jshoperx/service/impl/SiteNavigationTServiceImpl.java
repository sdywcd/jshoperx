package com.jshoperx.service.impl;

import com.jshoperx.entity.SiteNavigationT;
import com.jshoperx.service.SiteNavigationTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("siteNavigationTService")
@Scope("prototype")
public class SiteNavigationTServiceImpl extends BaseTServiceImpl<SiteNavigationT> implements SiteNavigationTService {

}
