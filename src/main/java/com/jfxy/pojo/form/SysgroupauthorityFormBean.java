package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Sysgroupauthority;

/**
 * 系统组受权限表 <br />
 * sysgroupauthority<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class SysgroupauthorityFormBean extends Pagination<Sysgroupauthority>   {
  private static final long serialVersionUID = 1L;
   /**
    * 受权ID   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer gaid;
   /**
    * 组ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer groupid;
   /**
    * 模块ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer moduleid;
   /**
    * 响应ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer actionid;
   /**
    * 响应值   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer actionvalue;
   /**
    * 扩展字段   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer tempc;
   /**
    * 获得 受权ID<br />
    * @return gaid<br />
    */
   public Integer getGaid(){
     return gaid;
   }
   
   /**
    * 设置 受权ID <br />
    * @param gaid
    */
   public void setGaid(Integer gaid ){
     this.gaid=gaid;
   }
   /**
    * 获得 组ID<br />
    * @return groupid<br />
    */
   public Integer getGroupid(){
     return groupid;
   }
   
   /**
    * 设置 组ID <br />
    * @param groupid
    */
   public void setGroupid(Integer groupid ){
     this.groupid=groupid;
   }
   /**
    * 获得 模块ID<br />
    * @return moduleid<br />
    */
   public Integer getModuleid(){
     return moduleid;
   }
   
   /**
    * 设置 模块ID <br />
    * @param moduleid
    */
   public void setModuleid(Integer moduleid ){
     this.moduleid=moduleid;
   }
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
    * 获得 响应值<br />
    * @return actionvalue<br />
    */
   public Integer getActionvalue(){
     return actionvalue;
   }
   
   /**
    * 设置 响应值 <br />
    * @param actionvalue
    */
   public void setActionvalue(Integer actionvalue ){
     this.actionvalue=actionvalue;
   }
   /**
    * 获得 扩展字段<br />
    * @return tempc<br />
    */
   public Integer getTempc(){
     return tempc;
   }
   
   /**
    * 设置 扩展字段 <br />
    * @param tempc
    */
   public void setTempc(Integer tempc ){
     this.tempc=tempc;
   }
}
