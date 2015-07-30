package com.jshoperx.action.backstage.utils.config;

import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/23
* Time:下午5:36
* Note:读取jshoper系统配置文件
**/
public class ReadSysConfig {
	private static final Logger log = LoggerFactory.getLogger(ReadSysConfig.class);

	/**
	 * 读取jshoper系统配置文件信息
	 * @return
	 */
	public static Properties getJConfig(){
		String filePath = StaticKey.EMPTY;
		Properties p = new Properties();
		ActionContext ac = ActionContext.getContext();
		ServletContext sc = (ServletContext) ac
				.get(ServletActionContext.SERVLET_CONTEXT);
		filePath = sc.getRealPath("/") + StaticKey.SYSTEM_CONFIG_FILE;
		try {
			p.load(new FileInputStream(filePath));
		} catch (IOException e) {
			log.debug("IOException");
		}
		return p;
	}
}
