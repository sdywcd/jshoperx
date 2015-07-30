package com.jshoperx.service.impl;


import com.jshoperx.dao.BrandTDao;
import com.jshoperx.entity.BrandT;
import com.jshoperx.entity.GoodsTypeBrandT;
import com.jshoperx.service.BrandTService;
import com.jshoperx.service.GoodsTypeBrandTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("brandTService")
@Scope("prototype")
public class BrandTServiceImpl extends BaseTServiceImpl<BrandT>implements BrandTService {
	@Resource
	private BrandTDao brandTDao;
	@Resource
	private GoodsTypeBrandTService goodsTypeBrandTService;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveBrandTransaction(BrandT brand,
			GoodsTypeBrandT goodsTypeBrandT) {
		this.brandTDao.save(brand);
		this.goodsTypeBrandTService.save(goodsTypeBrandT);
		
	}
}
