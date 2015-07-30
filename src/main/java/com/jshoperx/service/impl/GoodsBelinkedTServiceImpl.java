package com.jshoperx.service.impl;

import com.jshoperx.entity.GoodsBelinkedT;
import com.jshoperx.service.GoodsBelinkedTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("goodsBelinkedTService")
@Scope("prototype")
public class GoodsBelinkedTServiceImpl extends BaseTServiceImpl<GoodsBelinkedT>
		implements GoodsBelinkedTService {

}
