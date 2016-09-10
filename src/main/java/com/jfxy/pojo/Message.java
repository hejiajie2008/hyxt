package com.jfxy.pojo;
 
import java.util.Date;
 

/**
 * 留言管理表 <br />
 * message<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Message   {
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer messageid;
   /**
    * 会员ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer messagememid;
   /**
    * 内容   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String messagecontent;
   /**
    * 留言时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date messagetime;
   /**
    * 是否为回复   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer messageisreply;
   /**
    * 回复内容   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String messagereplycontent;
   /**
    * 回复时间   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Date messagereplytime;
   /**
    * 回复用户ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer messagereplyuserid;
   
   private Integer memcard;
   
   private String memname;
   
   private String memmobile;
   
   /**
    * 获得 主键<br />
    * @return messageid<br />
    */
   public Integer getMessageid(){
     return messageid;
   }
   
   /**
    * 设置 主键 <br />
    * @param messageid
    */
   public void setMessageid(Integer messageid ){
     this.messageid=messageid;
   }
   /**
    * 获得 会员ID<br />
    * @return messagememid<br />
    */
   public Integer getMessagememid(){
     return messagememid;
   }
   
   /**
    * 设置 会员ID <br />
    * @param messagememid
    */
   public void setMessagememid(Integer messagememid ){
     this.messagememid=messagememid;
   }
   /**
    * 获得 内容<br />
    * @return messagecontent<br />
    */
   public String getMessagecontent(){
     return messagecontent;
   }
   
   /**
    * 设置 内容 <br />
    * @param messagecontent
    */
   public void setMessagecontent(String messagecontent ){
     this.messagecontent=messagecontent;
   }
   /**
    * 获得 留言时间<br />
    * @return messagetime<br />
    */
   public Date getMessagetime(){
     return messagetime;
   }
   
   /**
    * 设置 留言时间 <br />
    * @param messagetime
    */
   public void setMessagetime(Date messagetime ){
     this.messagetime=messagetime;
   }
   /**
    * 获得 是否为回复<br />
    * @return messageisreply<br />
    */
   public Integer getMessageisreply(){
     return messageisreply;
   }
   
   /**
    * 设置 是否为回复 <br />
    * @param messageisreply
    */
   public void setMessageisreply(Integer messageisreply ){
     this.messageisreply=messageisreply;
   }
   /**
    * 获得 回复内容<br />
    * @return messagereplycontent<br />
    */
   public String getMessagereplycontent(){
     return messagereplycontent;
   }
   
   /**
    * 设置 回复内容 <br />
    * @param messagereplycontent
    */
   public void setMessagereplycontent(String messagereplycontent ){
     this.messagereplycontent=messagereplycontent;
   }
   /**
    * 获得 回复时间<br />
    * @return messagereplytime<br />
    */
   public Date getMessagereplytime(){
     return messagereplytime;
   }
   
   /**
    * 设置 回复时间 <br />
    * @param messagereplytime
    */
   public void setMessagereplytime(Date messagereplytime ){
     this.messagereplytime=messagereplytime;
   }
   /**
    * 获得 回复用户ID<br />
    * @return messagereplyuserid<br />
    */
   public Integer getMessagereplyuserid(){
     return messagereplyuserid;
   }
   
   /**
    * 设置 回复用户ID <br />
    * @param messagereplyuserid
    */
   public void setMessagereplyuserid(Integer messagereplyuserid ){
     this.messagereplyuserid=messagereplyuserid;
   }

public Integer getMemcard() {
	return memcard;
}

public void setMemcard(Integer memcard) {
	this.memcard = memcard;
}

public String getMemname() {
	return memname;
}

public void setMemname(String memname) {
	this.memname = memname;
}

public String getMemmobile() {
	return memmobile;
}

public void setMemmobile(String memmobile) {
	this.memmobile = memmobile;
}
   
   
}
