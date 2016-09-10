package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Goods;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表 <br />
 * goods<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class GoodsFormBean extends Pagination<Goods> {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer goodsid;
	/**
	 * 商品代码 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String goodscode;
	/**
	 * 商品分类 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer goodsclassid;
	/**
	 * 商品名称 <br />
	 * 允许为空 YES <br />
	 * 数据长度 100<br />
	 */
	private String name;
	/**
	 * 商品简码 <br />
	 * 允许为空 YES <br />
	 * 数据长度 20<br />
	 */
	private String namecode;
	/**
	 * 计量单位 <br />
	 * 允许为空 YES <br />
	 * 数据长度 10<br />
	 */
	private String unit;
	/**
	 * 商品库存（此字段无用，见商品库存表） <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer goodsnumber;
	/**
	 * <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer goodssalenumber;
	/**
	 * 零售单价 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal price;
	/**
	 * 提成类型（1按商品固定比例提成/2按商品固定金额提成） <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer commissiontype;
	/**
	 * 提成系数 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Double commissionnumber;
	/**
	 * 特价折扣 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private BigDecimal salepercet;
	/**
	 * 积分数量 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer point;
	/**
	 * 最低折扣 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Float minpercent;
	/**
	 * 是否为服务项目（1是，0否） <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer goodstype;
	/**
	 * 参考进价 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0 , 2<br />
	 */
	private BigDecimal goodsbidprice;
	/**
	 * 商品简介 <br />
	 * 允许为空 YES <br />
	 * 数据长度 100<br />
	 */
	private String goodsremark;
	/**
	 * 商品图片 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String goodspicture;
	/**
	 * 创建时间 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Date goodscreatetime;
	/**
	 * 创建店铺 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer createshopid;

	/**
	 * 所属店铺ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer shopid;

	private Integer key;

	/**
    * 
    */
	private Integer bolgoodsexpense;

	/**
	 * 
	 * 是否检查库存；
	 * 
	 */
	private Integer ischeckstock;
	
	private Integer memlevelid;
	
	

	/**
	 * 获得 主键<br />
	 * 
	 * @return goodsid<br />
	 */
	public Integer getGoodsid() {
		return goodsid;
	}

	/**
	 * 设置 主键 <br />
	 * 
	 * @param goodsid
	 */
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	/**
	 * 获得 商品代码<br />
	 * 
	 * @return goodscode<br />
	 */
	public String getGoodscode() {
		return goodscode;
	}

	/**
	 * 设置 商品代码 <br />
	 * 
	 * @param goodscode
	 */
	public void setGoodscode(String goodscode) {
		this.goodscode = goodscode;
	}

	/**
	 * 获得 商品分类<br />
	 * 
	 * @return goodsclassid<br />
	 */
	public Integer getGoodsclassid() {
		return goodsclassid;
	}

	/**
	 * 设置 商品分类 <br />
	 * 
	 * @param goodsclassid
	 */
	public void setGoodsclassid(Integer goodsclassid) {
		this.goodsclassid = goodsclassid;
	}

	/**
	 * 获得 商品名称<br />
	 * 
	 * @return name<br />
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 商品名称 <br />
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获得 商品简码<br />
	 * 
	 * @return namecode<br />
	 */
	public String getNamecode() {
		return namecode;
	}

	/**
	 * 设置 商品简码 <br />
	 * 
	 * @param namecode
	 */
	public void setNamecode(String namecode) {
		this.namecode = namecode;
	}

	/**
	 * 获得 计量单位<br />
	 * 
	 * @return unit<br />
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * 设置 计量单位 <br />
	 * 
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 获得 商品库存（此字段无用，见商品库存表）<br />
	 * 
	 * @return goodsnumber<br />
	 */
	public Integer getGoodsnumber() {
		return goodsnumber;
	}

	/**
	 * 设置 商品库存（此字段无用，见商品库存表） <br />
	 * 
	 * @param goodsnumber
	 */
	public void setGoodsnumber(Integer goodsnumber) {
		this.goodsnumber = goodsnumber;
	}

	/**
	 * 获得 <br />
	 * 
	 * @return goodssalenumber<br />
	 */
	public Integer getGoodssalenumber() {
		return goodssalenumber;
	}

	/**
	 * 设置 <br />
	 * 
	 * @param goodssalenumber
	 */
	public void setGoodssalenumber(Integer goodssalenumber) {
		this.goodssalenumber = goodssalenumber;
	}

	/**
	 * 获得 零售单价<br />
	 * 
	 * @return price<br />
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 设置 零售单价 <br />
	 * 
	 * @param price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 获得 提成类型（1按商品固定比例提成/2按商品固定金额提成）<br />
	 * 
	 * @return commissiontype<br />
	 */
	public Integer getCommissiontype() {
		return commissiontype;
	}

	/**
	 * 设置 提成类型（1按商品固定比例提成/2按商品固定金额提成） <br />
	 * 
	 * @param commissiontype
	 */
	public void setCommissiontype(Integer commissiontype) {
		this.commissiontype = commissiontype;
	}

	/**
	 * 获得 提成系数<br />
	 * 
	 * @return commissionnumber<br />
	 */
	public Double getCommissionnumber() {
		return commissionnumber;
	}

	/**
	 * 设置 提成系数 <br />
	 * 
	 * @param commissionnumber
	 */
	public void setCommissionnumber(Double commissionnumber) {
		this.commissionnumber = commissionnumber;
	}

	/**
	 * 获得 特价折扣<br />
	 * 
	 * @return salepercet<br />
	 */
	public BigDecimal getSalepercet() {
		return salepercet;
	}

	/**
	 * 设置 特价折扣 <br />
	 * 
	 * @param salepercet
	 */
	public void setSalepercet(BigDecimal salepercet) {
		this.salepercet = salepercet;
	}

	/**
	 * 获得 积分数量<br />
	 * 
	 * @return point<br />
	 */
	public Integer getPoint() {
		return point;
	}

	/**
	 * 设置 积分数量 <br />
	 * 
	 * @param point
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}

	/**
	 * 获得 最低折扣<br />
	 * 
	 * @return minpercent<br />
	 */
	public Float getMinpercent() {
		return minpercent;
	}

	/**
	 * 设置 最低折扣 <br />
	 * 
	 * @param minpercent
	 */
	public void setMinpercent(Float minpercent) {
		this.minpercent = minpercent;
	}

	/**
	 * 获得 是否为服务项目（1是，0否）<br />
	 * 
	 * @return goodstype<br />
	 */
	public Integer getGoodstype() {
		return goodstype;
	}

	/**
	 * 设置 是否为服务项目（1是，0否） <br />
	 * 
	 * @param goodstype
	 */
	public void setGoodstype(Integer goodstype) {
		this.goodstype = goodstype;
	}

	/**
	 * 获得 参考进价<br />
	 * 
	 * @return goodsbidprice<br />
	 */
	public BigDecimal getGoodsbidprice() {
		return goodsbidprice;
	}

	/**
	 * 设置 参考进价 <br />
	 * 
	 * @param goodsbidprice
	 */
	public void setGoodsbidprice(BigDecimal goodsbidprice) {
		this.goodsbidprice = goodsbidprice;
	}

	/**
	 * 获得 商品简介<br />
	 * 
	 * @return goodsremark<br />
	 */
	public String getGoodsremark() {
		return goodsremark;
	}

	/**
	 * 设置 商品简介 <br />
	 * 
	 * @param goodsremark
	 */
	public void setGoodsremark(String goodsremark) {
		this.goodsremark = goodsremark;
	}

	/**
	 * 获得 商品图片<br />
	 * 
	 * @return goodspicture<br />
	 */
	public String getGoodspicture() {
		return goodspicture;
	}

	/**
	 * 设置 商品图片 <br />
	 * 
	 * @param goodspicture
	 */
	public void setGoodspicture(String goodspicture) {
		this.goodspicture = goodspicture;
	}

	/**
	 * 获得 创建时间<br />
	 * 
	 * @return goodscreatetime<br />
	 */
	public Date getGoodscreatetime() {
		return goodscreatetime;
	}

	/**
	 * 设置 创建时间 <br />
	 * 
	 * @param goodscreatetime
	 */
	public void setGoodscreatetime(Date goodscreatetime) {
		this.goodscreatetime = goodscreatetime;
	}

	/**
	 * 获得 创建店铺<br />
	 * 
	 * @return createshopid<br />
	 */
	public Integer getCreateshopid() {
		return createshopid;
	}

	/**
	 * 设置 创建店铺 <br />
	 * 
	 * @param createshopid
	 */
	public void setCreateshopid(Integer createshopid) {
		this.createshopid = createshopid;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Integer getBolgoodsexpense() {
		return bolgoodsexpense;
	}

	public void setBolgoodsexpense(Integer bolgoodsexpense) {
		this.bolgoodsexpense = bolgoodsexpense;
	}

	public Integer getIscheckstock() {
		return ischeckstock;
	}

	public void setIscheckstock(Integer ischeckstock) {
		this.ischeckstock = ischeckstock;
	}

	public Integer getMemlevelid() {
		return memlevelid;
	}

	public void setMemlevelid(Integer memlevelid) {
		this.memlevelid = memlevelid;
	}

	

	
	

}
