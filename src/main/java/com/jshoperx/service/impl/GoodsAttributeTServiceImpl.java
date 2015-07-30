package com.jshoperx.service.impl;

import com.jshoperx.entity.GoodsAttributeT;
import com.jshoperx.service.GoodsAttributeTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("goodsAttributeTService")
@Scope("prototype")
public class GoodsAttributeTServiceImpl extends BaseTServiceImpl<GoodsAttributeT>implements GoodsAttributeTService {

}
