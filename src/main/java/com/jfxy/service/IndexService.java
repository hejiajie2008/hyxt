package com.jfxy.service;

import com.jfxy.pojo.Sysparameter;
import com.jfxy.pojo.form.SyscustomremindFormBean;
import com.jfxy.pojo.form.SysnoticeFormBean;

public interface IndexService {
	public Sysparameter getSysParameter();
	
	public SysnoticeFormBean getPage(SysnoticeFormBean sysnoticeFormBean);
	
	public SyscustomremindFormBean getPage(SyscustomremindFormBean syscustomremindFormBean);

}
