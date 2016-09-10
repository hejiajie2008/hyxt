package com.jfxy.service;

import java.util.List;

import com.jfxy.pojo.Sysshop;
/**
 * 
 * 内存获取数据业务模块
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
public interface MemoryService {
	/**
	 * 通过用户ID获取到对应用户
	 * @param userid
	 * @return
	 */
	public List<Integer> listShopID(int userid);
	/**
	 * 获取所有系统商铺集合
	 * @return
	 */
	public List<Sysshop> listShop();
	/**
	 * 根据ID获取指定店铺信息
	 * @param shopids
	 * @return
	 */
	public List<Sysshop> listShop(List<Integer> shopids);
	

}
