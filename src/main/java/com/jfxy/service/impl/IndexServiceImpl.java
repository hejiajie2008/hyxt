package com.jfxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jfxy.dao.SyscustomremindDao;
import com.jfxy.dao.SysnoticeDao;
import com.jfxy.dao.SysparameterDao;
import com.jfxy.pojo.Syscustomremind;
import com.jfxy.pojo.Sysnotice;
import com.jfxy.pojo.Sysparameter;
import com.jfxy.pojo.form.SyscustomremindFormBean;
import com.jfxy.pojo.form.SysnoticeFormBean;
import com.jfxy.service.IndexService;

/**
 * 
 * 会员模块业务层
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService{
	@Resource
	private SysparameterDao sysparameterDao;
	@Resource
	private SysnoticeDao sysnoticeDao;
	
	@Resource
	private SyscustomremindDao syscustomremindDao;
	
	public Sysparameter getSysParameter(){
		Sysparameter sysparameter=sysparameterDao.list(new Sysparameter()).get(0);
		return sysparameter;
	}
	
	public SysnoticeFormBean getPage(SysnoticeFormBean sysnoticeFormBean) {

		int total = sysnoticeDao.count(sysnoticeFormBean);
		sysnoticeFormBean.setTotal(total);
		List<Sysnotice> rows = sysnoticeDao.pageList(sysnoticeFormBean);
		sysnoticeFormBean.setDatas(rows);
		

		return sysnoticeFormBean;
	}
	
	public SyscustomremindFormBean getPage(SyscustomremindFormBean syscustomremindFormBean) {

		int total = syscustomremindDao.count(syscustomremindFormBean);
		syscustomremindFormBean.setTotal(total);
		List<Syscustomremind> rows = syscustomremindDao.pageList(syscustomremindFormBean);
		syscustomremindFormBean.setDatas(rows);
		

		return syscustomremindFormBean;
	}
	

}
