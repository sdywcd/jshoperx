package com.jshoperx.shiro;

import java.io.Serializable;
/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/23
* Time:下午5:38
* Note:shiro用户账号对象
**/
public class ShiroUser implements Serializable{

	private String userId;
	private String account;
	
	public ShiroUser(String userId,String account){
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
}
