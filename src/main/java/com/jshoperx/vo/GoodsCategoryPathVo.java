package com.jshoperx.vo;

import java.io.Serializable;

/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/23
* Time:下午5:21
* Note:商品分类递归路径
**/
public class GoodsCategoryPathVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4395258175126073759L;
	private String name;
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
