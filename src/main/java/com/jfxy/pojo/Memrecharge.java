package com.jfxy.pojo;
 

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 会员充值表 <br />
 * memrecharge<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Memrecharge   {
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer rechargeid;
   /**
    * 会员ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer rechargememid;
   /**
    * 订单号（fd开头）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String rechargeaccount;
   /**
    * 类型   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer rechargetype;
   /**
    * 充值金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal rechargemoney;
   /**
    * 赠送金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal rechargegive;
   /**
    * 备注   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String rechargeremark;
   /**
    * 所属店铺   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer rechargeshopid;
   
   
	private String memcard;

	private String memname;

   /**
    * 创建时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  
   private Date rechargecreatetime;
   /**
    * 所属用户   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer rechargeuserid;
   /**
    * 充值合计   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal rechargecardbalance;
   /**
    * 银联充值   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer rechargeisapprove;
   /**
    * 积分   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer point;
   /**
    * 消费积分   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer rechargepoint;
   
  
   
   private String shopname;
   
   private String username;
   /**
    * 获得 主键<br />
    * @return rechargeid<br />
    */
   public Integer getRechargeid(){
     return rechargeid;
   }
   
   /**
    * 设置 主键 <br />
    * @param rechargeid
    */
   public void setRechargeid(Integer rechargeid ){
     this.rechargeid=rechargeid;
   }
   /**
    * 获得 会员ID<br />
    * @return rechargememid<br />
    */
   public Integer getRechargememid(){
     return rechargememid;
   }
   
   /**
    * 设置 会员ID <br />
    * @param rechargememid
    */
   public void setRechargememid(Integer rechargememid ){
     this.rechargememid=rechargememid;
   }
   /**
    * 获得 订单号（fd开头）<br />
    * @return rechargeaccount<br />
    */
   public String getRechargeaccount(){
     return rechargeaccount;
   }
   
   /**
    * 设置 订单号（fd开头） <br />
    * @param rechargeaccount
    */
   public void setRechargeaccount(String rechargeaccount ){
     this.rechargeaccount=rechargeaccount;
   }
   /**
    * 获得 类型<br />
    * @return rechargetype<br />
    */
   public Integer getRechargetype(){
     return rechargetype;
   }
   
   /**
    * 设置 类型 <br />
    * @param rechargetype
    */
   public void setRechargetype(Integer rechargetype ){
     this.rechargetype=rechargetype;
   }
   /**
    * 获得 充值金额<br />
    * @return rechargemoney<br />
    */
   public BigDecimal getRechargemoney(){
     return rechargemoney;
   }
   
   /**
    * 设置 充值金额 <br />
    * @param rechargemoney
    */
   public void setRechargemoney(BigDecimal rechargemoney ){
     this.rechargemoney=rechargemoney;
   }
   /**
    * 获得 赠送金额<br />
    * @return rechargegive<br />
    */
   public BigDecimal getRechargegive(){
     return rechargegive;
   }
   
   /**
    * 设置 赠送金额 <br />
    * @param rechargegive
    */
   public void setRechargegive(BigDecimal rechargegive ){
     this.rechargegive=rechargegive;
   }
   /**
    * 获得 备注<br />
    * @return rechargeremark<br />
    */
   public String getRechargeremark(){
     return rechargeremark;
   }
   
   /**
    * 设置 备注 <br />
    * @param rechargeremark
    */
   public void setRechargeremark(String rechargeremark ){
     this.rechargeremark=rechargeremark;
   }
   /**
    * 获得 所属店铺<br />
    * @return rechargeshopid<br />
    */
   public Integer getRechargeshopid(){
     return rechargeshopid;
   }
   
   /**
    * 设置 所属店铺 <br />
    * @param rechargeshopid
    */
   public void setRechargeshopid(Integer rechargeshopid ){
     this.rechargeshopid=rechargeshopid;
   }
   /**
    * 获得 创建时间<br />
    * @return rechargecreatetime<br />
    */
   public Date getRechargecreatetime(){
     return rechargecreatetime;
   }
   
   /**
    * 设置 创建时间 <br />
    * @param rechargecreatetime
    */
   public void setRechargecreatetime(Date rechargecreatetime ){
     this.rechargecreatetime=rechargecreatetime;
   }
   /**
    * 获得 所属用户<br />
    * @return rechargeuserid<br />
    */
   public Integer getRechargeuserid(){
     return rechargeuserid;
   }
   
   /**
    * 设置 所属用户 <br />
    * @param rechargeuserid
    */
   public void setRechargeuserid(Integer rechargeuserid ){
     this.rechargeuserid=rechargeuserid;
   }
   /**
    * 获得 充值合计<br />
    * @return rechargecardbalance<br />
    */
   public BigDecimal getRechargecardbalance(){
     return rechargecardbalance;
   }
   
   /**
    * 设置 充值合计 <br />
    * @param rechargecardbalance
    */
   public void setRechargecardbalance(BigDecimal rechargecardbalance ){
     this.rechargecardbalance=rechargecardbalance;
   }
   /**
    * 获得 银联充值<br />
    * @return rechargeisapprove<br />
    */
   public Integer getRechargeisapprove(){
     return rechargeisapprove;
   }
   
   /**
    * 设置 银联充值 <br />
    * @param rechargeisapprove
    */
   public void setRechargeisapprove(Integer rechargeisapprove ){
     this.rechargeisapprove=rechargeisapprove;
   }
   /**
    * 获得 积分<br />
    * @return point<br />
    */
   public Integer getPoint(){
     return point;
   }
   
   /**
    * 设置 积分 <br />
    * @param point
    */
   public void setPoint(Integer point ){
     this.point=point;
   }
   /**
    * 获得 消费积分<br />
    * @return rechargepoint<br />
    */
   public Integer getRechargepoint(){
     return rechargepoint;
   }
   
   /**
    * 设置 消费积分 <br />
    * @param rechargepoint
    */
   public void setRechargepoint(Integer rechargepoint ){
     this.rechargepoint=rechargepoint;
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

public String getMemcard() {
	return memcard;
}

public void setMemcard(String memcard) {
	this.memcard = memcard;
}

public String getMemname() {
	return memname;
}

public void setMemname(String memname) {
	this.memname = memname;
}

	public BigDecimal getRechargeordmoney(){
		return rechargemoney.subtract(rechargegive);
	}
   
   
   
}
