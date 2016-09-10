package com.jfxy.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品日志表 <br />
 * goodslog<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Goodslog {
	
	private Integer id;
	/**
	 * 商品订单号 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String goodsaccount;
	/**
	 * 类型（1入库/2出库/3挂单出库/8库存编辑前/9库存编辑后） <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer type;
	/**
	 * 商品 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer goodsid;
	/**
	 * 总价格 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal totalprice;
	/**
	 * 总数量 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer goodsnumber;
	/**
	 * 备注 <br />
	 * 允许为空 YES <br />
	 * 数据长度 255<br />
	 */
	private String remark;
	/**
	 * 创建时间 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private String createtime;
	/**
	 * 所属店铺 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer shopid;
	/**
	 * 所属用户 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer userid;
	/**
	 * 目标店铺 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer changeshopid;
	
	private String changeshopname;
	
	private String shopname;
	
	private String username;

	private List<Goodslogdetail> details=new ArrayList<Goodslogdetail>();


	/**
	 * 获得 商品订单号<br />
	 * 
	 * @return goodsaccount<br />
	 */
	public String getGoodsaccount() {
		return goodsaccount;
	}

	/**
	 * 设置 商品订单号 <br />
	 * 
	 * @param goodsaccount
	 */
	public void setGoodsaccount(String goodsaccount) {
		this.goodsaccount = goodsaccount;
	}

	/**
	 * 获得 类型（1入库/2出库/3挂单出库/8库存编辑前/9库存编辑后）<br />
	 * 
	 * @return type<br />
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置 类型（1入库/2出库/3挂单出库/8库存编辑前/9库存编辑后） <br />
	 * 
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获得 商品<br />
	 * 
	 * @return goodsid<br />
	 */
	public Integer getGoodsid() {
		return goodsid;
	}

	/**
	 * 设置 商品 <br />
	 * 
	 * @param goodsid
	 */
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	/**
	 * 获得 总价格<br />
	 * 
	 * @return totalprice<br />
	 */
	public BigDecimal getTotalprice() {
		return totalprice;
	}

	/**
	 * 设置 总价格 <br />
	 * 
	 * @param totalprice
	 */
	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	/**
	 * 获得 总数量<br />
	 * 
	 * @return goodsnumber<br />
	 */
	public Integer getGoodsnumber() {
		return goodsnumber;
	}

	/**
	 * 设置 总数量 <br />
	 * 
	 * @param goodsnumber
	 */
	public void setGoodsnumber(Integer goodsnumber) {
		this.goodsnumber = goodsnumber;
	}

	/**
	 * 获得 备注<br />
	 * 
	 * @return remark<br />
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置 备注 <br />
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获得 创建时间<br />
	 * 
	 * @return createtime<br />
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * 设置 创建时间 <br />
	 * 
	 * @param createtime
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * 获得 所属店铺<br />
	 * 
	 * @return shopid<br />
	 */
	public Integer getShopid() {
		return shopid;
	}

	/**
	 * 设置 所属店铺 <br />
	 * 
	 * @param shopid
	 */
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	/**
	 * 获得 所属用户<br />
	 * 
	 * @return userid<br />
	 */
	public Integer getUserid() {
		return userid;
	}

	/**
	 * 设置 所属用户 <br />
	 * 
	 * @param userid
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * 获得 目标店铺<br />
	 * 
	 * @return changeshopid<br />
	 */
	public Integer getChangeshopid() {
		return changeshopid;
	}

	/**
	 * 设置 目标店铺 <br />
	 * 
	 * @param changeshopid
	 */
	public void setChangeshopid(Integer changeshopid) {
		this.changeshopid = changeshopid;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChangeshopname() {
		return changeshopname;
	}

	public void setChangeshopname(String changeshopname) {
		this.changeshopname = changeshopname;
	}

	public List<Goodslogdetail> getDetails() {
		return details;
	}

	public void setDetails(List<Goodslogdetail> details) {
		this.details = details;
	}
	
	
	
	

}
