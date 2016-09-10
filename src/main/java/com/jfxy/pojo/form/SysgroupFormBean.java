package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Sysgroup;

/**
 * 系统组（角色）表 <br />
 * sysgroup<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class SysgroupFormBean extends Pagination<Sysgroup>   {
  private static final long serialVersionUID = 1L;
   /**
    * 组ID   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer groupid;
   /**
    * 用户组名称   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String groupname;
   /**
    * 用户组备注   <br />
    * 允许为空  YES <br />
    * 数据长度 200<br />
    */
   private String groupremark;
   /**
    * 父节点组ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer parentgroupid;
   /**
    * 父节点组所有ID   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String parentidstr;
   /**
    * 是否是公共的   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ispublic;
   /**
    * 用创建用户ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer createuserid;
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
    * 获得 用户组名称<br />
    * @return groupname<br />
    */
   public String getGroupname(){
     return groupname;
   }
   
   /**
    * 设置 用户组名称 <br />
    * @param groupname
    */
   public void setGroupname(String groupname ){
     this.groupname=groupname;
   }
   /**
    * 获得 用户组备注<br />
    * @return groupremark<br />
    */
   public String getGroupremark(){
     return groupremark;
   }
   
   /**
    * 设置 用户组备注 <br />
    * @param groupremark
    */
   public void setGroupremark(String groupremark ){
     this.groupremark=groupremark;
   }
   /**
    * 获得 父节点组ID<br />
    * @return parentgroupid<br />
    */
   public Integer getParentgroupid(){
     return parentgroupid;
   }
   
   /**
    * 设置 父节点组ID <br />
    * @param parentgroupid
    */
   public void setParentgroupid(Integer parentgroupid ){
     this.parentgroupid=parentgroupid;
   }
   /**
    * 获得 父节点组所有ID<br />
    * @return parentidstr<br />
    */
   public String getParentidstr(){
     return parentidstr;
   }
   
   /**
    * 设置 父节点组所有ID <br />
    * @param parentidstr
    */
   public void setParentidstr(String parentidstr ){
     this.parentidstr=parentidstr;
   }
   /**
    * 获得 是否是公共的<br />
    * @return ispublic<br />
    */
   public Integer getIspublic(){
     return ispublic;
   }
   
   /**
    * 设置 是否是公共的 <br />
    * @param ispublic
    */
   public void setIspublic(Integer ispublic ){
     this.ispublic=ispublic;
   }
   /**
    * 获得 用创建用户ID<br />
    * @return createuserid<br />
    */
   public Integer getCreateuserid(){
     return createuserid;
   }
   
   /**
    * 设置 用创建用户ID <br />
    * @param createuserid
    */
   public void setCreateuserid(Integer createuserid ){
     this.createuserid=createuserid;
   }
}
