package com.jfxy.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.jfxy.constant.PrefixConstant;
import com.jfxy.dao.MemcustomfieldDao;
import com.jfxy.dao.MemlevelDao;
import com.jfxy.dao.SysareaDao;
import com.jfxy.dao.SysmoduleDao;
import com.jfxy.dao.SysparameterDao;
import com.jfxy.dao.SysshopDao;
import com.jfxy.dao.SysshopauthorityDao;
import com.jfxy.dao.SysuserDao;
import com.jfxy.pojo.ExcelField;
import com.jfxy.pojo.MemExcel;
import com.jfxy.pojo.Memcustomfield;
import com.jfxy.pojo.Memlevel;
import com.jfxy.pojo.Sysarea;
import com.jfxy.pojo.Sysmodule;
import com.jfxy.pojo.Sysparameter;
import com.jfxy.pojo.Sysshop;
import com.jfxy.pojo.Sysshopauthority;
import com.jfxy.pojo.Sysuser;
import com.jfxy.service.impl.GoodsExcelServiceImpl;
import com.jfxy.service.impl.MemExcelServiceImpl;
/**
 * 
 * 内存数据实例化
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月9日
 */
@Service("memoryListener")
public  class  MemoryListener implements InitializingBean,DisposableBean {
	Logger logger=Logger.getLogger(MemoryListener.class);
	@Resource
	private SysshopauthorityDao sysshopauthorityDao;
	@Resource
	private SysshopDao sysshopDao;
	@Resource
	private SysparameterDao sysparameterDao;
	@Resource
	private MemlevelDao memlevelDao;
	@Resource
	private SysmoduleDao sysmoduleDao;
	
	@Resource
	private MemcustomfieldDao memcustomfieldDao;
	
	@Resource
	private SysuserDao sysuserDao;
	
	@Resource
	private SysareaDao sysareaDao;
	
	@Resource
	private  MemExcelServiceImpl memExcelServiceImpl;
	
	@Resource
	private GoodsExcelServiceImpl goodsExcelServiceImpl;
	
	public static String topic="mem_info_kafka";
	
	public static List<Sysshopauthority> listShopIds;
	
	public static List<Sysmodule> listSysmodule;
	
	public static List<Sysshop> listShops;
	public static List<Sysuser> listUser;
	
	public static List<Memlevel> listMemlevels;
	
	public static Map<Integer, String> prefix;
	
	public static Sysparameter sysparameter;
	
	public static Map<String, String> logMap;
	
	public static List<Memcustomfield> memcustomfields;
	
	public static List<Memcustomfield> goodscustomfields;
	public static List<ExcelField> listMemfiled=null;
	public static List<ExcelField> listgoodsfiled=null;
	
	public static List<ExcelField> listgoodsnumberfiled=null;
	public static List<Sysarea> areaList;

	
	
	
	
	public static String projectName="/hyxt";



	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("内存消毁");
	}


	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		logger.info("加载内存");
		MemoryListener.listShopIds=sysshopauthorityDao.list(new Sysshopauthority());
		MemoryListener.listShops=sysshopDao.list(new Sysshop());
		MemoryListener.listMemlevels=memlevelDao.list(new Memlevel());
		reloadSysParameter();
		MemoryListener.listUser=sysuserDao.list(new Sysuser());
		MemoryListener.listSysmodule=sysmoduleDao.findalllist();
		
		MemoryListener.areaList=sysareaDao.list(new Sysarea());
		prefixInit();
		initlog();
		customfieldInit();
		
		initMemFiled();
		
		initExcel();
	}
	
	public static boolean isczshopid(int shopid){
		for(Sysshop shop:MemoryListener.listShops){
			if(shop.getShopid()==shopid){
				return true;
			}
		}
		
		return false;
	}
	
	public void reloadSysParameter(){
		MemoryListener.sysparameter=sysparameterDao.list(new Sysparameter()).get(0);
	}
	
	public  void customfieldInit(){
		Memcustomfield memcustomfield=new Memcustomfield();
		memcustomfield.setCustomtype(1);
		MemoryListener.memcustomfields=memcustomfieldDao.list(memcustomfield);
		memcustomfield.setCustomtype(2);
		MemoryListener.goodscustomfields=memcustomfieldDao.list(memcustomfield);
	}
	
	
	public void prefixInit(){
		prefix=new HashMap<Integer, String>();
		prefix.put(PrefixConstant.MemRechargePrefix_Int, MemoryListener.sysparameter.getMemrechargeprefix());
		prefix.put(PrefixConstant.GiftExchangePrefix_Int, MemoryListener.sysparameter.getGiftexchangeprefix());
		prefix.put(PrefixConstant.GoodsInPrefix_Int, MemoryListener.sysparameter.getGoodsinprefix());
		prefix.put(PrefixConstant.ExpensePrefix_Int, MemoryListener.sysparameter.getExpenseprefix());
		prefix.put(PrefixConstant.MemPointChangePrefix_Int, MemoryListener.sysparameter.getMempointchangeprefix());
		prefix.put(PrefixConstant.MemDrawMoneyPrefix_Int, MemoryListener.sysparameter.getMemdrawmoneyprefix());
		prefix.put(PrefixConstant.MemRechargeCountPrefix_Int, MemoryListener.sysparameter.getMemrechargeprefix());
		prefix.put(PrefixConstant.ConsumeMemCountPrefix_Int, MemoryListener.sysparameter.getMemcountexpenseprefix());
		prefix.put(PrefixConstant.Storagetimingprefix_Int, MemoryListener.sysparameter.getStoragetimingprefix());
	}
	
	public void initlog(){
		logMap=new HashMap<String, String>();
		logMap.put("tologin", "用户登录");
	}
	
	
	
	
	public void initMemFiled(){
		
		
		listMemfiled=memcustomfieldDao.listExcel(1);
		listgoodsfiled=memcustomfieldDao.listExcel(2);
		listgoodsnumberfiled=memcustomfieldDao.listExcel(3);
		
		System.out.println(listgoodsnumberfiled);
	}
	
	public void initExcel(){
		memExcelServiceImpl.writeExcel();
		goodsExcelServiceImpl.writeExcel();
		goodsExcelServiceImpl.writeNumberExcel();
	}
	
	
	
	
	
	
	
	
	

}
