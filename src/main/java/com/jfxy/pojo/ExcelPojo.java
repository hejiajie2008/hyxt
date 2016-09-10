package com.jfxy.pojo;

public class ExcelPojo {
	/*区域*/
	private String area;
	/*网点*/
	private String shopName;
	/*网点ID*/
	private int shopId;
	/*每月新增会员数*/
	private int addMembyMonth;
	
	
	/**每月站点消费总单数**/
	private int zdxfNum;
	
	
	/*重复消费会员数*/
	private int rechargeMemNum;
	/*站点总人数*/
	private int totalMemNum;
	
	
	private String maxGoods;
	
	private int maxGoodsNum;
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public int getAddMembyMonth() {
		return addMembyMonth;
	}
	public void setAddMembyMonth(int addMembyMonth) {
		this.addMembyMonth = addMembyMonth;
	}
	public int getRechargeMemNum() {
		return rechargeMemNum;
	}
	public void setRechargeMemNum(int rechargeMemNum) {
		this.rechargeMemNum = rechargeMemNum;
	}
	public int getTotalMemNum() {
		return totalMemNum;
	}
	public void setTotalMemNum(int totalMemNum) {
		this.totalMemNum = totalMemNum;
	}
	public int getZdxfNum() {
		return zdxfNum;
	}
	public void setZdxfNum(int zdxfNum) {
		this.zdxfNum = zdxfNum;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getMaxGoods() {
		return maxGoods;
	}
	public void setMaxGoods(String maxGoods) {
		this.maxGoods = maxGoods;
	}
	public int getMaxGoodsNum() {
		return maxGoodsNum;
	}
	public void setMaxGoodsNum(int maxGoodsNum) {
		this.maxGoodsNum = maxGoodsNum;
	}
	
	public double getNewMemRebate(){
		if(rechargeMemNum==0){
			return 0;
		}else{
			return ((double)addMembyMonth)/zdxfNum;
		}
	}
	
	public double getYdhyxshyd(){
		if(totalMemNum==0){
			return 0;
		}else{
			return (double)rechargeMemNum/totalMemNum;
		}
		
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	
	
	
	
	
	
	
	

}
