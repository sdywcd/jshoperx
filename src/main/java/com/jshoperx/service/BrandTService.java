package com.jshoperx.service;


import com.jshoperx.entity.BrandT;
import com.jshoperx.entity.GoodsTypeBrandT;

public interface BrandTService extends BaseTService<BrandT>{

	/**
	 * 保存品牌及商品品牌和商品类型的关系
	 * @param brandT
	 * @param goodsTypeBrandT
	 */
	public void saveBrandTransaction(BrandT brandT,GoodsTypeBrandT goodsTypeBrandT);
	
}
