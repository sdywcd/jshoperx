package com.jshoperx.service.impl;

import com.jshoperx.entity.GoodsTypeBrandT;
import com.jshoperx.service.GoodsTypeBrandTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("goodsTypeBrandTService")
@Scope("prototype")
public class GoodsTypeBrandTServiceImpl extends
		BaseTServiceImpl<GoodsTypeBrandT> implements GoodsTypeBrandTService {


}
