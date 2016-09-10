package com.jfxy.pojo.form;

import java.math.BigDecimal;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Goodslogdetail;

/**
 * 商品日志明细表 <br />
 * goodslogdetail<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class GoodslogdetailFormBean extends Pagination<Goodslogdetail>   {
  private static final long serialVersionUID = 1L;
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer goodslogdetailid;
   /**
    * 商品日志   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer goodslogid;
   /**
    * 商品   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer goodsid;
   /**
    * 入库商品价格   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal goodsinprice;
   /**
    * 出库商品价格   <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal goodsoutprice;
   /**
    * 商品数量   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Double goodsnumber;
   /**
    * 获得 主键<br />
    * @return goodslogdetailid<br />
    */
   public Integer getGoodslogdetailid(){
     return goodslogdetailid;
   }
   
   /**
    * 设置 主键 <br />
    * @param goodslogdetailid
    */
   public void setGoodslogdetailid(Integer goodslogdetailid ){
     this.goodslogdetailid=goodslogdetailid;
   }
   /**
    * 获得 商品日志<br />
    * @return goodslogid<br />
    */
   public Integer getGoodslogid(){
     return goodslogid;
   }
   
   /**
    * 设置 商品日志 <br />
    * @param goodslogid
    */
   public void setGoodslogid(Integer goodslogid ){
     this.goodslogid=goodslogid;
   }
   /**
    * 获得 商品<br />
    * @return goodsid<br />
    */
   public Integer getGoodsid(){
     return goodsid;
   }
   
   /**
    * 设置 商品 <br />
    * @param goodsid
    */
   public void setGoodsid(Integer goodsid ){
     this.goodsid=goodsid;
   }
   /**
    * 获得 入库商品价格<br />
    * @return goodsinprice<br />
    */
   public BigDecimal getGoodsinprice(){
     return goodsinprice;
   }
   
   /**
    * 设置 入库商品价格 <br />
    * @param goodsinprice
    */
   public void setGoodsinprice(BigDecimal goodsinprice ){
     this.goodsinprice=goodsinprice;
   }
   /**
    * 获得 出库商品价格<br />
    * @return goodsoutprice<br />
    */
   public BigDecimal getGoodsoutprice(){
     return goodsoutprice;
   }
   
   /**
    * 设置 出库商品价格 <br />
    * @param goodsoutprice
    */
   public void setGoodsoutprice(BigDecimal goodsoutprice ){
     this.goodsoutprice=goodsoutprice;
   }
   /**
    * 获得 商品数量<br />
    * @return goodsnumber<br />
    */
   public Double getGoodsnumber(){
     return goodsnumber;
   }
   
   /**
    * 设置 商品数量 <br />
    * @param goodsnumber
    */
   public void setGoodsnumber(Double goodsnumber ){
     this.goodsnumber=goodsnumber;
   }
}
