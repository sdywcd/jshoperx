package com.jshoperx.service.impl;

import com.jshoperx.entity.PaymentM;
import com.jshoperx.service.PaymentMService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;



@Service("paymentMService")
@Scope("prototype")
public class PaymentMServiceImpl extends BaseTServiceImpl<PaymentM> implements PaymentMService {
	
}
