package com.jfxy.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxNumPojo {
	
	private int shopid;
	private int goodsid;
	private int num;
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public static Map<Integer, Integer> getGoodsMaxNum(List<MaxNumPojo> list){
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(MaxNumPojo max:list){
			map.put(max.getShopid(),max.getNum() );
		}
		return map;
	}
	
	public static Map<Integer, String> getGoods(List<MaxNumPojo> list,Map<Integer, String> shopMap){
		Map<Integer, String> map=new HashMap<Integer, String>();
		for(MaxNumPojo max:list){
			String shopName="";
			if(shopMap.containsKey(max.getShopid())){
				shopName=shopMap.get(max.getShopid());
			}
			
			map.put(max.getShopid(),shopName );
		}
		return map;
	}
	
	
	
	

}
