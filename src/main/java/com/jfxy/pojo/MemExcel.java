package com.jfxy.pojo;

import java.util.List;

public class MemExcel extends Mem{
	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	private String validate;
	
	private List<ExcelField> excelFields;

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public List<ExcelField> getExcelFields() {
		return excelFields;
	}

	public void setExcelFields(List<ExcelField> excelFields) {
		this.excelFields = excelFields;
	}
	
	
	
}
