package com.jfxy.pojo;

import java.util.List;

public class GoodsnumberExcel {
	private String validate;
	private List<ExcelField> excelFields;
	
	public GoodsnumberExcel(){
		
	}
	
	/**
	 * 商品代码 <br />
	 * 允许为空 YES <br />
	 * 数据长度 50<br />
	 */
	private String goodscode;
	
	/**
	 * 商品名称 <br />
	 * 允许为空 YES <br />
	 * 数据长度 100<br />
	 */
	private String name;
	
	private Integer goodsnumber;
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
	public String getGoodscode() {
		return goodscode;
	}
	public void setGoodscode(String goodscode) {
		this.goodscode = goodscode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGoodsnumber() {
		return goodsnumber;
	}
	public void setGoodsnumber(Integer goodsnumber) {
		this.goodsnumber = goodsnumber;
	}
	
	
	
}
