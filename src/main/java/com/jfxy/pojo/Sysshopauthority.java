package com.jfxy.pojo;
/**
 * 店铺权限表 <br />
 * sysshopauthority<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Sysshopauthority   {
   /**
    * 店铺权限ID   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer shopauthorityid;
   /**
    * 店铺ID   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer shopauthorityshopid;
   /**
    * 权限数据   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String shopauthoritydata;
   /**
    * 获得 店铺权限ID<br />
    * @return shopauthorityid<br />
    */
   public Integer getShopauthorityid(){
     return shopauthorityid;
   }
   
   /**
    * 设置 店铺权限ID <br />
    * @param shopauthorityid
    */
   public void setShopauthorityid(Integer shopauthorityid ){
     this.shopauthorityid=shopauthorityid;
   }
   /**
    * 获得 店铺ID<br />
    * @return shopauthorityshopid<br />
    */
   public Integer getShopauthorityshopid(){
     return shopauthorityshopid;
   }
   
   /**
    * 设置 店铺ID <br />
    * @param shopauthorityshopid
    */
   public void setShopauthorityshopid(Integer shopauthorityshopid ){
     this.shopauthorityshopid=shopauthorityshopid;
   }
   /**
    * 获得 权限数据<br />
    * @return shopauthoritydata<br />
    */
   public String getShopauthoritydata(){
     return shopauthoritydata;
   }
   
   /**
    * 设置 权限数据 <br />
    * @param shopauthoritydata
    */
   public void setShopauthoritydata(String shopauthoritydata ){
     this.shopauthoritydata=shopauthoritydata;
   }
}
