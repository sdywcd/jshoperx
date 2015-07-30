package com.jshoperx.action.backstage.image.qiniu;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;
import org.json.JSONException;


/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/23
* Time:下午5:32
* Note:七牛上传文件
**/
public class QiNiuUploadFiles {

	public static int upLoads(String localFile,String key) throws AuthException, JSONException{
		Config.ACCESS_KEY = QiNiuConfig.ACCESS_KEY;
		Config.SECRET_KEY = QiNiuConfig.SECRET_KEY;
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		PutPolicy putPolicy = new PutPolicy(QiNiuConfig.BUCKETNAME);
		PutExtra extra = new PutExtra();
		PutRet ret = IoApi.putFile(putPolicy.token(mac), key, localFile, extra);
		return ret.getStatusCode();
	}

	
}
