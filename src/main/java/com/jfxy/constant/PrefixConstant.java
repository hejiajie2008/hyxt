package com.jfxy.constant;
/**
 * 
 * 前缀设置
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月11日
 */
public interface PrefixConstant {
	/**
	 * 会员充值前缀
	 */
	public int MemRechargePrefix_Int=1;
	/**
	 * 礼品兑换前缀（默认为gd）
	 */
	public int GiftExchangePrefix_Int=2;
	/**
	 * 商品入库前缀（默认为tt）
	 */
	public int GoodsInPrefix_Int=3;
	
	/**
	 * 会员积分变动前缀
	 */
	public int MemPointChangePrefix_Int=4;
	
	
	//会员提现前缀
	public int MemDrawMoneyPrefix_Int=5;
	
	/**
	 * 会员充次前缀
	 */
	public int MemRechargeCountPrefix_Int=6;
	
	/**
	 * 会员计次消费订单前缀
	 */
	public int ConsumeMemCountPrefix_Int=7;
	/**
	 * 会员充时前缀
	 */
	public int Storagetimingprefix_Int=8;
	
	
	
	/**
	 * 快递消费前缀
	 */
	public int ExpensePrefix_Int=0;
	
	public String ExpensePrefix_String="Expense";
	
	public String EmptyBillsPrefix_String="EmptyBills";
	
	public String MemCountPrefix_String="MemCount";
	
	public String CountExpensePrefix_String="CountExpense";
	
	public int MemCountPrefix_Int=0;
	
	
	public int EmptyBillsPrefix_Int=3;
	
	public int CountExpensePrefix_Int=7;
	
	public String GoodsExpensePrefix_String="GoodsExpense";
	
	public int GoodsExpensePrefix_Int=2;
	
	
	public String MemPointChangePrefix_String="MemPointChangePrefix";
	
	
	
	


}
