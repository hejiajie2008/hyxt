package com.jfxy.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SendCards {
	private Integer cardstart;   
	private Integer cardend;     
	private Integer memstate;    
	private String remark;      
	private String delcard;     
	private String pwd;         
	private Integer memlevel;    
	private Integer mempoint;    
	private BigDecimal memmoney;
	private Integer shopid;
	private Integer userid;
	private List<Integer> listCard=null;
	
	
	public Integer getCardstart() {
		return cardstart;
	}
	public void setCardstart(Integer cardstart) {
		this.cardstart = cardstart;
	}
	public Integer getCardend() {
		return cardend;
	}
	public void setCardend(Integer cardend) {
		this.cardend = cardend;
	}
	public Integer getMemstate() {
		return memstate;
	}
	public void setMemstate(Integer memstate) {
		this.memstate = memstate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDelcard() {
		return delcard;
	}
	public void setDelcard(String delcard) {
		this.delcard = delcard;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getMemlevel() {
		return memlevel;
	}
	public void setMemlevel(Integer memlevel) {
		this.memlevel = memlevel;
	}
	public Integer getMempoint() {
		return mempoint;
	}
	public void setMempoint(Integer mempoint) {
		this.mempoint = mempoint;
	}
	public BigDecimal getMemmoney() {
		return memmoney;
	}
	public void setMemmoney(BigDecimal memmoney) {
		this.memmoney = memmoney;
	}
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public List<Integer> getListCard() {
		return listCard;
	}
	public void setListCard(List<Integer> listCard) {
		this.listCard = listCard;
	}   
	
	

}
