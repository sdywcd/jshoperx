package com.jshoperx.service;


import com.jshoperx.entity.GoodsDetailRpT;
import com.jshoperx.entity.GoodsSpecificationsProductRpT;
import com.jshoperx.entity.GoodsT;
import com.jshoperx.entity.ProductT;

public interface GoodsTService extends BaseTService<GoodsT>{

	/**
	 * 商品信息增加过程
	 * @param gt
	 * @param pt
	 * @param gdpt
     * @param gspt
	 */
	public void saveGoodsProcess(GoodsT gt,GoodsDetailRpT gdpt,ProductT pt,GoodsSpecificationsProductRpT gspt);
	/**
	 * 商品信息更新过程
	 * @param gt
	 * @param detail
	 * @param pt
	 */
	public void updateGoodsProcess(GoodsT gt,String detail,ProductT pt);
	

}
