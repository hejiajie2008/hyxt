package com.jfxy.pojo;

import java.util.Date;

/**
 * 计时服务表 <br />
 * timingproject<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Timingproject {
	/**
	 * 主键 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer projectid;
	/**
	 * 服务名称 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String projectname;
	/**
	 * <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer projectcategoryid;
	/**
	 * 服务规则 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer projectrulesid;
	/**
	 * 创建时间 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Date projectaddtime;
	/**
	 * 所属店铺 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer projectshopid;
	/**
	 * 所属用户 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer projectuserid;
	/**
	 * 备注 <br />
	 * 允许为空 YES <br />
	 * 数据长度 200<br />
	 */
	private String projectremark;

	private String username;

	private String rulesname;

	private String rulesremark;
	
	private Integer rulesinterval;
	/**
	 * 获得 主键<br />
	 * 
	 * @return projectid<br />
	 */
	public Integer getProjectid() {
		return projectid;
	}

	/**
	 * 设置 主键 <br />
	 * 
	 * @param projectid
	 */
	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}

	/**
	 * 获得 服务名称<br />
	 * 
	 * @return projectname<br />
	 */
	public String getProjectname() {
		return projectname;
	}

	/**
	 * 设置 服务名称 <br />
	 * 
	 * @param projectname
	 */
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	/**
	 * 获得 <br />
	 * 
	 * @return projectcategoryid<br />
	 */
	public Integer getProjectcategoryid() {
		return projectcategoryid;
	}

	/**
	 * 设置 <br />
	 * 
	 * @param projectcategoryid
	 */
	public void setProjectcategoryid(Integer projectcategoryid) {
		this.projectcategoryid = projectcategoryid;
	}

	/**
	 * 获得 服务规则<br />
	 * 
	 * @return projectrulesid<br />
	 */
	public Integer getProjectrulesid() {
		return projectrulesid;
	}

	/**
	 * 设置 服务规则 <br />
	 * 
	 * @param projectrulesid
	 */
	public void setProjectrulesid(Integer projectrulesid) {
		this.projectrulesid = projectrulesid;
	}

	/**
	 * 获得 创建时间<br />
	 * 
	 * @return projectaddtime<br />
	 */
	public Date getProjectaddtime() {
		return projectaddtime;
	}

	/**
	 * 设置 创建时间 <br />
	 * 
	 * @param projectaddtime
	 */
	public void setProjectaddtime(Date projectaddtime) {
		this.projectaddtime = projectaddtime;
	}

	/**
	 * 获得 所属店铺<br />
	 * 
	 * @return projectshopid<br />
	 */
	public Integer getProjectshopid() {
		return projectshopid;
	}

	/**
	 * 设置 所属店铺 <br />
	 * 
	 * @param projectshopid
	 */
	public void setProjectshopid(Integer projectshopid) {
		this.projectshopid = projectshopid;
	}

	/**
	 * 获得 所属用户<br />
	 * 
	 * @return projectuserid<br />
	 */
	public Integer getProjectuserid() {
		return projectuserid;
	}

	/**
	 * 设置 所属用户 <br />
	 * 
	 * @param projectuserid
	 */
	public void setProjectuserid(Integer projectuserid) {
		this.projectuserid = projectuserid;
	}

	/**
	 * 获得 备注<br />
	 * 
	 * @return projectremark<br />
	 */
	public String getProjectremark() {
		return projectremark;
	}

	/**
	 * 设置 备注 <br />
	 * 
	 * @param projectremark
	 */
	public void setProjectremark(String projectremark) {
		this.projectremark = projectremark;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRulesname() {
		return rulesname;
	}

	public void setRulesname(String rulesname) {
		this.rulesname = rulesname;
	}

	public String getRulesremark() {
		return rulesremark;
	}

	public void setRulesremark(String rulesremark) {
		this.rulesremark = rulesremark;
	}

	
	
	public Integer getRulesinterval() {
		return rulesinterval;
	}

	public void setRulesinterval(Integer rulesinterval) {
		this.rulesinterval = rulesinterval;
	}

	public Integer getAllcount(){
		return this.rulesinterval;
	}
	

	
	
}
