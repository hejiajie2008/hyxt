package com.jfxy.pojo;

/**
 * 区域表 <br />
 * sysarea<br />
 * 
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Sysarea {

	private Integer id;
	/**
	 * 父节点ID <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer pid;
	/**
	 * 区域名称 <br />
	 * 允许为空 YES <br />
	 * 数据长度 100<br />
	 */
	private String name;

	/**
	 * 获得 父节点ID<br />
	 * 
	 * @return pid<br />
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 设置 父节点ID <br />
	 * 
	 * @param pid
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 获得 区域名称<br />
	 * 
	 * @return name<br />
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 区域名称 <br />
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
