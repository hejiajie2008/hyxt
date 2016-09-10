package com.jfxy.pojo;

import java.util.List;

public class GoodsExcel extends Goods{
	private String validate;
	private List<ExcelField> excelFields;
	
	public GoodsExcel(){
		
	}
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
	
	public void setAll(){
		
	}
	
	
	
}
