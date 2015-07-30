package com.jshoperx.service.impl;


import com.jshoperx.dao.GoodsTDao;
import com.jshoperx.dao.ProductTDao;
import com.jshoperx.entity.GoodsSpecificationsProductRpT;
import com.jshoperx.entity.GoodsT;
import com.jshoperx.entity.ProductT;
import com.jshoperx.service.GoodsSpecificationsProductRpTService;
import com.jshoperx.service.ProductTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("productTService")
@Scope("prototype")
public class ProductTServiceImpl extends BaseTServiceImpl<ProductT>implements ProductTService {
	@Resource
	private ProductTDao productTDao;
	@Resource
	private GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService;
	@Resource
	private GoodsTDao goodsTDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveProductProcess(ProductT pt,
			GoodsSpecificationsProductRpT gsrt) {
		this.productTDao.save(pt);
		this.goodsSpecificationsProductRpTService.save(gsrt);
		GoodsT gt=this.goodsTDao.findByPK(GoodsT.class, pt.getGoodsid());
		if(gt!=null){
			gt.setQuantity(gt.getQuantity()-0+pt.getStore());
			this.goodsTDao.update(gt);
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateProductProcess(ProductT pt,
			GoodsSpecificationsProductRpT gsrt,int oldQuantity) {
		this.productTDao.update(pt);
		this.goodsSpecificationsProductRpTService.update(gsrt);
		//得到商品的库存 得到货物的原始库存，得到货物的新库存 更新商品的库存=商品库存-原始库存+新库存
		GoodsT gt=this.goodsTDao.findByPK(GoodsT.class, pt.getGoodsid());
		if(gt!=null){
			gt.setQuantity(gt.getQuantity()-oldQuantity+pt.getStore());
			this.goodsTDao.update(gt);
		}
	}


}
