package com.jshoperx.service.impl;

import com.jshoperx.entity.GoodsTypeTN;
import com.jshoperx.service.GoodsTypeTNService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("goodsTypeTNService")
@Scope("prototype")
public class GoodsTypeTNServiceImpl extends BaseTServiceImpl<GoodsTypeTN> implements GoodsTypeTNService {

}
