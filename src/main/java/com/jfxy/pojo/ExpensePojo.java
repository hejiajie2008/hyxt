package com.jfxy.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExpensePojo {

	
	private String chknomember;
	private BigDecimal money;
	

	private String sendsms;
	private String istimeexpense;
	private String myremark;
	private String project;
	private String endtime;
	
	private Integer number;
	
	private List<ExpenseDatailPojo> detail=new ArrayList<ExpenseDatailPojo>();
	
	public String getChknomember() {
		return chknomember;
	}
	public void setChknomember(String chknomember) {
		this.chknomember = chknomember;
	}
	
	
	
	
	
	public String getSendsms() {
		return sendsms;
	}
	public void setSendsms(String sendsms) {
		this.sendsms = sendsms;
	}
	public String getIstimeexpense() {
		return istimeexpense;
	}
	public void setIstimeexpense(String istimeexpense) {
		this.istimeexpense = istimeexpense;
	}
	public String getMyremark() {
		return myremark;
	}
	public void setMyremark(String myremark) {
		this.myremark = myremark;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public List<ExpenseDatailPojo> getDetail() {
		return detail;
	}
	public void setDetail(List<ExpenseDatailPojo> detail) {
		this.detail = detail;
	}
	
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	

	
	
	

}
