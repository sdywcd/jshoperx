package com.jshoperx.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;
/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/23
* Time:下午5:38
* Note:密码和用户名token
**/
public class LoginUsernamePasswordToken extends UsernamePasswordToken {


	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public LoginUsernamePasswordToken(String username,String password){
		super(username,password);
		this.username=username;
		this.password=password;
	}

	public LoginUsernamePasswordToken()
	{
		super();
	}

}
