package com.jshoperx.service;


import com.jshoperx.entity.CartT;
import com.jshoperx.entity.OrderInvoiceT;
import com.jshoperx.entity.OrderT;
import com.jshoperx.entity.ShippingAddressT;

import java.util.List;

public interface OrderTService extends BaseTService<OrderT>{


	/**
	 * 初始化普通订单需要的信息并增加到数据表
	 * @param ordert
	 * @param sAddressT
	 */
	public void saveNormalOrderNeedInfoBack(OrderT ordert,ShippingAddressT sAddressT,List<CartT>cartLists,OrderInvoiceT oit);
	
}
