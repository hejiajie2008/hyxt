package com.jfxy.code.pojo;

import java.util.ArrayList;
import java.util.List;
/**
 * TODO
 * @author hejiajie
 *
 * @date 2013-7-6
 */
public class Table {
	/**
	 * 父类
	 */
	private String parentClass = "Entity";
	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 是否含有CODE字段
	 */
	private String hasCode;
	/**
	 * JAVA类名
	 */
	private String javaName;
	/**
	 * 表注释
	 */
	private String comments;

	/**
	 * 主键字段
	 */
	private Field primaryKeyField;
	/**
	 * 版本字段
	 */
	private Field versionField;
	/**
	 * 实现类
	 */
	private List<String> implemeFields = new ArrayList<String>();

	public List<String> getImplemeFields() {
		return implemeFields;
	}

	public void setImplemeFields(List<String> implemeFields) {
		this.implemeFields = implemeFields;
	}

	/**
	 * 所有字段
	 */
	private List<Field> allFields = new ArrayList<Field>();

	public String getHasCode() {
		return hasCode;
	}

	public void setHasCode(String hasCode) {
		this.hasCode = hasCode;
	}

	public String getParentClass() {
		return parentClass;
	}

	public void setParentClass(String parentClass) {
		this.parentClass = parentClass;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getJavaName() {
		return javaName;
	}

	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}

	public Field getPrimaryKeyField() {
		return primaryKeyField;
	}

	public void setPrimaryKeyField(Field primaryKeyField) {
		this.primaryKeyField = primaryKeyField;
	}

	public Field getVersionField() {
		return versionField;
	}

	public void setVersionField(Field versionField) {
		this.versionField = versionField;
	}

	public void addField(Field field) {
		if (field.getFieldName().equals("id")) {
			if (parentClass.equals("Entity")) {
				parentClass = "BaseEntity";
			}
		} else if (field.getFieldName().equals("createTime")) {
			if (parentClass.equals("Entity") || parentClass.equals("BaseEntity")) {
				parentClass = "OperatorEntity";
			}
		} else if (field.getFieldName().equals("deleted")) {
			implemeFields.add("Deleted");
		} else if (field.getFieldName().equals("version")) {
			implemeFields.add("Version");
		} else if (field.getFieldName().equals("code")) {
			hasCode = "T";
		}
		allFields.add(field);
	}

	public List<Field> getAllFields() {
		return allFields;
	}

	public void setAllFields(List<Field> allFields) {
		this.allFields = allFields;
	}

}
