package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.Staff;

/**
 * 员工表 <br />
 * staff<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class StaffFormBean extends Pagination<Staff> {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer staffid;
	/**
	 * 员工编号 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String staffnumber;
	/**
	 * 员工姓名 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String staffname;
	/**
	 * 员工性别（1男0女） <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer staffsex;
	/**
	 * 手机号码 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String staffmobile;
	/**
	 * 联系地址 <br />
	 * 允许为空 YES <br />
	 * 数据长度 255<br />
	 */
	private String staffaddress;
	/**
	 * 所属部门 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer staffclassid;
	/**
	 * 备注 <br />
	 * 允许为空 YES <br />
	 * 数据长度 255<br />
	 */
	private String staffremark;

	private String txtQuery;
	
	private Integer shopid;

	/**
	 * 获得 主键<br />
	 * 
	 * @return staffid<br />
	 */
	public Integer getStaffid() {
		return staffid;
	}

	/**
	 * 设置 主键 <br />
	 * 
	 * @param staffid
	 */
	public void setStaffid(Integer staffid) {
		this.staffid = staffid;
	}

	/**
	 * 获得 员工编号<br />
	 * 
	 * @return staffnumber<br />
	 */
	public String getStaffnumber() {
		return staffnumber;
	}

	/**
	 * 设置 员工编号 <br />
	 * 
	 * @param staffnumber
	 */
	public void setStaffnumber(String staffnumber) {
		this.staffnumber = staffnumber;
	}

	/**
	 * 获得 员工姓名<br />
	 * 
	 * @return staffname<br />
	 */
	public String getStaffname() {
		return staffname;
	}

	/**
	 * 设置 员工姓名 <br />
	 * 
	 * @param staffname
	 */
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	/**
	 * 获得 员工性别（1男0女）<br />
	 * 
	 * @return staffsex<br />
	 */
	public Integer getStaffsex() {
		return staffsex;
	}

	/**
	 * 设置 员工性别（1男0女） <br />
	 * 
	 * @param staffsex
	 */
	public void setStaffsex(Integer staffsex) {
		this.staffsex = staffsex;
	}

	/**
	 * 获得 手机号码<br />
	 * 
	 * @return staffmobile<br />
	 */
	public String getStaffmobile() {
		return staffmobile;
	}

	/**
	 * 设置 手机号码 <br />
	 * 
	 * @param staffmobile
	 */
	public void setStaffmobile(String staffmobile) {
		this.staffmobile = staffmobile;
	}

	/**
	 * 获得 联系地址<br />
	 * 
	 * @return staffaddress<br />
	 */
	public String getStaffaddress() {
		return staffaddress;
	}

	/**
	 * 设置 联系地址 <br />
	 * 
	 * @param staffaddress
	 */
	public void setStaffaddress(String staffaddress) {
		this.staffaddress = staffaddress;
	}

	/**
	 * 获得 所属部门<br />
	 * 
	 * @return staffclassid<br />
	 */
	public Integer getStaffclassid() {
		return staffclassid;
	}

	/**
	 * 设置 所属部门 <br />
	 * 
	 * @param staffclassid
	 */
	public void setStaffclassid(Integer staffclassid) {
		this.staffclassid = staffclassid;
	}

	/**
	 * 获得 备注<br />
	 * 
	 * @return staffremark<br />
	 */
	public String getStaffremark() {
		return staffremark;
	}

	/**
	 * 设置 备注 <br />
	 * 
	 * @param staffremark
	 */
	public void setStaffremark(String staffremark) {
		this.staffremark = staffremark;
	}

	public String getTxtQuery() {
		return txtQuery;
	}

	public void setTxtQuery(String txtQuery) {
		this.txtQuery = txtQuery;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	
}
