package com.jfxy.pojo;

import java.math.BigDecimal;

public class ExpenseDatailPojo {
	private String payType;                        
	private Short IsCard;                         
	private Short IsCash;                         
	private Short IsBink;                         
	private BigDecimal CardMoney;                      
	private BigDecimal CashMoney;                      
	private BigDecimal CouponMoney;                    
	private BigDecimal BinkMoney;                      
	private BigDecimal DiscountMoney;                  
	private BigDecimal ChangeMoney;
	
	
	public Short getIsCard() {
		return IsCard;
	}
	public void setIsCard(Short isCard) {
		IsCard = isCard;
	}
	public Short getIsCash() {
		return IsCash;
	}
	public void setIsCash(Short isCash) {
		IsCash = isCash;
	}
	public Short getIsBink() {
		return IsBink;
	}
	public void setIsBink(Short isBink) {
		IsBink = isBink;
	}
	public BigDecimal getCardMoney() {
		return CardMoney;
	}
	public void setCardMoney(BigDecimal cardMoney) {
		CardMoney = cardMoney;
	}
	public BigDecimal getCashMoney() {
		return CashMoney;
	}
	public void setCashMoney(BigDecimal cashMoney) {
		CashMoney = cashMoney;
	}
	public BigDecimal getCouponMoney() {
		return CouponMoney;
	}
	public void setCouponMoney(BigDecimal couponMoney) {
		CouponMoney = couponMoney;
	}
	public BigDecimal getBinkMoney() {
		return BinkMoney;
	}
	public void setBinkMoney(BigDecimal binkMoney) {
		BinkMoney = binkMoney;
	}
	public BigDecimal getDiscountMoney() {
		return DiscountMoney;
	}
	public void setDiscountMoney(BigDecimal discountMoney) {
		DiscountMoney = discountMoney;
	}
	public BigDecimal getChangeMoney() {
		return ChangeMoney;
	}
	public void setChangeMoney(BigDecimal changeMoney) {
		ChangeMoney = changeMoney;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	           
	   

}
