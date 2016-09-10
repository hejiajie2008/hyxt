package com.jfxy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jfxy.dao.SysmoduleDao;
import com.jfxy.pojo.Sysmodule;

public class SysmoduleServiceImpl {
	
	
	@Autowired
	private SysmoduleDao sysmoduleDao;
	/**
	 * 查询所有菜单
	 * @param value
	 * @return
	 */
	public List<Sysmodule> findMenus(int value){
		List<Sysmodule> list=new ArrayList<Sysmodule>();
		
		List<Sysmodule> head=new ArrayList<Sysmodule>();
		
		List<Sysmodule> menus=sysmoduleDao.findMenus(1);
		for(Sysmodule menu:menus){
			if(menu.getModuleparentid()==0){
				head.add(menu);
			}else{
				break;
			}
		}
		
		for(Sysmodule menu:menus){
			if(menu.getModuleparentid()!=0){
				head.add(menu);
			}
		}
		
		
		
		return list;
	}

}
