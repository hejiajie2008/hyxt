package com.jfxy.pojo;

import java.util.Date;

/**
 * 系统日志表 <br />
 * syslog<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Syslog {
	/**
	 * 日志ID <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer logid;
	/**
	 * 用户ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer loguserid;
	/**
	 * 响应ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer logactionid;
	/**
	 * 日志明细 <br />
	 * 允许为空 YES <br />
	 * 数据长度 255<br />
	 */
	private String logdetail;
	/**
	 * 店铺ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer logshopid;
	/**
	 * 创建时间 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Date logcreatetime;
	/**
	 * IP地址 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String logipadress;
	/**
	 * 日志类型 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String logtype;

	private String useraccount;

	private String username;

	private String shopname;

	/**
	 * 获得 日志ID<br />
	 * 
	 * @return logid<br />
	 */
	public Integer getLogid() {
		return logid;
	}

	/**
	 * 设置 日志ID <br />
	 * 
	 * @param logid
	 */
	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	/**
	 * 获得 用户ID<br />
	 * 
	 * @return loguserid<br />
	 */
	public Integer getLoguserid() {
		return loguserid;
	}

	/**
	 * 设置 用户ID <br />
	 * 
	 * @param loguserid
	 */
	public void setLoguserid(Integer loguserid) {
		this.loguserid = loguserid;
	}

	/**
	 * 获得 响应ID<br />
	 * 
	 * @return logactionid<br />
	 */
	public Integer getLogactionid() {
		return logactionid;
	}

	/**
	 * 设置 响应ID <br />
	 * 
	 * @param logactionid
	 */
	public void setLogactionid(Integer logactionid) {
		this.logactionid = logactionid;
	}

	/**
	 * 获得 日志明细<br />
	 * 
	 * @return logdetail<br />
	 */
	public String getLogdetail() {
		return logdetail;
	}

	/**
	 * 设置 日志明细 <br />
	 * 
	 * @param logdetail
	 */
	public void setLogdetail(String logdetail) {
		this.logdetail = logdetail;
	}

	/**
	 * 获得 店铺ID<br />
	 * 
	 * @return logshopid<br />
	 */
	public Integer getLogshopid() {
		return logshopid;
	}

	/**
	 * 设置 店铺ID <br />
	 * 
	 * @param logshopid
	 */
	public void setLogshopid(Integer logshopid) {
		this.logshopid = logshopid;
	}

	/**
	 * 获得 创建时间<br />
	 * 
	 * @return logcreatetime<br />
	 */
	public Date getLogcreatetime() {
		return logcreatetime;
	}

	/**
	 * 设置 创建时间 <br />
	 * 
	 * @param logcreatetime
	 */
	public void setLogcreatetime(Date logcreatetime) {
		this.logcreatetime = logcreatetime;
	}

	/**
	 * 获得 IP地址<br />
	 * 
	 * @return logipadress<br />
	 */
	public String getLogipadress() {
		return logipadress;
	}

	/**
	 * 设置 IP地址 <br />
	 * 
	 * @param logipadress
	 */
	public void setLogipadress(String logipadress) {
		this.logipadress = logipadress;
	}

	/**
	 * 获得 日志类型<br />
	 * 
	 * @return logtype<br />
	 */
	public String getLogtype() {
		return logtype;
	}

	/**
	 * 设置 日志类型 <br />
	 * 
	 * @param logtype
	 */
	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

}
