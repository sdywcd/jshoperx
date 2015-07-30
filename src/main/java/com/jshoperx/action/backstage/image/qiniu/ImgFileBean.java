package com.jshoperx.action.backstage.image.qiniu;

/**
* Created with sdywcd@gmail.com
* Author:sdywcd@gmail.com
* Date:15/7/23
* Time:下午5:30
* Note:图片上传结果返回内容实体
**/
public class ImgFileBean {

	private boolean sucflag;
	private boolean isCloudImg;
	private String normalfilepath;
	private String compressfilepath;
	
	public boolean isCloudImg() {
		return isCloudImg;
	}
	public void setCloudImg(boolean isCloudImg) {
		this.isCloudImg = isCloudImg;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	public String getNormalfilepath() {
		return normalfilepath;
	}
	public void setNormalfilepath(String normalfilepath) {
		this.normalfilepath = normalfilepath;
	}
	public String getCompressfilepath() {
		return compressfilepath;
	}
	public void setCompressfilepath(String compressfilepath) {
		this.compressfilepath = compressfilepath;
	}
	
	
}
