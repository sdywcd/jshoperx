package com.jshoperx.service;


import com.jshoperx.entity.GoodsGroupDetailRpT;
import com.jshoperx.entity.GoodsGroupT;

public interface GoodsGroupTService extends BaseTService<GoodsGroupT>{

    /**
     * 商品团购增加过程
     * @param ggt
     * @param ggdt
     * @param goodsAttrsVals
     */
    public void saveGoodsGroupProcess(GoodsGroupT ggt,GoodsGroupDetailRpT ggdt,String goodsAttrsVals);
    /**
     * 商品团购更新过程
     * @param ggt
     * @param detail
     * @param goodsAttrsVals
     */
    public void updateGoodsGroupProcess(GoodsGroupT ggt,String detail,String goodsAttrsVals);
}
