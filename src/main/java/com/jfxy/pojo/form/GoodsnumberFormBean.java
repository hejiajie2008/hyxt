package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Goodsnumber;

/**
 * 商品库存表 <br />
 * goodsnumber<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class GoodsnumberFormBean extends Pagination<Goodsnumber>   {
  private static final long serialVersionUID = 1L;
   /**
    * 商品编码   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer goodsid;
   /**
    * 所属店铺   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer shopid;
   /**
    * 数量   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Double number;
   /**
    * 获得 商品编码<br />
    * @return goodsid<br />
    */
   public Integer getGoodsid(){
     return goodsid;
   }
   
   /**
    * 设置 商品编码 <br />
    * @param goodsid
    */
   public void setGoodsid(Integer goodsid ){
     this.goodsid=goodsid;
   }
   /**
    * 获得 所属店铺<br />
    * @return shopid<br />
    */
   public Integer getShopid(){
     return shopid;
   }
   
   /**
    * 设置 所属店铺 <br />
    * @param shopid
    */
   public void setShopid(Integer shopid ){
     this.shopid=shopid;
   }
   /**
    * 获得 数量<br />
    * @return number<br />
    */
   public Double getNumber(){
     return number;
   }
   
   /**
    * 设置 数量 <br />
    * @param number
    */
   public void setNumber(Double number ){
     this.number=number;
   }
}
