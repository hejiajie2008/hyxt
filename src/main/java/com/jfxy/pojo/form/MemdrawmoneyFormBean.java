package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Memdrawmoney;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员提现表 <br />
 * memdrawmoney<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class MemdrawmoneyFormBean extends Pagination<Memdrawmoney>   {
  private static final long serialVersionUID = 1L;
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer drawmoneyid;
   /**
    * 会员ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer drawmoneymemid;
   /**
    * 提现订单号   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String drawmoneyaccount;
   /**
    * 提现金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal drawmoney;
   /**
    * 实际扣除金额   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal drawactualmoney;
   /**
    * 备注   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String drawmoneyremark;
   /**
    * 所属店铺   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer drawmoneyshopid;
   /**
    * 所属用户   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer drawmoneyuserid;
   /**
    * 创建时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date drawmoneycreatetime;
   /**
    * 获得 主键<br />
    * @return drawmoneyid<br />
    */
   public Integer getDrawmoneyid(){
     return drawmoneyid;
   }
   
   /**
    * 设置 主键 <br />
    * @param drawmoneyid
    */
   public void setDrawmoneyid(Integer drawmoneyid ){
     this.drawmoneyid=drawmoneyid;
   }
   /**
    * 获得 会员ID<br />
    * @return drawmoneymemid<br />
    */
   public Integer getDrawmoneymemid(){
     return drawmoneymemid;
   }
   
   /**
    * 设置 会员ID <br />
    * @param drawmoneymemid
    */
   public void setDrawmoneymemid(Integer drawmoneymemid ){
     this.drawmoneymemid=drawmoneymemid;
   }
   /**
    * 获得 提现订单号<br />
    * @return drawmoneyaccount<br />
    */
   public String getDrawmoneyaccount(){
     return drawmoneyaccount;
   }
   
   /**
    * 设置 提现订单号 <br />
    * @param drawmoneyaccount
    */
   public void setDrawmoneyaccount(String drawmoneyaccount ){
     this.drawmoneyaccount=drawmoneyaccount;
   }
   /**
    * 获得 提现金额<br />
    * @return drawmoney<br />
    */
   public BigDecimal getDrawmoney(){
     return drawmoney;
   }
   
   /**
    * 设置 提现金额 <br />
    * @param drawmoney
    */
   public void setDrawmoney(BigDecimal drawmoney ){
     this.drawmoney=drawmoney;
   }
   /**
    * 获得 实际扣除金额<br />
    * @return drawactualmoney<br />
    */
   public BigDecimal getDrawactualmoney(){
     return drawactualmoney;
   }
   
   /**
    * 设置 实际扣除金额 <br />
    * @param drawactualmoney
    */
   public void setDrawactualmoney(BigDecimal drawactualmoney ){
     this.drawactualmoney=drawactualmoney;
   }
   /**
    * 获得 备注<br />
    * @return drawmoneyremark<br />
    */
   public String getDrawmoneyremark(){
     return drawmoneyremark;
   }
   
   /**
    * 设置 备注 <br />
    * @param drawmoneyremark
    */
   public void setDrawmoneyremark(String drawmoneyremark ){
     this.drawmoneyremark=drawmoneyremark;
   }
   /**
    * 获得 所属店铺<br />
    * @return drawmoneyshopid<br />
    */
   public Integer getDrawmoneyshopid(){
     return drawmoneyshopid;
   }
   
   /**
    * 设置 所属店铺 <br />
    * @param drawmoneyshopid
    */
   public void setDrawmoneyshopid(Integer drawmoneyshopid ){
     this.drawmoneyshopid=drawmoneyshopid;
   }
   /**
    * 获得 所属用户<br />
    * @return drawmoneyuserid<br />
    */
   public Integer getDrawmoneyuserid(){
     return drawmoneyuserid;
   }
   
   /**
    * 设置 所属用户 <br />
    * @param drawmoneyuserid
    */
   public void setDrawmoneyuserid(Integer drawmoneyuserid ){
     this.drawmoneyuserid=drawmoneyuserid;
   }
   /**
    * 获得 创建时间<br />
    * @return drawmoneycreatetime<br />
    */
   public Date getDrawmoneycreatetime(){
     return drawmoneycreatetime;
   }
   
   /**
    * 设置 创建时间 <br />
    * @param drawmoneycreatetime
    */
   public void setDrawmoneycreatetime(Date drawmoneycreatetime ){
     this.drawmoneycreatetime=drawmoneycreatetime;
   }
}
