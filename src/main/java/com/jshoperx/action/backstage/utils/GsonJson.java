package com.jshoperx.action.backstage.utils;

import java.sql.Timestamp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/23
* Time:下午3:40
* Note:Gson和Mysql的日期转换方法
**/
public class GsonJson {
	
	public static String parseDataToJson(Object obj) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter()).registerTypeAdapter(java.sql.Date.class, new SQLDateTypeAdapter()).create();
		return gson.toJson(obj);
	}

}
