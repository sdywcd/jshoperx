package com.jshoperx.action.frontstage.cart;

import com.jshoperx.action.backstage.base.DataCollectionTAction;
import com.jshoperx.action.backstage.staticspage.FreeMarkervariable;
import com.jshoperx.action.backstage.utils.Arith;
import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.enums.BaseEnums;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.CartT;
import com.jshoperx.entity.GoodsT;
import com.jshoperx.entity.MemberT;
import com.jshoperx.entity.OrderSnapshotT;
import com.jshoperx.service.CartTService;
import com.jshoperx.service.GoodsTService;
import com.jshoperx.service.OrderSnapshotTService;
import com.jshoperx.service.ProductTService;
import com.jshoperx.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.util.*;

@ParentPackage("jshoperx")
@Namespace("")
@InterceptorRefs( { @InterceptorRef("defaultStack") })
public class CartAction extends ActionSupport {
	/**
	 * 开启规格标记＝1
	 */
	public final static String OPENGUIGE="1";
	private GoodsTService goodsTService;
	private CartTService cartTService;
	private ProductTService productTService;
	@Resource
	private OrderSnapshotTService orderSnapshotTService;
	private DataCollectionTAction dataCollectionTAction;
	private Serial serial;
	private String hidurl;
	private String redirecturl;
	private String cartid;
	private String orderid;
	private String goodsid;
	private String goodsname;
	private String userid;
	private String username;
	private String needquantity;
	private String price;
	private String favorable;
	private String changeprice;
	private String points;
	private String subtotal;
	private String quantity;
	private String picture;
	private String orderTag;
	private String id;
	private String guigeflag;//是否规格商品标记
	private String productid;//货品id
	private String sendstring;
	private Double totalweight = 0.0;
	private Double totalmemberprice = 0.0;
	private String basePath;
	private boolean sucflag;
	private boolean slogin;
	
	@JSON(serialize = false)
	public ProductTService getProductTService() {
		return productTService;
	}

	public void setProductTService(ProductTService productTService) {
		this.productTService = productTService;
	}

	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}

	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}

	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}

	@JSON(serialize = false)
	public CartTService getCartTService() {
		return cartTService;
	}

	public void setCartTService(CartTService cartTService) {
		this.cartTService = cartTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNeedquantity() {
		return needquantity;
	}

	public void setNeedquantity(String needquantity) {
		this.needquantity = needquantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFavorable() {
		return favorable;
	}

	public void setFavorable(String favorable) {
		this.favorable = favorable;
	}

	public String getChangeprice() {
		return changeprice;
	}

	public void setChangeprice(String changeprice) {
		this.changeprice = changeprice;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public String getHidurl() {
		return hidurl;
	}

	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}

	public Double getTotalweight() {
		return totalweight;
	}

	public void setTotalweight(Double totalweight) {
		this.totalweight = totalweight;
	}

	public Double getTotalmemberprice() {
		return totalmemberprice;
	}

	public void setTotalmemberprice(Double totalmemberprice) {
		this.totalmemberprice = totalmemberprice;
	}

	public String getRedirecturl() {
		return redirecturl;
	}

	public void setRedirecturl(String redirecturl) {
		this.redirecturl = redirecturl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSendstring() {
		return sendstring;
	}

	public void setSendstring(String sendstring) {
		this.sendstring = sendstring;
	}

	public String getGuigeflag() {
		return guigeflag;
	}

	public void setGuigeflag(String guigeflag) {
		this.guigeflag = guigeflag;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getOrderTag() {
		return orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
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
	 * 在增加商品到购物车前查询商品信息
	 */
	public List<GoodsT> GetGoodsdetailByGoodsidForCart() {
		if (StringUtils.isNotBlank(this.getGoodsid())) {
			List<GoodsT> list1 = new ArrayList<GoodsT>();
			String[] tempgoodsid = this.getGoodsid().split(",");
			for (int i = 0; i < tempgoodsid.length; i++) {
				GoodsT list = this.getGoodsTService().findByPK(GoodsT.class, tempgoodsid[i]);
				if (list != null) {

					list1.add(list);
				}
			}
			return list1;
		}
		return null;
	}

	/**
	 * 增加购物车商品
	 * 
	 * @return
	 */
	@Action(value = "addCart", results = { @Result(name = "json", type = "json") })
	public String addCart() {
		this.setBasePath(BaseTools.getBasePath());
		MemberT member = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (member != null) {
			this.setSlogin(true);
			List<GoodsT> gtlist1 = this.GetGoodsdetailByGoodsidForCart();
			for (int i = 0; i < gtlist1.size(); i++) {
				GoodsT gtlist = gtlist1.get(i);
				//如果是货品当且仅当只有一个goodsid时正确
				if(OPENGUIGE.equals(this.getGuigeflag())){
					//进行根据goodsid，userid，productid的在购物车中的商品查询
					Map<String,String>params=new HashMap<>();
					params.put("memberid",member.getId());
					params.put("goodsid",gtlist.getGoodsid());
					params.put("productid",this.getProductid().trim());
					params.put("state", BaseEnums.CartGoodstate.NEWADDTOCART_ONE_NUM.getState());
					Criterion criterion= Restrictions.allEq(params);
					CartT cart=this.getCartTService().findOneByCriteria(CartT.class,criterion);
					if(cart!=null){
						cart.setNeedquantity(cart.getNeedquantity()+1);
						this.getCartTService().update(cart);
						this.setSucflag(true);
					}else{
						//新增商品到购物车
						String[] picturelist = gtlist.getPictureurl().split(",");
						CartT t = new CartT();
						t.setId(this.getSerial().Serialid(Serial.CARTINFO));
						t.setCartid("");//标记是否在同一个购物车中的id这里需要重新处理
						t.setOrderid(null);
						t.setGoodsid(gtlist.getGoodsid());
						t.setGoodsname(gtlist.getGoodsname());
						t.setUserid(member.getId());
						t.setUsername(member.getLoginname());
						t.setMemberid(member.getId());
						t.setMembername(member.getLoginname());
						t.setNeedquantity(Integer.parseInt(this.getNeedquantity()));
						t.setPrice(gtlist.getPrice());
						t.setFavorable(gtlist.getMemberprice());
						t.setChangeprice(0.0);
						t.setPoints(gtlist.getPoints());
						t.setSubtotal(Double.parseDouble(this.getNeedquantity()) * gtlist.getMemberprice());
						t.setAddtime(BaseTools.getSystemTime());
						t.setQuantity(gtlist.getQuantity());
						t.setPicture(picturelist[0]);
						t.setUsersetnum(gtlist.getUsersetnum());
						t.setWeight(gtlist.getWeight());
						t.setState(BaseEnums.CartGoodstate.NEWADDTOCART_ONE_NUM.getState());//新加入购物车的商品
						if(OPENGUIGE.equals(this.getGuigeflag())){
							t.setProductid(this.getProductid());
						}
						t.setOrderTag(this.getOrderTag());
						t.setHtmlpath(gtlist.getHtmlPath());
						this.getCartTService().save(t);
						saveOrderSnapShot(t);
						//要通过事务处理
						this.setSucflag(true);
						
					}
				}else{
					Map<String,String>params=new HashMap<>();
					params.put("memberid",member.getId());
					params.put("goodsid",gtlist.getGoodsid());
					params.put("state", BaseEnums.CartGoodstate.NEWADDTOCART_ONE_NUM.getState());
					Criterion criterion= Restrictions.allEq(params);
					CartT cart=this.getCartTService().findOneByCriteria(CartT.class, criterion);
					if (cart != null) {
						//同状态的商品只能在购物车出现一次
						//更新对应商品id的数量	//检测商品是否已经在购物车中，如果有责增加数量，没有责加入
						cart.setNeedquantity(cart.getNeedquantity()+1);
						this.getCartTService().update(cart);
						this.setSucflag(true);

						//state=1表示更新商品到新增状态，前台可在购物车读取。注意在同一个商品被删除后，通过更新状态到1做到可以再次购买这个商品
						//					if(cart.getState().equals("2")){
						//						@SuppressWarnings("unused")
						//						int k=this.getCartserviceimpl().UpdateCartState(user.getUserid(), this.getGoodsid().trim(), "1");
						//					
						//					}
						//更新商品价格小计subtotal
						//int j=this.getCartserviceimpl().UpdateCartSubtotal(user.getUserid(), this.getGoodsid(), Integer.parseInt(this.getNeedquantity())*cart.getFavorable());
						
					} else {
						//新曾商品到购物车
						String[] picturelist = gtlist.getPictureurl().split(",");
						CartT t = new CartT();
						t.setId(this.getSerial().Serialid(Serial.CARTINFO));
						t.setCartid("");
						t.setOrderid(null);
						t.setGoodsid(gtlist.getGoodsid());
						t.setGoodsname(gtlist.getGoodsname());
						t.setUserid(member.getId());
						t.setUsername(member.getLoginname());
						t.setMemberid(member.getId());
						t.setMembername(member.getLoginname());
						t.setNeedquantity(Integer.parseInt(this.getNeedquantity()));
						t.setPrice(gtlist.getPrice());
						t.setFavorable(gtlist.getMemberprice());
						t.setChangeprice(0.0);
						t.setPoints(gtlist.getPoints());
						t.setSubtotal(Double.parseDouble(this.getNeedquantity()) * gtlist.getMemberprice());
						t.setAddtime(BaseTools.getSystemTime());
						t.setQuantity(gtlist.getQuantity());
						t.setPicture(picturelist[0]);
						t.setUsersetnum(gtlist.getUsersetnum());
						t.setWeight(gtlist.getWeight());
						t.setState("1");//新加入购物车的商品				
						t.setProductid("");//表示非规格商品即为空
						t.setHtmlpath(gtlist.getHtmlPath());//
						t.setOrderTag(this.getOrderTag());
						this.getCartTService().save(t);
						saveOrderSnapShot(t);
						this.setSucflag(true);
					}
				}
				
			}
			
			return "json";
		}
		this.setSlogin(false);
		return "json";

	}

	/**
	 * 订单的快照
	 * @param t
	 */
	private void saveOrderSnapShot(CartT t){
		OrderSnapshotT os=new OrderSnapshotT();
		os.setId(this.getSerial().Serialid(Serial.ORDERSNAPSHOTT));
		os.setCartinfoid(t.getId());
		os.setCartid(StaticKey.EMPTY);
		os.setOrderid(StaticKey.EMPTY);
		os.setGoodsid(t.getGoodsid());
		os.setGoodsname(t.getGoodsname());
		os.setUserid(t.getUserid());
		os.setUsername(t.getUsername());
		os.setNeedquantity(t.getNeedquantity());
		os.setPrice(t.getPrice());
		os.setFavorable(t.getFavorable());
		os.setChangeprice(t.getChangeprice());
		os.setPoints(t.getPoints());
		os.setSubtotal(t.getSubtotal());
		os.setAddtime(t.getAddtime());
		os.setQuantity(t.getQuantity());
		os.setPicture(t.getPicture());
		os.setUsersetnum(t.getUsersetnum());
		os.setWeight(t.getWeight());
		os.setState(StaticKey.ONE);//订单快照状态 1可用
		os.setHtmlpath("");
		os.setProductid(t.getProductid());
		os.setOrderTag(t.getOrderTag());
		os.setMemberid(t.getMemberid());
		os.setMembername(t.getMembername());
		os.setStoreTag(1);//当前库存状态1有库存
		os.setShopid(StaticKey.EMPTY);//店铺id
		os.setShippingaddressid(StaticKey.EMPTY);
		orderSnapshotTService.save(os);
	}


	/**
	 * 获取购物车数据给用户中心我的购物车
	 * 
	 * @return
	 */
	//	@Action(value = "findAllCartByUserIdForUsercenter", results = { 
	//			@Result(name = "success", type="redirect",location = "/jshop/admin/adminindex.jsp?session=${param}"),
	//			@Result(name = "input", type="redirect",location = "/jshop/admin/adminlogin.jsp?msg=${param}")
	//	})
	//	public String findAllCartByUserIdForUsercenter() {
	//		UserT user = (UserT) ActionContext.getContext().getSession().get("user");
	//		if (user != null) {
	//			List<CartT> list = this.getCartTServiceImpl().findAllCartByUserId(user.getUserid());
	//			if (list != null && list.size() > 0) {
	//				//删除购物车session
	//				ActionContext.getContext().getSession().remove("usercart");
	//				this.setTotalmemberprice(0.0);
	//				this.setTotalweight(0.0);
	//				for (Iterator it = list.iterator(); it.hasNext();) {
	//					CartT ct = (CartT) it.next();
	//					totalweight = Arith.add(totalweight, Arith.mul(Double.parseDouble(ct.getWeight()), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
	//					totalmemberprice = Arith.add(totalmemberprice, Arith.mul(ct.getFavorable(), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
	//
	//				}
	//				//获取推荐商品（暂时根据价位来获取）
	//				GetRcommendedGoods(5, Arith.sub(list.get(0).getFavorable(), 20.0), Arith.add(list.get(0).getFavorable(), 20.0), list.get(0).getGoodsid());
	//				Map<String, Object> map = new HashMap<String, Object>();
	//				map.put("cart", list);
	//				map.put("totalweight", totalweight);
	//				map.put("totalmemberprice", totalmemberprice);
	//				map.put("count", list.size());
	//				ActionContext.getContext().getSession().put("usercart", map);
	//				return SUCCESS;
	//			}
	//			//删除购物车session
	//			ActionContext.getContext().getSession().remove("usercart");
	//			return SUCCESS;
	//		}
	//		ActionContext.getContext().getSession().remove("usercart");
	//		return INPUT;
	//	}

	/**
	 * 根据userid获取购物车信息(给普通商品使用ordertag=1)
	 * 
	 * @return
	 */
	@Action(value = "findAllCartByMemberId", results = { @Result(name = "success", type = "freemarker", location = "/WEB-INF/theme/default/shop/mycart.ftl"), @Result(name = "input", type = "redirect", location = "/html/default/shop/user/login.html?redirecturl=${redirecturl}") })
	public String findAllCartByMemberId() {
		this.setBasePath(BaseTools.getBasePath());
		MemberT member = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (member != null) {
			String state=BaseEnums.CartGoodstate.NEWADDTOCART_ONE_NUM.getState();//表示新加入购物车商品的标记
			String orderTag=StaticKey.EMPTY;
			if(StringUtils.isNotBlank(this.getOrderTag())){
				orderTag=BaseEnums.OrderCreateTag.ORDERTAG_NORMAL_ONE_NUM.getState();
			}else{
				orderTag=this.getOrderTag().trim();
			}
			Map<String,String>params=new HashMap<>();
			params.put("memberid",member.getId());
			params.put("state",state);
			params.put("orderTag",orderTag);
			Criterion criterion=Restrictions.allEq(params);
			List<CartT> list = this.getCartTService().findByCriteria(CartT.class,criterion);
			this.setTotalmemberprice(0.0);
			this.setTotalweight(0.0);
			for (Iterator it = list.iterator(); it.hasNext();) {
				CartT ct = (CartT) it.next();
				if(ct.getWeight()!=null){
					totalweight = Arith.add(totalweight, Arith.mul(Double.parseDouble(ct.getWeight()), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				}
				totalmemberprice = Arith.add(totalmemberprice, Arith.mul(ct.getFavorable(), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
			}
			ActionContext.getContext().put(FreeMarkervariable.MEMBERCART, list);
			ActionContext.getContext().put(FreeMarkervariable.TOTALMEMBERPRICE, totalmemberprice);
			ActionContext.getContext().put(FreeMarkervariable.TOTALWEIGHT, totalweight);
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, BaseTools.getBasePath());
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation(BaseEnums.DataShowState.SHOW.getState()));
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(BaseEnums.DataShowState.SHOW.getState(),BaseEnums.JshopOpenState.OPEN.getOpenstate()));
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT(BaseEnums.CategoryGrade.FIRST.getState(),BaseEnums.DataShowState.SHOW.getState()));
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle(BaseEnums.DataShowState.SHOW.getState()));
			return SUCCESS;
		}
		return INPUT;
	}

	/**
	 * 获取用户购物车数据用于上方显示购物车数据
	 * 
	 * @return
	 */
	@Action(value = "findAllCartByUserIdFortopCart", results = { @Result(name = "json", type = "json") })
	public String findAllCartByUserIdFortopCart() {
		MemberT member = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (member != null) {
			String state=BaseEnums.CartGoodstate.NEWADDTOCART_ONE_NUM.getState();//表示新加入购物车商品的标记
			String orderTag=this.getOrderTag().trim();
			Map<String,String>params=new HashMap<>();
			params.put("memberid",member.getId());
			params.put("state",state);
			params.put("orderTag",orderTag);
			Criterion criterion=Restrictions.allEq(params);
			List<CartT> list = this.getCartTService().findByCriteria(CartT.class, criterion);
			if (list != null && list.size() > 0) {
				//删除购物车session
				ActionContext.getContext().getSession().remove("usercart");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("cart", list);
				map.put("count", list.size());
				ActionContext.getContext().getSession().put("usercart", map);
				return "json";
			}
			//删除购物车session
			ActionContext.getContext().getSession().remove("usercart");
			return "json";
		}
		ActionContext.getContext().getSession().remove("usercart");
		return "json";
	}

	/**
	 * 更新商品数量，在提交订单时修改购物车商品数量的ajax
	 * 
	 * @return
	 */
	@Action(value = "PlusCartNeedquantityByGoodsid", results = { @Result(name = "json", type = "json") })
	public String PlusCartNeedquantityByGoodsid() {
		MemberT member = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (member != null) {
			//更新对应商品id的数量	//检测商品是否已经在购物车中，如果有责增加数量，没有责加入
			String[] tempstring = this.getSendstring().split(":");
			String temp = null;
			String[] ttemp = null;
			String cartid = this.getSerial().Serialid(Serial.CART);//获取购物车信息id是可重复的。一次提交只有一个购物车信息id,标记这批商品被标记在同一个订单中
			Map<String,String>params=new HashMap<>();

			for (int k = 0; k < tempstring.length; k++) {
				temp = tempstring[k];
				ttemp = temp.split(StaticKey.SPLITDOT);
				params.put("memberid",member.getId());
				params.put("goodsid",ttemp[0]);
				Criterion criterion=Restrictions.allEq(params);
				CartT cart=this.getCartTService().findOneByCriteria(CartT.class, criterion);
				if(cart!=null){
					cart.setNeedquantity(Integer.parseInt(ttemp[1]));
					this.getCartTService().update(cart);
					params.clear();
					params.put("memberid", member.getId());
					params.put("state", BaseEnums.CartGoodstate.NEWADDTOCART_ONE_NUM.getState());
					params.put("goodsid",ttemp[0]);
					Criterion criterion1=Restrictions.allEq(params);
					cart=this.getCartTService().findOneByCriteria(CartT.class,criterion1);
					if(cart!=null){
						cart.setCartid(cartid);
						cart.setProductid(ttemp[0]);
						this.getCartTService().update(cart);

					}
				}

			}
			this.setSucflag(true);
			return "json";
		} else {
			this.setSlogin(true);
			return "json";
		}
	}

	/**
	 * 删除购物车中的商品
	 * 
	 * 
	 * @return
	 */
	@Action(value = "DelCartByGoodsId", results = { @Result(name = "json", type = "json") })
	public String DelCartByGoodsId() {
		MemberT member = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (member != null) {
			this.setSlogin(true);
			@SuppressWarnings("unused")
			Map<String,String>params=new HashMap<>();
			params.put("memberid",member.getId());
			params.put("state",BaseEnums.CartGoodstate.NEWADDTOCART_ONE_NUM.getState());
			params.put("goodsid", this.getGoodsid());
			Criterion criterion=Restrictions.allEq(params);
			CartT cartT=this.getCartTService().findOneByCriteria(CartT.class, criterion);
			this.getCartTService().delete(cartT);
			this.setSucflag(true);
			return "json";
		} else {
			this.setSlogin(false);
			return "json";
		}
	}
	/**
	 * 删除购物车中的商品
	 * 
	 * @return
	 */
	@Action(value = "delCartByid", results = { @Result(name = "json", type = "json") })
	public String delCartByid() {
		MemberT user = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (user != null) {
			this.setSlogin(true);
			CartT cartT=this.getCartTService().findByPK(CartT.class,this.getId());
			this.getCartTService().delete(cartT);
			this.setSucflag(true);
			return "json";
		} else {
			this.setSlogin(false);
			return "json";
		}
	}

	/**
	 * 暂时删除购物车中商品
	 * 
	 * @return
	 */
	@Action(value = "UpdateCartGoodsstate2", results = { @Result(name = "success", type = "chain", location = "findAllCartByUserId"), @Result(name = "input", type = "redirect", location = "/html/default/shop/user/login.html?redirecturl=${redirecturl}") })
	public String UpdateCartGoodsstate2() {
		MemberT member = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (member != null) {
			String []strs=StringUtils.split(this.getGoodsid(),StaticKey.SPLITDOT);
			for(String s:strs){
				Criterion criterion=Restrictions.and(Restrictions.eq("memberid",member.getId())).add(Restrictions.eq("goodsid",s));
				CartT cart=this.getCartTService().findOneByCriteria(CartT.class,criterion);
				if(cart!=null){
					cart.setState(BaseEnums.CartGoodstate.HAVE_DELETETOCART_TWO_NUM.getState());
					this.getCartTService().update(cart);
				}
			}
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

}
