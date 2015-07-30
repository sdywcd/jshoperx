package com.jshoperx.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshoperx.entity.GoodsCardsT;
import com.jshoperx.service.GoodsCardsTService;
@Service("goodsCardsTService")
@Scope("prototype")
public class GoodsCardsTServiceImpl extends BaseTServiceImpl<GoodsCardsT> implements GoodsCardsTService {
	
}
