package com.jshoperx.service.impl;

import com.jshoperx.entity.GoodsCommentT;
import com.jshoperx.service.GoodsCommentTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("goodsCommentTService")
@Scope("prototype")
public class GoodsCommentTServiceImpl extends BaseTServiceImpl<GoodsCommentT>implements GoodsCommentTService {

}
