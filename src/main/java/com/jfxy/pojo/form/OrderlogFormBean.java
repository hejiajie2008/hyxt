package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Orderlog;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 消费记录表 <br />
 * orderlog<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class OrderlogFormBean extends Pagination<Orderlog>   {
  private static final long serialVersionUID = 1L;
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer orderid;
   /**
    * 订单编码（CD消费撤单，gd商品消费，gr计时消费）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String orderaccount;
   /**
    * -1散客消费/0快速消费/1计时消费/2商品消费/4消费撤单/5消费原单/6商品退货/7计次消费,   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ordertype;
   /**
    * 会员ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ordermemid;
   /**
    * 总金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal ordertotalmoney;
   /**
    * 折扣金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal orderdiscountmoney;
   /**
    * 是否用卡   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer orderiscard;
   /**
    * 卡支付金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal orderpaycard;
   /**
    * 是否银联   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer orderiscash;
   /**
    * 银联支付金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal orderpaycash;
   /**
    * 是否银行卡支付   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer orderisbink;
   /**
    * 银行卡支付金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal orderpaybink;
   /**
    * 现金支付   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal orderpaycoupon;
   /**
    * 积分   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer orderpoint;
   /**
    * 积分备注   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private String orderremark;
   /**
    * 支付方式   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer orderpaytype;
   /**
    * 所属店铺   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ordershopid;
   /**
    * 创建时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date ordercreatetime;
   /**
    * 录入用户名   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer orderuserid;
   /**
    * 旧的订单号   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String oldaccount;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal ordercardbalance;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ordercardpoint;
   /**
    * 获得 主键<br />
    * @return orderid<br />
    */
   public Integer getOrderid(){
     return orderid;
   }
   
   /**
    * 设置 主键 <br />
    * @param orderid
    */
   public void setOrderid(Integer orderid ){
     this.orderid=orderid;
   }
   /**
    * 获得 订单编码（CD消费撤单，gd商品消费，gr计时消费）<br />
    * @return orderaccount<br />
    */
   public String getOrderaccount(){
     return orderaccount;
   }
   
   /**
    * 设置 订单编码（CD消费撤单，gd商品消费，gr计时消费） <br />
    * @param orderaccount
    */
   public void setOrderaccount(String orderaccount ){
     this.orderaccount=orderaccount;
   }
   /**
    * 获得 -1散客消费/0快速消费/1计时消费/2商品消费/4消费撤单/5消费原单/6商品退货/7计次消费,<br />
    * @return ordertype<br />
    */
   public Integer getOrdertype(){
     return ordertype;
   }
   
   /**
    * 设置 -1散客消费/0快速消费/1计时消费/2商品消费/4消费撤单/5消费原单/6商品退货/7计次消费, <br />
    * @param ordertype
    */
   public void setOrdertype(Integer ordertype ){
     this.ordertype=ordertype;
   }
   /**
    * 获得 会员ID<br />
    * @return ordermemid<br />
    */
   public Integer getOrdermemid(){
     return ordermemid;
   }
   
   /**
    * 设置 会员ID <br />
    * @param ordermemid
    */
   public void setOrdermemid(Integer ordermemid ){
     this.ordermemid=ordermemid;
   }
   /**
    * 获得 总金额<br />
    * @return ordertotalmoney<br />
    */
   private BigDecimal getOrdertotalmoney(){
     return ordertotalmoney;
   }
   
   /**
    * 设置 总金额 <br />
    * @param ordertotalmoney
    */
   public void setOrdertotalmoney(BigDecimal ordertotalmoney ){
     this.ordertotalmoney=ordertotalmoney;
   }
   /**
    * 获得 折扣金额<br />
    * @return orderdiscountmoney<br />
    */
   private BigDecimal getOrderdiscountmoney(){
     return orderdiscountmoney;
   }
   
   /**
    * 设置 折扣金额 <br />
    * @param orderdiscountmoney
    */
   public void setOrderdiscountmoney(BigDecimal orderdiscountmoney ){
     this.orderdiscountmoney=orderdiscountmoney;
   }
   /**
    * 获得 是否用卡<br />
    * @return orderiscard<br />
    */
   public Integer getOrderiscard(){
     return orderiscard;
   }
   
   /**
    * 设置 是否用卡 <br />
    * @param orderiscard
    */
   public void setOrderiscard(Integer orderiscard ){
     this.orderiscard=orderiscard;
   }
   /**
    * 获得 卡支付金额<br />
    * @return orderpaycard<br />
    */
   private BigDecimal getOrderpaycard(){
     return orderpaycard;
   }
   
   /**
    * 设置 卡支付金额 <br />
    * @param orderpaycard
    */
   public void setOrderpaycard(BigDecimal orderpaycard ){
     this.orderpaycard=orderpaycard;
   }
   /**
    * 获得 是否银联<br />
    * @return orderiscash<br />
    */
   public Integer getOrderiscash(){
     return orderiscash;
   }
   
   /**
    * 设置 是否银联 <br />
    * @param orderiscash
    */
   public void setOrderiscash(Integer orderiscash ){
     this.orderiscash=orderiscash;
   }
   /**
    * 获得 银联支付金额<br />
    * @return orderpaycash<br />
    */
   private BigDecimal getOrderpaycash(){
     return orderpaycash;
   }
   
   /**
    * 设置 银联支付金额 <br />
    * @param orderpaycash
    */
   public void setOrderpaycash(BigDecimal orderpaycash ){
     this.orderpaycash=orderpaycash;
   }
   /**
    * 获得 是否银行卡支付<br />
    * @return orderisbink<br />
    */
   public Integer getOrderisbink(){
     return orderisbink;
   }
   
   /**
    * 设置 是否银行卡支付 <br />
    * @param orderisbink
    */
   public void setOrderisbink(Integer orderisbink ){
     this.orderisbink=orderisbink;
   }
   /**
    * 获得 银行卡支付金额<br />
    * @return orderpaybink<br />
    */
   private BigDecimal getOrderpaybink(){
     return orderpaybink;
   }
   
   /**
    * 设置 银行卡支付金额 <br />
    * @param orderpaybink
    */
   public void setOrderpaybink(BigDecimal orderpaybink ){
     this.orderpaybink=orderpaybink;
   }
   /**
    * 获得 现金支付<br />
    * @return orderpaycoupon<br />
    */
   private BigDecimal getOrderpaycoupon(){
     return orderpaycoupon;
   }
   
   /**
    * 设置 现金支付 <br />
    * @param orderpaycoupon
    */
   public void setOrderpaycoupon(BigDecimal orderpaycoupon ){
     this.orderpaycoupon=orderpaycoupon;
   }
   /**
    * 获得 积分<br />
    * @return orderpoint<br />
    */
   public Integer getOrderpoint(){
     return orderpoint;
   }
   
   /**
    * 设置 积分 <br />
    * @param orderpoint
    */
   public void setOrderpoint(Integer orderpoint ){
     this.orderpoint=orderpoint;
   }
   /**
    * 获得 积分备注<br />
    * @return orderremark<br />
    */
   public String getOrderremark(){
     return orderremark;
   }
   
   /**
    * 设置 积分备注 <br />
    * @param orderremark
    */
   public void setOrderremark(String orderremark ){
     this.orderremark=orderremark;
   }
   /**
    * 获得 支付方式<br />
    * @return orderpaytype<br />
    */
   public Integer getOrderpaytype(){
     return orderpaytype;
   }
   
   /**
    * 设置 支付方式 <br />
    * @param orderpaytype
    */
   public void setOrderpaytype(Integer orderpaytype ){
     this.orderpaytype=orderpaytype;
   }
   /**
    * 获得 所属店铺<br />
    * @return ordershopid<br />
    */
   public Integer getOrdershopid(){
     return ordershopid;
   }
   
   /**
    * 设置 所属店铺 <br />
    * @param ordershopid
    */
   public void setOrdershopid(Integer ordershopid ){
     this.ordershopid=ordershopid;
   }
   /**
    * 获得 创建时间<br />
    * @return ordercreatetime<br />
    */
   public Date getOrdercreatetime(){
     return ordercreatetime;
   }
   
   /**
    * 设置 创建时间 <br />
    * @param ordercreatetime
    */
   public void setOrdercreatetime(Date ordercreatetime ){
     this.ordercreatetime=ordercreatetime;
   }
   /**
    * 获得 录入用户名<br />
    * @return orderuserid<br />
    */
   public Integer getOrderuserid(){
     return orderuserid;
   }
   
   /**
    * 设置 录入用户名 <br />
    * @param orderuserid
    */
   public void setOrderuserid(Integer orderuserid ){
     this.orderuserid=orderuserid;
   }
   /**
    * 获得 旧的订单号<br />
    * @return oldaccount<br />
    */
   public String getOldaccount(){
     return oldaccount;
   }
   
   /**
    * 设置 旧的订单号 <br />
    * @param oldaccount
    */
   public void setOldaccount(String oldaccount ){
     this.oldaccount=oldaccount;
   }
   /**
    * 获得 <br />
    * @return ordercardbalance<br />
    */
   private BigDecimal getOrdercardbalance(){
     return ordercardbalance;
   }
   
   /**
    * 设置  <br />
    * @param ordercardbalance
    */
   public void setOrdercardbalance(BigDecimal ordercardbalance ){
     this.ordercardbalance=ordercardbalance;
   }
   /**
    * 获得 <br />
    * @return ordercardpoint<br />
    */
   public Integer getOrdercardpoint(){
     return ordercardpoint;
   }
   
   /**
    * 设置  <br />
    * @param ordercardpoint
    */
   public void setOrdercardpoint(Integer ordercardpoint ){
     this.ordercardpoint=ordercardpoint;
   }
}
