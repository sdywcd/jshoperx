package com.jshoperx.action.frontstage.goods;


import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.GoodsCommentT;
import com.jshoperx.entity.MemberT;
import com.jshoperx.service.GoodsCommentTService;
import com.jshoperx.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
@ParentPackage("jshoperx")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class GoodsCommentAction extends ActionSupport {
	@Resource
	private GoodsCommentTService goodsCommentTService;
	@Resource
	private Serial serial;
	private String commentid;
	private String goodsid;
	private String goodsname;
	private String replyorcommentusername;
	private Date posttime;
	private String commentcontent;
	private Integer score;
	private String state;
	private String replyorcomment;
	private String replyid;
	private String replyorcommentuserid;
	private String emailable;
	private String userid;
	private boolean slogin;
	private boolean sucflag;



	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getReplyorcommentusername() {
		return replyorcommentusername;
	}
	public void setReplyorcommentusername(String replyorcommentusername) {
		this.replyorcommentusername = replyorcommentusername;
	}
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getReplyorcomment() {
		return replyorcomment;
	}
	public void setReplyorcomment(String replyorcomment) {
		this.replyorcomment = replyorcomment;
	}
	public String getReplyid() {
		return replyid;
	}
	public void setReplyid(String replyid) {
		this.replyid = replyid;
	}
	public String getReplyorcommentuserid() {
		return replyorcommentuserid;
	}
	public void setReplyorcommentuserid(String replyorcommentuserid) {
		this.replyorcommentuserid = replyorcommentuserid;
	}
	public String getEmailable() {
		return emailable;
	}
	public void setEmailable(String emailable) {
		this.emailable = emailable;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public boolean isSlogin() {
		return slogin;
	}
	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	/**
	 * 去除查询所有商品类别的错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}

	

	/**
	 * 增加用户评论商品
	 * @return
	 */
	@Action(value = "addGoodsComment", results = { 
			@Result(name = "json",type="json")
	})
	public String addGoodsComment(){
		MemberT member=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(member!=null){
			GoodsCommentT gct=new GoodsCommentT();
			gct.setCommentid(this.serial.Serialid(Serial.GOODSCOMMENT));
			gct.setGoodsid(this.getGoodsid().trim());
			gct.setGoodsname(this.getGoodsname());
			gct.setReplyorcommentusername(member.getLoginname());
			gct.setReplyorcommentuserid(member.getId());
			gct.setPosttime(BaseTools.getSystemTime());
			gct.setCommentcontent(this.getCommentcontent());
			gct.setScore(0);
			gct.setState("1");//显示
			gct.setReplyorcomment("1");//评论
			gct.setReplyid("0");//回复的评论id
			gct.setEmailable("0");//不进行邮件提醒
			gct.setVirtualadd("0");
			this.goodsCommentTService.save(gct);
			this.setSucflag(true);
			return "json";
			
		}
		this.setSucflag(false);
		return "json";
	}
	
	
	
	
	
}
