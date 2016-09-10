package com.jfxy.pojo;

public class ExcelField {
	

	/**
	 * 主键 <br />
	 * 允许为空 NO <br />
	 * 数据长度 0<br />
	 */
	private Integer fieldid;
	
	/**
	 * 字段 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String field;
	/**
	 * 字段名称 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String fieldname;
	
	
	private Integer fieldtype;
	/**
	 * 是否为空 <br />
	 * 允许为空 YES <br />
	 * 数据长度 0<br />
	 */
	private Integer fieldisnull;
	
	private String fieldvalue;
	
	private Integer fieldlength;

	public Integer getFieldid() {
		return fieldid;
	}

	public void setFieldid(Integer fieldid) {
		this.fieldid = fieldid;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public Integer getFieldisnull() {
		return fieldisnull;
	}

	public void setFieldisnull(Integer fieldisnull) {
		this.fieldisnull = fieldisnull;
	}

	public String getFieldvalue() {
		return fieldvalue;
	}

	public void setFieldvalue(String fieldvalue) {
		this.fieldvalue = fieldvalue;
	}

	public Integer getFieldlength() {
		return fieldlength;
	}

	public void setFieldlength(Integer fieldlength) {
		this.fieldlength = fieldlength;
	}

	public Integer getFieldtype() {
		return fieldtype;
	}

	public void setFieldtype(Integer fieldtype) {
		this.fieldtype = fieldtype;
	}
	
	
	

}
