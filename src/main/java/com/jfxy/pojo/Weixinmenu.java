package com.jfxy.pojo;

/**
 * 微信菜单表 <br />
 * weixinmenu<br />
 * 
 * @author hejiajie
 * @date 2015-12-22 16:03:24
 */
public class Weixinmenu {
	/**
	 * 菜单ID <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer menuid;
	/**
	 * 菜单名称 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String menuname;
	/**
	 * 菜单类型 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer menutype;
	/**
	 * 菜单键 <br />
	 * 允许为空 YES <br />
	 * 数据长度 128<br />
	 */
	private String menukey;
	/**
	 * 菜单URL <br />
	 * 允许为空 YES <br />
	 * 数据长度 255<br />
	 */
	private String menuurl;
	/**
	 * 父菜单ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer parentmenuid;

	private Integer childnum;

	/**
	 * 获得 菜单ID<br />
	 * 
	 * @return menuid<br />
	 */
	public Integer getMenuid() {
		return menuid;
	}

	/**
	 * 设置 菜单ID <br />
	 * 
	 * @param menuid
	 */
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	/**
	 * 获得 菜单名称<br />
	 * 
	 * @return menuname<br />
	 */
	public String getMenuname() {
		return menuname;
	}

	/**
	 * 设置 菜单名称 <br />
	 * 
	 * @param menuname
	 */
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	/**
	 * 获得 菜单类型<br />
	 * 
	 * @return menutype<br />
	 */
	public Integer getMenutype() {
		return menutype;
	}

	/**
	 * 设置 菜单类型 <br />
	 * 
	 * @param menutype
	 */
	public void setMenutype(Integer menutype) {
		this.menutype = menutype;
	}

	/**
	 * 获得 菜单键<br />
	 * 
	 * @return menukey<br />
	 */
	public String getMenukey() {
		return menukey;
	}

	/**
	 * 设置 菜单键 <br />
	 * 
	 * @param menukey
	 */
	public void setMenukey(String menukey) {
		this.menukey = menukey;
	}

	/**
	 * 获得 菜单URL<br />
	 * 
	 * @return menuurl<br />
	 */
	public String getMenuurl() {
		return menuurl;
	}

	/**
	 * 设置 菜单URL <br />
	 * 
	 * @param menuurl
	 */
	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

	/**
	 * 获得 父菜单ID<br />
	 * 
	 * @return parentmenuid<br />
	 */
	public Integer getParentmenuid() {
		return parentmenuid;
	}

	/**
	 * 设置 父菜单ID <br />
	 * 
	 * @param parentmenuid
	 */
	public void setParentmenuid(Integer parentmenuid) {
		this.parentmenuid = parentmenuid;
	}

	public Integer getChildnum() {
		return childnum;
	}

	public void setChildnum(Integer childnum) {
		this.childnum = childnum;
	}

	

}
