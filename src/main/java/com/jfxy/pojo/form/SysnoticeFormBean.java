package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Sysnotice;
import java.util.Date;

/**
 * 系统公告表 <br />
 * sysnotice<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class SysnoticeFormBean extends Pagination<Sysnotice>   {
  private static final long serialVersionUID = 1L;
   /**
    * 系统通知ID   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer sysnoticeid;
   /**
    * 系统通知代码   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String sysnoticecode;
   /**
    * 系统通知名称   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String sysnotiecename;
   /**
    * 系统通知标题   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String sysnoticetitle;
   /**
    * 系统通知明细   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String sysnoticedetail;
   /**
    * 系统通知名称   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date sysnoticetime;
   /**
    * 获得 系统通知ID<br />
    * @return sysnoticeid<br />
    */
   public Integer getSysnoticeid(){
     return sysnoticeid;
   }
   
   /**
    * 设置 系统通知ID <br />
    * @param sysnoticeid
    */
   public void setSysnoticeid(Integer sysnoticeid ){
     this.sysnoticeid=sysnoticeid;
   }
   /**
    * 获得 系统通知代码<br />
    * @return sysnoticecode<br />
    */
   public String getSysnoticecode(){
     return sysnoticecode;
   }
   
   /**
    * 设置 系统通知代码 <br />
    * @param sysnoticecode
    */
   public void setSysnoticecode(String sysnoticecode ){
     this.sysnoticecode=sysnoticecode;
   }
   /**
    * 获得 系统通知名称<br />
    * @return sysnotiecename<br />
    */
   public String getSysnotiecename(){
     return sysnotiecename;
   }
   
   /**
    * 设置 系统通知名称 <br />
    * @param sysnotiecename
    */
   public void setSysnotiecename(String sysnotiecename ){
     this.sysnotiecename=sysnotiecename;
   }
   /**
    * 获得 系统通知标题<br />
    * @return sysnoticetitle<br />
    */
   public String getSysnoticetitle(){
     return sysnoticetitle;
   }
   
   /**
    * 设置 系统通知标题 <br />
    * @param sysnoticetitle
    */
   public void setSysnoticetitle(String sysnoticetitle ){
     this.sysnoticetitle=sysnoticetitle;
   }
   /**
    * 获得 系统通知明细<br />
    * @return sysnoticedetail<br />
    */
   public String getSysnoticedetail(){
     return sysnoticedetail;
   }
   
   /**
    * 设置 系统通知明细 <br />
    * @param sysnoticedetail
    */
   public void setSysnoticedetail(String sysnoticedetail ){
     this.sysnoticedetail=sysnoticedetail;
   }
   /**
    * 获得 系统通知名称<br />
    * @return sysnoticetime<br />
    */
   public Date getSysnoticetime(){
     return sysnoticetime;
   }
   
   /**
    * 设置 系统通知名称 <br />
    * @param sysnoticetime
    */
   public void setSysnoticetime(Date sysnoticetime ){
     this.sysnoticetime=sysnoticetime;
   }
}
