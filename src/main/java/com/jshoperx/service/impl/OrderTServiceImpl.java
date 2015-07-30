package com.jshoperx.service.impl;

import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.dao.CartTDao;
import com.jshoperx.dao.OrderInvoiceTDao;
import com.jshoperx.dao.OrderTDao;
import com.jshoperx.dao.ShippingAddressTDao;
import com.jshoperx.entity.CartT;
import com.jshoperx.entity.OrderInvoiceT;
import com.jshoperx.entity.OrderT;
import com.jshoperx.entity.ShippingAddressT;
import com.jshoperx.service.OrderTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service("orderTService")
@Scope("prototype")
public class OrderTServiceImpl extends BaseTServiceImpl<OrderT>implements OrderTService {
	@Resource
	private OrderTDao orderTDao;
	@Resource
	private Serial serial;
	@Resource
	private ShippingAddressTDao shippingAddressTDao;
	@Resource
	private CartTDao cartTDao;
	@Resource
	private OrderInvoiceTDao orderInvoiceTDao;

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveNormalOrderNeedInfoBack(OrderT ordert,
			ShippingAddressT sAddressT,List<CartT> cartLists,OrderInvoiceT oit) {
		//生成一个订单号
		String orderid=this.serial.Serialid(Serial.ORDER);
		//生成一个同批次购物车号
		String cartid=this.serial.Serialid(Serial.CART);
		//加入购物车表
		for(CartT c:cartLists){
			c.setOrderid(orderid);
			c.setCartid(cartid);
			c.setState(StaticKey.CARTSTATE_RELBYORDER_NUM);
			this.cartTDao.save(c);
		}
		//加入到发货地址表中
		sAddressT.setOrderid(orderid);
		this.shippingAddressTDao.save(sAddressT);
		//加入订单表
		ordert.setOrderid(orderid);
		this.orderTDao.save(ordert);
		//加入订单发票表
		oit.setOrderInvoiceid(this.serial.Serialid(Serial.ORDERINVOICE));
		oit.setOrderid(orderid);
		this.orderInvoiceTDao.save(oit);
	}



	
	
}
