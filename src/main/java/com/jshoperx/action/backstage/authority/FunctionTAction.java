package com.jshoperx.action.backstage.authority;

import com.jshoperx.action.backstage.base.BaseTAction;
import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.Validate;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.FunctionT;
import com.jshoperx.service.BaseTService;
import com.jshoperx.service.impl.Serial;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.util.*;

@Namespace("")
@ParentPackage("jshoperx")
public class FunctionTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private BaseTService<FunctionT> baseTService;
	private String id;
	private String visiturl;
	private String visitmethodname;
	private String functionname;
	private Date createtime;
	private String moduleid;
	private FunctionT bean = new FunctionT();
	private List<FunctionT> beanlist = new ArrayList<FunctionT>();
	private Map<String, Object> map = new HashMap<String, Object>();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVisiturl() {
		return visiturl;
	}

	public void setVisiturl(String visiturl) {
		this.visiturl = visiturl;
	}

	public String getVisitmethodname() {
		return visitmethodname;
	}

	public void setVisitmethodname(String visitmethodname) {
		this.visitmethodname = visitmethodname;
	}
	public FunctionT getBean() {
		return bean;
	}

	public void setBean(FunctionT bean) {
		this.bean = bean;
	}

	public List<FunctionT> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<FunctionT> beanlist) {
		this.beanlist = beanlist;
	}
	public String getFunctionname() {
		return functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getModuleid() {
		return moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}



	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加可访问的功能路径或方法
	 * 
	 * @return
	 */
	@Action(value = "addFunctionM", results = { @Result(name = "json", type = "json") })
	public String addFunctionM() {
		FunctionT fm = new FunctionT();
		fm.setId(this.getSerial().Serialid(Serial.FUNCTION));
		fm.setFunctionname(this.getFunctionname());
		fm.setVisitmethodname(this.getVisitmethodname());
		fm.setVisiturl(this.getVisiturl());
		fm.setModuleid(this.getModuleid());
		fm.setCreatetime(BaseTools.getSystemTime());
		this.baseTService.save(fm);
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 根据id获取功能信息数据
	 * 
	 * @return
	 */
	@Action(value = "findFunctionMById", results = { @Result(name = "json", type = "json") })
	public String findFunctionMById() {
		if (StringUtils.isNotBlank(this.getId())) {
			setBean(this.baseTService.findByPK(FunctionT.class, this.getId()
					.trim()));
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 更新功能
	 * 
	 * @return
	 */
	@Action(value = "updateFunctionM", results = { @Result(name = "json", type = "json") })
	public String updateFunctionM() {
		getBean().setId(this.getId());
		getBean().setFunctionname(this.getFunctionname());
		getBean().setVisitmethodname(this.getVisitmethodname());
		getBean().setVisiturl(this.getVisiturl());
		getBean().setModuleid(this.getModuleid());
		getBean().setCreatetime(BaseTools.getSystemTime());
		this.baseTService.update(getBean());
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 根据模块id查询对应功能列表
	 * 
	 * @return
	 */
	@Action(value = "findAllFunctionMBymoduleid", results = { @Result(name = "json", type = "json") })
	public String findAllFunctionMBymoduleid() {
		if (Validate.StrNotNull(this.getModuleid())) {
			this.findDefaultAllFunctionMBymoduleid();
		} else {
			this.findAllFunctionM();
		}
		return "json";
	}

	public void findDefaultAllFunctionMBymoduleid() {
		Criterion criterion=Restrictions.eq("moduleid", this.getModuleid());
		Order order=Order.asc("moduleid");
		List<FunctionT> list =this.baseTService.findByCriteria(FunctionT.class, criterion,order);
		if (!list.isEmpty()) {
			total = list.size();
			this.ProcessFunctionMList(list);
		}
	}

	public void findAllFunctionM() {
		List<FunctionT> list = this.baseTService.findAll(FunctionT.class);
		if (!list.isEmpty()) {
			total = list.size();
			this.ProcessFunctionMList(list);
		}
	}

	public void ProcessFunctionMList(List<FunctionT> list) {
		for (Iterator<FunctionT> it = list.iterator(); it.hasNext();) {
			FunctionT fm = (FunctionT) it.next();
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", fm.getId());
			cellMap.put(
					"cell",
					new Object[] {
							fm.getFunctionname(),
							fm.getVisiturl(),
							fm.getVisitmethodname(),
							BaseTools.formateDbDate(fm.getCreatetime()),
							"<a id='editfunction' name='editfunction' href='function.jsp?operate=edit&folder=setting&id="
									+ fm.getId() + "'>[编辑]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 删除系统模块功能
	 * 
	 * @return
	 */
	@Action(value = "delFunctionM", results = { @Result(name = "json", type = "json") })
	public String delFunctionM() {
		if (StringUtils.isNotBlank(this.getId())) {
			String[] strs = StringUtils.split(this.getId(), StaticKey.SPLITDOT);
			for(String s:strs){
				FunctionT fm=this.baseTService.findByPK(FunctionT.class, s);
				if(fm!=null){
					this.baseTService.delete(fm);
				}
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 获取所有功能，给前台的checkbox显示
	 * 
	 * @return
	 */
	@Action(value = "findAllFunction", results = { @Result(name = "json", type = "json") })
	public String findAllFunction() {
		setBeanlist(this.baseTService.findAll(FunctionT.class));
		return "json";
	}


}
