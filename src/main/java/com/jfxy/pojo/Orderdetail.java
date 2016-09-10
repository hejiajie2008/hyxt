package com.jfxy.pojo;

import java.math.BigDecimal;

/**
 * 订单明细表 <br />
 * orderdetail<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Orderdetail {
	/**
	 * 主键 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer orderdetailid;
	/**
	 * 订单号 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer orderid;
	/**
	 * 商品 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer goodsid;
	/**
	 * 明细价格 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal orderdetailprice;
	/**
	 * 明细积分 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer orderdetailpoint;
	/**
	 * 明细折扣价 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal orderdetaildiscountprice;
	/**
	 * <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer orderdetailnumber;
	/**
	 * <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer orderdetailtype;

	private String name;
	
	private String goodscode;
	
	private Integer goodstype;

	/**
	 * 获得 主键<br />
	 * 
	 * @return orderdetailid<br />
	 */
	public Integer getOrderdetailid() {
		return orderdetailid;
	}

	/**
	 * 设置 主键 <br />
	 * 
	 * @param orderdetailid
	 */
	public void setOrderdetailid(Integer orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

	/**
	 * 获得 订单号<br />
	 * 
	 * @return orderid<br />
	 */
	public Integer getOrderid() {
		return orderid;
	}

	/**
	 * 设置 订单号 <br />
	 * 
	 * @param orderid
	 */
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
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
	 * 获得 明细价格<br />
	 * 
	 * @return orderdetailprice<br />
	 */
	public BigDecimal getOrderdetailprice() {
		return orderdetailprice;
	}

	/**
	 * 设置 明细价格 <br />
	 * 
	 * @param orderdetailprice
	 */
	public void setOrderdetailprice(BigDecimal orderdetailprice) {
		this.orderdetailprice = orderdetailprice;
	}

	/**
	 * 获得 明细积分<br />
	 * 
	 * @return orderdetailpoint<br />
	 */
	public Integer getOrderdetailpoint() {
		return orderdetailpoint;
	}

	/**
	 * 设置 明细积分 <br />
	 * 
	 * @param orderdetailpoint
	 */
	public void setOrderdetailpoint(Integer orderdetailpoint) {
		this.orderdetailpoint = orderdetailpoint;
	}

	/**
	 * 获得 明细折扣价<br />
	 * 
	 * @return orderdetaildiscountprice<br />
	 */
	public BigDecimal getOrderdetaildiscountprice() {
		return orderdetaildiscountprice;
	}

	/**
	 * 设置 明细折扣价 <br />
	 * 
	 * @param orderdetaildiscountprice
	 */
	public void setOrderdetaildiscountprice(BigDecimal orderdetaildiscountprice) {
		this.orderdetaildiscountprice = orderdetaildiscountprice;
	}

	/**
	 * 获得 <br />
	 * 
	 * @return orderdetailnumber<br />
	 */
	public Integer getOrderdetailnumber() {
		return orderdetailnumber;
	}

	/**
	 * 设置 <br />
	 * 
	 * @param orderdetailnumber
	 */
	public void setOrderdetailnumber(Integer orderdetailnumber) {
		this.orderdetailnumber = orderdetailnumber;
	}

	/**
	 * 获得 <br />
	 * 
	 * @return orderdetailtype<br />
	 */
	public Integer getOrderdetailtype() {
		return orderdetailtype;
	}

	/**
	 * 设置 <br />
	 * 
	 * @param orderdetailtype
	 */
	public void setOrderdetailtype(Integer orderdetailtype) {
		this.orderdetailtype = orderdetailtype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGoodscode() {
		return goodscode;
	}

	public void setGoodscode(String goodscode) {
		this.goodscode = goodscode;
	}

	public Integer getGoodstype() {
		return goodstype;
	}

	public void setGoodstype(Integer goodstype) {
		this.goodstype = goodstype;
	}
	public void setExpnum(Integer number){
		this.setOrderdetailnumber(number);
	}
	
	
}
