package com.jfxy.service;


import com.jfxy.pojo.form.MemFormBean;
import com.jfxy.pojo.form.MemcountFormBean;
import com.jfxy.pojo.form.MemdrawmoneyFormBean;
import com.jfxy.pojo.form.MemrechargeFormBean;
import com.jfxy.pojo.form.PointlogFormBean;
import com.jfxy.pojo.form.RptMemFormBean;

public interface ReportService {
	public PointlogFormBean getPage(PointlogFormBean pointlogFormBean);
	public MemFormBean getPage(MemFormBean memFormBean);
	public MemdrawmoneyFormBean getPage(MemdrawmoneyFormBean memdrawmoneyFormBean);
	
	public MemrechargeFormBean getPage(MemrechargeFormBean memrechargeFormBean);
	
	public MemFormBean getMemPage(MemFormBean memFormBean);
	
	public RptMemFormBean getPage(RptMemFormBean rptMemFormBean);
	
	public MemcountFormBean getPage(MemcountFormBean memcountFormBean);
}
