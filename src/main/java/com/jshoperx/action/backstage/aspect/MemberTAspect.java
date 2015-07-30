package com.jshoperx.action.backstage.aspect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.jshoperx.action.backstage.member.MemberTAction;
import com.jshoperx.action.backstage.utils.config.GlobalParam;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.opensymphony.xwork2.ActionContext;

/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/24
* Time:下午3:19
* Note:会员相关的切片
**/
@Aspect
public class MemberTAspect {

	/**
	 * 检测系统是否允许新会员注册
	 * @param joinPoint
	 */
	@Before("execution(String com.jshoperx.action.backstage.member.MemberTAction.saveMemberT())")
	public void checkWhetherRegiterMember(JoinPoint joinPoint){
		MemberTAction memberTAction=(MemberTAction) joinPoint.getThis();
		//是否允许注册的标记
		boolean isCanRegister=false;
		String filePath="";
		Properties p=new Properties();
		ActionContext ac=ActionContext.getContext();
		ServletContext sc = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		filePath=sc.getRealPath("/")+StaticKey.SYSTEM_CONFIG_FILE;
		try {
			p.load(new FileInputStream(filePath));
			String isUsercanRegister=p.getProperty(GlobalParam.ISUSERCANREGISTER, "0");
			if(isUsercanRegister.equals(StaticKey.ONE)){
				isCanRegister=true;
			}
			memberTAction.setDoingTag(isCanRegister);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
}
