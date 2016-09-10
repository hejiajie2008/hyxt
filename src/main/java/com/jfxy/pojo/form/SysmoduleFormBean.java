package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Sysmodule;

/**
 * 系统模块 <br />
 * sysmodule<br />
 * @author hejiajie
 * @date 2015-12-03 14:31:34
 */
public class SysmoduleFormBean extends Pagination<Sysmodule>   {
  private static final long serialVersionUID = 1L;
   /**
    * 模块ID   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer moduleid;
   /**
    * 模块说明文字   <br />
    * 允许为空  YES <br />
    * 数据长度 200<br />
    */
   private String modulecaption;
   /**
    * 模块链接地址   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String modulelink;
   /**
    * 父模块ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer moduleparentid;
   /**
    * 模块序号   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer moduleorder;
   /**
    * 模块是否可见   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer modulevisible;
   /**
    * 模块ico图片地址   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String moduleicopath;
   /**
    * 模块备注   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String moduleremark;
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
    * 获得 模块说明文字<br />
    * @return modulecaption<br />
    */
   public String getModulecaption(){
     return modulecaption;
   }
   
   /**
    * 设置 模块说明文字 <br />
    * @param modulecaption
    */
   public void setModulecaption(String modulecaption ){
     this.modulecaption=modulecaption;
   }
   /**
    * 获得 模块链接地址<br />
    * @return modulelink<br />
    */
   public String getModulelink(){
     return modulelink;
   }
   
   /**
    * 设置 模块链接地址 <br />
    * @param modulelink
    */
   public void setModulelink(String modulelink ){
     this.modulelink=modulelink;
   }
   /**
    * 获得 父模块ID<br />
    * @return moduleparentid<br />
    */
   public Integer getModuleparentid(){
     return moduleparentid;
   }
   
   /**
    * 设置 父模块ID <br />
    * @param moduleparentid
    */
   public void setModuleparentid(Integer moduleparentid ){
     this.moduleparentid=moduleparentid;
   }
   /**
    * 获得 模块序号<br />
    * @return moduleorder<br />
    */
   public Integer getModuleorder(){
     return moduleorder;
   }
   
   /**
    * 设置 模块序号 <br />
    * @param moduleorder
    */
   public void setModuleorder(Integer moduleorder ){
     this.moduleorder=moduleorder;
   }
   /**
    * 获得 模块是否可见<br />
    * @return modulevisible<br />
    */
   public Integer getModulevisible(){
     return modulevisible;
   }
   
   /**
    * 设置 模块是否可见 <br />
    * @param modulevisible
    */
   public void setModulevisible(Integer modulevisible ){
     this.modulevisible=modulevisible;
   }
   /**
    * 获得 模块ico图片地址<br />
    * @return moduleicopath<br />
    */
   public String getModuleicopath(){
     return moduleicopath;
   }
   
   /**
    * 设置 模块ico图片地址 <br />
    * @param moduleicopath
    */
   public void setModuleicopath(String moduleicopath ){
     this.moduleicopath=moduleicopath;
   }
   /**
    * 获得 模块备注<br />
    * @return moduleremark<br />
    */
   public String getModuleremark(){
     return moduleremark;
   }
   
   /**
    * 设置 模块备注 <br />
    * @param moduleremark
    */
   public void setModuleremark(String moduleremark ){
     this.moduleremark=moduleremark;
   }
}
