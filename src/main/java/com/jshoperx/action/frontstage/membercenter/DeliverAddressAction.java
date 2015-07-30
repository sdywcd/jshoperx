package com.jshoperx.action.frontstage.membercenter;


import com.jshoperx.action.backstage.base.DataCollectionTAction;
import com.jshoperx.action.backstage.staticspage.FreeMarkervariable;
import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.DeliverAddressT;
import com.jshoperx.entity.MemberT;
import com.jshoperx.service.DeliverAddressTService;
import com.jshoperx.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ParentPackage("jshoperx")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class DeliverAddressAction extends ActionSupport {
	private Serial serial;
	private DeliverAddressTService deliverAddressTService;
	private DataCollectionTAction dataCollectionTAction;
	private DeliverAddressT bean = new DeliverAddressT();
	private String addressid;
	private String userid;
	private String membername;
	private String province;
	private String city;
	private String district;
	private String street;
	private String postcode;
	private String telno;
	private String mobile;
	private String email;
	private String state;
	private String country;

	private boolean sucflag;
	private boolean slogin;
	private String basePath;
	
	private Map<String,Object>map=new HashMap<String,Object>();
	
	@JSON(serialize=false) 
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	@JSON(serialize=false) 
	public DeliverAddressTService getDeliverAddressTService() {
		return deliverAddressTService;
	}

	public void setDeliverAddressTService(DeliverAddressTService deliverAddressTService) {
		this.deliverAddressTService = deliverAddressTService;
	}

	@JSON(serialize=false) 
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public DeliverAddressT getBean() {
		return bean;
	}

	public void setBean(DeliverAddressT bean) {
		this.bean = bean;
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
	 * 增加用户收获地址
	 * @return
	 */
	@Action(value = "addDeliveraddress", results = { 
			@Result(name = "json",type="json")
	})
	public String addDeliveraddress(){
		MemberT member=(MemberT)ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(member!=null){
			DeliverAddressT d=new DeliverAddressT();
			d.setAddressid(this.getSerial().Serialid(Serial.DELIVERADDRESS));
			d.setMemberid(member.getId());
			d.setShippingusername(this.getMembername().trim());
			d.setCountry(this.getCountry().trim());
			d.setProvince(this.getProvince().trim());
			d.setCity(this.getCity().trim());
			d.setDistrict(this.getDistrict().trim());
			d.setStreet(this.getStreet().trim());
			d.setPostcode(this.getPostcode().trim());
			d.setTelno(this.getTelno());
			d.setMobile(this.getMobile());
			d.setEmail(this.getEmail().trim());
			d.setCreatetime(BaseTools.getSystemTime());
			d.setState(StaticKey.ZERO);//0非默认，1默认
			this.getDeliverAddressTService().save(d);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 获取用户收获地址
	 * @return
	 */
	@Action(value = "getMemberDeliverAddress", results = { 
			@Result(name = "success",type="chain",location = "initOrder"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String getUserDeliverAddress(){
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			Criterion criterion= Restrictions.eq("memberid",memberT.getId());

			List<DeliverAddressT> list=this.deliverAddressTService.findByCriteria(DeliverAddressT.class,criterion);
			ActionContext.getContext().put(FreeMarkervariable.DELIVERADDRESS, list);
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}

	
	/**
	 * 根据收获地址id删除收获地址
	 * @return
	 */
	@Action(value = "delDeliverAddressByaddressid", results = { @Result(name = "json", type = "json") })
	public String delDeliverAddressByaddressid(){
		this.setBasePath(BaseTools.getBasePath());
		MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			if(StringUtils.isNotBlank(this.getAddressid())){
				String strs[]=StringUtils.split(this.getAddressid(), ",");
				for(String s:strs){
					DeliverAddressT d=this.deliverAddressTService.findByPK(DeliverAddressT.class,s);
					if(d!=null){
						this.deliverAddressTService.delete(d);
					}
				}
				this.setSucflag(true);
				return "json";
			}
		}
		return "json";
	}
	/**
	 *用户中心获取用户收货地址
	 * @return
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	@Action(value = "getMemberDeliverAddress4Mc", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/mydeliveraddress.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String getMemberDeliverAddressForUserCenter() throws TemplateException, IOException{
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			Criterion criterion=Restrictions.eq("memberid",memberT.getId());
			List<DeliverAddressT> list=this.getDeliverAddressTService().findByCriteria(DeliverAddressT.class,criterion);
			//获取收货地址
			ActionContext.getContext().put(FreeMarkervariable.DELIVERADDRESS, list);
			this.getDataCollectionTAction().putBaseInfoToContext();
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	/**
	 * 根据地址ID获取用户地址
	 * return 
	 */
	@Action(value = "findDeliverAddressByaddresid", results = { @Result(name = "json", type = "json") })
	public String findDeliverAddressByaddresid(){
		MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			this.setSlogin(true);
			if(StringUtils.isNotBlank(this.getAddressid())){
				Criterion criterion=Restrictions.eq("addressid",this.getAddressid());
				bean = this.getDeliverAddressTService().findOneByCriteria(DeliverAddressT.class,criterion);
				this.setSucflag(true);
				return "json";
			}else{
				this.setSucflag(false);
				return "json";
			}
	
		}
		this.setSucflag(false);
		return "json";
		
	}
	
	/**
	 * 根据地址ID更新用户地址
	 * 
	 */
	@Action(value = "updateDeliverAddress", results = { @Result(name = "json", type = "json") })
	public String updateDeliverAddress(){
		MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			this.setSlogin(true);
			if(StringUtils.isNotBlank(this.getAddressid())){
				bean = this.getDeliverAddressTService().findByPK(DeliverAddressT.class,this.getAddressid());
				bean.setShippingusername(this.getMembername().trim());
				bean.setCountry(this.getCountry());
				bean.setProvince(this.getProvince());
				bean.setCity(this.getCity());
				bean.setDistrict(this.getDistrict());
				bean.setStreet(this.getStreet());
				bean.setTelno(this.getTelno());
				bean.setMobile(this.getMobile());
				bean.setPostcode(this.getPostcode());
				bean.setEmail(this.getEmail());
				this.getDeliverAddressTService().update(bean);
				this.setSucflag(true);
				return "json";
			}else{
				this.setSucflag(false);
				return "json";
			}
		}
		this.setSucflag(false);
		return "json";
	}
}
