package com.jshoperx.action.backstage.aspect;

import com.jshoperx.action.backstage.image.ImgTAction;
import com.jshoperx.action.backstage.utils.ImgCutTools;
import com.jshoperx.action.backstage.utils.config.GlobalParam;
import com.jshoperx.action.backstage.utils.config.ReadSysConfig;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/24
* Time:下午3:12
* Note:图片上传切片
**/
@Aspect
public class ImgTAspect {
	private static final Logger log = LoggerFactory.getLogger(ImgTAspect.class);

	private static String[] imgExts = new String[] { "jpeg", "jpg", "gif",
			"png" };

	/**
	 * 保存图片缩略图 1,判定图片类型是否正确 2,读取jshoper系统关于图片是否压缩的配置，判定是否需要本地保存图片副本
	 * 3,调用图片压缩方法保存图片
	 * 
	 * @param joinPoint
	 */
	//@After("execution(String com.jshop.action.backstage.image.ImgTAction.ajaxFileUploads())")
	public void saveDifferentSizeImg(JoinPoint joinPoint) {
		boolean doCut = false;
		ImgTAction imgTAction = (ImgTAction) joinPoint.getThis();
		String extName = imgTAction.getExtName();
		for (int i = 0; i < imgExts.length; i++) {
			if (extName.equalsIgnoreCase(imgExts[i])) {
				doCut = true;
				break;
			}
		}
		if (doCut) {
			try {
				Properties p = ReadSysConfig.getJConfig();
				String needCutImgPath = imgTAction.getmNewImgPath();
				String targetSavePath = imgTAction.getTargetSavePath();
				String isimagecompression = p.getProperty(
						GlobalParam.ISIMAGECOMPRESSION, StaticKey.ZERO);
				if (isimagecompression.equals(StaticKey.ONE)) {
					// 只有当开启压缩时才执行压缩方法并保存缩略图
					int width = Integer.parseInt(p.getProperty(
							GlobalParam.THUMBNAILWIDTH,
							GlobalParam.DEFAULTWIDTH));
					int height = Integer.parseInt(p.getProperty(
							GlobalParam.THUMBNAILHEIGHT,
							GlobalParam.DEFAULTHEIGHT));
					ImgCutTools.compressImages(needCutImgPath, targetSavePath,
							width, height);
				}
			} catch (FileNotFoundException e) {
				log.debug("FileNotFound");
			} catch (IOException e) {
		}
	
		}
	}
}
