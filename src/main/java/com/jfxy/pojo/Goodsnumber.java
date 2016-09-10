package com.jfxy.pojo;

/**
 * 商品库存表 <br />
 * goodsnumber<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Goodsnumber {
	
	private Integer id;
	/**
	 * 商品编码 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer goodsid;
	/**
	 * 所属店铺 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer shopid;
	/**
	 * 数量 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer number;
	/**
    * 
    */
	private Integer innumber;
	
	
	private String goodscode;
	
	public Goodsnumber(){
		
	}

	/**
	 * 获得 商品编码<br />
	 * 
	 * @return goodsid<br />
	 */
	public Integer getGoodsid() {
		return goodsid;
	}

	/**
	 * 设置 商品编码 <br />
	 * 
	 * @param goodsid
	 */
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	/**
	 * 获得 所属店铺<br />
	 * 
	 * @return shopid<br />
	 */
	public Integer getShopid() {
		return shopid;
	}

	/**
	 * 设置 所属店铺 <br />
	 * 
	 * @param shopid
	 */
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	/**
	 * 获得 数量<br />
	 * 
	 * @return number<br />
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * 设置 数量 <br />
	 * 
	 * @param number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getInnumber() {
		return innumber;
	}

	public void setInnumber(Integer innumber) {
		this.innumber = innumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodscode() {
		return goodscode;
	}

	public void setGoodscode(String goodscode) {
		this.goodscode = goodscode;
	}

	
}
