package com.jfxy.service;


import org.springframework.transaction.annotation.Transactional;

import com.jfxy.pojo.Memstoragetiming;
import com.jfxy.pojo.Orderlog;
import com.jfxy.pojo.form.MemcountdetailFormBean;
import com.jfxy.pojo.form.MemstoragetimingFormBean;
import com.jfxy.pojo.form.OrderlogFormBean;

/**
 * 
 * 会员模块业务层
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
public interface MemExpenseService {

	
	@Transactional
	public void saveExpense(Orderlog orderlog);
	
	
	public OrderlogFormBean getPage(OrderlogFormBean orderlogFormBean);
	
	public MemcountdetailFormBean queryServingProductPage(MemcountdetailFormBean memcountdetailFormBean);
	
	public void saveCountExpense(Orderlog orderlog);
	

	public Integer saveMemStorageTiming(Memstoragetiming memstoragetiming);
	
	public MemstoragetimingFormBean getPage(MemstoragetimingFormBean memstoragetimingFormBean);
}
