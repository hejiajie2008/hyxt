package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Memcustomfield;
import java.util.Date;

/**
 * 会员自定义字段表 <br />
 * memcustomfield<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class MemcustomfieldFormBean extends Pagination<Memcustomfield>   {
  private static final long serialVersionUID = 1L;
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer customfieldid;
   /**
    * 类型   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer customtype;
   /**
    * 字段   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String customfield;
   /**
    * 字段名称   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String customfieldname;
   /**
    * 是否为空   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer customfieldisnull;
   /**
    * 是否显示   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer customfieldisshow;
   /**
    * 字段类型   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String customfieldtype;
   /**
    * 字段明细   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String customfieldinfo;
   /**
    * 所以店铺   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer customfieldshopid;
   /**
    * 创建时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date customfieldcreatetime;
   /**
    * 用户ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer customfielduserid;
   /**
    * 获得 主键<br />
    * @return customfieldid<br />
    */
   public Integer getCustomfieldid(){
     return customfieldid;
   }
   
   /**
    * 设置 主键 <br />
    * @param customfieldid
    */
   public void setCustomfieldid(Integer customfieldid ){
     this.customfieldid=customfieldid;
   }
   /**
    * 获得 类型<br />
    * @return customtype<br />
    */
   public Integer getCustomtype(){
     return customtype;
   }
   
   /**
    * 设置 类型 <br />
    * @param customtype
    */
   public void setCustomtype(Integer customtype ){
     this.customtype=customtype;
   }
   /**
    * 获得 字段<br />
    * @return customfield<br />
    */
   public String getCustomfield(){
     return customfield;
   }
   
   /**
    * 设置 字段 <br />
    * @param customfield
    */
   public void setCustomfield(String customfield ){
     this.customfield=customfield;
   }
   /**
    * 获得 字段名称<br />
    * @return customfieldname<br />
    */
   public String getCustomfieldname(){
     return customfieldname;
   }
   
   /**
    * 设置 字段名称 <br />
    * @param customfieldname
    */
   public void setCustomfieldname(String customfieldname ){
     this.customfieldname=customfieldname;
   }
   /**
    * 获得 是否为空<br />
    * @return customfieldisnull<br />
    */
   public Integer getCustomfieldisnull(){
     return customfieldisnull;
   }
   
   /**
    * 设置 是否为空 <br />
    * @param customfieldisnull
    */
   public void setCustomfieldisnull(Integer customfieldisnull ){
     this.customfieldisnull=customfieldisnull;
   }
   /**
    * 获得 是否显示<br />
    * @return customfieldisshow<br />
    */
   public Integer getCustomfieldisshow(){
     return customfieldisshow;
   }
   
   /**
    * 设置 是否显示 <br />
    * @param customfieldisshow
    */
   public void setCustomfieldisshow(Integer customfieldisshow ){
     this.customfieldisshow=customfieldisshow;
   }
   /**
    * 获得 字段类型<br />
    * @return customfieldtype<br />
    */
   public String getCustomfieldtype(){
     return customfieldtype;
   }
   
   /**
    * 设置 字段类型 <br />
    * @param customfieldtype
    */
   public void setCustomfieldtype(String customfieldtype ){
     this.customfieldtype=customfieldtype;
   }
   /**
    * 获得 字段明细<br />
    * @return customfieldinfo<br />
    */
   public String getCustomfieldinfo(){
     return customfieldinfo;
   }
   
   /**
    * 设置 字段明细 <br />
    * @param customfieldinfo
    */
   public void setCustomfieldinfo(String customfieldinfo ){
     this.customfieldinfo=customfieldinfo;
   }
   /**
    * 获得 所以店铺<br />
    * @return customfieldshopid<br />
    */
   public Integer getCustomfieldshopid(){
     return customfieldshopid;
   }
   
   /**
    * 设置 所以店铺 <br />
    * @param customfieldshopid
    */
   public void setCustomfieldshopid(Integer customfieldshopid ){
     this.customfieldshopid=customfieldshopid;
   }
   /**
    * 获得 创建时间<br />
    * @return customfieldcreatetime<br />
    */
   public Date getCustomfieldcreatetime(){
     return customfieldcreatetime;
   }
   
   /**
    * 设置 创建时间 <br />
    * @param customfieldcreatetime
    */
   public void setCustomfieldcreatetime(Date customfieldcreatetime ){
     this.customfieldcreatetime=customfieldcreatetime;
   }
   /**
    * 获得 用户ID<br />
    * @return customfielduserid<br />
    */
   public Integer getCustomfielduserid(){
     return customfielduserid;
   }
   
   /**
    * 设置 用户ID <br />
    * @param customfielduserid
    */
   public void setCustomfielduserid(Integer customfielduserid ){
     this.customfielduserid=customfielduserid;
   }
}
