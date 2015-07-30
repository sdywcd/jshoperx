package com.jshoperx.action.backstage.image.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/23
* Time:下午5:28
* Note:图片上传相关检查方法
**/
public class UtilCommon {
	 public static String getSerial(Date date, int index) {  
	        long msel = date.getTime();  
	        SimpleDateFormat fm = new SimpleDateFormat("MMddyyyyHHmmssSS");  
	        msel += index;  
	        date.setTime(msel);  
	        String serials = fm.format(date);  
	        return serials;  
	    }  
	    // 检查是否是图片格式  
	    public static boolean checkIsImage(String imgStr) {  
	        boolean flag = false;  
	        if (imgStr != null) {  
	            if (imgStr.equalsIgnoreCase(".gif")  
	                    || imgStr.equalsIgnoreCase(".jpg")  
	                    || imgStr.equalsIgnoreCase(".jpeg")  
	                    || imgStr.equalsIgnoreCase(".png")) {  
	                flag = true;  
	            }  
	        }  
	        return flag;  
	    }  

}
