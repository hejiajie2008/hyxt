package com.jfxy.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


/**
 * 基础action 用于获取用户相关信息
 * @author hejiajie
 *
 */
/**
 * 
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月9日
 */
public class BaseAction {
	/**
	 *  获取用户ＩＤ
	 * @return
	 */
	public Integer getUserId(){
		Subject subject = SecurityUtils.getSubject();
		String userid=subject.getSession().getAttribute("userid").toString();
		
		return Integer.parseInt(userid);
	}
	/**
	 * 获取当前用户的店铺ID
	 * @return
	 */
	
	public Integer getUserShopId(){
		
		Subject subject = SecurityUtils.getSubject();
		String userShopId=subject.getSession().getAttribute("usershopid").toString();
		
		return Integer.parseInt(userShopId);
	}
	
	public Integer getRoleId(){
		Subject subject = SecurityUtils.getSubject();
		String roleid=subject.getSession().getAttribute("roleid").toString();
		return Integer.parseInt(roleid);
	}
	
	
	
	

}
