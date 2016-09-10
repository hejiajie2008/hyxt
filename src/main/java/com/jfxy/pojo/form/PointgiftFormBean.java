package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Pointgift;

/**
 * 积分礼品表 <br />
 * pointgift<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class PointgiftFormBean extends Pagination<Pointgift>   {
  private static final long serialVersionUID = 1L;
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer giftid;
   /**
    * 礼品名称   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String giftname;
   /**
    * 礼品简码   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String giftcode;
   /**
    * 礼品类型   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer giftclassid;
   /**
    * 礼品分类   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String giftphoto;
   /**
    * 兑换礼品所需积分   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer giftexchangepoint;
   /**
    * 礼品库存数量   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer giftstocknumber;
   /**
    * 礼品兑换数量   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer giftexchangenumber;
   /**
    * 所属店铺   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer giftshopid;
   /**
    * 备注   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String giftremark;
   /**
    * 获得 主键<br />
    * @return giftid<br />
    */
   public Integer getGiftid(){
     return giftid;
   }
   
   /**
    * 设置 主键 <br />
    * @param giftid
    */
   public void setGiftid(Integer giftid ){
     this.giftid=giftid;
   }
   /**
    * 获得 礼品名称<br />
    * @return giftname<br />
    */
   public String getGiftname(){
     return giftname;
   }
   
   /**
    * 设置 礼品名称 <br />
    * @param giftname
    */
   public void setGiftname(String giftname ){
     this.giftname=giftname;
   }
   /**
    * 获得 礼品简码<br />
    * @return giftcode<br />
    */
   public String getGiftcode(){
     return giftcode;
   }
   
   /**
    * 设置 礼品简码 <br />
    * @param giftcode
    */
   public void setGiftcode(String giftcode ){
     this.giftcode=giftcode;
   }
   /**
    * 获得 礼品类型<br />
    * @return giftclassid<br />
    */
   public Integer getGiftclassid(){
     return giftclassid;
   }
   
   /**
    * 设置 礼品类型 <br />
    * @param giftclassid
    */
   public void setGiftclassid(Integer giftclassid ){
     this.giftclassid=giftclassid;
   }
   /**
    * 获得 礼品分类<br />
    * @return giftphoto<br />
    */
   public String getGiftphoto(){
     return giftphoto;
   }
   
   /**
    * 设置 礼品分类 <br />
    * @param giftphoto
    */
   public void setGiftphoto(String giftphoto ){
     this.giftphoto=giftphoto;
   }
   /**
    * 获得 兑换礼品所需积分<br />
    * @return giftexchangepoint<br />
    */
   public Integer getGiftexchangepoint(){
     return giftexchangepoint;
   }
   
   /**
    * 设置 兑换礼品所需积分 <br />
    * @param giftexchangepoint
    */
   public void setGiftexchangepoint(Integer giftexchangepoint ){
     this.giftexchangepoint=giftexchangepoint;
   }
   /**
    * 获得 礼品库存数量<br />
    * @return giftstocknumber<br />
    */
   public Integer getGiftstocknumber(){
     return giftstocknumber;
   }
   
   /**
    * 设置 礼品库存数量 <br />
    * @param giftstocknumber
    */
   public void setGiftstocknumber(Integer giftstocknumber ){
     this.giftstocknumber=giftstocknumber;
   }
   /**
    * 获得 礼品兑换数量<br />
    * @return giftexchangenumber<br />
    */
   public Integer getGiftexchangenumber(){
     return giftexchangenumber;
   }
   
   /**
    * 设置 礼品兑换数量 <br />
    * @param giftexchangenumber
    */
   public void setGiftexchangenumber(Integer giftexchangenumber ){
     this.giftexchangenumber=giftexchangenumber;
   }
   /**
    * 获得 所属店铺<br />
    * @return giftshopid<br />
    */
   public Integer getGiftshopid(){
     return giftshopid;
   }
   
   /**
    * 设置 所属店铺 <br />
    * @param giftshopid
    */
   public void setGiftshopid(Integer giftshopid ){
     this.giftshopid=giftshopid;
   }
   /**
    * 获得 备注<br />
    * @return giftremark<br />
    */
   public String getGiftremark(){
     return giftremark;
   }
   
   /**
    * 设置 备注 <br />
    * @param giftremark
    */
   public void setGiftremark(String giftremark ){
     this.giftremark=giftremark;
   }
}
