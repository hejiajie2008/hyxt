package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Pointlog;
import java.util.Date;

/**
 * 积分变动日志表 <br />
 * pointlog<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class PointlogFormBean extends Pagination<Pointlog>   {
  private static final long serialVersionUID = 1L;
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer pointid;
   /**
    * 会员ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer pointmemid;
   /**
    * 积分数量   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer pointnumber;
   /**
    * 类型（4主系统兑换/15消费/1撤消前/2撤消后/6积分变动）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer pointchangetype;
   /**
    * 备注   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String pointremark;
   /**
    * 所属店铺   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer pointshopid;
   /**
    * 创建时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date pointcreatetime;
   /**
    * 用户ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer pointuserid;
   /**
    * 订单编码   <br />
    * 允许为空  YES <br />
    * 数据长度 40<br />
    */
   private String pointordercode;
   /**
    * 积分会员ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer pointgivememid;
   /**
    * 获得 主键<br />
    * @return pointid<br />
    */
   public Integer getPointid(){
     return pointid;
   }
   
   /**
    * 设置 主键 <br />
    * @param pointid
    */
   public void setPointid(Integer pointid ){
     this.pointid=pointid;
   }
   /**
    * 获得 会员ID<br />
    * @return pointmemid<br />
    */
   public Integer getPointmemid(){
     return pointmemid;
   }
   
   /**
    * 设置 会员ID <br />
    * @param pointmemid
    */
   public void setPointmemid(Integer pointmemid ){
     this.pointmemid=pointmemid;
   }
   /**
    * 获得 积分数量<br />
    * @return pointnumber<br />
    */
   public Integer getPointnumber(){
     return pointnumber;
   }
   
   /**
    * 设置 积分数量 <br />
    * @param pointnumber
    */
   public void setPointnumber(Integer pointnumber ){
     this.pointnumber=pointnumber;
   }
   /**
    * 获得 类型（4主系统兑换/15消费/1撤消前/2撤消后/6积分变动）<br />
    * @return pointchangetype<br />
    */
   public Integer getPointchangetype(){
     return pointchangetype;
   }
   
   /**
    * 设置 类型（4主系统兑换/15消费/1撤消前/2撤消后/6积分变动） <br />
    * @param pointchangetype
    */
   public void setPointchangetype(Integer pointchangetype ){
     this.pointchangetype=pointchangetype;
   }
   /**
    * 获得 备注<br />
    * @return pointremark<br />
    */
   public String getPointremark(){
     return pointremark;
   }
   
   /**
    * 设置 备注 <br />
    * @param pointremark
    */
   public void setPointremark(String pointremark ){
     this.pointremark=pointremark;
   }
   /**
    * 获得 所属店铺<br />
    * @return pointshopid<br />
    */
   public Integer getPointshopid(){
     return pointshopid;
   }
   
   /**
    * 设置 所属店铺 <br />
    * @param pointshopid
    */
   public void setPointshopid(Integer pointshopid ){
     this.pointshopid=pointshopid;
   }
   /**
    * 获得 创建时间<br />
    * @return pointcreatetime<br />
    */
   public Date getPointcreatetime(){
     return pointcreatetime;
   }
   
   /**
    * 设置 创建时间 <br />
    * @param pointcreatetime
    */
   public void setPointcreatetime(Date pointcreatetime ){
     this.pointcreatetime=pointcreatetime;
   }
   /**
    * 获得 用户ID<br />
    * @return pointuserid<br />
    */
   public Integer getPointuserid(){
     return pointuserid;
   }
   
   /**
    * 设置 用户ID <br />
    * @param pointuserid
    */
   public void setPointuserid(Integer pointuserid ){
     this.pointuserid=pointuserid;
   }
   /**
    * 获得 订单编码<br />
    * @return pointordercode<br />
    */
   public String getPointordercode(){
     return pointordercode;
   }
   
   /**
    * 设置 订单编码 <br />
    * @param pointordercode
    */
   public void setPointordercode(String pointordercode ){
     this.pointordercode=pointordercode;
   }
   /**
    * 获得 积分会员ID<br />
    * @return pointgivememid<br />
    */
   public Integer getPointgivememid(){
     return pointgivememid;
   }
   
   /**
    * 设置 积分会员ID <br />
    * @param pointgivememid
    */
   public void setPointgivememid(Integer pointgivememid ){
     this.pointgivememid=pointgivememid;
   }
}
