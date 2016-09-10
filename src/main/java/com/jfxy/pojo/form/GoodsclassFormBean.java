package com.jfxy.pojo.form;


import com.jfxy.util.Pagination;
import com.jfxy.pojo.Goodsclass;

/**
 * 商品种类表 <br />
 * goodsclass<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class GoodsclassFormBean extends Pagination<Goodsclass> {
	private static final long serialVersionUID = 1L;
	/**
	 * 种类ID <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer classid;
	/**
	 * 种类名称 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String classname;
	/**
	 * 种类备注 <br />
	 * 允许为空 YES <br />
	 * 数据长度 100<br />
	 */
	private String classremark;
	/**
	 * 父节点ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer parentid;
	/**
	 * 创建店铺ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer createshopid;

	private Integer goodclassshopid;

	/**
	 * 获得 种类ID<br />
	 * 
	 * @return classid<br />
	 */
	public Integer getClassid() {
		return classid;
	}

	/**
	 * 设置 种类ID <br />
	 * 
	 * @param classid
	 */
	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	/**
	 * 获得 种类名称<br />
	 * 
	 * @return classname<br />
	 */
	public String getClassname() {
		return classname;
	}

	/**
	 * 设置 种类名称 <br />
	 * 
	 * @param classname
	 */
	public void setClassname(String classname) {
		this.classname = classname;
	}

	/**
	 * 获得 种类备注<br />
	 * 
	 * @return classremark<br />
	 */
	public String getClassremark() {
		return classremark;
	}

	/**
	 * 设置 种类备注 <br />
	 * 
	 * @param classremark
	 */
	public void setClassremark(String classremark) {
		this.classremark = classremark;
	}

	/**
	 * 获得 父节点ID<br />
	 * 
	 * @return parentid<br />
	 */
	public Integer getParentid() {
		return parentid;
	}

	/**
	 * 设置 父节点ID <br />
	 * 
	 * @param parentid
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	/**
	 * 获得 创建店铺ID<br />
	 * 
	 * @return createshopid<br />
	 */
	public Integer getCreateshopid() {
		return createshopid;
	}

	/**
	 * 设置 创建店铺ID <br />
	 * 
	 * @param createshopid
	 */
	public void setCreateshopid(Integer createshopid) {
		this.createshopid = createshopid;
	}

	public Integer getGoodclassshopid() {
		return goodclassshopid;
	}

	public void setGoodclassshopid(Integer goodclassshopid) {
		this.goodclassshopid = goodclassshopid;
	}

}
