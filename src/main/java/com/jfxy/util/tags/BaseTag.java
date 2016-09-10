package com.jfxy.util.tags;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.jfxy.pojo.Sysmodule;

public abstract class BaseTag extends SimpleTagSupport{
	
	/**
	 *  获取用户ＩＤ
	 * @return
	 */
	public Integer getUserId(){
		Subject subject = SecurityUtils.getSubject();
		String userid=subject.getSession().getAttribute("userid").toString();
		
		return Integer.parseInt(userid);
	}
	
	
	public String getPid(){
		HttpServletRequest request = (HttpServletRequest)((PageContext)this.getJspContext()).getRequest();
		String pid=request.getParameter("PID");
		return pid;
	}
	
	public List<Sysmodule> getMenus(){
		Subject subject = SecurityUtils.getSubject();
		@SuppressWarnings("unchecked")
		List<Sysmodule> menus=(List<Sysmodule>) subject.getSession().getAttribute("menus");
		return menus;
		
	}
	
	

}
