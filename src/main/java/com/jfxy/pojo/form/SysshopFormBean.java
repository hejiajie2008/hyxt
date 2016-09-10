package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Sysshop;

import java.util.Date;
import java.util.List;

/**
 * 店铺表 <br />
 * sysshop<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class SysshopFormBean extends Pagination<Sysshop> {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer shopid;
	/**
	 * 主键 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private List<Integer> shopids;

	/**
	 * 店铺名称 <br />
	 * 允许为空 YES <br />
	 * 数据长度 100<br />
	 */
	private String shopname;
	/**
	 * 店铺手机号 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String shoptelephone;
	/**
	 * 店铺联系人 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String shopcontactman;
	/**
	 * 店铺所在区域 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer shopareaid;
	/**
	 * 店铺地址 <br />
	 * 允许为空 YES <br />
	 * 数据长度 255<br />
	 */
	private String shopaddress;
	/**
	 * 备注 <br />
	 * 允许为空 YES <br />
	 * 数据长度 255<br />
	 */
	private String shopremark;
	/**
	 * 店铺创建时间 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Date shopcreatetime;
	/**
	 * 店铺状态 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer shopstate;
	/**
	 * 打印标题 <br />
	 * 允许为空 YES <br />
	 * 数据长度 255<br />
	 */
	private String shopprinttitle;
	/**
	 * 打印脚注 <br />
	 * 允许为空 YES <br />
	 * 数据长度 255<br />
	 */
	private String shopprintfoot;
	/**
	 * 短信后缀 <br />
	 * 允许为空 YES <br />
	 * 数据长度 255<br />
	 */
	private String shopsmsname;
	/**
	 * 最近店铺 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer fathershopid;
	/**
	 * <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer isallianceprogram;
	/**
	 * <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer settlementinterval;
	/**
	 * <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private double shopproportion;
	/**
	 * 积分数 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer pointcount;
	/**
	 * 短信数量 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer smscount;
	/**
	 * 积分类型 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer pointtype;
	/**
	 * 短信类型 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer smstype;
	
	private String searchcontent;
	
	private Integer shopauthorityshopid;

	/**
	 * 获得 主键<br />
	 * 
	 * @return shopid<br />
	 */
	public Integer getShopid() {
		return shopid;
	}

	/**
	 * 设置 主键 <br />
	 * 
	 * @param shopid
	 */
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	/**
	 * 获得 店铺名称<br />
	 * 
	 * @return shopname<br />
	 */
	public String getShopname() {
		return shopname;
	}

	/**
	 * 设置 店铺名称 <br />
	 * 
	 * @param shopname
	 */
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	/**
	 * 获得 店铺手机号<br />
	 * 
	 * @return shoptelephone<br />
	 */
	public String getShoptelephone() {
		return shoptelephone;
	}

	/**
	 * 设置 店铺手机号 <br />
	 * 
	 * @param shoptelephone
	 */
	public void setShoptelephone(String shoptelephone) {
		this.shoptelephone = shoptelephone;
	}

	/**
	 * 获得 店铺联系人<br />
	 * 
	 * @return shopcontactman<br />
	 */
	public String getShopcontactman() {
		return shopcontactman;
	}

	/**
	 * 设置 店铺联系人 <br />
	 * 
	 * @param shopcontactman
	 */
	public void setShopcontactman(String shopcontactman) {
		this.shopcontactman = shopcontactman;
	}

	/**
	 * 获得 店铺所在区域<br />
	 * 
	 * @return shopareaid<br />
	 */
	public Integer getShopareaid() {
		return shopareaid;
	}

	/**
	 * 设置 店铺所在区域 <br />
	 * 
	 * @param shopareaid
	 */
	public void setShopareaid(Integer shopareaid) {
		this.shopareaid = shopareaid;
	}

	/**
	 * 获得 店铺地址<br />
	 * 
	 * @return shopaddress<br />
	 */
	public String getShopaddress() {
		return shopaddress;
	}

	/**
	 * 设置 店铺地址 <br />
	 * 
	 * @param shopaddress
	 */
	public void setShopaddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}

	/**
	 * 获得 备注<br />
	 * 
	 * @return shopremark<br />
	 */
	public String getShopremark() {
		return shopremark;
	}

	/**
	 * 设置 备注 <br />
	 * 
	 * @param shopremark
	 */
	public void setShopremark(String shopremark) {
		this.shopremark = shopremark;
	}

	/**
	 * 获得 店铺创建时间<br />
	 * 
	 * @return shopcreatetime<br />
	 */
	public Date getShopcreatetime() {
		return shopcreatetime;
	}

	/**
	 * 设置 店铺创建时间 <br />
	 * 
	 * @param shopcreatetime
	 */
	public void setShopcreatetime(Date shopcreatetime) {
		this.shopcreatetime = shopcreatetime;
	}

	/**
	 * 获得 店铺状态<br />
	 * 
	 * @return shopstate<br />
	 */
	public Integer getShopstate() {
		return shopstate;
	}

	/**
	 * 设置 店铺状态 <br />
	 * 
	 * @param shopstate
	 */
	public void setShopstate(Integer shopstate) {
		this.shopstate = shopstate;
	}

	/**
	 * 获得 打印标题<br />
	 * 
	 * @return shopprinttitle<br />
	 */
	public String getShopprinttitle() {
		return shopprinttitle;
	}

	/**
	 * 设置 打印标题 <br />
	 * 
	 * @param shopprinttitle
	 */
	public void setShopprinttitle(String shopprinttitle) {
		this.shopprinttitle = shopprinttitle;
	}

	/**
	 * 获得 打印脚注<br />
	 * 
	 * @return shopprintfoot<br />
	 */
	public String getShopprintfoot() {
		return shopprintfoot;
	}

	/**
	 * 设置 打印脚注 <br />
	 * 
	 * @param shopprintfoot
	 */
	public void setShopprintfoot(String shopprintfoot) {
		this.shopprintfoot = shopprintfoot;
	}

	/**
	 * 获得 短信后缀<br />
	 * 
	 * @return shopsmsname<br />
	 */
	public String getShopsmsname() {
		return shopsmsname;
	}

	/**
	 * 设置 短信后缀 <br />
	 * 
	 * @param shopsmsname
	 */
	public void setShopsmsname(String shopsmsname) {
		this.shopsmsname = shopsmsname;
	}

	/**
	 * 获得 最近店铺<br />
	 * 
	 * @return fathershopid<br />
	 */
	public Integer getFathershopid() {
		return fathershopid;
	}

	/**
	 * 设置 最近店铺 <br />
	 * 
	 * @param fathershopid
	 */
	public void setFathershopid(Integer fathershopid) {
		this.fathershopid = fathershopid;
	}

	/**
	 * 获得 <br />
	 * 
	 * @return isallianceprogram<br />
	 */
	public Integer getIsallianceprogram() {
		return isallianceprogram;
	}

	/**
	 * 设置 <br />
	 * 
	 * @param isallianceprogram
	 */
	public void setIsallianceprogram(Integer isallianceprogram) {
		this.isallianceprogram = isallianceprogram;
	}

	/**
	 * 获得 <br />
	 * 
	 * @return settlementinterval<br />
	 */
	public Integer getSettlementinterval() {
		return settlementinterval;
	}

	/**
	 * 设置 <br />
	 * 
	 * @param settlementinterval
	 */
	public void setSettlementinterval(Integer settlementinterval) {
		this.settlementinterval = settlementinterval;
	}

	/**
	 * 获得 <br />
	 * 
	 * @return shopproportion<br />
	 */
	public double getShopproportion() {
		return shopproportion;
	}

	/**
	 * 设置 <br />
	 * 
	 * @param shopproportion
	 */
	public void setShopproportion(double shopproportion) {
		this.shopproportion = shopproportion;
	}

	/**
	 * 获得 积分数<br />
	 * 
	 * @return pointcount<br />
	 */
	public Integer getPointcount() {
		return pointcount;
	}

	/**
	 * 设置 积分数 <br />
	 * 
	 * @param pointcount
	 */
	public void setPointcount(Integer pointcount) {
		this.pointcount = pointcount;
	}

	/**
	 * 获得 短信数量<br />
	 * 
	 * @return smscount<br />
	 */
	public Integer getSmscount() {
		return smscount;
	}

	/**
	 * 设置 短信数量 <br />
	 * 
	 * @param smscount
	 */
	public void setSmscount(Integer smscount) {
		this.smscount = smscount;
	}

	/**
	 * 获得 积分类型<br />
	 * 
	 * @return pointtype<br />
	 */
	public Integer getPointtype() {
		return pointtype;
	}

	/**
	 * 设置 积分类型 <br />
	 * 
	 * @param pointtype
	 */
	public void setPointtype(Integer pointtype) {
		this.pointtype = pointtype;
	}

	/**
	 * 获得 短信类型<br />
	 * 
	 * @return smstype<br />
	 */
	public Integer getSmstype() {
		return smstype;
	}

	/**
	 * 设置 短信类型 <br />
	 * 
	 * @param smstype
	 */
	public void setSmstype(Integer smstype) {
		this.smstype = smstype;
	}

	public List<Integer> getShopids() {
		return shopids;
	}

	public void setShopids(List<Integer> shopids) {
		this.shopids = shopids;
	}

	public String getSearchcontent() {
		return searchcontent;
	}

	public void setSearchcontent(String searchcontent) {
		this.searchcontent = searchcontent;
	}

	public Integer getShopauthorityshopid() {
		return shopauthorityshopid;
	}

	public void setShopauthorityshopid(Integer shopauthorityshopid) {
		this.shopauthorityshopid = shopauthorityshopid;
	}
	
	

}
