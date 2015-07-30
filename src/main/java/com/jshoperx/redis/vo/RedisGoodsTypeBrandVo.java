package com.jshoperx.redis.vo;

import com.jshoperx.entity.GoodsTypeBrandT;

import java.io.Serializable;
import java.util.List;


public class RedisGoodsTypeBrandVo implements Serializable{
	
	
	private List<GoodsTypeBrandT> gtbrand;
	

	
	public List<GoodsTypeBrandT> getGtbrand() {
		return gtbrand;
	}

	public void setGtbrand(List<GoodsTypeBrandT> gtbrand) {
		this.gtbrand = gtbrand;
	}

	
	
}
