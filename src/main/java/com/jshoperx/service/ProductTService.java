package com.jshoperx.service;


import com.jshoperx.entity.GoodsSpecificationsProductRpT;
import com.jshoperx.entity.ProductT;

public interface ProductTService extends BaseTService<ProductT>{


	/**
	 * 货物信息增加过程
	 * @param pt
	 * @param gsrt
	 */
	public void saveProductProcess(ProductT pt,GoodsSpecificationsProductRpT gsrt);
	/**
	 * 货物信息更新过程
	 * @param pt
	 * @param gsrt
	 * @param oldQuantity 当前货物的原始库存
	 */
	public void updateProductProcess(ProductT pt,GoodsSpecificationsProductRpT gsrt,int oldQuantity);

}
