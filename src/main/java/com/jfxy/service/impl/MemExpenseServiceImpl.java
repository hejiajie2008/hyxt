package com.jfxy.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jfxy.constant.MemConstant;
import com.jfxy.constant.PrefixConstant;
import com.jfxy.dao.MemDao;
import com.jfxy.dao.MemcountdetailDao;
import com.jfxy.dao.MemlevelDao;
import com.jfxy.dao.MemrechargeDao;
import com.jfxy.dao.MemstoragetimingDao;
import com.jfxy.dao.OrderdetailDao;
import com.jfxy.dao.OrderlogDao;
import com.jfxy.dao.PointlogDao;
import com.jfxy.pojo.ExpenseDatailPojo;
import com.jfxy.pojo.ExpensePojo;
import com.jfxy.pojo.GoodsClassRebat;
import com.jfxy.pojo.Goodsnumber;
import com.jfxy.pojo.Mem;
import com.jfxy.pojo.MemExcel;
import com.jfxy.pojo.Memcountdetail;
import com.jfxy.pojo.Memlevel;
import com.jfxy.pojo.Memrecharge;
import com.jfxy.pojo.Memstoragetiming;
import com.jfxy.pojo.Orderdetail;
import com.jfxy.pojo.Orderlog;
import com.jfxy.pojo.Pointlog;
import com.jfxy.pojo.form.MemFormBean;
import com.jfxy.pojo.form.MemcountdetailFormBean;
import com.jfxy.pojo.form.MemlevelFormBean;
import com.jfxy.pojo.form.MemrechargeFormBean;
import com.jfxy.pojo.form.MemstoragetimingFormBean;
import com.jfxy.pojo.form.OrderlogFormBean;
import com.jfxy.service.MemExpenseService;
import com.jfxy.service.MemService;
import com.jfxy.util.Md5Utils;

import scala.collection.generic.BitOperations.Int;

/**
 * 
 * 会员模块业务层
 * 
 * @author hejiajie
 * @version 2.0, 2016年3月8日
 */
@Service("memExpenseService")
public class MemExpenseServiceImpl implements MemExpenseService {

	@Resource
	private MemDao memDao;

	@Resource
	private MemlevelDao memlevelDao;

	@Resource
	private MemrechargeDao memrechargeDao;
	@Resource
	private OrderlogDao orderlogDao;

	@Resource
	private MemcountdetailDao memcountdetailDao;

	@Resource
	private OrderdetailDao orderdetailDao;

	@Resource
	private MemstoragetimingDao memstoragetimingDao;

	@Resource
	private PointlogDao pointlogDao;

	public void saveExpense(Orderlog orderlog) {

		Mem mem = new Mem();
		mem.setMemid(orderlog.getOrdermemid());
		List<ExpenseDatailPojo> detail = orderlog.getDetail();

		for (ExpenseDatailPojo pojo : detail) {

			orderlog.setOrderiscard(pojo.getIsCard());
			orderlog.setOrderisbink(pojo.getIsBink());
			orderlog.setOrderiscash(pojo.getIsCash());
			orderlog.setOrderpaycard(pojo.getCardMoney());
			orderlog.setOrderpaybink(pojo.getBinkMoney());
			orderlog.setOrderpaycash(pojo.getCashMoney());
			orderlog.setOrderpaycoupon(pojo.getCouponMoney());
			// orderlog.setOrderpaytype(pojo.getPayType());
			/**
			 * if(pojo.getPayType().equals(PrefixConstant.ExpensePrefix_String)){
			 * orderlog.setOrderpaytype(PrefixConstant.ExpensePrefix_Int); }
			 **/
			orderlog.setOrderdiscountmoney(pojo.getDiscountMoney());
			orderlog.setOrdertotalmoney(pojo.getChangeMoney());
			if (pojo.getIsCard() > 0) {
				BigDecimal money = pojo.getCardMoney();
				if (money.compareTo(BigDecimal.ZERO) > 0) {
					mem.setMemmoney(new BigDecimal("-" + money));

				}

			}
		}

		if (orderlog.getOrderpoint() > 0) {
			mem.setMempoint(orderlog.getOrderpoint());
		}
		orderlogDao.insert(orderlog);
		if (mem.getMemmoney() != null || mem.getMempoint() != null) {
			memDao.updateMemMoney(mem);
		}

	}

	public void saveCountExpense(Orderlog orderlog) {
		Mem mem = new Mem();
		mem.setMemid(orderlog.getOrdermemid());
		List<ExpenseDatailPojo> detail = orderlog.getDetail();

		for (ExpenseDatailPojo pojo : detail) {

			orderlog.setOrderiscard(pojo.getIsCard());
			orderlog.setOrderisbink(pojo.getIsBink());
			orderlog.setOrderiscash(pojo.getIsCash());
			orderlog.setOrderpaycard(pojo.getCardMoney());
			orderlog.setOrderpaybink(pojo.getBinkMoney());
			orderlog.setOrderpaycash(pojo.getCashMoney());
			orderlog.setOrderpaycoupon(pojo.getCouponMoney());
			// orderlog.setOrderpaytype(pojo.getPayType());

			if (pojo.getPayType().equals(PrefixConstant.CountExpensePrefix_String)) {
				orderlog.setOrderpaytype(PrefixConstant.CountExpensePrefix_Int);
				orderlog.setOrdertype(PrefixConstant.CountExpensePrefix_Int);
			}

			orderlog.setOrderdiscountmoney(pojo.getDiscountMoney());
			orderlog.setOrdertotalmoney(pojo.getChangeMoney());
			if (pojo.getIsCard() > 0) {
				BigDecimal money = pojo.getCardMoney();
				if (money.compareTo(BigDecimal.ZERO) > 0) {
					mem.setMemmoney(new BigDecimal("-" + money));

				}

			}
		}

		if (orderlog.getOrderpoint() > 0) {
			mem.setMempoint(orderlog.getOrderpoint());
		}
		orderlogDao.insert(orderlog);
		/**
		 * if(mem.getMemmoney()!=null||mem.getMempoint()!=null){
		 * memDao.updateMemMoney(mem); }
		 **/

		List<Orderdetail> details = orderlog.getDetails();
		for (Orderdetail d : details) {
			Integer type = d.getGoodstype();
			d.setOrderdetailtype(type);
			if (type == 1) {
				Memcountdetail memcountdetail = new Memcountdetail();
				memcountdetail.setCountdetailmemid(orderlog.getOrdermemid());
				memcountdetail.setGoodsid(d.getGoodsid());
				memcountdetail.setCountdetailtotalnumber(d.getOrderdetailnumber());
				// goodsnumberDao.updateNumber(goodsnumber);
				memcountdetailDao.updateMemCountdetailnumber(memcountdetail);
			}

			d.setOrderid(orderlog.getOrderid());

			orderdetailDao.insert(d);

		}

	}

	public OrderlogFormBean getPage(OrderlogFormBean orderlogFormBean) {
		// TODO Auto-generated method stub

		int total = orderlogDao.count(orderlogFormBean);
		orderlogFormBean.setTotal(total);
		List<Orderlog> rows = orderlogDao.pageList(orderlogFormBean);
		orderlogFormBean.setDatas(rows);
		return orderlogFormBean;
	}

	public MemcountdetailFormBean queryServingProductPage(MemcountdetailFormBean memcountdetailFormBean) {
		int total = memcountdetailDao.queryServingProductCount(memcountdetailFormBean);
		memcountdetailFormBean.setTotal(total);
		List<Memcountdetail> rows = memcountdetailDao.queryServingProductPageList(memcountdetailFormBean);
		memcountdetailFormBean.setDatas(rows);
		return memcountdetailFormBean;
	}

	public Integer saveMemStorageTiming(Memstoragetiming memstoragetiming) {

		memstoragetimingDao.insert(memstoragetiming);
		return 1;
	}

	public MemstoragetimingFormBean getPage(MemstoragetimingFormBean memstoragetimingFormBean) {
		int total = memstoragetimingDao.count(memstoragetimingFormBean);
		memstoragetimingFormBean.setTotal(total);
		List<Memstoragetiming> rows = memstoragetimingDao.pageList(memstoragetimingFormBean);
		memstoragetimingFormBean.setDatas(rows);
		return memstoragetimingFormBean;
	}

}
