package com.jshoperx.action.frontstage.membercenter;

import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.SHA1;
import com.jshoperx.action.backstage.utils.enums.BaseEnums;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.MemberT;
import com.jshoperx.service.MemberTService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@ParentPackage("jshoperx")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")
})
public class LoginAction extends ActionSupport {
	@Resource
	private MemberTService memberTService;
	private MemberT memberT;
	private String basePath;
	private String loginname;
	private String loginpwd;
	private String hidurl;
	private String redirecturl;
	private boolean loginflag;


	public String getRedirecturl() {
		return redirecturl;
	}

	public void setRedirecturl(String redirecturl) {
		this.redirecturl = redirecturl;
	}

	@JSON(serialize = false)
	public MemberT getMemberT() {
		return memberT;
	}

	public void setMemberT(MemberT memberT) {
		this.memberT = memberT;
	}
	

	public boolean isLoginflag() {
		return loginflag;
	}
	public void setLoginflag(boolean loginflag) {
		this.loginflag = loginflag;
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

	public String getHidurl() {
		return hidurl;
	}

	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}



	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 前台用户登录
	 * 
	 * @return
	 */
	@Action(value = "login", results = { 
			@Result(name = "success",type="redirect",location = "${redirecturl}"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String login() {
		this.setBasePath(BaseTools.getBasePath());
		MemberT m = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(m!=null){
			
			ActionContext.getContext().getSession().remove(StaticKey.MEMBER_SESSION_KEY);
		}
		Map<String,String>params=new HashMap<>();
		params.put("loginname",this.getLoginname().trim());
		params.put("loginpwd",SHA1.getDigestOfString(this.getLoginpwd().trim()));
		params.put("memberstate",BaseEnums.MemberState.ACTIVE.getState());
		Criterion criterion= Restrictions.allEq(params);
		MemberT member=memberTService.findOneByCriteria(MemberT.class, criterion);
		if (member!=null) {
			this.setLoginflag(true);
			ActionContext.getContext().getSession().put(StaticKey.MEMBER_SESSION_KEY, member);
			return SUCCESS;
		}
		return INPUT;
	}
	/**
	 * 前台登出 
	 */
	@Action(value = "memberlogout", results = { 
			@Result(name = "success",type="freemarker",location = "/html/default/shop/user/login.html")
	})
	public String memberlogout() throws UnsupportedEncodingException {
		ActionContext.getContext().getSession().remove(StaticKey.MEMBER_SESSION_KEY);
		return SUCCESS;
	}
	
	@Action(value="islogin", results={ @Result(name="json",type="json") })
	public String islogin(){
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			this.setLoginname(memberT.getLoginname());
		}else{
			this.setLoginname("");
		}
		return "json";
	}
	
}
