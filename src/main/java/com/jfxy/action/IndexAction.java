package com.jfxy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfxy.dao.SysmoduleDao;
import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Sysmodule;
import com.jfxy.pojo.Sysparameter;
import com.jfxy.pojo.Sysshop;
import com.jfxy.pojo.Sysuser;
import com.jfxy.pojo.form.SyscustomremindFormBean;
import com.jfxy.pojo.form.SysnoticeFormBean;
import com.jfxy.service.IndexService;
import com.jfxy.util.tags.ShopTag;

/**
 * 
 * 主页面模块
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月9日
 */
@Controller
@RequestMapping(value = "/")
public class IndexAction extends BaseAction{
	

	@Autowired
	private IndexService indexService;
	
	
	@RequestMapping(value = "/GetSysParameter")
	@ResponseBody
	public Sysparameter getSysParameter(HttpServletRequest request){
		Sysparameter sysparameter=indexService.getSysParameter();
		
		return sysparameter;
	}
	
	
	@RequestMapping(value = "/UpdateCouponList")
	@ResponseBody
	public Integer UpdateCouponList(HttpServletRequest request){
		return 1;
	}
	
	@RequestMapping(value = "startPage")
	public String startPage(HttpServletRequest request){
		Integer shopid=getUserShopId();
		
		
		
		Sysshop sysshop=null;
		
		for(Sysshop shop:MemoryListener.listShops){
			if(shopid.intValue()==shop.getShopid().intValue()){
				sysshop=shop;
				break;
			}
		}
		
		Integer userid=getUserId();
		Sysuser sysuser=null;
		
		for(Sysuser user:MemoryListener.listUser){
			if(user.getUserid().intValue()==userid.intValue()){
				sysuser=user;
				break;
			}
		}
		request.setAttribute("shopname", sysshop.getShopname());
		request.setAttribute("username", sysuser.getUsername());
		request.setAttribute("shopcontactman", sysshop.getShopcontactman());
		request.setAttribute("shoptelephone", sysshop.getShoptelephone());
		request.setAttribute("groupname", sysuser.getGroupname());
		request.setAttribute("shopaddress", sysshop.getShopaddress());
		
		SysnoticeFormBean sysnoticeFormBean=new SysnoticeFormBean();
		sysnoticeFormBean=indexService.getPage(sysnoticeFormBean);
		request.setAttribute("sysnoticeFormBean", sysnoticeFormBean);
		SyscustomremindFormBean syscustomremindFormBean=new SyscustomremindFormBean();
		syscustomremindFormBean=indexService.getPage(syscustomremindFormBean);
		request.setAttribute("syscustomremindFormBean", syscustomremindFormBean);
		return "startPage.jsp";
	}
	
	
	
	

}
