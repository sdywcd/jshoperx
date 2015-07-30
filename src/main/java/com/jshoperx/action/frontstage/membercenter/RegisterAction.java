package com.jshoperx.action.frontstage.membercenter;

import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.SHA1;
import com.jshoperx.action.backstage.utils.enums.BaseEnums;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.MemberT;
import com.jshoperx.service.MemberTService;
import com.jshoperx.service.impl.Serial;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ParentPackage("jshoperx")
@Namespace("")
@InterceptorRefs({
//    @InterceptorRef("isusercanregister"),
//    @InterceptorRef("issendactivatemail"),
    @InterceptorRef("defaultStack")  
})
public class RegisterAction extends ActionSupport {
	@Resource
	private MemberTService memberTService;
	@Resource
	private Serial serial;
	private MemberT memberT;
	private String loginname;
	private String loginpwd;
	private String email;
	private String rand;
	private String mid;
	private String question;
	private String answer;
	private String nick;
	private String msg;
	private boolean sucflag;


	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String questoin) {
		this.question = questoin;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public MemberT getMemberT() {
		return memberT;
	}
	public void setMemberT(MemberT memberT) {
		this.memberT = memberT;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	/**
	 * 注册验证
	 * @return
	 */
	public boolean registervalidation(){
		boolean register=false;
		this.setMsg("");
		if(StringUtils.isNotBlank(this.getLoginname())){
			if(this.getLoginname().length()<4){
				this.setMsg("1");
				return register;
			}else if(this.getLoginname().length()>20){
				this.setMsg("1");
				return register;
			}
		}else{
			this.setMsg("1");
			return register;
		}
		if(StringUtils.isNotBlank(this.getLoginpwd())){
			if(this.getLoginpwd().length()<7){
				this.setMsg("2");
				return register;
			}else if(this.getLoginpwd().length()>20){
				this.setMsg("2");
				return register;
			}
		}else{
			this.setMsg("2");
			return register;
		}
		
//		if(!StringUtils.isNotBlank(this.getEmail())){
//			this.setMsg("3");
//			return register;
//		}
		register=true;
		return register;
		
		
	}
	
	/**
	 * 增加新用户
	 * @return
	 */
	@Action(value = "register", results = { 
			@Result(name = "register_success",type="redirect",location = "/index.html"),
			@Result(name = "register_error",type="redirect",location = "/html/default/shop/user/register.html?msg=${msg}"),
			@Result(name = "useractivates",type="redirect",location = "/html/default/shop/user/register.html?msg=${msg}")
	})
	public String register() {
		if(registervalidation()){
			Criterion criterion= Restrictions.eq("loginname", this.getLoginname().toLowerCase(Locale.CHINA));
			MemberT memberT=this.memberTService.findOneByCriteria(MemberT.class, criterion);
			if(memberT!=null){
				this.setMsg("4");
				return "register_error";
			}

			MemberT m=new MemberT();
			m.setId(this.serial.Serialid(Serial.MEMBER));
			m.setMid(SHA1.getDigestOfString(m.getId()));
			m.setLoginname(this.getLoginname().toLowerCase(Locale.CHINA).trim());
			m.setLoginpwd(SHA1.getDigestOfString(this.getLoginpwd().trim()));
			m.setNick(StaticKey.EMPTY);
			m.setRealname(StaticKey.EMPTY);
			m.setCity(StaticKey.EMPTY);
			m.setDistrict(StaticKey.EMPTY);
			m.setSex(StaticKey.EMPTY);
			m.setWhichsex(StaticKey.EMPTY);
			m.setMemberstate(StaticKey.MEMBERSTATE_ONE_NUM);
			m.setMerrystatus(StaticKey.EMPTY);
			m.setBirthday(StaticKey.EMPTY);
			m.setBlood(StaticKey.EMPTY);
			m.setConstellation(StaticKey.EMPTY);
			m.setDes(StaticKey.EMPTY);
			m.setEmail(StaticKey.EMPTY);
			m.setQq(StaticKey.EMPTY);
			m.setWeixin(StaticKey.EMPTY);
			m.setSinaweibo(StaticKey.EMPTY);
			m.setTag(StaticKey.EMPTY);
			m.setBelove(0);
			m.setLoveother(0);
			m.setPostingcount(0);
			m.setQuestion(StaticKey.EMPTY);
			m.setAnswer(StaticKey.EMPTY);
			m.setHeadpath("#");
			m.setCreatetime(BaseTools.getSystemTime());
			m.setCreatorid(StaticKey.ZERO);
			m.setMobile(StaticKey.EMPTY);
			m.setPaypassword(StaticKey.EMPTY);
			m.setMemberGroupId(StaticKey.EMPTY);
			m.setMemberGroupName(StaticKey.EMPTY);
			m.setTelno(StaticKey.EMPTY);
			m.setVersiont(1);
			m.setIntegration(0);
			m.setUpdatetime(m.getCreatetime());
			this.memberTService.save(m);
			return "register_success";
		}else{
			return "register_error";
		}
	}

	
	/**
	 * 激活用户
	 */
	@Action(value = "updateMemberstate", results = { 
			@Result(name = "json",type="json")
	})
	public String updateMemberstate(){
		if(StringUtils.isBlank(this.getMid())){
			return "json";
		}
		Criterion criterion=Restrictions.eq("mid", this.getMid());
		MemberT memberT=this.memberTService.findOneByCriteria(MemberT.class, criterion);
		if(memberT!=null){
			memberT.setMemberstate(BaseEnums.MemberState.ACTIVE.getState());
			this.memberTService.update(memberT);
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	/**
	 * 根据安全问题和答案检查用户是否存在
	 * @return
	 */
	@Action(value = "findMemberByQA", results = { 
			@Result(name = "json",type="json")
	})
	public String findMemberByQA(){
		if(StringUtils.isBlank(this.getLoginname())||StringUtils.isBlank(this.getQuestion())||StringUtils.isBlank(this.getAnswer())){
			return "json";
		}
		Map<String,String>params=new HashMap<>();
		params.put("loginname",this.getLoginname());
		params.put("question",this.getQuestion());
		params.put("answer",this.getAnswer());
		Criterion criterion=Restrictions.allEq(params);
		MemberT memberT=this.memberTService.findOneByCriteria(MemberT.class,criterion);
		if(memberT!=null){
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}

}
