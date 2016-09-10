package com.jfxy.pojo;

/**
 * 部门表 <br />
 * staffclass<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Staffclass {
	/**
	 * 主键 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer classid;
	/**
	 * 部门名称 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String classname;
	/**
	 * 类型（是否提成） <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer classtype;
	/**
	 * 提成比例 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Double classpercent;
	/**
	 * 所属店铺 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer classshopid;
	/**
	 * 店铺说明 <br />
	 * 允许为空 YES <br />
	 * 数据长度 255<br />
	 */
	private String classremark;

	private String shopname;

	/**
	 * 获得 主键<br />
	 * 
	 * @return classid<br />
	 */
	public Integer getClassid() {
		return classid;
	}

	/**
	 * 设置 主键 <br />
	 * 
	 * @param classid
	 */
	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	/**
	 * 获得 部门名称<br />
	 * 
	 * @return classname<br />
	 */
	public String getClassname() {
		return classname;
	}

	/**
	 * 设置 部门名称 <br />
	 * 
	 * @param classname
	 */
	public void setClassname(String classname) {
		this.classname = classname;
	}

	/**
	 * 获得 类型（是否提成）<br />
	 * 
	 * @return classtype<br />
	 */
	public Integer getClasstype() {
		return classtype;
	}

	/**
	 * 设置 类型（是否提成） <br />
	 * 
	 * @param classtype
	 */
	public void setClasstype(Integer classtype) {
		this.classtype = classtype;
	}

	/**
	 * 获得 提成比例<br />
	 * 
	 * @return classpercent<br />
	 */
	public Double getClasspercent() {
		return classpercent;
	}

	/**
	 * 设置 提成比例 <br />
	 * 
	 * @param classpercent
	 */
	public void setClasspercent(Double classpercent) {
		this.classpercent = classpercent;
	}

	/**
	 * 获得 所属店铺<br />
	 * 
	 * @return classshopid<br />
	 */
	public Integer getClassshopid() {
		return classshopid;
	}

	/**
	 * 设置 所属店铺 <br />
	 * 
	 * @param classshopid
	 */
	public void setClassshopid(Integer classshopid) {
		this.classshopid = classshopid;
	}

	/**
	 * 获得 店铺说明<br />
	 * 
	 * @return classremark<br />
	 */
	public String getClassremark() {
		return classremark;
	}

	/**
	 * 设置 店铺说明 <br />
	 * 
	 * @param classremark
	 */
	public void setClassremark(String classremark) {
		this.classremark = classremark;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

}
