package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Timingrules;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 计时规则表 <br />
 * timingrules<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class TimingrulesFormBean extends Pagination<Timingrules>   {
  private static final long serialVersionUID = 1L;
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer rulesid;
   /**
    * 规则名称   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String rulesname;
   /**
    * 单位计时规则   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer rulesinterval;
   /**
    * 单价   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal rulesunitprice;
   /**
    * 不足单位计费   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer rulesexceedtime;
   /**
    * 添加时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date rulesaddtime;
   /**
    * 所属店铺   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer rulesshopid;
   /**
    * 所属用户   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer rulesuserid;
   /**
    * 备注   <br />
    * 允许为空  YES <br />
    * 数据长度 200<br />
    */
   private String rulesremark;
   /**
    * 获得 主键<br />
    * @return rulesid<br />
    */
   public Integer getRulesid(){
     return rulesid;
   }
   
   /**
    * 设置 主键 <br />
    * @param rulesid
    */
   public void setRulesid(Integer rulesid ){
     this.rulesid=rulesid;
   }
   /**
    * 获得 规则名称<br />
    * @return rulesname<br />
    */
   public String getRulesname(){
     return rulesname;
   }
   
   /**
    * 设置 规则名称 <br />
    * @param rulesname
    */
   public void setRulesname(String rulesname ){
     this.rulesname=rulesname;
   }
   /**
    * 获得 单位计时规则<br />
    * @return rulesinterval<br />
    */
   public Integer getRulesinterval(){
     return rulesinterval;
   }
   
   /**
    * 设置 单位计时规则 <br />
    * @param rulesinterval
    */
   public void setRulesinterval(Integer rulesinterval ){
     this.rulesinterval=rulesinterval;
   }
   /**
    * 获得 单价<br />
    * @return rulesunitprice<br />
    */
   public BigDecimal getRulesunitprice(){
     return rulesunitprice;
   }
   
   /**
    * 设置 单价 <br />
    * @param rulesunitprice
    */
   public void setRulesunitprice(BigDecimal rulesunitprice ){
     this.rulesunitprice=rulesunitprice;
   }
   /**
    * 获得 不足单位计费<br />
    * @return rulesexceedtime<br />
    */
   public Integer getRulesexceedtime(){
     return rulesexceedtime;
   }
   
   /**
    * 设置 不足单位计费 <br />
    * @param rulesexceedtime
    */
   public void setRulesexceedtime(Integer rulesexceedtime ){
     this.rulesexceedtime=rulesexceedtime;
   }
   /**
    * 获得 添加时间<br />
    * @return rulesaddtime<br />
    */
   public Date getRulesaddtime(){
     return rulesaddtime;
   }
   
   /**
    * 设置 添加时间 <br />
    * @param rulesaddtime
    */
   public void setRulesaddtime(Date rulesaddtime ){
     this.rulesaddtime=rulesaddtime;
   }
   /**
    * 获得 所属店铺<br />
    * @return rulesshopid<br />
    */
   public Integer getRulesshopid(){
     return rulesshopid;
   }
   
   /**
    * 设置 所属店铺 <br />
    * @param rulesshopid
    */
   public void setRulesshopid(Integer rulesshopid ){
     this.rulesshopid=rulesshopid;
   }
   /**
    * 获得 所属用户<br />
    * @return rulesuserid<br />
    */
   public Integer getRulesuserid(){
     return rulesuserid;
   }
   
   /**
    * 设置 所属用户 <br />
    * @param rulesuserid
    */
   public void setRulesuserid(Integer rulesuserid ){
     this.rulesuserid=rulesuserid;
   }
   /**
    * 获得 备注<br />
    * @return rulesremark<br />
    */
   public String getRulesremark(){
     return rulesremark;
   }
   
   /**
    * 设置 备注 <br />
    * @param rulesremark
    */
   public void setRulesremark(String rulesremark ){
     this.rulesremark=rulesremark;
   }
}
