package com.jfxy.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfxy.pojo.ExpensePojo;
import com.jfxy.pojo.Goods;
import com.jfxy.pojo.GoodsClassRebat;
import com.jfxy.pojo.Mem;
import com.jfxy.pojo.Memlevel;
import com.jfxy.pojo.Memrecharge;
import com.jfxy.pojo.Memstoragetiming;
import com.jfxy.pojo.Orderlog;
import com.jfxy.pojo.Sysshop;
import com.jfxy.pojo.Timingproject;
import com.jfxy.pojo.Timingrules;
import com.jfxy.pojo.form.GoodsFormBean;
import com.jfxy.pojo.form.MemFormBean;
import com.jfxy.pojo.form.MemcountFormBean;
import com.jfxy.pojo.form.MemcountdetailFormBean;
import com.jfxy.pojo.form.MemlevelFormBean;
import com.jfxy.pojo.form.MemrechargeFormBean;
import com.jfxy.pojo.form.MemstoragetimingFormBean;
import com.jfxy.pojo.form.OrderlogFormBean;
import com.jfxy.pojo.form.TimingprojectFormBean;
import com.jfxy.service.KafkaProducerService;
import com.jfxy.service.MemExpenseService;
import com.jfxy.service.MemService;
import com.jfxy.service.MemoryService;
import com.jfxy.service.StockManagerService;
import com.jfxy.util.UserUtils;
/**
 * 
 * 会员管理模块
 * 包括会员管理，会员注册，挂失解锁功能
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
@Controller
@RequestMapping(value = "/MemExpense")
public class MemExpenseAction extends BaseAction{

	@Autowired
	private MemService memService;
	
	@Autowired
	private MemoryService memoryService;
	
	@Autowired
	private KafkaProducerService kafkaProducerService;
	@Autowired
	private MemExpenseService memExpenseService;
	@Autowired
	private StockManagerService stockManagerService;
	
	

	
	/**
	 * 保存消费信息
	 * @param request
	 * @param memrechargeFormBean
	 * @return [参数说明]
	 * 
	 * @return MemrechargeFormBean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "Expense")
	@ResponseBody
	public Integer  expense(HttpServletRequest request, @RequestBody   Orderlog orderlog){
		
		System.out.println(orderlog);
		memExpenseService.saveExpense(orderlog);
		return 1;
	}
	@RequestMapping(value = "ExpenseHistory")
	public String expense_history(HttpServletRequest request,OrderlogFormBean orderlogFormBean){
		
		orderlogFormBean=memExpenseService.getPage(orderlogFormBean);
		request.setAttribute("orderlogFormBean", orderlogFormBean);
		return "ExpenseHistory.jsp";
	}
	/**
	 * 保存消费信息
	 * @param request
	 * @param memrechargeFormBean
	 * @return [参数说明]
	 * 
	 * @return MemrechargeFormBean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "MemInfoExpense")
	@ResponseBody
	public OrderlogFormBean  meminfo_expense(HttpServletRequest request,OrderlogFormBean orderlogFormBean){
		orderlogFormBean=memExpenseService.getPage(orderlogFormBean);
		return  orderlogFormBean;
	}
	
	@RequestMapping(value = "GetGoodsInfo")
	@ResponseBody
	public List<Goods> GetGoodsInfo(HttpServletRequest request,Goods goods){
		
		
		List<Goods> goodsList=stockManagerService.findGoodsList(goods);
		
		return goodsList;
	}
	
	
	
	@RequestMapping(value = "GetServingProductList")
	@ResponseBody
	public MemcountdetailFormBean getServing_productList(MemcountdetailFormBean memcountdetailFormBean){
		
		memcountdetailFormBean=memExpenseService.queryServingProductPage(memcountdetailFormBean);
		
		return memcountdetailFormBean;
	}
	
	
	/**
	 * 保存消费信息
	 * @param request
	 * @param memrechargeFormBean
	 * @return [参数说明]
	 * 
	 * @return MemrechargeFormBean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "CountExpense")
	@ResponseBody
	public Map<String, Object>  saveCountExpense(HttpServletRequest request, @RequestBody   Orderlog orderlog){
		Map<String, Object> result=new HashMap<String, Object>();
		orderlog.setOrdershopid(getUserShopId());
		System.out.println(orderlog);
		memExpenseService.saveCountExpense(orderlog);
		result.put("result", 1);
		result.put("strUpdateMemLevel", "test");
		result.put("point", 11);
		return result;
	}
	
	
	
	/**
	 * 保存消费信息
	 * @param request
	 * @param memrechargeFormBean
	 * @return [参数说明]
	 * 
	 * @return MemrechargeFormBean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "GetPrjectByPage")
	@ResponseBody
	public TimingprojectFormBean  GetPrjectByPage(HttpServletRequest request,    TimingprojectFormBean timingprojectFormBean){
		
			
		timingprojectFormBean = stockManagerService.getPage(timingprojectFormBean); 
		
		
		return timingprojectFormBean;
	}
	
	
	@RequestMapping(value = "GetRules", method = RequestMethod.POST)
	@ResponseBody
	public List<Timingrules> GetRules(HttpServletRequest request,Timingrules timingrules){
		List<Timingrules> timingrulesList=stockManagerService.timingrules_get(timingrules);
		
		return timingrulesList;
	}
	
	@RequestMapping(value = "MemStorageTiming")
	@ResponseBody
	public Map<String, Object> memStorageTiming(HttpServletRequest request,@RequestBody Memstoragetiming memstoragetiming){
		Map<String, Object> result=new HashMap<String, Object>();
		int resultInt=memExpenseService.saveMemStorageTiming(memstoragetiming);
		result.put("result", resultInt);
		result.put("strUpdateMemLevel", "test");
		result.put("point", 11);
		return result;
	}
	
	
	/**
	 * 会员列表
	 * @param request
	 * @param memFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "TimeList", method = RequestMethod.GET)
	public String time_list(HttpServletRequest request, MemstoragetimingFormBean memstoragetimingBean) {
		memstoragetimingBean=memExpenseService.getPage(memstoragetimingBean);
		request.setAttribute("memstoragetimingBean", memstoragetimingBean);
		return "TimeList.jsp";
	}

}
