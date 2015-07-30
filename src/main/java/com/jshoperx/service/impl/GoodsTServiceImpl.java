package com.jshoperx.service.impl;


import com.jshoperx.dao.GoodsAttributeRpTDao;
import com.jshoperx.dao.GoodsDetailRpTDao;
import com.jshoperx.dao.GoodsTDao;
import com.jshoperx.dao.ProductTDao;
import com.jshoperx.entity.GoodsDetailRpT;
import com.jshoperx.entity.GoodsSpecificationsProductRpT;
import com.jshoperx.entity.GoodsT;
import com.jshoperx.entity.ProductT;
import com.jshoperx.service.GoodsSpecificationsProductRpTService;
import com.jshoperx.service.GoodsTService;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("goodsTService")
@Scope("prototype")
public class GoodsTServiceImpl extends BaseTServiceImpl<GoodsT>implements GoodsTService {
	@Resource
	private GoodsTDao goodsTDao;
	@Resource
	private GoodsDetailRpTDao goodsDetailRpTDao;
	@Resource 
	private GoodsAttributeRpTDao goodsAttributeRpTDao;
	@Resource
	private ProductTDao productTDao;
	@Resource
	private GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService;
	@Resource
	private Serial serial;
	


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveGoodsProcess(GoodsT gt,
			GoodsDetailRpT gdpt,ProductT pt,GoodsSpecificationsProductRpT gspt) {
			this.goodsTDao.save(gt);
			this.goodsDetailRpTDao.save(gdpt);
			this.productTDao.save(pt);
			//增加规格商品和货物关系表
			this.goodsSpecificationsProductRpTService.save(gspt);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateGoodsProcess(GoodsT gt,String detail,ProductT pt) {
		//更新商品表
		this.goodsTDao.update(gt);
		//更新商品介绍
		Criterion criterion=Restrictions.eq("goodsid", gt.getGoodsid());
		GoodsDetailRpT gdrt=this.goodsDetailRpTDao.findOneByCriteria(GoodsDetailRpT.class, criterion);
		if(gdrt!=null){
			gdrt.setDetail(detail);
			this.goodsDetailRpTDao.update(gdrt);
		}else{
			gdrt=new GoodsDetailRpT();
			gdrt.setGoodsid(gt.getGoodsid());
			gdrt.setId(this.serial.Serialid(Serial.GOODSDETAILRPT));
			this.goodsDetailRpTDao.save(gdrt);
		}
		this.productTDao.update(pt);
	}




}
