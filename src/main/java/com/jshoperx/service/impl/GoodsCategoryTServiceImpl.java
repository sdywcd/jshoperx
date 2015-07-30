package com.jshoperx.service.impl;

import com.jshoperx.entity.GoodsCategoryT;
import com.jshoperx.service.GoodsCategoryTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("goodsCategoryTService")
@Scope("prototype")
public class GoodsCategoryTServiceImpl extends BaseTServiceImpl<GoodsCategoryT> implements GoodsCategoryTService {


}
