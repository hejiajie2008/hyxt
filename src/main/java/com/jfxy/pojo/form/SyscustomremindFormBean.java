package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Syscustomremind;
import java.util.Date;

/**
 * 自定义提醒表 <br />
 * syscustomremind<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class SyscustomremindFormBean extends Pagination<Syscustomremind>   {
  private static final long serialVersionUID = 1L;
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer customremindid;
   /**
    * 提醒标题   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String customremindtitle;
   /**
    * 提醒详情   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String customreminddetail;
   /**
    * 提醒用户   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String customreminder;
   /**
    * 提醒日期   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date customremindtime;
   /**
    * 创建时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date customremindcreatetime;
   /**
    * 所属店铺   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer customremindshopid;
   /**
    * 所属用户   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer customreminduserid;
   /**
    * 获得 主键<br />
    * @return customremindid<br />
    */
   public Integer getCustomremindid(){
     return customremindid;
   }
   
   /**
    * 设置 主键 <br />
    * @param customremindid
    */
   public void setCustomremindid(Integer customremindid ){
     this.customremindid=customremindid;
   }
   /**
    * 获得 提醒标题<br />
    * @return customremindtitle<br />
    */
   public String getCustomremindtitle(){
     return customremindtitle;
   }
   
   /**
    * 设置 提醒标题 <br />
    * @param customremindtitle
    */
   public void setCustomremindtitle(String customremindtitle ){
     this.customremindtitle=customremindtitle;
   }
   /**
    * 获得 提醒详情<br />
    * @return customreminddetail<br />
    */
   public String getCustomreminddetail(){
     return customreminddetail;
   }
   
   /**
    * 设置 提醒详情 <br />
    * @param customreminddetail
    */
   public void setCustomreminddetail(String customreminddetail ){
     this.customreminddetail=customreminddetail;
   }
   /**
    * 获得 提醒用户<br />
    * @return customreminder<br />
    */
   public String getCustomreminder(){
     return customreminder;
   }
   
   /**
    * 设置 提醒用户 <br />
    * @param customreminder
    */
   public void setCustomreminder(String customreminder ){
     this.customreminder=customreminder;
   }
   /**
    * 获得 提醒日期<br />
    * @return customremindtime<br />
    */
   public Date getCustomremindtime(){
     return customremindtime;
   }
   
   /**
    * 设置 提醒日期 <br />
    * @param customremindtime
    */
   public void setCustomremindtime(Date customremindtime ){
     this.customremindtime=customremindtime;
   }
   /**
    * 获得 创建时间<br />
    * @return customremindcreatetime<br />
    */
   public Date getCustomremindcreatetime(){
     return customremindcreatetime;
   }
   
   /**
    * 设置 创建时间 <br />
    * @param customremindcreatetime
    */
   public void setCustomremindcreatetime(Date customremindcreatetime ){
     this.customremindcreatetime=customremindcreatetime;
   }
   /**
    * 获得 所属店铺<br />
    * @return customremindshopid<br />
    */
   public Integer getCustomremindshopid(){
     return customremindshopid;
   }
   
   /**
    * 设置 所属店铺 <br />
    * @param customremindshopid
    */
   public void setCustomremindshopid(Integer customremindshopid ){
     this.customremindshopid=customremindshopid;
   }
   /**
    * 获得 所属用户<br />
    * @return customreminduserid<br />
    */
   public Integer getCustomreminduserid(){
     return customreminduserid;
   }
   
   /**
    * 设置 所属用户 <br />
    * @param customreminduserid
    */
   public void setCustomreminduserid(Integer customreminduserid ){
     this.customreminduserid=customreminduserid;
   }
}
