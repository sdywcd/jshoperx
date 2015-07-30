package com.jshoperx.action.backstage.utils;

import java.io.File;

import org.apache.struts2.ServletActionContext;

/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/23
* Time:下午5:14
* Note:删除服务器上文件
**/
public class ServerFileDel {

	private final static String FS=System.getProperty("file.separator");
	private final static String TOMACT_HOME=System.getProperty("catalina.home");
	private static String TEMP_PATH="";
	
	public static void Del(String PATH){
		String spath=ServletActionContext.getServletContext().getRealPath("");
		TEMP_PATH=spath+PATH.replace("\\", "//");
		File fileTemp=new File(TEMP_PATH);
		boolean flag=false;
		flag=fileTemp.exists();
		if(flag){
			if(true==fileTemp.isFile()){
				if(fileTemp.delete()){
				}
			}
		}
	}
}
