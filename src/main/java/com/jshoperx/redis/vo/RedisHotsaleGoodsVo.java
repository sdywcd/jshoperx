package com.jshoperx.redis.vo;

import com.jshoperx.entity.GoodsT;

import java.io.Serializable;
import java.util.List;


public class RedisHotsaleGoodsVo implements Serializable {

	private List<GoodsT> hotsaleGoodsTs;

	public List<GoodsT> getHotsaleGoodsTs() {
		return hotsaleGoodsTs;
	}

	public void setHotsaleGoodsTs(List<GoodsT> hotsaleGoodsTs) {
		this.hotsaleGoodsTs = hotsaleGoodsTs;
	}
	
	

	
}
