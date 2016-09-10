package com.jfxy.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfxy.pojo.Goods;
import com.jfxy.pojo.GoodsClassRebat;
import com.jfxy.pojo.Goodsclass;
import com.jfxy.pojo.Goodslog;
import com.jfxy.pojo.Orderlog;
import com.jfxy.pojo.Staff;
import com.jfxy.pojo.Timingproject;
import com.jfxy.pojo.Timingrules;
import com.jfxy.pojo.form.GoodsFormBean;
import com.jfxy.pojo.form.GoodsclassFormBean;
import com.jfxy.pojo.form.GoodslogFormBean;
import com.jfxy.pojo.form.OrderlogFormBean;
import com.jfxy.pojo.form.TimingprojectFormBean;
import com.jfxy.pojo.form.TimingrulesFormBean;
import com.jfxy.service.StockManagerService;

/**
 * 
 * 商品管理模块
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
@Controller
@RequestMapping(value = "/StockManager")
public class StockManagerAction extends BaseAction{
	Logger logger=Logger.getLogger(StockManagerAction.class);
	@Autowired
	private StockManagerService stockManagerService;
	
	/**
	 * 查询商品级别
	 * @param request
	 * @param goodsclassFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "SetGoodsLevel", method = RequestMethod.GET)
	public String setGoodsLevel(HttpServletRequest request, GoodsclassFormBean goodsclassFormBean){
		
		if(goodsclassFormBean.getGoodclassshopid()==null||goodsclassFormBean.getGoodclassshopid()==0){
			goodsclassFormBean.setGoodclassshopid(getUserShopId());
		}
		
		
		goodsclassFormBean=stockManagerService.getPage(goodsclassFormBean);
		
		request.setAttribute("goodsclassFormBean", goodsclassFormBean);
		logger.info("设置分类级别");
		return "SetGoodsLevel.jsp";
	}
	
	/**
	 * 编辑商品级别
	 * @param request
	 * @param classid
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "EditGoodsLevel", method = RequestMethod.GET)
	public String editGoodsLevel(HttpServletRequest request,Integer classid){
		List<GoodsClassRebat> goodsClassList=null;
		if(classid==null){
			 goodsClassList=stockManagerService.getGoodsclassrebatlist();
		}else{
			Integer shopid=1;
			 goodsClassList=stockManagerService.getGoodsclassrebatlist(classid, shopid);
			 Goodsclass goodsclass=stockManagerService.findGoodsclass(classid);
			 request.setAttribute("goodsclass", goodsclass);
		}
		GoodsclassFormBean goodsclassFormBean=new GoodsclassFormBean();
		goodsclassFormBean.setGoodclassshopid(getUserShopId());
		goodsclassFormBean=stockManagerService.getPage(goodsclassFormBean);
		
		request.setAttribute("goodsclassFormBean", goodsclassFormBean);
		
		 request.setAttribute("goodsClassList", goodsClassList);
		
		
		return "EditGoodsLevel.jsp";
	}
	
	
	/**
	 * 保存商品级别
	 * @param request
	 * @param goodsclass
	 * @return [参数说明]
	 * 
	 * @return int [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "saveGoodsLevel", method = RequestMethod.POST)
	@ResponseBody
	public int saveGoodsLevel(HttpServletRequest request,Goodsclass goodsclass){
		if(goodsclass.getClassid()==null){
			goodsclass.setCreateshopid(getUserShopId());
			goodsclass.setParentid(0);
			stockManagerService.saveGoodsclass(goodsclass,getUserShopId());
		}else{
			
		}
		
		 
		
		return 1;
	}
	
	/**
	 * 删除分类
	 * @param request
	 * @param classid
	 * @param shopid
	 * @return [参数说明]
	 * 
	 * @return Integer [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "GoodsClassDel", method = RequestMethod.POST)
	@ResponseBody
	public Integer delGoodsClass(HttpServletRequest request, Integer classid,Integer shopid){
		
		
		stockManagerService.delGoodsClass(classid,shopid);
		

		return 1;
	}
	/**
	 * 商品列表页面
	 * @param request
	 * @param goodsFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "GoodsList", method = RequestMethod.GET)
	public String goodsList(HttpServletRequest request,GoodsFormBean goodsFormBean){
		if(goodsFormBean.getShopid()==null){
			goodsFormBean.setShopid(getUserShopId());
		}
		
		goodsFormBean = stockManagerService.getPage(goodsFormBean); 
		 request.setAttribute("goodsFormBean", goodsFormBean);
		 return "GoodsList.jsp";
	}
	
	@RequestMapping(value = "GoodsAdd", method = RequestMethod.GET)
	public String goodsAdd(HttpServletRequest request,Goods goods){
		if(goods!=null&&goods.getGoodsid()!=null){
			goods=stockManagerService.findGoods(goods);
		}
		GoodsclassFormBean goodsclassFormBean=new GoodsclassFormBean();
		goodsclassFormBean.setGoodclassshopid(getUserShopId());
		goodsclassFormBean=stockManagerService.getPage(goodsclassFormBean);
		request.setAttribute("goodsclassFormBean", goodsclassFormBean);
		request.setAttribute("goodsinfo", goods);
		return "GoodsAdd.jsp";
	}
	
	@RequestMapping(value = "GoodsAddAndEdit")
	@ResponseBody
	public Integer goodsAddAndEdit(HttpServletRequest request,Goods goods){
		if(goods!=null&&goods.getGoodsid()!=null){
			goods.setShopid(getUserShopId());
			stockManagerService.updateGoods(goods);
		}else{
			goods.setGoodssalenumber(0);
			goods.setGoodsnumber(0);
			goods.setShopid(getUserShopId());
			if(goods.getGoodstype()==null){
				goods.setGoodstype(0);
			}
			stockManagerService.saveGoods(goods);
		}
		
		
		return 1;
	}
	
	
	
	@RequestMapping(value = "GoodsDel")
	@ResponseBody
	public Integer goodsDel(HttpServletRequest request,Goods goods){
		
		stockManagerService.delGoods(goods.getGoodsid());
		return 1;
		
	}
	
	@RequestMapping(value = "GetGoodsList")
	@ResponseBody
	public GoodsFormBean getGoodsList(GoodsFormBean goodsFormBean){
		
		if(goodsFormBean.getShopid()==null){
			goodsFormBean.setShopid(getUserShopId());
		}
		
		if(goodsFormBean.getIscheckstock()>0){
			goodsFormBean.setGoodsnumber(1);
		}
		
		goodsFormBean=stockManagerService.getPage(goodsFormBean);
		
		return goodsFormBean;
	}
	
	@RequestMapping(value = "GoodsIn")
	public String goodsIn(HttpServletRequest request){
		request.setAttribute("shopid", getUserShopId());
		return "GoodsIn.jsp";
	}

	
	
	@RequestMapping(value = "GetGoodsNumber")
	@ResponseBody
	public GoodsFormBean getGoodsNumber(GoodsFormBean goodsFormBean){
		if(goodsFormBean.getShopid()==null){
			goodsFormBean.setShopid(getUserShopId());
		}
		
		goodsFormBean=stockManagerService.getPage(goodsFormBean);
		return goodsFormBean;
	}
	
	@RequestMapping(value = "saveGoodsIn")
	@ResponseBody
	public int saveGoodsIn(@RequestBody  Goodslog goodslog){
		goodslog.setUserid(getUserId());
		int result=stockManagerService.saveGoodsIn(goodslog);
		return result;
	}
	@RequestMapping(value = "StockList", method = RequestMethod.GET)
	public String stockList(HttpServletRequest request,GoodsFormBean goodsFormBean){
		if(goodsFormBean.getShopid()==null){
			goodsFormBean.setShopid(getUserShopId());
		}
		goodsFormBean.setGoodsnumber(1);
		goodsFormBean=stockManagerService.getPage(goodsFormBean);
		request.setAttribute("goodsFormBean", goodsFormBean);
		return "StockList.jsp";
	}
	
	/**
	 * 商品出库入库日志
	 * @param request
	 * @param goodsFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "GoodsLog", method = RequestMethod.GET)
	public String goods_log_list(HttpServletRequest request,GoodslogFormBean goodslogFormBean){
		if(goodslogFormBean.getShopid()==null){
			goodslogFormBean.setShopid(getUserShopId());
		}
		
		goodslogFormBean = stockManagerService.getPage(goodslogFormBean); 
		 request.setAttribute("goodslogFormBean", goodslogFormBean);
		 return "GoodsLog.jsp";
	}
	
	@RequestMapping(value = "GoodsExpense", method = RequestMethod.GET)
	public String goods_expense(HttpServletRequest request,GoodsFormBean goodsFormBean){
		if(goodsFormBean.getShopid()==null){
			goodsFormBean.setShopid(getUserShopId());
		}
		goodsFormBean.setGoodsnumber(1);
		goodsFormBean=stockManagerService.getPage(goodsFormBean);
		request.setAttribute("goodsFormBean", goodsFormBean);
		return "GoodsExpense.jsp";
	}
	@RequestMapping(value = "GetGoodsInfo")
	@ResponseBody
	public List<Goods> GetGoodsInfo(HttpServletRequest request,Goods goods){
		
		
		List<Goods> goodsList=stockManagerService.findGoodsList(goods);
		
		return goodsList;
	}
	@RequestMapping(value = "saveGoodsExpense")
	@ResponseBody
	public Map<String, Object>  saveGoodsExpense(HttpServletRequest request,@RequestBody Orderlog orderlog){
		Map<String, Object> result=new HashMap<String, Object>();
		orderlog.setOrdershopid(getUserShopId());
		
		stockManagerService.saveGoodsExpense(orderlog);
		
		result.put("result", 1);
		result.put("strUpdateMemLevel", "test");
		result.put("point", 11);
		return result;
	}
	
	
	@RequestMapping(value = "RptEmptyBills", method = RequestMethod.GET)
	public String rpt_empty_bills(HttpServletRequest request,OrderlogFormBean orderlogFormBean){
		orderlogFormBean.setOrdertype(3);
		orderlogFormBean=stockManagerService.getPage(orderlogFormBean);
		request.setAttribute("orderlogFormBean", orderlogFormBean);
		return "RptEmptyBills.jsp";
	}
	
	@RequestMapping(value = "EmptyBillsSubmit")
	@ResponseBody
	public Map<String, Object> empty_bills_submit(HttpServletRequest request,@RequestBody Orderlog orderlog){
		Map<String, Object> result=new HashMap<String, Object>();
		System.out.println(orderlog);
		stockManagerService.updateGoodsExpense(orderlog);
		result.put("result", 1);
		result.put("strUpdateMemLevel", "test");
		result.put("point", 11);
		return result;
	}
	
	
	@RequestMapping(value = "DeleteEmptyBills")
	@ResponseBody
	public Map<String, Object> DeleteEmptyBills(HttpServletRequest request, Orderlog orderlog){
		Map<String, Object> result=new HashMap<String, Object>();
		System.out.println(orderlog);
		stockManagerService.deleteGoodsExpense(orderlog);
		result.put("result", 1);
		result.put("strUpdateMemLevel", "test");
		result.put("point", 11);
		return result;
	}
	/**
	 * 商品出库入库日志
	 * @param request
	 * @param goodsFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "TimingProject", method = RequestMethod.GET)
	public String TimingProject_list(HttpServletRequest request,TimingprojectFormBean timingprojectFormBean){
		
		
		timingprojectFormBean = stockManagerService.getPage(timingprojectFormBean); 
		List<Timingrules> list=stockManagerService.list(new Timingrules());
		request.setAttribute("timingrules", list);
		
		
		 return "TimingProject.jsp";
	}
	
	
	
	@RequestMapping(value = "Timingrules", method = RequestMethod.GET)
	public String Timingrules_list(HttpServletRequest request,TimingrulesFormBean timingrulesFormBean){
		
		
		timingrulesFormBean = stockManagerService.getPage(timingrulesFormBean); 
		
		 return "Timingrules.jsp";
	}
	
	
	
	
	@RequestMapping(value = "RulesAdd", method = RequestMethod.POST)
	@ResponseBody
	public Integer rulesAdd(HttpServletRequest request,Timingrules timingrules){
		
		timingrules.setRulesuserid(this.getUserId());
		int result=stockManagerService.timingrules_add(timingrules);
		
		return result;
	}
	
	@RequestMapping(value = "RulesEdit", method = RequestMethod.POST)
	@ResponseBody
	public Integer rulesEdit(HttpServletRequest request,Timingrules timingrules){
		timingrules.setRulesuserid(this.getUserId());
		int result=stockManagerService.timingrules_edit(timingrules);
		
		return result;
	}
	
	@RequestMapping(value = "GetRules", method = RequestMethod.POST)
	@ResponseBody
	public List<Timingrules> GetRules(HttpServletRequest request,Timingrules timingrules){
		List<Timingrules> timingrulesList=stockManagerService.timingrules_get(timingrules);
		
		return timingrulesList;
	}
	
	@RequestMapping(value="DelRules")
	@ResponseBody
	public Integer DelRules(HttpServletRequest request,Integer rulesid){
		Integer result=stockManagerService.timingrules_del(rulesid);
		return result;
	}
	
	
	
	@RequestMapping(value = "TimingProjectAdd", method = RequestMethod.POST)
	@ResponseBody
	public Integer timingProjectAdd(HttpServletRequest request,Timingproject timingproject){
		
		timingproject.setProjectuserid(this.getUserId());
		int result=stockManagerService.timingProject_add(timingproject);
		
		return result;
	}
	@RequestMapping(value = "TimingProjectEdit", method = RequestMethod.POST)
	@ResponseBody
	public Integer timingProjectEdit(HttpServletRequest request,Timingproject timingproject){
		
		timingproject.setProjectuserid(this.getUserId());
		int result=stockManagerService.timingProject_edit(timingproject);
		
		return result;
	}
	
	@RequestMapping(value = "DelTimingProject", method = RequestMethod.POST)
	@ResponseBody
	public Integer delTimingProject(HttpServletRequest request,Integer projectid){
		
		
		int result=stockManagerService.timingProject_del(projectid);
		
		return result;
	}
	@RequestMapping(value = "GetTimingProject", method = RequestMethod.POST)
	@ResponseBody
	public List<Timingproject> getTimingProject(HttpServletRequest request,Timingproject timingproject){
		List<Timingproject> timingprojectList=stockManagerService.timingrules_get(timingproject);
		
		return timingprojectList;
	}
	
	
	


}
