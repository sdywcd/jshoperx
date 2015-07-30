package com.jshoperx.vo;

import java.io.Serializable;

/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/23
* Time:下午5:22
* Note:商品参数
**/
public class GoodsParameterInGoodsTypeTnVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String sortList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortList() {
		return sortList;
	}

	public void setSortList(String sortList) {
		this.sortList = sortList;
	}

}
