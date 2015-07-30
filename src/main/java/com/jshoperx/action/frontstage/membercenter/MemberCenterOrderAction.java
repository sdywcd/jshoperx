package com.jshoperx.action.frontstage.membercenter;

import com.jshoperx.action.backstage.base.DataCollectionTAction;
import com.jshoperx.action.backstage.pay.thirdpartyplatform.alipay.AlipayConfig;
import com.jshoperx.action.backstage.staticspage.FreeMarkervariable;
import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.PageModel;
import com.jshoperx.action.backstage.utils.enums.BaseEnums;
import com.jshoperx.action.backstage.utils.statickey.PaymentCode;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.*;
import com.jshoperx.service.*;
import com.jshoperx.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParentPackage("jshoperx")
@Namespace("")
@InterceptorRefs( { @InterceptorRef("defaultStack") })
public class MemberCenterOrderAction extends ActionSupport {
	@Resource
	private Serial serial;
	@Resource
	private LogisticsBTService logisticsBTService;
	@Resource
	private PaymentMService paymentMService;
	@Resource
	private DeliverAddressTService deliverAddressTService;
	@Resource
	private CartTService cartTService;
	@Resource
	private ShippingAddressTService shippingAddressTService;
	@Resource
	private OrderTService orderTService;
	@Resource
	private UsertService usertService;
	@Resource
	private DataCollectionTAction dataCollectionTAction;
	@Resource
	private MemberTService memberTService;
	@Resource
	private OrderBaseProcessTService orderBaseProcessTService;
	//获取隐藏的url
	private String hidurl;
	private OrderT order = new OrderT();
	private PaymentM pm=new PaymentM();
	private DeliverAddressT dt=new DeliverAddressT();
	private String cp;
	private String orderid;//订单编号
	private String defaultlogisticsid;//默认 物流商id，用来计算默认运费
	//支付方式id
	private String paymentid;
	//物流商id
	private String logisticsid;
	//订单标记
	private String orderTag;

	private String addressid;
	//收获地址id
	private String logisticswebaddress;
	//客户留言，订单备注
	private String customernotes;
	private OrderT oldorder = new OrderT();
	//放入request的数据
	private Map<String, Object> map = new HashMap<String, Object>();
	private boolean spayment = false;//是否支付信息写入成功标记
	private boolean sshoppingaddress = false;//发货地址标记
	private boolean supdateorder = false;//订单更新标记
	private boolean ischangeaddress;//是否改变了收货地址
	private String paymentcode;//返回给前台的支付方式
	private String paymentinterface;//反馈给前台的支付接口类型
	private int rp=8;//每页显示数量
	private int page=1;
	private int total=0;
	private int totalpage=1;
	private boolean slogin;
	private String basePath;


	public OrderT getOrder() {
		return order;
	}

	public void setOrder(OrderT order) {
		this.order = order;
	}

	public OrderT getOldorder() {
		return oldorder;
	}

	public void setOldorder(OrderT oldorder) {
		this.oldorder = oldorder;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getHidurl() {
		return hidurl;
	}

	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}

	public boolean isSupdateorder() {
		return supdateorder;
	}

	public void setSupdateorder(boolean supdateorder) {
		this.supdateorder = supdateorder;
	}

	public boolean isSshoppingaddress() {
		return sshoppingaddress;
	}

	public void setSshoppingaddress(boolean sshoppingaddress) {
		this.sshoppingaddress = sshoppingaddress;
	}

	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getCustomernotes() {
		return customernotes;
	}

	public void setCustomernotes(String customernotes) {
		this.customernotes = customernotes;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getLogisticsid() {
		return logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	public String getOrderTag() {
		return orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}

	public String getDefaultlogisticsid() {
		return defaultlogisticsid;
	}

	public void setDefaultlogisticsid(String defaultlogisticsid) {
		this.defaultlogisticsid = defaultlogisticsid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getLogisticswebaddress() {
		return logisticswebaddress;
	}

	public void setLogisticswebaddress(String logisticswebaddress) {
		this.logisticswebaddress = logisticswebaddress;
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public PaymentM getPm() {
		return pm;
	}

	public void setPm(PaymentM pm) {
		this.pm = pm;
	}

	public String getPaymentcode() {
		return paymentcode;
	}

	public void setPaymentcode(String paymentcode) {
		this.paymentcode = paymentcode;
	}

	public String getPaymentinterface() {
		return paymentinterface;
	}

	public void setPaymentinterface(String paymentinterface) {
		this.paymentinterface = paymentinterface;
	}

	public boolean isSpayment() {
		return spayment;
	}

	public void setSpayment(boolean spayment) {
		this.spayment = spayment;
	}

	public boolean isIschangeaddress() {
		return ischangeaddress;
	}

	public void setIschangeaddress(boolean ischangeaddress) {
		this.ischangeaddress = ischangeaddress;
	}

	public DeliverAddressT getDt() {
		return dt;
	}

	public void setDt(DeliverAddressT dt) {
		this.dt = dt;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 获取用户的所有订单（即已买到的商品）
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	@Action(value = "findAllMemberOrder", results = { @Result(name = "success", type = "freemarker", location = "/WEB-INF/theme/default/shop/myorder.ftl"), @Result(name = "input", type = "redirect", location = "/html/default/shop/user/login.html?redirecturl=${hidurl}") })
	public String findAllMemberOrder() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			//获取最近的订单信息
			this.findAllUserOrderOn(memberT.getId());
			dataCollectionTAction.putBaseInfoToContext();
			return SUCCESS;
		}
		return INPUT;
	}
	
	
	/**
	 * 获取用户未处理的订单只获取前30条
	 */
	public void findAllUserOrderOn(String memberid){
		int currentPage=page;
		int lineSize=rp;
		Criterion criterion= Restrictions.and(Restrictions.ne("orderstate",BaseEnums.OrderState.ORDERSTATE_MEMBER_DELETE_EIGHT_NUM)).add(Restrictions.eq("memberid",memberid)).add(Restrictions.ne("paystate",BaseEnums.OrderPayState.ORDERPAYSTATE_CLOSE_TWO_NUM)).add(Restrictions.ne("shippingstate", BaseEnums.OrderShippingState.ORDERSHIPPINGSTATE_CLOSE_TWO_NUM));
		Order order=Order.desc("purchasetime");
		List<OrderT>list=this.orderTService.findByCriteriaByPage(OrderT.class, criterion, order, currentPage, lineSize);
		total=this.orderTService.count(OrderT.class, criterion).intValue();
		PageModel<OrderT> pm=new PageModel<>(currentPage, lineSize, list, total);
		String action= BaseTools.getBasePath()+"/findAllMemberOrder.action?";
		ActionContext.getContext().put("actionlink", action);
		ActionContext.getContext().put("sign", "disstatic");
		ActionContext.getContext().put("goods", pm);
		ActionContext.getContext().put(FreeMarkervariable.MEMBERORDERON,list);
		ActionContext.getContext().put("totalgoods",pm.getTotalRecord());
		ActionContext.getContext().put("totalpage",pm.getTotalpage());
		

		
	}
	
	
	
	
	
	

	/**
	 * 删除订单（更新订单到8状态）
	 * 
	 * @return
	 */
	@Action(value = "DelOrderByorderid", results = { @Result(name = "success", type = "chain", location = "findAllUserOrder"), @Result(name = "input", type = "redirect", location = "/html/default/shop/login.html?redirecturl=${hidurl}") })
	public String delOrderByorderid() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			String orderstate = BaseEnums.OrderState.ORDERSTATE_MEMBER_DELETE_EIGHT_NUM.getState();//8表示用户自己删除的订单
			Criterion criterion=Restrictions.and(Restrictions.eq("memberid",memberT.getId())).add(Restrictions.eq("orderid", this.getOrderid()));
			OrderT orderT=this.orderTService.findOneByCriteria(OrderT.class, criterion);
			if(orderT!=null){
				orderT.setOrderstate(orderstate);
				orderTService.update(orderT);
			}
			return SUCCESS;
		} else {
			return INPUT;
		}

	}

	/**
	 * 用户更新到收货确认
	 * 
	 * @return
	 */
	@Action(value = "ConfirmGoodsReceive", results = { @Result(name = "success", type = "chain", location = "findAllUserOrder"), @Result(name = "input", type = "redirect", location = "/html/default/shop/login.html?redirecturl=${hidurl}") })
	public String ConfirmGoodsReceive() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			String orderstate = BaseEnums.OrderState.ORDERSTATE_MEMBER_HAVE_REVEIVE_GOODS_SIX_NUM.getState();//6表示用户已经确认收货
			Criterion criterion=Restrictions.and(Restrictions.eq("memberid",memberT.getId())).add(Restrictions.eq("orderid", this.getOrderid()));
			OrderT orderT=this.orderTService.findOneByCriteria(OrderT.class, criterion);
			if(orderT!=null){
				orderT.setOrderstate(orderstate);
				orderTService.update(orderT);
			}
			return SUCCESS;
		} else {
			return INPUT;
		}

	}

	/**
	 * 查询我的未处理订单
	 * 
	 * @return
	 * 
	 */
	@Action(value = "findAllUserOrderOn", results = { @Result(name = "success", type = "freemarker", location = "WEB-INF/theme/default/shop/myorder.ftl"), @Result(name = "input", type = "redirect", location = "/html/default/shop/login.html?redirecturl=${hidurl}") })
	public String findAllUserOrderOn() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
//			currentPage = 1;
//			lineSize = 5;
//			String orderstate = "8";//9表示用户自己删除的订单
//			String paystate = "2";//未付款,已付款
//			String shippingstate = "2";//已发货，未发货
//			try {
//				currentPage = Integer.parseInt(this.getCp());
//			} catch (Exception e) {
//
//			}
//			allRecorders = this.getOrderTService().countfindAllOrderByorderstateForOn(memberT.getId(), orderstate, paystate, shippingstate);
//			List<OrderT> list = this.getOrderTService().findAllOrderByorderstateForOn(currentPage, lineSize, memberT.getId(), orderstate, paystate, shippingstate);
//			//获取我的订单
//			ActionContext.getContext().put("userorderon", list);
//			this.getDataCollectionTAction().putBaseInfoToContext();
			return SUCCESS;
	

		} else {
			return INPUT;
		}
	}

	





	/**
	 * 初始化再次支付的页面信息（收货地址，支付方式，抵用券）用户中心订单付款界面
	 * 
	 * @return
	 */
	@Action(value = "InitPayPage", results = { @Result(name = "success", type="freemarker", location = "/WEB-INF/theme/default/shop/confirmorderag.ftl"), @Result(name = "input", type = "redirect", location = "/html/default/shop/user/login.html?redirecturl=${hidurl}") })
	public String InitPayPage() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			//获取用户收获地址
			ActionContext.getContext().put(FreeMarkervariable.DELIVERADDRESS, orderBaseProcessTService.getMemberDeliverAddress(memberT));
			//获取物流商 需要设定一个默认物流商来计算运费
			ActionContext.getContext().put(FreeMarkervariable.LOGISTICS, orderBaseProcessTService.getLogisticstsBusiness(StaticKey.ONE));
			//获取支付方式
			ActionContext.getContext().put(FreeMarkervariable.PAYMENTS, orderBaseProcessTService.getPaymentM(StaticKey.ONE));
			//获取订单信息
			OrderT o=orderBaseProcessTService.getOrder(this.getOrderid());
			if(o!=null){
				//订单信息
				ActionContext.getContext().put(FreeMarkervariable.MYORDERINFO,o);
				//运费
				ActionContext.getContext().put(FreeMarkervariable.FREIGHT, o.getFreight());
			}
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, BaseTools.getBasePath());
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, dataCollectionTAction.findSiteNavigation(BaseEnums.DataShowState.SHOW.getState()));
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, dataCollectionTAction.findJshopbasicInfo(BaseEnums.DataShowState.SHOW.getState(), BaseEnums.JshopOpenState.OPEN.getOpenstate()));
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, dataCollectionTAction.findFooterCateogyrT(BaseEnums.CategoryGrade.FIRST.getState(), BaseEnums.DataUsingState.USING.getState()));
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, dataCollectionTAction.findFooterArticle(BaseEnums.DataShowState.SHOW.getState()));
			
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	
	
	/**
	 * 增加发货地址
	 */
	public ShippingAddressT saveShippingAddress(DeliverAddressT da) {
		
		ShippingAddressT s = new ShippingAddressT();
		s.setShippingaddressid(serial.Serialid(Serial.SHIPPINGADDRESS));
		s.setMemberid(da.getMemberid());
		s.setShippingusername(da.getShippingusername());
		s.setCountry(da.getCountry());
		s.setProvince(da.getProvince());
		s.setCity(da.getCity());
		s.setDistrict(da.getDistrict());
		s.setStreet(da.getStreet());
		s.setPostcode(da.getPostcode());
		s.setTelno(da.getTelno());
		s.setMobile(da.getMobile());
		s.setEmail(da.getEmail());
		s.setCreatetime(BaseTools.getSystemTime());
		s.setState(StaticKey.ONE);//把发货地址设置成状态1，表示此地址已经和订单绑定
		s.setDeliveraddressid(da.getAddressid());
		s.setIssend(StaticKey.ZERO);//未发送到这个地址过
		s.setOrderid(oldorder.getOrderid());
		this.shippingAddressTService.save(s);
		this.setDt(da);
		this.setSshoppingaddress(true);
		
		return s;

	}

	/**
	 * 比较收货地址和发货地址，判断是否需要更新订单中的收获地址id和发货地址id，和发货地址表中的响应信息
	 */
	public boolean compareShippingAddress(String addressid,String orderid) {
		//如果选中的地址已经在发货地址表，并且用户选中的发货地址也在订单中，则根据订单中的发货地址id读取信息给支付宝
		//如果用户选中的地址不在发货地址表中，那么新增发货地址并且更新发货地址到过去节点并且更新订单中的发货地址
		/**
		 * 获取发货地址表数据，判断传来的收获地址是不是已经在发货地址表中 state="1"表示使用的地址
		 */
		ShippingAddressT sa = orderBaseProcessTService.getShippingAddress(addressid, StaticKey.ONE, orderid);
		if (sa!=null) {
			if (StringUtils.equals(oldorder.getDeliveraddressid(), addressid)) {
				//用户选择的收获地址已经在发货地址表中，那么订单中任然使用原始的发货地址id和收获地址id
				this.setIschangeaddress(false);
			}
			return false;
		} else {
			this.setIschangeaddress(true);//改变了收货地址信息需要新增收货地址
			//设定以前这个订单在发货表中的地址到state2表示弃用了。根据orderid获取并更新
			List<ShippingAddressT>slist=orderBaseProcessTService.getShippingAddress(orderid);
			for(ShippingAddressT s:slist){
				s.setState(StaticKey.TWO);
				this.shippingAddressTService.update(s);
			}
			return true;
		}
	}

	/**
	 * 获取支付方式
	 * @param paymentid
	 * @return
	 */
	private PaymentM getPayway(String paymentid){
		PaymentM pm=orderBaseProcessTService.getSelectedPayMent(paymentid);
		if(pm!=null){
			this.setPm(pm);
			if(StringUtils.equals(PaymentCode.PAYMENT_CODE_ALIPAY, pm.getPaymentCode())){
				this.setPaymentcode(PaymentCode.PAYMENT_CODE_ALIPAY);
				if(StringUtils.equals(StaticKey.PAY_INTERFACE_CODE_TWOPAY, pm.getPaymentInterface())){
					this.setPaymentinterface(StaticKey.PAY_INTERFACE_CODE_TWOPAY);//双接口
				}
			}else if(StringUtils.equals(PaymentCode.PAYMENT_CODE_TENPAY, pm.getPaymentCode())){
				this.setPaymentcode(PaymentCode.PAYMENT_CODE_TENPAY);
				if(StringUtils.equals(StaticKey.PAY_INTERFACE_CODE_TWOPAY, pm.getPaymentInterface())){
					this.setPaymentinterface(StaticKey.PAY_INTERFACE_CODE_TWOPAY);
				}
			}
			this.setSpayment(true);
		}else{
			this.setSpayment(false);
		}
		return pm;
	
	}
	
	/**
	 * 比较支付方式是不是不同了，不同则更新订单，同则不变
	 */
	public PaymentM getPaymentinfo(String paymentid) {
		
		if(StringUtils.equals(oldorder.getPaymentid(), paymentid)){
			return getPayway(paymentid);	
		}else{
			return getPayway(paymentid);
		}
	}

	/**
	 * 比较物流方式是否改变
	 */
	public String compareLogisticsbusiness(String logisticsid) {
		if(StringUtils.equals(oldorder.getLogisticsid(), logisticsid)){
			return oldorder.getLogisticsid();
		}else{
			return logisticsid;
		}
	}

	/**
	 * 更新订单信息
	 * 
	 *
	 */
	public void updateOrderInfo(MemberT membert,PaymentM pm,DeliverAddressT da,ShippingAddressT s,String logisticsid) {
		order.setOrderid(oldorder.getOrderid());
		order.setUserid(oldorder.getUserid());
		order.setUsername(oldorder.getUsername());
		order.setMemberid(membert.getId());
		order.setMembername(membert.getLoginname());
		if(StaticKey.PAY_ON_DELIVERY_TAG.equals(this.getPaymentid())){
			order.setDelivermode(StaticKey.PAY_ON_DELIVERY);
		}else{
			order.setDelivermode(oldorder.getDelivermode());
		}
		order.setDeliverynumber(StaticKey.EMPTY);//发货单号在发货后填写
		order.setOrderstate(oldorder.getOrderstate());
		order.setPaystate(oldorder.getPaystate());
		order.setShippingstate(oldorder.getShippingstate());
		order.setLogisticsid(logisticsid);
		order.setLogisticswebaddress(oldorder.getLogisticswebaddress());
		order.setProductinfo(oldorder.getProductinfo());
		order.setOrdername(oldorder.getOrdername());
		order.setMainpicture(oldorder.getMainpicture());
		order.setNeedquantity(oldorder.getNeedquantity());
		order.setFreight(oldorder.getFreight());
		order.setAmount(oldorder.getAmount());
		order.setPoints(oldorder.getPoints());
		order.setPurchasetime(BaseTools.getSystemTime());
		order.setDeliverytime(null);
		order.setDeliverynumber(StaticKey.EMPTY);
		order.setIsinvoice(oldorder.getIsinvoice());
		order.setCustomerordernotes(this.getCustomernotes());
		order.setPaytime(null);
		order.setOrderTag(oldorder.getOrderTag());
		order.setToBuyerNotes(oldorder.getToBuyerNotes());
		order.setShouldpay(oldorder.getShouldpay());
		order.setUsepoints(oldorder.getUsepoints());
		order.setVouchersid(oldorder.getVouchersid());
		order.setCreatetime(oldorder.getCreatetime());
		order.setUpdatetime(BaseTools.getSystemTime());
		order.setIsprintexpress(oldorder.getIsprintexpress());//未打印快递单
		order.setIsprintinvoice(oldorder.getIsprintinvoice());//未打印发货单
		order.setIsprintfpinvoice(oldorder.getIsprintfpinvoice());//未开具发票
		order.setExpressnumber(oldorder.getExpressnumber());//快递单号
		order.setPaymentid(pm.getPaymentid());
		order.setPaymentname(pm.getPaymentname());
		if(!this.isIschangeaddress()){
			//如果发货地址没有变化则使用以前的订单信息
			order.setShippingaddressid(oldorder.getShippingaddressid());
			order.setDeliveraddressid(oldorder.getDeliveraddressid());
			order.setShippingusername(oldorder.getShippingusername());
		}else{
			//如果发货地址变化则使用新的发货地址信息
			order.setShippingaddressid(s.getShippingaddressid());//设置发货地址到订单中
			order.setDeliveraddressid(da.getAddressid());//设置收货地址到订单中
			order.setShippingusername(da.getShippingusername());//设置收货人
		}
		this.orderTService.update(order);
		this.setSupdateorder(true);
	}

	/**
	 * 获取收货地址信息
	 * @param addressid
	 * @return
	 */
	private DeliverAddressT getDeliverAddress(String addressid){
		return orderBaseProcessTService.getDeliverAddress(addressid);
	}
	
	/**
	 * 再次获取支付所需信息并更新订单
	 * 
	 * @return
	 */
	@Action(value = "InitAgAlipayandUpdateOrder", results = { @Result(name = "json", type = "json") })
	public String initAgAlipayandUpdateOrder() {
		MemberT membert = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (membert != null) {
			this.setSlogin(true);
			//这里需要注意
			//获取一次原始订单比较地址信息
			oldorder=this.orderTService.findByPK(OrderT.class,this.getOrderid());
			//比较发货地址,如果地址和原有订单中的发货地址不一致则废弃原有地址，新增地址
			if(compareShippingAddress(this.getAddressid(),this.getOrderid())){
				//增加发货地址
				DeliverAddressT da=getDeliverAddress(this.getAddressid());
				if(da!=null){
					ShippingAddressT s=saveShippingAddress(da);
					//获取支付方式信息
					PaymentM pm=getPaymentinfo(this.getPaymentid());
					//比较物流并更新
					String lid=compareLogisticsbusiness(this.getLogisticsid());
					if(pm!=null){
						//更新订单
						updateOrderInfo(membert,pm,da,s,lid);
						if(isSupdateorder()){
							if(PaymentCode.PAYMENT_CODE_ALIPAY.equals(pm.getPaymentCode())){
								BuildAlipayConfig();
							}
						}
					}
					
				}
			}
			this.setBasePath(BaseTools.getBasePath());
			return "json";
		} else {
			this.setSlogin(false);
			return "json";
		}

	}
	/**
	 * 开始对支付宝采集数据
	 */
	private void BuildAlipayConfig() {
		AlipayConfig.partner = this.getPm().getPartnerid();
		AlipayConfig.key = this.getPm().getSafecode();
		AlipayConfig.seller_email = this.getPm().getAccount();
		AlipayConfig.out_trade_no = order.getOrderid();
		AlipayConfig.subject = order.getOrdername();
		AlipayConfig.body = order.getOrdername();
		AlipayConfig.price = String.valueOf(order.getShouldpay());
		AlipayConfig.logistics_fee = String.valueOf(order.getFreight());
		//设置收货人信息给支付宝借口
		AlipayConfig.receive_name = this.getDt().getShippingusername();
		AlipayConfig.receive_address = this.getDt().getProvince() + this.getDt().getCity() + this.getDt().getDistrict() + this.getDt().getStreet();
		AlipayConfig.reveive_zip = this.getDt().getPostcode();
		AlipayConfig.reveive_phone = this.getDt().getTelno();
		AlipayConfig.reveive_mobile = this.getDt().getMobile();
		
	}

	/**
	 * 获取订单详细
	 */
	public void getOrderDetail(String orderid) {
		Criterion criterion=Restrictions.eq("orderid", orderid);
		OrderT o = this.orderTService.findOneByCriteria(OrderT.class, criterion);
		if (o != null) {
			o.setOrderstate(BaseEnums.OrderState.getName(o.getOrderstate()));
			o.setPaystate(BaseEnums.OrderPayState.getName(o.getPaystate()));
			o.setShippingstate(BaseEnums.OrderShippingState.getName(o.getShippingstate()));
			o.setIsinvoice(BaseEnums.OrderIsInvoice.getName(o.getIsinvoice()));
			o.setDelivermode(BaseEnums.OrderDeliverMode.getName(o.getDelivermode()));
			o.setOrderTag(BaseEnums.OrderCreateTag.getName(o.getOrderTag()));
			map.put("orderdetail", o);
			//获取买家信息
			getMemberBuyerInfo(o.getMemberid());
		}

	}

	/**
	 * 获取买家信息
	 * 
	 * @param memberid
	 */
	public void getMemberBuyerInfo(String memberid) {
		MemberT memberT = this.memberTService.findByPK(MemberT.class, memberid);
		if (memberT != null) {
			map.put("orderbuyerinfo", memberT);
		}
	}

	/**
	 * 获取订单中的商品列表
	 * 
	 * @param orderid
	 */
	public void getOrderGoodsList(String orderid) {
		Criterion criterion=Restrictions.eq("orderid", orderid);
		List<CartT> list = this.cartTService.findByCriteria(CartT.class, criterion);
		if (list != null) {
			map.put("ordergoods", list);
		}
	}

	/**
	 * 获取订单发货地址
	 * 
	 * @param orderid
	 */
	public void getOrderShippingAddress(String orderid) {
		Criterion criterion=Restrictions.and(Restrictions.eq("orderid", orderid)).add(Restrictions.eq("state", BaseEnums.DataEffectiveState.EFFECTIVE.getState()));
		ShippingAddressT st = this.shippingAddressTService.findOneByCriteria(ShippingAddressT.class, criterion);
		if (st != null) {
			map.put("shipping", st);
		}

	}

	/**
	 * 获取订单详细信息
	 * 
	 * @return
	 */
	@Action(value = "InitMyOrdersDetail", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/myordersdetail.ftl"),
			@Result(name = "input",location = "/html/default/shop/user/login.html")
	})
	public String initMyOrdersDetail() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			if(StringUtils.isNotBlank(this.getOrderid())){
				String orderid = this.getOrderid().trim();
				//获取订单详细
				getOrderDetail(orderid);
				//获取订单中的商品列表
				getOrderGoodsList(orderid);
				//获取发货地址信息
				getOrderShippingAddress(orderid);
				ActionContext.getContext().put("myorder", map);
				dataCollectionTAction.putBaseInfoToContext();
				return SUCCESS;
			}
		}
		return INPUT;
		
	}

}
