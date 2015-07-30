package com.jshoperx.service.impl;

import com.jshoperx.entity.GoodsSpecificationsProductRpT;
import com.jshoperx.service.GoodsSpecificationsProductRpTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("goodsSpecificationsProductRpTService")
@Scope("prototype")
public class GoodsSpecificationsProductRpTServiceImpl extends
		BaseTServiceImpl<GoodsSpecificationsProductRpT> implements
		GoodsSpecificationsProductRpTService {

}
