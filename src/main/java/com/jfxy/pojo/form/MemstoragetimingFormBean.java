package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;

import scala.collection.generic.BitOperations.Int;

import com.jfxy.pojo.Memstoragetiming;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员充时表 <br />
 * memstoragetiming<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class MemstoragetimingFormBean extends Pagination<Memstoragetiming> {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer storagetimingid;
	/**
	 * 会员ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer storagetimingmemid;
	/**
	 * 订单号 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String storagetimingaccount;
	/**
	 * 应付金额 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal storagetimingtotalmoney;
	/**
	 * 实付金额 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal storagetimingdiscountmoney;
	/**
	 * 使否使用银联支付 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer storagetimingiscard;
	/**
	 * 银联支付 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal storagetimingpaycard;
	/**
	 * 是否现在金支付 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer storagetimingiscash;
	/**
	 * 现在支付金额 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal storagetimingpaycash;
	/**
	 * 使否使用银行卡支付 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer storagetimingisbink;
	/**
	 * 银行卡支付 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal storagetimingpaybink;
	/**
	 * 支付优惠券 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal storagetimingpaycoupon;
	/**
	 * 支付类型？ <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer storagetimingpaytype;
	/**
	 * 可得积分 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer storagetimingpoint;
	/**
	 * 备注 <br />
	 * 允许为空 YES <br />
	 * 数据长度 200<br />
	 */
	private String storagetimingremark;
	/**
	 * 所属店铺ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer storagetimingshopid;
	/**
	 * 所属用户ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer storagetiminguserid;
	/**
	 * 创建时间 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Date storagetimingcreatetime;
	/**
	 * 充值时长 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer storagetotaltime;
	/**
	 * <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer storageresiduetime;
	/**
	 * 项目ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer storagetimingprojectid;

	

	/**
	 * 获得 主键<br />
	 * 
	 * @return storagetimingid<br />
	 */
	public Integer getStoragetimingid() {
		return storagetimingid;
	}

	/**
	 * 设置 主键 <br />
	 * 
	 * @param storagetimingid
	 */
	public void setStoragetimingid(Integer storagetimingid) {
		this.storagetimingid = storagetimingid;
	}

	/**
	 * 获得 会员ID<br />
	 * 
	 * @return storagetimingmemid<br />
	 */
	public Integer getStoragetimingmemid() {
		return storagetimingmemid;
	}

	/**
	 * 设置 会员ID <br />
	 * 
	 * @param storagetimingmemid
	 */
	public void setStoragetimingmemid(Integer storagetimingmemid) {
		this.storagetimingmemid = storagetimingmemid;
	}

	/**
	 * 获得 订单号<br />
	 * 
	 * @return storagetimingaccount<br />
	 */
	public String getStoragetimingaccount() {
		return storagetimingaccount;
	}

	/**
	 * 设置 订单号 <br />
	 * 
	 * @param storagetimingaccount
	 */
	public void setStoragetimingaccount(String storagetimingaccount) {
		this.storagetimingaccount = storagetimingaccount;
	}

	/**
	 * 获得 应付金额<br />
	 * 
	 * @return storagetimingtotalmoney<br />
	 */
	public BigDecimal getStoragetimingtotalmoney() {
		return storagetimingtotalmoney;
	}

	/**
	 * 设置 应付金额 <br />
	 * 
	 * @param storagetimingtotalmoney
	 */
	public void setStoragetimingtotalmoney(BigDecimal storagetimingtotalmoney) {
		this.storagetimingtotalmoney = storagetimingtotalmoney;
	}

	/**
	 * 获得 实付金额<br />
	 * 
	 * @return storagetimingdiscountmoney<br />
	 */
	public BigDecimal getStoragetimingdiscountmoney() {
		return storagetimingdiscountmoney;
	}

	/**
	 * 设置 实付金额 <br />
	 * 
	 * @param storagetimingdiscountmoney
	 */
	public void setStoragetimingdiscountmoney(BigDecimal storagetimingdiscountmoney) {
		this.storagetimingdiscountmoney = storagetimingdiscountmoney;
	}

	/**
	 * 获得 使否使用银联支付<br />
	 * 
	 * @return storagetimingiscard<br />
	 */
	public Integer getStoragetimingiscard() {
		return storagetimingiscard;
	}

	/**
	 * 设置 使否使用银联支付 <br />
	 * 
	 * @param storagetimingiscard
	 */
	public void setStoragetimingiscard(Integer storagetimingiscard) {
		this.storagetimingiscard = storagetimingiscard;
	}

	/**
	 * 获得 银联支付<br />
	 * 
	 * @return storagetimingpaycard<br />
	 */
	public BigDecimal getStoragetimingpaycard() {
		return storagetimingpaycard;
	}

	/**
	 * 设置 银联支付 <br />
	 * 
	 * @param storagetimingpaycard
	 */
	public void setStoragetimingpaycard(BigDecimal storagetimingpaycard) {
		this.storagetimingpaycard = storagetimingpaycard;
	}

	/**
	 * 获得 是否现在金支付<br />
	 * 
	 * @return storagetimingiscash<br />
	 */
	public Integer getStoragetimingiscash() {
		return storagetimingiscash;
	}

	/**
	 * 设置 是否现在金支付 <br />
	 * 
	 * @param storagetimingiscash
	 */
	public void setStoragetimingiscash(Integer storagetimingiscash) {
		this.storagetimingiscash = storagetimingiscash;
	}

	/**
	 * 获得 现在支付金额<br />
	 * 
	 * @return storagetimingpaycash<br />
	 */
	public BigDecimal getStoragetimingpaycash() {
		return storagetimingpaycash;
	}

	/**
	 * 设置 现在支付金额 <br />
	 * 
	 * @param storagetimingpaycash
	 */
	public void setStoragetimingpaycash(BigDecimal storagetimingpaycash) {
		this.storagetimingpaycash = storagetimingpaycash;
	}

	/**
	 * 获得 使否使用银行卡支付<br />
	 * 
	 * @return storagetimingisbink<br />
	 */
	public Integer getStoragetimingisbink() {
		return storagetimingisbink;
	}

	/**
	 * 设置 使否使用银行卡支付 <br />
	 * 
	 * @param storagetimingisbink
	 */
	public void setStoragetimingisbink(Integer storagetimingisbink) {
		this.storagetimingisbink = storagetimingisbink;
	}

	/**
	 * 获得 银行卡支付<br />
	 * 
	 * @return storagetimingpaybink<br />
	 */
	public BigDecimal getStoragetimingpaybink() {
		return storagetimingpaybink;
	}

	/**
	 * 设置 银行卡支付 <br />
	 * 
	 * @param storagetimingpaybink
	 */
	public void setStoragetimingpaybink(BigDecimal storagetimingpaybink) {
		this.storagetimingpaybink = storagetimingpaybink;
	}

	/**
	 * 获得 支付优惠券<br />
	 * 
	 * @return storagetimingpaycoupon<br />
	 */
	public BigDecimal getStoragetimingpaycoupon() {
		return storagetimingpaycoupon;
	}

	/**
	 * 设置 支付优惠券 <br />
	 * 
	 * @param storagetimingpaycoupon
	 */
	public void setStoragetimingpaycoupon(BigDecimal storagetimingpaycoupon) {
		this.storagetimingpaycoupon = storagetimingpaycoupon;
	}

	/**
	 * 获得 支付类型？<br />
	 * 
	 * @return storagetimingpaytype<br />
	 */
	public Integer getStoragetimingpaytype() {
		return storagetimingpaytype;
	}

	/**
	 * 设置 支付类型？ <br />
	 * 
	 * @param storagetimingpaytype
	 */
	public void setStoragetimingpaytype(Integer storagetimingpaytype) {
		this.storagetimingpaytype = storagetimingpaytype;
	}

	/**
	 * 获得 可得积分<br />
	 * 
	 * @return storagetimingpoint<br />
	 */
	public Integer getStoragetimingpoint() {
		return storagetimingpoint;
	}

	/**
	 * 设置 可得积分 <br />
	 * 
	 * @param storagetimingpoint
	 */
	public void setStoragetimingpoint(Integer storagetimingpoint) {
		this.storagetimingpoint = storagetimingpoint;
	}

	/**
	 * 获得 备注<br />
	 * 
	 * @return storagetimingremark<br />
	 */
	public String getStoragetimingremark() {
		return storagetimingremark;
	}

	/**
	 * 设置 备注 <br />
	 * 
	 * @param storagetimingremark
	 */
	public void setStoragetimingremark(String storagetimingremark) {
		this.storagetimingremark = storagetimingremark;
	}

	/**
	 * 获得 所属店铺ID<br />
	 * 
	 * @return storagetimingshopid<br />
	 */
	public Integer getStoragetimingshopid() {
		return storagetimingshopid;
	}

	/**
	 * 设置 所属店铺ID <br />
	 * 
	 * @param storagetimingshopid
	 */
	public void setStoragetimingshopid(Integer storagetimingshopid) {
		this.storagetimingshopid = storagetimingshopid;
	}

	/**
	 * 获得 所属用户ID<br />
	 * 
	 * @return storagetiminguserid<br />
	 */
	public Integer getStoragetiminguserid() {
		return storagetiminguserid;
	}

	/**
	 * 设置 所属用户ID <br />
	 * 
	 * @param storagetiminguserid
	 */
	public void setStoragetiminguserid(Integer storagetiminguserid) {
		this.storagetiminguserid = storagetiminguserid;
	}

	/**
	 * 获得 创建时间<br />
	 * 
	 * @return storagetimingcreatetime<br />
	 */
	public Date getStoragetimingcreatetime() {
		return storagetimingcreatetime;
	}

	/**
	 * 设置 创建时间 <br />
	 * 
	 * @param storagetimingcreatetime
	 */
	public void setStoragetimingcreatetime(Date storagetimingcreatetime) {
		this.storagetimingcreatetime = storagetimingcreatetime;
	}

	/**
	 * 获得 充值时长<br />
	 * 
	 * @return storagetotaltime<br />
	 */
	public Integer getStoragetotaltime() {
		return storagetotaltime;
	}

	/**
	 * 设置 充值时长 <br />
	 * 
	 * @param storagetotaltime
	 */
	public void setStoragetotaltime(Integer storagetotaltime) {
		this.storagetotaltime = storagetotaltime;
	}

	/**
	 * 获得 <br />
	 * 
	 * @return storageresiduetime<br />
	 */
	public Integer getStorageresiduetime() {
		return storageresiduetime;
	}

	/**
	 * 设置 <br />
	 * 
	 * @param storageresiduetime
	 */
	public void setStorageresiduetime(Integer storageresiduetime) {
		this.storageresiduetime = storageresiduetime;
	}

	/**
	 * 获得 项目ID<br />
	 * 
	 * @return storagetimingprojectid<br />
	 */
	public Integer getStoragetimingprojectid() {
		return storagetimingprojectid;
	}

	/**
	 * 设置 项目ID <br />
	 * 
	 * @param storagetimingprojectid
	 */
	public void setStoragetimingprojectid(Integer storagetimingprojectid) {
		this.storagetimingprojectid = storagetimingprojectid;
	}

	
	
	

}
