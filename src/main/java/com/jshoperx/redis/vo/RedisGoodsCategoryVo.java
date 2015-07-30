package com.jshoperx.redis.vo;

import com.jshoperx.entity.GoodsCategoryT;

import java.io.Serializable;
import java.util.List;


public class RedisGoodsCategoryVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<GoodsCategoryT> goodsCategorys;

	public List<GoodsCategoryT> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryT> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}
	
	
}
