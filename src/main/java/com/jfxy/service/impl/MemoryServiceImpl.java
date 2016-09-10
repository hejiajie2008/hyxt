package com.jfxy.service.impl;

import java.util.ArrayList;
import java.util.List;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jfxy.dao.SysshopDao;
import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Sysshop;
import com.jfxy.pojo.Sysshopauthority;
import com.jfxy.pojo.form.SysshopFormBean;
import com.jfxy.service.MemoryService;
import com.jfxy.util.UserUtils;
/**
 * 
 * 内存获取数据业务模块
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
@Service("memoryService")
public class MemoryServiceImpl implements MemoryService {
	
	
	@Resource
	private SysshopDao sysshopDao;
	
	public static List<Sysshop> getAuthShop(int userid){
		List<Sysshop> shopAuthList=null;
		if(UserUtils.isNotAdmin(userid)){
			shopAuthList=new ArrayList<Sysshop>();
			List<Sysshop> allShopList=MemoryListener.listShops;
			List<Sysshopauthority> list=MemoryListener.listShopIds;
			
			for(Sysshopauthority sysshopauthority:list){
				String userids=sysshopauthority.getShopauthoritydata();
				for(String userIdStr:userids.split(",")){
					if(Integer.parseInt(userIdStr)==userid){
						Integer shopid=sysshopauthority.getShopauthorityshopid();
						for(Sysshop shop:allShopList){
							if(shop.getShopid()==shopid){
								shopAuthList.add(shop);
								break;
							}
						}
						
					}
				}
			}
		}else{
			shopAuthList=MemoryListener.listShops;
		}
		
		return shopAuthList;
	}
	

	/**
	 * 通过用户ID获取到对应用户
	 * @param userid
	 * @return
	 */
	public List<Integer> listShopID(int userid){
		List<Integer> shopIdList=new ArrayList<Integer>();
		List<Sysshopauthority> list=MemoryListener.listShopIds;
		
		for(Sysshopauthority sysshopauthority:list){
			String userids=sysshopauthority.getShopauthoritydata();
			for(String userIdStr:userids.split(",")){
				if(Integer.parseInt(userIdStr)==userid){
					shopIdList.add(sysshopauthority.getShopauthorityshopid());
				}
			}
		}
		return shopIdList;
	}
	/**
	 * 获取所有系统商铺集合
	 * @return
	 */
	public List<Sysshop> listShop(){
		List<Sysshop> shopList=sysshopDao.list(new Sysshop());
		
		
		return shopList;
	}
	/**
	 * 根据ID获取指定店铺信息
	 * @param shopids
	 * @return
	 */
	public List<Sysshop> listShop(List<Integer> shopids) {
		// TODO Auto-generated method stub
		SysshopFormBean sysshopFormBean=new SysshopFormBean();
		sysshopFormBean.setShopids(shopids);
		List<Sysshop> shopList=sysshopDao.listbyForm(sysshopFormBean);
		return shopList;
	}
	
	
	
	
}
