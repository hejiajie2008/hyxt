package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Weixinnews;
import java.util.Date;

/**
 * 微信新闻 <br />
 * weixinnews<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class WeixinnewsFormBean extends Pagination<Weixinnews>   {
  private static final long serialVersionUID = 1L;
   /**
    * 微信新闻ID   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer newsid;
   /**
    * 微信新闻规则ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer newsruleid;
   /**
    * 图文标题   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String newstitle;
   /**
    * 图文描述   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String newsdesc;
   /**
    * 新闻第一URL   <br />
    * 允许为空  YES <br />
    * 数据长度 200<br />
    */
   private String newsurlfirst;
   /**
    * 新闻第二URL   <br />
    * 允许为空  YES <br />
    * 数据长度 200<br />
    */
   private String newsurlsecond;
   /**
    * 新闻内容   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private String newslinkcontent;
   /**
    * 新闻创建时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date newscreatetime;
   /**
    * 获得 微信新闻ID<br />
    * @return newsid<br />
    */
   public Integer getNewsid(){
     return newsid;
   }
   
   /**
    * 设置 微信新闻ID <br />
    * @param newsid
    */
   public void setNewsid(Integer newsid ){
     this.newsid=newsid;
   }
   /**
    * 获得 微信新闻规则ID<br />
    * @return newsruleid<br />
    */
   public Integer getNewsruleid(){
     return newsruleid;
   }
   
   /**
    * 设置 微信新闻规则ID <br />
    * @param newsruleid
    */
   public void setNewsruleid(Integer newsruleid ){
     this.newsruleid=newsruleid;
   }
   /**
    * 获得 图文标题<br />
    * @return newstitle<br />
    */
   public String getNewstitle(){
     return newstitle;
   }
   
   /**
    * 设置 图文标题 <br />
    * @param newstitle
    */
   public void setNewstitle(String newstitle ){
     this.newstitle=newstitle;
   }
   /**
    * 获得 图文描述<br />
    * @return newsdesc<br />
    */
   public String getNewsdesc(){
     return newsdesc;
   }
   
   /**
    * 设置 图文描述 <br />
    * @param newsdesc
    */
   public void setNewsdesc(String newsdesc ){
     this.newsdesc=newsdesc;
   }
   /**
    * 获得 新闻第一URL<br />
    * @return newsurlfirst<br />
    */
   public String getNewsurlfirst(){
     return newsurlfirst;
   }
   
   /**
    * 设置 新闻第一URL <br />
    * @param newsurlfirst
    */
   public void setNewsurlfirst(String newsurlfirst ){
     this.newsurlfirst=newsurlfirst;
   }
   /**
    * 获得 新闻第二URL<br />
    * @return newsurlsecond<br />
    */
   public String getNewsurlsecond(){
     return newsurlsecond;
   }
   
   /**
    * 设置 新闻第二URL <br />
    * @param newsurlsecond
    */
   public void setNewsurlsecond(String newsurlsecond ){
     this.newsurlsecond=newsurlsecond;
   }
   /**
    * 获得 新闻内容<br />
    * @return newslinkcontent<br />
    */
   public String getNewslinkcontent(){
     return newslinkcontent;
   }
   
   /**
    * 设置 新闻内容 <br />
    * @param newslinkcontent
    */
   public void setNewslinkcontent(String newslinkcontent ){
     this.newslinkcontent=newslinkcontent;
   }
   /**
    * 获得 新闻创建时间<br />
    * @return newscreatetime<br />
    */
   public Date getNewscreatetime(){
     return newscreatetime;
   }
   
   /**
    * 设置 新闻创建时间 <br />
    * @param newscreatetime
    */
   public void setNewscreatetime(Date newscreatetime ){
     this.newscreatetime=newscreatetime;
   }
}
