package com.jfxy.pojo;
/**
 * 系统模块响应 <br />
 * sysmoduleaction<br />
 * @author hejiajie
 * @date 2015-12-03 14:31:34
 */
public class Sysmoduleaction   {
   /**
    * 响应ID   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer actionid;
   /**
    * 响应说明   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String actioncaption;
   /**
    * 响应控制   <br />
    * 允许为空  YES <br />
    * 数据长度 200<br />
    */
   private String actioncontrol;
   /**
    * 响应说明   <br />
    * 允许为空  YES <br />
    * 数据长度 200<br />
    */
   private String actionremark;
   /**
    * 响应模块ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer actionmoduleid;
   /**
    * 获得 响应ID<br />
    * @return actionid<br />
    */
   public Integer getActionid(){
     return actionid;
   }
   
   /**
    * 设置 响应ID <br />
    * @param actionid
    */
   public void setActionid(Integer actionid ){
     this.actionid=actionid;
   }
   /**
    * 获得 响应说明<br />
    * @return actioncaption<br />
    */
   public String getActioncaption(){
     return actioncaption;
   }
   
   /**
    * 设置 响应说明 <br />
    * @param actioncaption
    */
   public void setActioncaption(String actioncaption ){
     this.actioncaption=actioncaption;
   }
   /**
    * 获得 响应控制<br />
    * @return actioncontrol<br />
    */
   public String getActioncontrol(){
     return actioncontrol;
   }
   
   /**
    * 设置 响应控制 <br />
    * @param actioncontrol
    */
   public void setActioncontrol(String actioncontrol ){
     this.actioncontrol=actioncontrol;
   }
   /**
    * 获得 响应说明<br />
    * @return actionremark<br />
    */
   public String getActionremark(){
     return actionremark;
   }
   
   /**
    * 设置 响应说明 <br />
    * @param actionremark
    */
   public void setActionremark(String actionremark ){
     this.actionremark=actionremark;
   }
   /**
    * 获得 响应模块ID<br />
    * @return actionmoduleid<br />
    */
   public Integer getActionmoduleid(){
     return actionmoduleid;
   }
   
   /**
    * 设置 响应模块ID <br />
    * @param actionmoduleid
    */
   public void setActionmoduleid(Integer actionmoduleid ){
     this.actionmoduleid=actionmoduleid;
   }
}
