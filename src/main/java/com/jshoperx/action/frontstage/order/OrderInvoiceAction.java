package com.jshoperx.action.frontstage.order;


import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.enums.BaseEnums;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.MemberT;
import com.jshoperx.entity.OrderInvoiceT;
import com.jshoperx.entity.OrderT;
import com.jshoperx.service.OrderInvoiceTService;
import com.jshoperx.service.OrderTService;
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
public class OrderInvoiceAction extends ActionSupport {
	@Resource
	private OrderInvoiceTService orderInvoiceTService;
	@Resource
	private Serial serial;
	@Resource
	private OrderTService orderTService;
	private String orderInvoiceid;
	private String orderid;
	private String invType;
	private String invPayee;
	private String amount;
	private String userid;
	private String state;
	private String username;
	private String invContent;
	private Date createtime;
	
	private boolean slogin;
	private boolean saddflag;

	
	public String getOrderInvoiceid() {
		return orderInvoiceid;
	}
	public void setOrderInvoiceid(String orderInvoiceid) {
		this.orderInvoiceid = orderInvoiceid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getInvType() {
		return invType;
	}
	public void setInvType(String invType) {
		this.invType = invType;
	}
	public String getInvPayee() {
		return invPayee;
	}
	public void setInvPayee(String invPayee) {
		this.invPayee = invPayee;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getInvContent() {
		return invContent;
	}
	public void setInvContent(String invContent) {
		this.invContent = invContent;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public boolean isSlogin() {
		return slogin;
	}
	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}
	public boolean isSaddflag() {
		return saddflag;
	}
	public void setSaddflag(boolean saddflag) {
		this.saddflag = saddflag;
	}

	/**
	 *清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	
	/**
	 *增加订单发票
	 * @return
	 */
	@Action(value = "addOrderInvoice", results = { 
			@Result(name = "json",type="json")
	})
	public String addOrderInvoice(){
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			OrderInvoiceT oi=new OrderInvoiceT();
			oi.setOrderInvoiceid(this.serial.Serialid(Serial.ORDERINVOICE));
			oi.setOrderid(this.getOrderid().trim());
			oi.setInvType(this.getInvType());
			oi.setInvPayee(this.getInvPayee().trim());
			oi.setAmount(this.getAmount());
			oi.setMemberid(memberT.getId());
			oi.setMembername(memberT.getLoginname());
			oi.setState(BaseEnums.InvState.UNDO.getState());
			oi.setInvContent(this.getInvContent());
			oi.setCreatetime(BaseTools.getSystemTime());
			this.orderInvoiceTService.save(oi);
				updateInvoiceByOrderId(this.getOrderid().trim(), "1");
				this.setSaddflag(true);
				return "json";
			
		}
		return "json";
	}
	
	/**
	 * 更新订单是否要开票标记
	 */
	private void updateInvoiceByOrderId(String orderid,String invoice){
		OrderT order=orderTService.findByPK(OrderT.class, orderid);
		if(order!=null){
			order.setIsinvoice(BaseEnums.OrderIsInvoice.ORDERISINVOICE_DO_ONE_NUM.getState());
			orderTService.update(order);
		}
	}
	
	
	
}
