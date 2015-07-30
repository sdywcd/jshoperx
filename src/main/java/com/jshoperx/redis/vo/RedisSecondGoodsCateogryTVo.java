package com.jshoperx.redis.vo;

import com.jshoperx.entity.GoodsCategoryT;

import java.io.Serializable;
import java.util.List;


public class RedisSecondGoodsCateogryTVo implements Serializable {

	private List<GoodsCategoryT> goodsCategoryTs;

	public List<GoodsCategoryT> getGoodsCategoryTs() {
		return goodsCategoryTs;
	}

	public void setGoodsCategoryTs(List<GoodsCategoryT> goodsCategoryTs) {
		this.goodsCategoryTs = goodsCategoryTs;
	}

	
}
