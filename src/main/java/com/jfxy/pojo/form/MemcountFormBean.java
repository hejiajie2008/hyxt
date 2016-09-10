package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Memcount;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员充次表 <br />
 * memcount<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class MemcountFormBean extends Pagination<Memcount>   {
  private static final long serialVersionUID = 1L;
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer countid;
   /**
    * 会员ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer countmemid;
   /**
    * 账号   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String countaccount;
   /**
    * 总金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal counttotalmoney;
   /**
    * 折扣金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal countdiscountmoney;
   /**
    * 使否使用银联支付   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer countiscard;
   /**
    * 银联支付   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal countpaycard;
   /**
    * 是否现在金支付   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer countiscash;
   /**
    * 现在支付金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal countpaycash;
   /**
    * 使否使用银行卡支付   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer countisbink;
   /**
    * 银行卡支付   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal countpaybink;
   /**
    * 支付优惠券   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal countpaycoupon;
   /**
    * 支付类型   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer countpaytype;
   /**
    * 积分   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer countpoint;
   /**
    * 积分备注   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String countremark;
   /**
    * 店铺ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer countshopid;
   /**
    * 消费时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date countcreatetime;
   /**
    * 录入用户   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer countuserid;
   /**
    * 获得 主键<br />
    * @return countid<br />
    */
   public Integer getCountid(){
     return countid;
   }
   
   /**
    * 设置 主键 <br />
    * @param countid
    */
   public void setCountid(Integer countid ){
     this.countid=countid;
   }
   /**
    * 获得 会员ID<br />
    * @return countmemid<br />
    */
   public Integer getCountmemid(){
     return countmemid;
   }
   
   /**
    * 设置 会员ID <br />
    * @param countmemid
    */
   public void setCountmemid(Integer countmemid ){
     this.countmemid=countmemid;
   }
   /**
    * 获得 账号<br />
    * @return countaccount<br />
    */
   public String getCountaccount(){
     return countaccount;
   }
   
   /**
    * 设置 账号 <br />
    * @param countaccount
    */
   public void setCountaccount(String countaccount ){
     this.countaccount=countaccount;
   }
   /**
    * 获得 总金额<br />
    * @return counttotalmoney<br />
    */
   public BigDecimal getCounttotalmoney(){
     return counttotalmoney;
   }
   
   /**
    * 设置 总金额 <br />
    * @param counttotalmoney
    */
   public void setCounttotalmoney(BigDecimal counttotalmoney ){
     this.counttotalmoney=counttotalmoney;
   }
   /**
    * 获得 折扣金额<br />
    * @return countdiscountmoney<br />
    */
   public BigDecimal getCountdiscountmoney(){
     return countdiscountmoney;
   }
   
   /**
    * 设置 折扣金额 <br />
    * @param countdiscountmoney
    */
   public void setCountdiscountmoney(BigDecimal countdiscountmoney ){
     this.countdiscountmoney=countdiscountmoney;
   }
   /**
    * 获得 使否使用银联支付<br />
    * @return countiscard<br />
    */
   public Integer getCountiscard(){
     return countiscard;
   }
   
   /**
    * 设置 使否使用银联支付 <br />
    * @param countiscard
    */
   public void setCountiscard(Integer countiscard ){
     this.countiscard=countiscard;
   }
   /**
    * 获得 银联支付<br />
    * @return countpaycard<br />
    */
   public BigDecimal getCountpaycard(){
     return countpaycard;
   }
   
   /**
    * 设置 银联支付 <br />
    * @param countpaycard
    */
   public void setCountpaycard(BigDecimal countpaycard ){
     this.countpaycard=countpaycard;
   }
   /**
    * 获得 是否现在金支付<br />
    * @return countiscash<br />
    */
   public Integer getCountiscash(){
     return countiscash;
   }
   
   /**
    * 设置 是否现在金支付 <br />
    * @param countiscash
    */
   public void setCountiscash(Integer countiscash ){
     this.countiscash=countiscash;
   }
   /**
    * 获得 现在支付金额<br />
    * @return countpaycash<br />
    */
   public BigDecimal getCountpaycash(){
     return countpaycash;
   }
   
   /**
    * 设置 现在支付金额 <br />
    * @param countpaycash
    */
   public void setCountpaycash(BigDecimal countpaycash ){
     this.countpaycash=countpaycash;
   }
   /**
    * 获得 使否使用银行卡支付<br />
    * @return countisbink<br />
    */
   public Integer getCountisbink(){
     return countisbink;
   }
   
   /**
    * 设置 使否使用银行卡支付 <br />
    * @param countisbink
    */
   public void setCountisbink(Integer countisbink ){
     this.countisbink=countisbink;
   }
   /**
    * 获得 银行卡支付<br />
    * @return countpaybink<br />
    */
   public BigDecimal getCountpaybink(){
     return countpaybink;
   }
   
   /**
    * 设置 银行卡支付 <br />
    * @param countpaybink
    */
   public void setCountpaybink(BigDecimal countpaybink ){
     this.countpaybink=countpaybink;
   }
   /**
    * 获得 支付优惠券<br />
    * @return countpaycoupon<br />
    */
   public BigDecimal getCountpaycoupon(){
     return countpaycoupon;
   }
   
   /**
    * 设置 支付优惠券 <br />
    * @param countpaycoupon
    */
   public void setCountpaycoupon(BigDecimal countpaycoupon ){
     this.countpaycoupon=countpaycoupon;
   }
   /**
    * 获得 支付类型<br />
    * @return countpaytype<br />
    */
   public Integer getCountpaytype(){
     return countpaytype;
   }
   
   /**
    * 设置 支付类型 <br />
    * @param countpaytype
    */
   public void setCountpaytype(Integer countpaytype ){
     this.countpaytype=countpaytype;
   }
   /**
    * 获得 积分<br />
    * @return countpoint<br />
    */
   public Integer getCountpoint(){
     return countpoint;
   }
   
   /**
    * 设置 积分 <br />
    * @param countpoint
    */
   public void setCountpoint(Integer countpoint ){
     this.countpoint=countpoint;
   }
   /**
    * 获得 积分备注<br />
    * @return countremark<br />
    */
   public String getCountremark(){
     return countremark;
   }
   
   /**
    * 设置 积分备注 <br />
    * @param countremark
    */
   public void setCountremark(String countremark ){
     this.countremark=countremark;
   }
   /**
    * 获得 店铺ID<br />
    * @return countshopid<br />
    */
   public Integer getCountshopid(){
     return countshopid;
   }
   
   /**
    * 设置 店铺ID <br />
    * @param countshopid
    */
   public void setCountshopid(Integer countshopid ){
     this.countshopid=countshopid;
   }
   /**
    * 获得 消费时间<br />
    * @return countcreatetime<br />
    */
   public Date getCountcreatetime(){
     return countcreatetime;
   }
   
   /**
    * 设置 消费时间 <br />
    * @param countcreatetime
    */
   public void setCountcreatetime(Date countcreatetime ){
     this.countcreatetime=countcreatetime;
   }
   /**
    * 获得 录入用户<br />
    * @return countuserid<br />
    */
   public Integer getCountuserid(){
     return countuserid;
   }
   
   /**
    * 设置 录入用户 <br />
    * @param countuserid
    */
   public void setCountuserid(Integer countuserid ){
     this.countuserid=countuserid;
   }
}
