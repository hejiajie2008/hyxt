package com.jfxy.code.pojo;

/**
 * 字段
 * 
 * @author hejiajie
 * 
 */
public class Field {
	/**
	 * 列名
	 */
	private String columnName;
	/**
	 * 列长度
	 */
	private int length;
	/**
	 * 精度
	 */
	private int scale;
	/**
	 * 注释
	 */
	private String comments;
	/**
	 * 字段名
	 */
	private String fieldName;

	/**
	 * 注释详情
	 */
	private String commentsDetail;
	/**
	 * 数据类型
	 */
	private String dataType;
	/**
	 * Hibernate mybatis 数据类型
	 */
	private String type;
	/**
	 * JAVA数据类型
	 */
	private String javaDataType;
	/**
	 * 是否允许为空
	 */
	private String nullable;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJavaDataType() {
		return javaDataType;
	}

	public void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public String getCommentsDetail() {
		return commentsDetail;
	}

	public void setCommentsDetail(String commentsDetail) {
		this.commentsDetail = commentsDetail;
	}

}
