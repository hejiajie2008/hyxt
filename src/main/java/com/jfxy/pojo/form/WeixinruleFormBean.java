package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Weixinrule;
import java.util.Date;

/**
 * 微信规则（回复消息）表 <br />
 * weixinrule<br />
 * @author hejiajie
 * @date 2015-12-22 16:03:24
 */
public class WeixinruleFormBean extends Pagination<Weixinrule>   {
  private static final long serialVersionUID = 1L;
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer ruleid;
   /**
    * 回复序号   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String rulenumber;
   /**
    * 回复类型（text文本/news图文）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String rulenewstype;
   /**
    * 规则描述   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String ruledesc;
   /**
    * 发送内容   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String rulecontent;
   /**
    * 所属用户   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ruleuserid;
   /**
    * 创建时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date rulecreatetime;
   /**
    * 获得 主键<br />
    * @return ruleid<br />
    */
   public Integer getRuleid(){
     return ruleid;
   }
   
   /**
    * 设置 主键 <br />
    * @param ruleid
    */
   public void setRuleid(Integer ruleid ){
     this.ruleid=ruleid;
   }
   /**
    * 获得 回复序号<br />
    * @return rulenumber<br />
    */
   public String getRulenumber(){
     return rulenumber;
   }
   
   /**
    * 设置 回复序号 <br />
    * @param rulenumber
    */
   public void setRulenumber(String rulenumber ){
     this.rulenumber=rulenumber;
   }
   /**
    * 获得 回复类型（text文本/news图文）<br />
    * @return rulenewstype<br />
    */
   public String getRulenewstype(){
     return rulenewstype;
   }
   
   /**
    * 设置 回复类型（text文本/news图文） <br />
    * @param rulenewstype
    */
   public void setRulenewstype(String rulenewstype ){
     this.rulenewstype=rulenewstype;
   }
   /**
    * 获得 规则描述<br />
    * @return ruledesc<br />
    */
   public String getRuledesc(){
     return ruledesc;
   }
   
   /**
    * 设置 规则描述 <br />
    * @param ruledesc
    */
   public void setRuledesc(String ruledesc ){
     this.ruledesc=ruledesc;
   }
   /**
    * 获得 发送内容<br />
    * @return rulecontent<br />
    */
   public String getRulecontent(){
     return rulecontent;
   }
   
   /**
    * 设置 发送内容 <br />
    * @param rulecontent
    */
   public void setRulecontent(String rulecontent ){
     this.rulecontent=rulecontent;
   }
   /**
    * 获得 所属用户<br />
    * @return ruleuserid<br />
    */
   public Integer getRuleuserid(){
     return ruleuserid;
   }
   
   /**
    * 设置 所属用户 <br />
    * @param ruleuserid
    */
   public void setRuleuserid(Integer ruleuserid ){
     this.ruleuserid=ruleuserid;
   }
   /**
    * 获得 创建时间<br />
    * @return rulecreatetime<br />
    */
   public Date getRulecreatetime(){
     return rulecreatetime;
   }
   
   /**
    * 设置 创建时间 <br />
    * @param rulecreatetime
    */
   public void setRulecreatetime(Date rulecreatetime ){
     this.rulecreatetime=rulecreatetime;
   }
}
