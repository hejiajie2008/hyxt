package com.jfxy.service.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.jfxy.constant.MemConstant;
import com.jfxy.constant.PrefixConstant;
import com.jfxy.dao.GoodsnumberDao;
import com.jfxy.dao.MemDao;
import com.jfxy.dao.MemcountDao;
import com.jfxy.dao.MemcountdetailDao;
import com.jfxy.dao.MemdrawmoneyDao;
import com.jfxy.dao.MemlevelDao;
import com.jfxy.dao.MemrechargeDao;
import com.jfxy.dao.PointlogDao;
import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Batch;
import com.jfxy.pojo.ExcelField;
import com.jfxy.pojo.ExpenseDatailPojo;
import com.jfxy.pojo.GoodsClassRebat;
import com.jfxy.pojo.Goodsnumber;
import com.jfxy.pojo.Mem;
import com.jfxy.pojo.MemChangeCard;
import com.jfxy.pojo.MemExcel;
import com.jfxy.pojo.Memcount;
import com.jfxy.pojo.Memcountdetail;
import com.jfxy.pojo.Memcustomfield;
import com.jfxy.pojo.Memdrawmoney;
import com.jfxy.pojo.Memlevel;
import com.jfxy.pojo.Memrecharge;
import com.jfxy.pojo.Orderdetail;
import com.jfxy.pojo.Pointlog;
import com.jfxy.pojo.SendCards;
import com.jfxy.pojo.Sysuser;
import com.jfxy.pojo.form.MemFormBean;
import com.jfxy.pojo.form.MemlevelFormBean;
import com.jfxy.pojo.form.MemrechargeFormBean;
import com.jfxy.service.MemService;
import com.jfxy.util.DateUtil;
import com.jfxy.util.EhcacheUtil;
import com.jfxy.util.Md5Utils;
import com.jfxy.util.StringUtil;
/**
 * 
 * 会员模块业务层
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
@Service("memService")
public class MemServiceImpl implements MemService{

	
	
	@Resource
	private MemDao memDao;
	
	@Resource
	private MemcountDao memcountDao;
	
	@Resource
	private GoodsnumberDao goodsnumberDao;
	
	
	@Resource
	private MemcountdetailDao memcountdetailDao;
	@Resource
	private MemlevelDao memlevelDao;
	
	@Resource
	private MemrechargeDao memrechargeDao;
	
	@Resource
	private PointlogDao pointlogDao;
	
	@Resource
	private MemdrawmoneyDao memdrawmoneyDao;
	@Resource
	private DataSource dataSource;
	/**
	 * 创建单个会员业务方法
	 * @param mem
	 * @return
	 * [0系统异常，未保存数据，请再次点击保存！
	 * -1 此卡号已经在系统中存在，请重新输入卡号，然后重试！
	 * -2此手机号码已经在系统中存在，请重新输入手机号，然后重试！
	 * -3保存成功，短信余额不足，不能发送短信，请充值短信！
	 * -4会员已经存在其他数据异动，不能修改创建时间！
	 * -5系统错误 请与系统管理员联系！
	 * -6此卡面号码已经在系统中存在，请重新输入卡面号码，然后重试！
	 * -7该卡不在发卡范围内，请与总店联系！
	 * -8该店铺剩余可用积分不足，请重新填写！
	 * other 成功！]
	 */
	public Integer createMem(Mem mem) {
		
		if(memDao.validateMemCard(mem.getMemcard())>0){
			return -1;
		}else if(mem.getMemmobile()!=null&&mem.getMemmobile().length()>0&&memDao.validateMobile(mem.getMemmobile())>0){
			return -2;
		}else{
			mem.setMemmoney(new BigDecimal(0));
			mem.setMemconsumemoney(new BigDecimal(0));
			if(mem.getMemstate()==null){
				mem.setMemstate(0);
			}
			if(mem.getMempoint()==null){
				mem.setMempoint(0);
			}
			String mempassword=mem.getMempassword();
			mem.setMempassword(Md5Utils.encrypt(mempassword));
			memDao.createMem(mem);
			
			return 1;
		}
		

	}
	
	
	
	public boolean createMem(List<Mem>  mems){
		for(Mem mem:mems){
			memDao.createMem(mem);
		}
		return true;
	}
	
	public boolean createMemExcel(List<MemExcel>  mems){
		Batch batchMem=new Batch();
		
		
		int ishead=0;
		List<Object> memArr=new ArrayList<Object>();
		Map<String,String> head=new HashMap<String, String>();
		
		for(MemExcel memExcel:mems){
			
			
			
			
			Map<String, String> map=new HashMap<String, String>();
			
			List<ExcelField> list=memExcel.getExcelFields();
			for(ExcelField excelField:list){
				String value=null;
				if(null==excelField.getFieldvalue()){
					value=null;
				}else if("".equals(excelField.getFieldvalue())){
					value=null;
				}else{
					value=excelField.getFieldvalue();
				}
				map.put(excelField.getField(),value);
				if(ishead==0){
					head.put(excelField.getField(),null);
					
				}
				
				
			}
			ishead=1;
			memExcel.setMap(map);
			Mem mem=memExcel;
			memArr.add(mem);
			
		}
		batchMem.setHead(head);
		batchMem.setListvalue(memArr);
		memDao.batchCreateMem(batchMem);
		List<Memdrawmoney> memdrawmoneyList=new ArrayList<Memdrawmoney>();
		for(MemExcel memExcel:mems){
			if(memExcel.getMemmoney().compareTo(BigDecimal.ZERO) > 0){
				Memdrawmoney memdrawmoney=new Memdrawmoney();
				memdrawmoney.setDrawmoney(memExcel.getMemmoney());
				memdrawmoney.setDrawactualmoney(memdrawmoney.getDrawmoney());
				memdrawmoney.setMemcard(memExcel.getMemcard());
				memdrawmoney.setDrawmoneycreatetime(new Date());
				memdrawmoney.setDrawmoneymemid(1);
				memdrawmoney.setDrawmoneyaccount(MemoryListener.prefix.get(PrefixConstant.MemDrawMoneyPrefix_Int)+DateUtil.dateRandom());
				memdrawmoney.setDrawmoneyremark("会员导入金额充值：充值金额："+memdrawmoney.getDrawmoney());
				memdrawmoney.setDrawmoneyshopid(memExcel.getMemshopid());
				memdrawmoney.setDrawmoneyuserid(memExcel.getMemuserid());
				memdrawmoneyList.add(memdrawmoney);
			}
		}
		memdrawmoneyDao.batchCreateMemdrawmoney(memdrawmoneyList);
		
		
		return true;
	}
	/**
	 * 以分页的方式获取会员列表
	 * @param memFormBean
	 * @return
	 */
	public MemFormBean getPage(MemFormBean memFormBean) {
		int total = memDao.getMemCount(memFormBean);
		memFormBean.setTotal(total);
		List<Mem> rows =new ArrayList<Mem>();
		Connection conn=null;
		PreparedStatement pre=null;
		try {
			
			 conn= dataSource.getConnection();
			StringBuffer sqlsb=new StringBuffer();
			sqlsb.append("select ");
			sqlsb.append("MemID, MemCard, MemPassword, MemName, MemSex, MemIdentityCard, MemMobile, MemPhoto, "+
    "MemBirthdayType, MemBirthday, MemIsPast, MemPastTime, MemPoint, MemPointAutomatic, "+
    "MemMoney, MemConsumeMoney, MemConsumeLastTime, MemConsumeCount, MemEmail, MemAddress,"+ 
    "MemState, MemRecommendID, MemLevelID, MemShopID, MemCreateTime, MemRemark, MemUserID, "+
    "MemTelePhone, MemQRCode, MemProvince, MemCity, MemCounty, MemVillage, MemQuestion,"+ 
    "MemAnswer, MemWeiXinCard, MemCardNumber, MemAttention, MemWeiXinCards");
			
			List<Memcustomfield> list=MemoryListener.memcustomfields;
			
			for(Memcustomfield mc:list){
				sqlsb.append(",").append(mc.getCustomfield());
			}
			
			
			
			sqlsb.append(" ,sysshop.ShopName,memlevel.LevelName,sysuser.UserName FROM mem  left join sysshop on mem.MemShopID=sysshop.ShopID left join memlevel on mem.MemLevelID=memlevel.LevelID left join sysuser on mem.MemUserID=sysuser.UserID ");
			
			Integer memlevelid=memFormBean.getMemlevelid();
			Boolean iswhere=Boolean.TRUE;
			if(null!=memlevelid&&memlevelid!=0){
				if(iswhere){
					sqlsb.append(" where ");
					iswhere=Boolean.FALSE;
				}else{
					sqlsb.append(" and ");
				}
				sqlsb.append(" memlevelid ="+memFormBean.getMemlevelid());
			}
			String memcardl=memFormBean.getMemcardl();
			if(null!=memcardl&&!"".equals(memcardl)){
				if(iswhere){
					sqlsb.append(" where ");
					iswhere=Boolean.FALSE;
				}else{
					sqlsb.append(" and ");
				}
				sqlsb.append(" memcard like  '%").append(memcardl).append("%' ");
			}

			String memcard=memFormBean.getMemcard();
			
			if(null!=memcard&&!"".equals(memcard)){
				if(iswhere){
					sqlsb.append(" where ");
					iswhere=Boolean.FALSE;
				}else{
					sqlsb.append(" and ");
				}
				sqlsb.append(" memcard='").append(memcard).append("' ");
			}
			
			Integer memshopid=memFormBean.getMemshopid();
			if(null!=memshopid){
				if(iswhere){
					sqlsb.append(" where ");
					iswhere=Boolean.FALSE;
				}else{
					sqlsb.append(" and ");
				}
				sqlsb.append(" memshopid='").append(memshopid).append("' ");
			}
			List<Integer> memshopids=memFormBean.getMemshopids();
			if(null!=memshopids){
				if(iswhere){
					sqlsb.append(" where ");
					iswhere=Boolean.FALSE;
				}else{
					sqlsb.append(" and ");
				}
				sqlsb.append(" memshopid in '(").append(memshopid);
				int size=memshopids.size();
				for(int i=0;i<size;i++){
					if(i==size-1){
						sqlsb.append(memshopids.get(i));
					}else{
						sqlsb.append(memshopids.get(i)).append(",");
					}
				}
				sqlsb.append("' ");
				
				
			}

			sqlsb.append(" LIMIT ").append(memFormBean.getFirstResult())
			.append(",").append(memFormBean.getPageSize());
			 pre=conn.prepareStatement(sqlsb.toString());
			
			ResultSet rs= pre.executeQuery();
			while(rs.next()){
				Mem mem=new Mem();
				mem.setShopname(rs.getString("ShopName"));
				mem.setLevelname(rs.getString("LevelName"));
				mem.setUsername(rs.getString("UserName"));
				mem.setMemid(rs.getInt("MemID"));
				mem.setMemcard(rs.getString("MemCard"));
				mem.setMempassword(rs.getString("MemPassword"));
				mem.setMemname(rs.getString("MemName"));
				mem.setMemsex(rs.getInt("MemSex"));
				mem.setMemidentitycard(rs.getString("MemIdentityCard"));
				mem.setMemmobile(rs.getString("MemMobile"));
				mem.setMemphoto(rs.getString("MemPhoto"));
				mem.setMembirthdaytype(rs.getInt("MemBirthdayType"));
				mem.setMembirthday(rs.getString("MemBirthday"));
				mem.setMemispast(rs.getInt("MemIsPast"));
				mem.setMempasttime(rs.getString("MemPastTime"));
				mem.setMempoint(rs.getInt("MemPoint"));
				mem.setMempointautomatic(rs.getInt("MemPointAutomatic"));
				mem.setMemmoney(rs.getBigDecimal("MemMoney"));
				mem.setMemconsumemoney(rs.getBigDecimal("MemConsumeMoney"));
				mem.setMemconsumelasttime(rs.getTimestamp("MemConsumeLastTime"));
				

				mem.setMemconsumecount(rs.getInt("MemConsumeCount"));
				mem.setMememail(rs.getString("MemEmail"));
				mem.setMemaddress(rs.getString("MemAddress"));
				mem.setMemstate(rs.getInt("MemState"));
				mem.setMemrecommendid(rs.getInt("MemRecommendID"));
				mem.setMemlevelid(rs.getInt("MemLevelID"));
				mem.setMemshopid(rs.getInt("MemShopID"));
				mem.setMemcreatetime(rs.getDate("MemCreateTime"));
				mem.setMemremark(rs.getString("MemRemark"));
				mem.setMemuserid(rs.getInt("MemUserID"));
				mem.setMemtelephone(rs.getString("MemTelePhone"));
				mem.setMemqrcode(rs.getString("MemQRCode"));
				mem.setMemprovince(rs.getString("MemProvince"));
				mem.setMemcity(rs.getString("MemCity"));
				mem.setMemcounty(rs.getString("MemCounty"));
				mem.setMemvillage(rs.getString("MemVillage"));
				mem.setMemquestion(rs.getString("MemQuestion"));
				mem.setMemanswer(rs.getString("MemAnswer"));
				mem.setMemweixincard(rs.getString("MemWeiXinCard"));
				mem.setMemcardnumber(rs.getString("MemCardNumber"));
				mem.setMemattention(rs.getInt("MemAttention"));
				mem.setMemweixincards(rs.getString("MemWeiXinCards"));
				Map<String, String> map=new HashMap<String, String>();
				for(Memcustomfield mc:list){
					String value=rs.getString(mc.getCustomfield());
					map.put(mc.getCustomfield(), value);
				}
				mem.setMap(map);
				rows.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pre!=null){
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//List<Mem> rows = memDao.getMemList(memFormBean);
		memFormBean.setDatas(rows);
		

		return memFormBean;
	}
	
	/**
	 * 以分页的方式获取会员等级列表
	 * @param memLevelFormBean
	 * @return
	 */
	public MemlevelFormBean getPage(MemlevelFormBean memLevelFormBean) {

		int total = memlevelDao.count(memLevelFormBean);
		memLevelFormBean.setTotal(total);
		List<Memlevel> rows = memlevelDao.pageList(memLevelFormBean);
		memLevelFormBean.setDatas(rows);

		return memLevelFormBean;
	}
	
	/**
	 * 获取会员等级列表
	 * @return
	 */
	public List<Memlevel> getList() {
		List<Memlevel> rows = memlevelDao.list(new Memlevel());
		
		return rows;
	}
	/**
	 * 删除会员
	 * @param memId
	 * @return
	 */
	public boolean deleteMem(long memId) {
		memDao.deleteMem(memId);
		return true;

	}
	/**
	 * 保存会员等级设置
	 * @param memlevel
	 */
	
	public void saveMemLevel(Memlevel memlevel) {
		memlevelDao.insert(memlevel);
		int memlevelid=memlevel.getLevelid();
		List<GoodsClassRebat> goodsClassRabatList=memlevel.getGoodsClassRabatList();
		for(GoodsClassRebat goodsClassRebat:goodsClassRabatList){
			goodsClassRebat.setMemlevelid(memlevelid);
			memlevelDao.insertRebat(goodsClassRebat);
		}
		

	}
	/**
	 * 修改会员等级
	 * @param memlevel
	 */
	
	public void updateMemLevel(Memlevel memlevel){
		memlevelDao.update(memlevel);
		List<GoodsClassRebat> goodsClassRabatList=memlevel.getGoodsClassRabatList();
		for(GoodsClassRebat goodsClassRebat:goodsClassRabatList){
		
			
			memlevelDao.updateRabat(goodsClassRebat);
		}
		
		
	}
	/**
	 * 修改会员
	 * @param mem
	 */
	public void updateMem(Mem mem){
		memDao.updateMem(mem);
	}
	/**
	 * 查找会员等级
	 * @param memlevelid
	 * @return
	 */
	public Memlevel findMemLevel(int memlevelid){
		return memlevelDao.findbyId(memlevelid);
	}
	/**
	 * 查找会员根据会员ID
	 * @param memid
	 * @return
	 */
	public Mem findMem(Long  memid){
		
		Mem mem=new Mem();
		Connection conn=null;
		PreparedStatement pre=null;
try {
			
			 conn= dataSource.getConnection();
			StringBuffer sqlsb=new StringBuffer();
			sqlsb.append("select ");
			sqlsb.append("MemID, MemCard, MemPassword, MemName, MemSex, MemIdentityCard, MemMobile, MemPhoto, "+
    "MemBirthdayType, MemBirthday, MemIsPast, MemPastTime, MemPoint, MemPointAutomatic, "+
    "MemMoney, MemConsumeMoney, MemConsumeLastTime, MemConsumeCount, MemEmail, MemAddress,"+ 
    "MemState, MemRecommendID, MemLevelID, MemShopID, MemCreateTime, MemRemark, MemUserID, "+
    "MemTelePhone, MemQRCode, MemProvince, MemCity, MemCounty, MemVillage, MemQuestion,"+ 
    "MemAnswer, MemWeiXinCard, MemCardNumber, MemAttention, MemWeiXinCards");
			
			List<Memcustomfield> list=MemoryListener.memcustomfields;
			
			for(Memcustomfield mc:list){
				sqlsb.append(",").append(mc.getCustomfield());
			}
			
			
			
			sqlsb.append("  FROM mem  ");
			
			
			
			
			
			sqlsb.append(" where MemID=").append(memid);
			

			
			 pre=conn.prepareStatement(sqlsb.toString());
			
			ResultSet rs= pre.executeQuery();
			if(rs.next()){
				
				
				mem.setMemid(rs.getInt("MemID"));
				mem.setMemcard(rs.getString("MemCard"));
				mem.setMempassword(rs.getString("MemPassword"));
				mem.setMemname(rs.getString("MemName"));
				mem.setMemsex(rs.getInt("MemSex"));
				mem.setMemidentitycard(rs.getString("MemIdentityCard"));
				mem.setMemmobile(rs.getString("MemMobile"));
				mem.setMemphoto(rs.getString("MemPhoto"));
				mem.setMembirthdaytype(rs.getInt("MemBirthdayType"));
				mem.setMembirthday(rs.getString("MemBirthday"));
				mem.setMemispast(rs.getInt("MemIsPast"));
				mem.setMempasttime(rs.getString("MemPastTime"));
				mem.setMempoint(rs.getInt("MemPoint"));
				mem.setMempointautomatic(rs.getInt("MemPointAutomatic"));
				mem.setMemmoney(rs.getBigDecimal("MemMoney"));
				mem.setMemconsumemoney(rs.getBigDecimal("MemConsumeMoney"));
				mem.setMemconsumelasttime(rs.getTimestamp("MemConsumeLastTime"));
				

				mem.setMemconsumecount(rs.getInt("MemConsumeCount"));
				mem.setMememail(rs.getString("MemEmail"));
				mem.setMemaddress(rs.getString("MemAddress"));
				mem.setMemstate(rs.getInt("MemState"));
				mem.setMemrecommendid(rs.getInt("MemRecommendID"));
				mem.setMemlevelid(rs.getInt("MemLevelID"));
				mem.setMemshopid(rs.getInt("MemShopID"));
				mem.setMemcreatetime(rs.getDate("MemCreateTime"));
				mem.setMemremark(rs.getString("MemRemark"));
				mem.setMemuserid(rs.getInt("MemUserID"));
				mem.setMemtelephone(rs.getString("MemTelePhone"));
				mem.setMemqrcode(rs.getString("MemQRCode"));
				mem.setMemprovince(rs.getString("MemProvince"));
				mem.setMemcity(rs.getString("MemCity"));
				mem.setMemcounty(rs.getString("MemCounty"));
				mem.setMemvillage(rs.getString("MemVillage"));
				mem.setMemquestion(rs.getString("MemQuestion"));
				mem.setMemanswer(rs.getString("MemAnswer"));
				mem.setMemweixincard(rs.getString("MemWeiXinCard"));
				mem.setMemcardnumber(rs.getString("MemCardNumber"));
				mem.setMemattention(rs.getInt("MemAttention"));
				mem.setMemweixincards(rs.getString("MemWeiXinCards"));
				Map<String, String> map=new HashMap<String, String>();
				for(Memcustomfield mc:list){
					String value=rs.getString(mc.getCustomfield());
					map.put(mc.getCustomfield(), value);
				}
				mem.setMap(map);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pre!=null){
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		return mem;
	}
	/**
	 * 查找会员，参数以memFormBean提供的参数为准
	 * @param memFormBean
	 * @return
	 */
	public List<Mem> findMem(MemFormBean memFormBean){
		List<Mem> list=memDao.getMemList(memFormBean);
		
		
		
		return list;
	}
	/**
	 * 删除会员级别
	 * @param memLevelId
	 * @param shopid
	 */
	
	public void deleteMemLevel(int memLevelId,int shopid) {
		memlevelDao.deleteById(memLevelId);
		
		GoodsClassRebat goodsClassRebat=new GoodsClassRebat();
		goodsClassRebat.setMemlevelid(memLevelId);
		goodsClassRebat.setShopid(shopid);
		memlevelDao.deleteRabat(goodsClassRebat);

	}
	/**
	 * 查询商品分类积分比例信息(用于新建)
	 * @param map
	 * @return
	 */
	public List<GoodsClassRebat> queryGoodsClass(Map<String, Integer> map){
		return memlevelDao.queryGoodsClass(map);
	}
	/**
	 * 查询商品分类积分比例信息（用于修改）
	 * @param map
	 * @return
	 */
	public List<GoodsClassRebat> queryGoodsClassforA(Map<String, Integer> map){
		return memlevelDao.queryGoodsClassforA(map);
	}
	
	/**
	 * 获取会员充值数据
	 * @param memrechargeFormBean
	 * @return
	 */
	public MemrechargeFormBean getPage(MemrechargeFormBean memrechargeFormBean){
		int total = memrechargeDao.count(memrechargeFormBean);
		memrechargeFormBean.setTotal(total);
		List<Memrecharge> rows = memrechargeDao.pageList(memrechargeFormBean);
		memrechargeFormBean.setDatas(rows);
		return memrechargeFormBean;
	}
	/**
	 * 保存会员充值信息
	 * @param memrecharge
	 */
	
	public void saveMemRecharge(Memrecharge memrecharge) {
		
		
		
		
		
		Mem mem=new Mem();
		mem.setMemid(memrecharge.getRechargememid());
		
		
		BigDecimal addmoney=memrecharge.getRechargemoney();
		mem.setMemmoney(addmoney);
	
		
		mem.setMempoint(memrecharge.getRechargepoint());
		memDao.updateMemMoney(mem);
		
		mem=memDao.queryMembyId(mem.getMemid());
		
		memrecharge.setRechargecardbalance(mem.getMemmoney());
		memrechargeDao.insert(memrecharge);
		if(memrecharge.getRechargepoint()!=null&&memrecharge.getRechargepoint()>0){
			Pointlog pointlog=new Pointlog();
			pointlog.setPointuserid(memrecharge.getRechargeuserid());
			
			pointlog.setPointchangetype(MemConstant.pointChangeType_recharge);
			pointlog.setPointmemid(memrecharge.getRechargememid());
			pointlog.setPointshopid(memrecharge.getRechargeshopid());
			pointlog.setPointnumber(memrecharge.getRechargepoint());
			pointlog.setPointordercode(memrecharge.getRechargeaccount());
			pointlog.setPointgivememid(0);
			pointlog.setPointremark("会员充值，充值金额：["+memrecharge.getRechargemoney()+"],获得积分：["+memrecharge.getRechargepoint()+"] ");
			pointlogDao.insert(pointlog);
		}
		
		

	}
	
	
	public Integer saveDrawMoney(Memdrawmoney memdrawmoney){
		Mem mem=new Mem();
		mem.setMemid(memdrawmoney.getDrawmoneymemid());
		memdrawmoneyDao.insert(memdrawmoney);
		
		BigDecimal drawMoney=memdrawmoney.getDrawactualmoney();
		mem.setMemmoney(new BigDecimal("-" + drawMoney));
		memDao.updateMemMoney(mem);
		
		return 1;
	}
	public Integer changeCard(MemChangeCard memChangeCard){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("memid", memChangeCard.getMemid());
		map.put("mempassword", EhcacheUtil.quckmd5Password(memChangeCard.getOldpwd()));
		int result=memDao.validateMemCardpassword(map);
		if(result>0){
			
			if(memDao.validateMemCard(memChangeCard.getNewcard())>0){
				return -4;
			}
			Mem mem=new Mem();
			mem.setMemid(memChangeCard.getMemid());
			mem.setMemcard(memChangeCard.getNewcard());
			//mem.setMemcardnumber(memChangeCard.getNewcardnumber());
			mem.setMempassword(EhcacheUtil.quckmd5Password(memChangeCard.getNewpwd()));
			
			memDao.updateMemCard(mem);
			return 1;
		}else{
			return -3;
		}
		
		
		
	}
	
	public Integer changePwd(MemChangeCard memChangeCard){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("memid", memChangeCard.getMemid());
		map.put("mempassword", EhcacheUtil.quckmd5Password(memChangeCard.getOldpwd()));
		int result=memDao.validateMemCardpassword(map);
		if(result>0){
			Mem mem=new Mem();
			mem.setMemid(memChangeCard.getMemid());
			//mem.setMemcard(memChangeCard.getNewcard());
			//mem.setMemcardnumber(memChangeCard.getNewcardnumber());
			mem.setMempassword(EhcacheUtil.quckmd5Password(memChangeCard.getNewpwd()));
			
			memDao.updateMemCard(mem);
			return 1;
		}else{
			return -1;
		}
		
		
		
	}
	public Integer sendCards(SendCards sendCards){
		
		String delcard=sendCards.getDelcard();
		String[] dels=null;
		if(StringUtil.isNotTrimBlank(delcard)){
			dels=delcard.split(",");
		}
		 
		List<Integer> list=new ArrayList<Integer>();
		for(int i=sendCards.getCardstart();i<=sendCards.getCardend();i++){
			if(dels!=null){
				boolean flag=false;
				for(String del:dels){
					if((i+"").contains(del)){
						flag=true;
					}
				}
				if(flag){
					continue;
				}
				
			}
			
			
			list.add(i);
		}
		if(list.size()==0){
			return 0;
		}
		
		
		
		sendCards.setListCard(list);
		sendCards.setPwd(EhcacheUtil.quckmd5Password(sendCards.getPwd()));
		Boolean result=memDao.createMemsplfk(sendCards);
		
		if(result){
			return 1;
		}else{
			return -1;
		}
		
		
		
		
	}
	public Integer saveMemLock(Integer memid,Integer state,String remark){
		
		Mem mem=new Mem();
		mem.setMemid(memid);
		mem.setMemstate(state);
		memDao.updateMemlock(mem);
		
		return 1;
	}
	
	public Integer saveDelayTime(Integer memid,String newPastTime,String remark){
		Mem mem=new Mem();
		mem.setMemid(memid);
		mem.setMempasttime(newPastTime);
		memDao.updateMemDelayTime(mem);
		
		return 1;
	}
	
	
	public Integer  saveMemCount(Memcount memcount){
		Mem mem = new Mem();
		mem.setMemid(memcount.getCountmemid());
		List<ExpenseDatailPojo> detail = memcount.getDetail();
		
		
		Boolean isgdflag=Boolean.FALSE;
		for (ExpenseDatailPojo pojo : detail) {
			memcount.setCountiscard(pojo.getIsCard());
			memcount.setCountisbink(pojo.getIsBink());
			memcount.setCountiscash(pojo.getIsCash());
			memcount.setCountpaycard(pojo.getCardMoney());
			memcount.setCountpaybink(pojo.getBinkMoney());
			memcount.setCountpaycash(pojo.getCashMoney());
			memcount.setCountpaycoupon(pojo.getCouponMoney());
			if(pojo.getPayType().equals(PrefixConstant.MemCountPrefix_String)){
				memcount.setCountpaytype(PrefixConstant.MemCountPrefix_Int);
			}else{
				System.out.println("未找到此类型");
			}
			memcount.setCountdiscountmoney(pojo.getDiscountMoney());
			memcount.setCounttotalmoney(pojo.getChangeMoney());
			if (pojo.getIsCard() > 0) {
				BigDecimal money = pojo.getCardMoney();
				if (money.compareTo(BigDecimal.ZERO) > 0) {
					mem.setMemmoney(new BigDecimal("-" + money));
					mem.setConsumemoney( money);
					mem.setMemconsumecount(1);

				}

			}
		}
		if (memcount.getCountpoint() > 0) {
			mem.setMempoint(memcount.getCountpoint());
		}
		memcountDao.insert(memcount);
		
		List<Memcountdetail> details=memcount.getDetails();
		for(Memcountdetail d:details){
			
			  d.setCountdetailmemid(memcount.getCountmemid());
			  d.setCountdetailtotalnumber(d.getCountdetailnumber());
			  
				Goodsnumber goodsnumber = new Goodsnumber();
				goodsnumber.setShopid(memcount.getCountshopid());
				goodsnumber.setGoodsid(d.getGoodsid());
				goodsnumber.setInnumber(-d.getCountdetailnumber());
				goodsnumberDao.updateNumber(goodsnumber);
			
			
			d.setCountdetailcountid(memcount.getCountid());
			
			
			memcountdetailDao.insert(d);
			
		}
		if(mem.getMemmoney()!=null||mem.getMempoint()!=null){
				memDao.updateMemMoney(mem);
		}
		
		
		
		
		return 1;
	}
	


}
