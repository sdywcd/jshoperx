package com.jshoperx.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshoperx.entity.OrderInvoiceT;
import com.jshoperx.service.OrderInvoiceTService;

@Service("orderInvoiceTService")
@Scope("prototype")
public class OrderInvoiceTServiceImpl extends BaseTServiceImpl<OrderInvoiceT>implements OrderInvoiceTService {

}
