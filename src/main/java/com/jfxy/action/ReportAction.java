package com.jfxy.action;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;






import org.springframework.web.bind.annotation.ResponseBody;

import com.jfxy.pojo.ExpensePojo;
import com.jfxy.pojo.form.MemFormBean;
import com.jfxy.pojo.form.MemcountFormBean;
import com.jfxy.pojo.form.MemdrawmoneyFormBean;
import com.jfxy.pojo.form.MemrechargeFormBean;
import com.jfxy.pojo.form.OrderlogFormBean;
import com.jfxy.pojo.form.PointlogFormBean;
import com.jfxy.pojo.form.RptMemFormBean;
import com.jfxy.service.ReportService;

@Controller
@RequestMapping(value = "/Report")
public class ReportAction extends BaseAction{
	private Logger logger = Logger.getLogger(ReportAction.class.getName());
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(value = "RptPointChange")
	public String RptPointChange(HttpServletRequest request,PointlogFormBean pointlogFormBean) {
		
		try {
			pointlogFormBean=reportService.getPage(pointlogFormBean);
			request.setAttribute("pointlogFormBean", pointlogFormBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("query pointlogFormBean error" + e.getMessage());
		}
		return "RptPointChange.jsp";
	}
	
	
	@RequestMapping(value = "RptPointRankList")
	public String RptPointRankList(HttpServletRequest request,MemFormBean memFormBean) {
		
		try {
			memFormBean=reportService.getPage(memFormBean);
			request.setAttribute("memFormBean", memFormBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("query memFormBean error" + e.getMessage());
		}
		return "RptPointRankList.jsp";
	}
	@RequestMapping(value = "RptMemDrawMoney")
	public String RptMemDrawMoney(HttpServletRequest request,MemdrawmoneyFormBean memdrawmoneyFormBean){
		memdrawmoneyFormBean=reportService.getPage(memdrawmoneyFormBean);
		request.setAttribute("memdrawmoneyFormBean", memdrawmoneyFormBean);
		return "RptMemDrawMoney.jsp";
	}
	@RequestMapping(value = "GetRechargeListByPage")
	@ResponseBody
	public MemrechargeFormBean getRechargeListByPage(HttpServletRequest request,@RequestBody MemrechargeFormBean memrechargeFormBean){
		
		if("".equals(memrechargeFormBean.getRechargeaccount())){
			memrechargeFormBean.setRechargeaccount(null);
		}
		memrechargeFormBean=reportService.getPage(memrechargeFormBean);
		return memrechargeFormBean;
	}
	@RequestMapping(value = "RptMem")
	public String RptMem(HttpServletRequest request,MemFormBean memFormBean){
		memFormBean=reportService.getMemPage(memFormBean);
		return "RptMem.jsp";
	}
	
	@RequestMapping(value = "RptMemCount")
	public String RptMemCount(HttpServletRequest request,MemcountFormBean memcountFormBean){
		
		memcountFormBean=reportService.getPage(memcountFormBean);
		return "RptMemCount.jsp";
	}
	
	
}