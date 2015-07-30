package com.jshoperx.service.impl;

import com.jshoperx.entity.CartT;
import com.jshoperx.service.CartTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("cartTService")
@Scope("prototype")
public class CartTServiceImpl extends BaseTServiceImpl<CartT> implements CartTService {

}
