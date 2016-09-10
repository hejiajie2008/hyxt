package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Pointexchange;
import java.util.Date;

/**
 * 积分兑换表 <br />
 * pointexchange<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class PointexchangeFormBean extends Pagination<Pointexchange>   {
  private static final long serialVersionUID = 1L;
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer exchangeid;
   /**
    * 会员ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer exchangememid;
   /**
    * 礼品   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer exchangegiftid;
   /**
    * 数量   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer exchangenumber;
   /**
    * 总积分数   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer exchangetotalpoint;
   /**
    * 店铺   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer exchangeshopid;
   /**
    * 兑换时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date exchangetime;
   /**
    * 用户   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer exchangeuserid;
   /**
    * 获得 主键<br />
    * @return exchangeid<br />
    */
   public Integer getExchangeid(){
     return exchangeid;
   }
   
   /**
    * 设置 主键 <br />
    * @param exchangeid
    */
   public void setExchangeid(Integer exchangeid ){
     this.exchangeid=exchangeid;
   }
   /**
    * 获得 会员ID<br />
    * @return exchangememid<br />
    */
   public Integer getExchangememid(){
     return exchangememid;
   }
   
   /**
    * 设置 会员ID <br />
    * @param exchangememid
    */
   public void setExchangememid(Integer exchangememid ){
     this.exchangememid=exchangememid;
   }
   /**
    * 获得 礼品<br />
    * @return exchangegiftid<br />
    */
   public Integer getExchangegiftid(){
     return exchangegiftid;
   }
   
   /**
    * 设置 礼品 <br />
    * @param exchangegiftid
    */
   public void setExchangegiftid(Integer exchangegiftid ){
     this.exchangegiftid=exchangegiftid;
   }
   /**
    * 获得 数量<br />
    * @return exchangenumber<br />
    */
   public Integer getExchangenumber(){
     return exchangenumber;
   }
   
   /**
    * 设置 数量 <br />
    * @param exchangenumber
    */
   public void setExchangenumber(Integer exchangenumber ){
     this.exchangenumber=exchangenumber;
   }
   /**
    * 获得 总积分数<br />
    * @return exchangetotalpoint<br />
    */
   public Integer getExchangetotalpoint(){
     return exchangetotalpoint;
   }
   
   /**
    * 设置 总积分数 <br />
    * @param exchangetotalpoint
    */
   public void setExchangetotalpoint(Integer exchangetotalpoint ){
     this.exchangetotalpoint=exchangetotalpoint;
   }
   /**
    * 获得 店铺<br />
    * @return exchangeshopid<br />
    */
   public Integer getExchangeshopid(){
     return exchangeshopid;
   }
   
   /**
    * 设置 店铺 <br />
    * @param exchangeshopid
    */
   public void setExchangeshopid(Integer exchangeshopid ){
     this.exchangeshopid=exchangeshopid;
   }
   /**
    * 获得 兑换时间<br />
    * @return exchangetime<br />
    */
   public Date getExchangetime(){
     return exchangetime;
   }
   
   /**
    * 设置 兑换时间 <br />
    * @param exchangetime
    */
   public void setExchangetime(Date exchangetime ){
     this.exchangetime=exchangetime;
   }
   /**
    * 获得 用户<br />
    * @return exchangeuserid<br />
    */
   public Integer getExchangeuserid(){
     return exchangeuserid;
   }
   
   /**
    * 设置 用户 <br />
    * @param exchangeuserid
    */
   public void setExchangeuserid(Integer exchangeuserid ){
     this.exchangeuserid=exchangeuserid;
   }
}
