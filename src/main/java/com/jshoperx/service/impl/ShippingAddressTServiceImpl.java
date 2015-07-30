package com.jshoperx.service.impl;

import com.jshoperx.entity.ShippingAddressT;
import com.jshoperx.service.ShippingAddressTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("shippingAddressTService")
@Scope("prototype")
public class ShippingAddressTServiceImpl extends BaseTServiceImpl<ShippingAddressT>implements ShippingAddressTService {

}
