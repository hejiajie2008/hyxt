package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Memlevel;

/**
 * 会员级别 <br />
 * memlevel<br />
 * @author hejiajie
 * @date 2015-12-03 14:13:11
 */
public class MemlevelFormBean extends Pagination<Memlevel>   {
  private static final long serialVersionUID = 1L;
   /**
    * 级别ID   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer levelid;
   /**
    * 级别名称   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String levelname;
   /**
    * 积分   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer levelpoint;
   /**
    * 折扣率   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Double leveldiscountpercent;
   /**
    * 积分率   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Double levelpointpercent;
   /**
    * 级别锁定   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer levelllock;
   /**
    * 兑换积分率   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer levelrechargepointrate;
   /**
    * 获得 级别ID<br />
    * @return levelid<br />
    */
   public Integer getLevelid(){
     return levelid;
   }
   
   /**
    * 设置 级别ID <br />
    * @param levelid
    */
   public void setLevelid(Integer levelid ){
     this.levelid=levelid;
   }
   /**
    * 获得 级别名称<br />
    * @return levelname<br />
    */
   public String getLevelname(){
     return levelname;
   }
   
   /**
    * 设置 级别名称 <br />
    * @param levelname
    */
   public void setLevelname(String levelname ){
     this.levelname=levelname;
   }
   /**
    * 获得 积分<br />
    * @return levelpoint<br />
    */
   public Integer getLevelpoint(){
     return levelpoint;
   }
   
   /**
    * 设置 积分 <br />
    * @param levelpoint
    */
   public void setLevelpoint(Integer levelpoint ){
     this.levelpoint=levelpoint;
   }
   /**
    * 获得 折扣率<br />
    * @return leveldiscountpercent<br />
    */
   public Double getLeveldiscountpercent(){
     return leveldiscountpercent;
   }
   
   /**
    * 设置 折扣率 <br />
    * @param leveldiscountpercent
    */
   public void setLeveldiscountpercent(Double leveldiscountpercent ){
     this.leveldiscountpercent=leveldiscountpercent;
   }
   /**
    * 获得 积分率<br />
    * @return levelpointpercent<br />
    */
   public Double getLevelpointpercent(){
     return levelpointpercent;
   }
   
   /**
    * 设置 积分率 <br />
    * @param levelpointpercent
    */
   public void setLevelpointpercent(Double levelpointpercent ){
     this.levelpointpercent=levelpointpercent;
   }
   /**
    * 获得 级别锁定<br />
    * @return levelllock<br />
    */
   public Integer getLevelllock(){
     return levelllock;
   }
   
   /**
    * 设置 级别锁定 <br />
    * @param levelllock
    */
   public void setLevelllock(Integer levelllock ){
     this.levelllock=levelllock;
   }
   /**
    * 获得 兑换积分率<br />
    * @return levelrechargepointrate<br />
    */
   public Integer getLevelrechargepointrate(){
     return levelrechargepointrate;
   }
   
   /**
    * 设置 兑换积分率 <br />
    * @param levelrechargepointrate
    */
   public void setLevelrechargepointrate(Integer levelrechargepointrate ){
     this.levelrechargepointrate=levelrechargepointrate;
   }
}
