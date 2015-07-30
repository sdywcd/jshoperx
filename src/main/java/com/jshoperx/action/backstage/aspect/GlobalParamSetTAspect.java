package com.jshoperx.action.backstage.aspect;

import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/24
* Time:下午3:12
* Note:系统配置信息
**/
@Aspect
public class GlobalParamSetTAspect {
	/**
	 * 在后台登陆后读取jshoper配置信息
	 * @param joinPoint
	 * @throws IOException 
	 */
	@After("execution(String com.jshoperx.action.backstage.user.UserTAction.adminlogin())")
	public void afterAdminLogin(JoinPoint joinPoint) throws IOException{
		Map<String,Object> config=new HashMap<String, Object>();
		String filePath="";
		ActionContext ac=ActionContext.getContext();
		ServletContext sc = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		filePath=sc.getRealPath("/")+"admin/jshoperconfig.properties";
		InputStream inputStream = new FileInputStream(filePath);
		Properties p = new Properties();
		p.load(inputStream);
		Enumeration en = p.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
            String value = p.getProperty (key);
            config.put(key, value);
        }
		ActionContext.getContext().getSession().remove(StaticKey.GLOBALPARAMS);
		ActionContext.getContext().getSession().put(StaticKey.GLOBALPARAMS, config);
	}
	
}
