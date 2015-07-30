package com.jshoperx.action.app.goods;

import com.jshoperx.action.app.vo.goods.RequestGoodsCategoryMsg;
import com.jshoperx.action.backstage.base.BaseTAction;
import com.jshoperx.action.backstage.utils.GsonJson;
import com.jshoperx.action.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.GoodsCategoryT;
import com.jshoperx.service.GoodsCategoryTService;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
/**
 * app 商品分类页面接口
* @ClassName: GoodsCategoryAppAction 
* @Description: TODO
* @author sdywcd@gmail.com
* @date 2015年3月24日 下午5:34:53 
*
 */
@Namespace("/app")
@ParentPackage("jshoperx")
@InterceptorRefs({ @InterceptorRef("appstack") })
public class GoodsCategoryAppAction extends BaseTAction implements
ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GoodsCategoryAppAction.class);
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Resource
	private GoodsCategoryTService goodsCategoryTService;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
	
	/**
	 * 获取所有可用的商品分类信息
	 */
	@Action(value = "getAllGoodsCategory4App")
	public void getAllGoodsCategory4App(){
		PrintWriter out = null;
		RequestGoodsCategoryMsg rm=new RequestGoodsCategoryMsg();
		try{
			Criterion criterion=Restrictions.eq("state", DataUsingState.USING.getState());
			Order order=Order.desc("sort");
			List<GoodsCategoryT>list=goodsCategoryTService.findByCriteria(GoodsCategoryT.class, criterion, order);
			rm.setGct(list);
			rm.setSucflag(true);
			String jsonstr = GsonJson.parseDataToJson(rm);
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			out.write(jsonstr);
		}catch(IOException e){
			log.debug(GoodsCategoryAppAction.class.getName() + "has thrown an exception: "
					+ e.getMessage());
			rm.setMsg(StaticKey.SERVER_BUSY);
		}finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		}
	}

}
