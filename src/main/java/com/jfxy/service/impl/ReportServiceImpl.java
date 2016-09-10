package com.jfxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jfxy.dao.MemDao;
import com.jfxy.dao.MemcountDao;
import com.jfxy.dao.MemdrawmoneyDao;
import com.jfxy.dao.MemrechargeDao;
import com.jfxy.dao.OrderlogDao;
import com.jfxy.dao.PointlogDao;
import com.jfxy.pojo.Mem;
import com.jfxy.pojo.Memcount;
import com.jfxy.pojo.Memdrawmoney;
import com.jfxy.pojo.Memrecharge;
import com.jfxy.pojo.Orderlog;
import com.jfxy.pojo.Pointlog;
import com.jfxy.pojo.RptMem;
import com.jfxy.pojo.form.MemFormBean;
import com.jfxy.pojo.form.MemcountFormBean;
import com.jfxy.pojo.form.MemdrawmoneyFormBean;
import com.jfxy.pojo.form.MemrechargeFormBean;
import com.jfxy.pojo.form.OrderlogFormBean;
import com.jfxy.pojo.form.PointlogFormBean;
import com.jfxy.pojo.form.RptMemFormBean;
import com.jfxy.service.ReportService;
@Service("reportService")
public class ReportServiceImpl implements ReportService {
	
	@Resource
	private PointlogDao pointlogDao;
	
	@Resource
	private MemDao memDao;
	
	@Resource
	private MemcountDao memcountDao;
	
	@Resource
	private MemdrawmoneyDao memdrawmoneyDao;
	@Resource
	private MemrechargeDao memrechargeDao;
	
	@Resource
	private OrderlogDao orderlogDao;
	/**
	 * 以分页的方式获取会员列表
	 * @param memFormBean
	 * @return
	 */
	public PointlogFormBean getPage(PointlogFormBean pointlogFormBean) {

		int total = pointlogDao.count(pointlogFormBean);
		pointlogFormBean.setTotal(total);
		List<Pointlog> rows = pointlogDao.pageList(pointlogFormBean);
		pointlogFormBean.setDatas(rows);
		

		return pointlogFormBean;
	}


	/**
	 * 以分页的方式获取根据积分排名后的会员列表
	 * @param memFormBean
	 * @return
	 */
	public MemFormBean getPage(MemFormBean memFormBean) {

		int total = memDao.getMemCount(memFormBean);
		memFormBean.setTotal(total);
		List<Mem> rows = memDao.pageOrderList(memFormBean);
		memFormBean.setDatas(rows);
		

		return memFormBean;
	}
	
	public MemdrawmoneyFormBean getPage(MemdrawmoneyFormBean memdrawmoneyFormBean){
		int total = memdrawmoneyDao.count(memdrawmoneyFormBean);
		memdrawmoneyFormBean.setTotal(total);
		List<Memdrawmoney> rows = memdrawmoneyDao.pageList(memdrawmoneyFormBean);
		memdrawmoneyFormBean.setDatas(rows);
		return memdrawmoneyFormBean;
	}
	public MemrechargeFormBean getPage(MemrechargeFormBean memrechargeFormBean){
		int total = memrechargeDao.count(memrechargeFormBean);
		memrechargeFormBean.setTotal(total);
		List<Memrecharge> rows = memrechargeDao.pageList(memrechargeFormBean);
		memrechargeFormBean.setDatas(rows);
		return memrechargeFormBean;
	}
	
	/**
	 * 以分页的方式获取根据积分排名后的会员列表
	 * @param memFormBean
	 * @return
	 */
	public MemFormBean getMemPage(MemFormBean memFormBean) {

		int total = memDao.getMemCount(memFormBean);
		memFormBean.setTotal(total);
		List<Mem> rows = memDao.getMemList(memFormBean);
		memFormBean.setDatas(rows);
		

		return memFormBean;
	}
	
	public RptMemFormBean getPage(RptMemFormBean rptMemFormBean) {
		// TODO Auto-generated method stub
		
		int total = memDao.countRptMem(rptMemFormBean);
		rptMemFormBean.setTotal(total);
		List<RptMem> rows = memDao.pageListRptMem(rptMemFormBean);
		rptMemFormBean.setDatas(rows);
		return rptMemFormBean;
	}
	public MemcountFormBean getPage(MemcountFormBean memcountFormBean) {
		// TODO Auto-generated method stub
		
		int total = memcountDao.count(memcountFormBean);
		memcountFormBean.setTotal(total);
		List<Memcount> rows = memcountDao.pageList(memcountFormBean);
		memcountFormBean.setDatas(rows);
		return memcountFormBean;
	}

}
