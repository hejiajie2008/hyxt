package com.jfxy.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员充次明细表 <br />
 * memcountdetail<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Memcountdetail {
	/**
	 * 主键 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer countdetailid;
	/**
	 * 会员消费ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer countdetailcountid;
	/**
	 * 商品ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer goodsid;
	/**
	 * 会员ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer countdetailmemid;
	/**
	 * 总数量 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer countdetailtotalnumber;
	/**
	 * 明细数量 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer countdetailnumber;
	/**
	 * 折扣金额 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal countdetaildiscountmoney;
	/**
	 * 积分 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer countdetailpoint;
	/**
	 * 创建时间 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Date countcreatetime;

	private String name;
	private String goodscode;
	
	private String unit;

	/**
	 * 获得 主键<br />
	 * 
	 * @return countdetailid<br />
	 */
	public Integer getCountdetailid() {
		return countdetailid;
	}

	/**
	 * 设置 主键 <br />
	 * 
	 * @param countdetailid
	 */
	public void setCountdetailid(Integer countdetailid) {
		this.countdetailid = countdetailid;
	}

	/**
	 * 获得 会员消费ID<br />
	 * 
	 * @return countdetailcountid<br />
	 */
	public Integer getCountdetailcountid() {
		return countdetailcountid;
	}

	/**
	 * 设置 会员消费ID <br />
	 * 
	 * @param countdetailcountid
	 */
	public void setCountdetailcountid(Integer countdetailcountid) {
		this.countdetailcountid = countdetailcountid;
	}

	/**
	 * 获得 商品ID<br />
	 * 
	 * @return countdetailgoodsid<br />
	 */
	public Integer getGoodsid() {
		return goodsid;
	}

	/**
	 * 设置 商品ID <br />
	 * 
	 * @param countdetailgoodsid
	 */
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	/**
	 * 获得 会员ID<br />
	 * 
	 * @return countdetailmemid<br />
	 */
	public Integer getCountdetailmemid() {
		return countdetailmemid;
	}

	/**
	 * 设置 会员ID <br />
	 * 
	 * @param countdetailmemid
	 */
	public void setCountdetailmemid(Integer countdetailmemid) {
		this.countdetailmemid = countdetailmemid;
	}

	/**
	 * 获得 总数量<br />
	 * 
	 * @return countdetailtotalnumber<br />
	 */
	public Integer getCountdetailtotalnumber() {
		return countdetailtotalnumber;
	}

	/**
	 * 设置 总数量 <br />
	 * 
	 * @param countdetailtotalnumber
	 */
	public void setCountdetailtotalnumber(Integer countdetailtotalnumber) {
		this.countdetailtotalnumber = countdetailtotalnumber;
	}

	/**
	 * 获得 明细数量<br />
	 * 
	 * @return countdetailnumber<br />
	 */
	public Integer getCountdetailnumber() {
		return countdetailnumber;
	}

	/**
	 * 设置 明细数量 <br />
	 * 
	 * @param countdetailnumber
	 */
	public void setCountdetailnumber(Integer countdetailnumber) {
		this.countdetailnumber = countdetailnumber;
	}

	/**
	 * 获得 折扣金额<br />
	 * 
	 * @return countdetaildiscountmoney<br />
	 */
	public BigDecimal getCountdetaildiscountmoney() {
		return countdetaildiscountmoney;
	}

	/**
	 * 设置 折扣金额 <br />
	 * 
	 * @param countdetaildiscountmoney
	 */
	public void setCountdetaildiscountmoney(BigDecimal countdetaildiscountmoney) {
		this.countdetaildiscountmoney = countdetaildiscountmoney;
	}

	/**
	 * 获得 积分<br />
	 * 
	 * @return countdetailpoint<br />
	 */
	public Integer getCountdetailpoint() {
		return countdetailpoint;
	}

	/**
	 * 设置 积分 <br />
	 * 
	 * @param countdetailpoint
	 */
	public void setCountdetailpoint(Integer countdetailpoint) {
		this.countdetailpoint = countdetailpoint;
	}

	/**
	 * 获得 创建时间<br />
	 * 
	 * @return countcreatetime<br />
	 */
	public Date getCountcreatetime() {
		return countcreatetime;
	}

	/**
	 * 设置 创建时间 <br />
	 * 
	 * @param countcreatetime
	 */
	public void setCountcreatetime(Date countcreatetime) {
		this.countcreatetime = countcreatetime;
	}

	public void setExpnum(Integer expnum) {
		this.countdetailnumber = expnum;
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

	public void setExpmoney(BigDecimal expmoney){
		this.countdetaildiscountmoney=expmoney;
	}
	
	public void setExppoint(Integer exppoint){
		this.countdetailpoint=exppoint;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Integer getNumber(){
		return this.getCountdetailtotalnumber();
	}
}
