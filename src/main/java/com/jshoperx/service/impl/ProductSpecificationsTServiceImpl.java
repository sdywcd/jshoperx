package com.jshoperx.service.impl;


import com.jshoperx.entity.ProductSpecificationsT;
import com.jshoperx.service.ProductSpecificationsTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("productSpecificationsTService")
@Scope("prototype")
public class ProductSpecificationsTServiceImpl extends BaseTServiceImpl<ProductSpecificationsT>implements ProductSpecificationsTService {

}
