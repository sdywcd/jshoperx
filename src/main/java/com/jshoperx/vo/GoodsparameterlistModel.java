package com.jshoperx.vo;

/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/23
* Time:下午5:23
* Note:商品参数模型
**/
public class GoodsparameterlistModel {
	private String goodsTypeParamid;

	private String goodsParamid;
	/**
	 * 商品参数名称
	 */
	private String paramName;
	/**
	 * 商品参数值
	 */
	private String paramValue;
	/**
	 * 商品参数排列
	 */
	private String sortList;
	
	
	
	public String getGoodsTypeParamid() {
		return goodsTypeParamid;
	}
	public void setGoodsTypeParamid(String goodsTypeParamid) {
		this.goodsTypeParamid = goodsTypeParamid;
	}
	public String getGoodsParamid() {
		return goodsParamid;
	}
	public void setGoodsParamid(String goodsParamid) {
		this.goodsParamid = goodsParamid;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public String getSortList() {
		return sortList;
	}
	public void setSortList(String sortList) {
		this.sortList = sortList;
	}
	public GoodsparameterlistModel(String goodsTypeParamid, String goodsParamid, String paramName, String paramValue, String sortList) {
		super();
		this.goodsTypeParamid = goodsTypeParamid;
		this.goodsParamid = goodsParamid;
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.sortList = sortList;
	}
	public GoodsparameterlistModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
