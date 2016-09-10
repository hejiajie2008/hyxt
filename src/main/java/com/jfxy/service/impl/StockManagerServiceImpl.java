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

import com.jfxy.constant.PrefixConstant;
import com.jfxy.dao.GoodsDao;
import com.jfxy.dao.GoodsclassDao;
import com.jfxy.dao.GoodslogDao;
import com.jfxy.dao.GoodslogdetailDao;
import com.jfxy.dao.GoodsnumberDao;
import com.jfxy.dao.MemDao;
import com.jfxy.dao.MemlevelDao;
import com.jfxy.dao.OrderdetailDao;
import com.jfxy.dao.OrderlogDao;
import com.jfxy.dao.TimingprojectDao;
import com.jfxy.dao.TimingrulesDao;
import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Batch;
import com.jfxy.pojo.ExcelField;
import com.jfxy.pojo.ExpenseDatailPojo;
import com.jfxy.pojo.Goods;
import com.jfxy.pojo.GoodsClassRebat;
import com.jfxy.pojo.GoodsExcel;
import com.jfxy.pojo.Goodsclass;
import com.jfxy.pojo.Goodslog;
import com.jfxy.pojo.Goodslogdetail;
import com.jfxy.pojo.Goodsnumber;
import com.jfxy.pojo.Mem;
import com.jfxy.pojo.MemExcel;
import com.jfxy.pojo.Memcustomfield;
import com.jfxy.pojo.Memlevel;
import com.jfxy.pojo.Orderdetail;
import com.jfxy.pojo.Orderlog;
import com.jfxy.pojo.Sysshop;
import com.jfxy.pojo.Sysshopauthority;
import com.jfxy.pojo.Timingproject;
import com.jfxy.pojo.Timingrules;
import com.jfxy.pojo.form.GoodsFormBean;
import com.jfxy.pojo.form.GoodsclassFormBean;
import com.jfxy.pojo.form.GoodslogFormBean;
import com.jfxy.pojo.form.MemstoragetimingFormBean;
import com.jfxy.pojo.form.OrderlogFormBean;
import com.jfxy.pojo.form.TimingprojectFormBean;
import com.jfxy.pojo.form.TimingrulesFormBean;
import com.jfxy.service.StockManagerService;
import com.jfxy.util.DateUtil;
import com.jfxy.util.StringUtil;

/**
 * 
 * 商品信息业务层
 * 
 * @author hejiajie
 * @version 2.0, 2016年3月10日
 */
@Service("stockManagerService")
public class StockManagerServiceImpl implements StockManagerService {

	@Resource
	private GoodsclassDao goodsclassDao;

	@Resource
	private MemlevelDao memlevelDao;

	@Resource
	private GoodsDao goodsDao;
	@Resource
	private GoodslogDao goodslogDao;
	@Resource
	private GoodslogdetailDao goodslogdetailDao;
	@Resource
	private GoodsnumberDao goodsnumberDao;
	@Resource
	private OrderlogDao orderlogDao;
	@Resource
	private OrderdetailDao orderdetailDao;
	@Resource
	private MemDao memDao;
	
	@Resource 
	private TimingrulesDao timingrulesDao;
	
	@Resource 
	private TimingprojectDao timingprojectDao;
	@Resource
	private DataSource dataSource;

	/**
	 * 
	 * @param goodsclass
	 * @return
	 */
	public GoodsclassFormBean getPage(GoodsclassFormBean goodsclassFormBean) {
		List<Goodsclass> rows = goodsclassDao.pageList(goodsclassFormBean);
		goodsclassFormBean.setDatas(rows);

		return goodsclassFormBean;
	}
	
	
	
	/**
	 * 
	 * @param goodsclass
	 * @return
	 */
	public TimingrulesFormBean getPage(TimingrulesFormBean timingrulesFormBean) {
		List<Timingrules> rows =timingrulesDao.pageList(timingrulesFormBean);
		timingrulesFormBean.setDatas(rows);

		return timingrulesFormBean;
	}
	
	/**
	 * 
	 * @param goodsclass
	 * @return
	 */
	public List<Timingrules> list(Timingrules timingrules) {
		List<Timingrules> rows =timingrulesDao.list(timingrules);
		

		return rows;
	}
	
	
	/**
	 * 
	 * @param goodsclass
	 * @return
	 */
	public TimingprojectFormBean getPage(TimingprojectFormBean timingprojectFormBean) {
		List<Timingproject> rows =timingprojectDao.pageList(timingprojectFormBean);
		timingprojectFormBean.setDatas(rows);
		timingprojectFormBean.setTotal(rows.size());
		return timingprojectFormBean;
	}

	/**
	 * 删除商品分类
	 * 
	 * @param goodsclassid
	 */
	public void delGoodsClass(Integer goodsclassid, Integer shopid) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("classid", goodsclassid);
		map.put("shopid", shopid);
		goodsclassDao.deleteByGoodsShopId(map);
		goodsclassDao.deleteByShopId(map);
		goodsclassDao.deleteclassRabat(map);

	}

	public Goodsclass findGoodsclass(Integer classid) {

		return goodsclassDao.findbyId(classid);
	}

	public List<GoodsClassRebat> getGoodsclassrebatlist() {
		List<GoodsClassRebat> goodsclassrebatlist = new ArrayList<GoodsClassRebat>();

		List<Memlevel> listmemlevel = memlevelDao.list(new Memlevel());
		for (Memlevel memLevel : listmemlevel) {
			GoodsClassRebat goodsClassRebat = new GoodsClassRebat();
			goodsClassRebat.setLevelname(memLevel.getLevelname());
			goodsClassRebat.setMemlevelid(memLevel.getLevelid());
			goodsclassrebatlist.add(goodsClassRebat);
		}
		return goodsclassrebatlist;

	}

	public List<GoodsClassRebat> getGoodsclassrebatlist(Integer classid,
			Integer shopid) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("shopid", shopid);
		map.put("classid", classid);
		return goodsclassDao.findclassrebate(map);
	}

	public void saveGoodsclass(Goodsclass goodsclass, Integer shopid) {
		goodsclassDao.insert(goodsclass);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("classid", goodsclass.getClassid());
		map.put("shopid", shopid);
		goodsclassDao.insertClassAutho(map);

		for (GoodsClassRebat goodsClassRebat : goodsclass
				.getGoodsClassRabatList()) {
			goodsClassRebat.setClassid(goodsclass.getClassid());
			goodsclassDao.insertclassRebat(goodsClassRebat);
		}
	}

	public void updateGoodsclass(Goodsclass goodsclass, Integer shopid) {
		goodsclassDao.update(goodsclass);
		for (GoodsClassRebat goodsClassRebat : goodsclass
				.getGoodsClassRabatList()) {
			goodsClassRebat.setClassid(goodsclass.getClassid());
			goodsclassDao.insertclassRebat(goodsClassRebat);
		}
	}

	/**
	 * 查询商品信息以分页方式显示 <功能详细描述>
	 * 
	 * @param goodsFormBean
	 * @return [参数说明]
	 * 
	 * @return GoodsFormBean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public GoodsFormBean getPage(GoodsFormBean goodsFormBean) {
		int total = goodsDao.count(goodsFormBean);
		goodsFormBean.setTotal(total);
		List<Goods> rows =new ArrayList<Goods>();
		Connection conn=null;
		PreparedStatement pre=null;
		try {
			 conn= dataSource.getConnection();
			StringBuffer sqlsb=new StringBuffer();
			sqlsb.append("select ")
			.append("goods.GoodsID,goods.GoodsCode,goods.GoodsClassID,goods.Name,")
			.append("goods.NameCode,goods.Unit,goodsnumber.Number GoodsNumber,goods.GoodsSaleNumber,")
			.append("goods.Price,goods.CommissionType,goods.CommissionNumber,goods.SalePercet,")
			.append("goods.Point,goods.MinPercent,goods.GoodsType,goods.GoodsBidPrice,goods.GoodsRemark,")
			.append("goods.GoodsPicture,goods.GoodsCreateTime,goods.CreateShopID ,goodsnumber.shopid,goodsclass.classname");
			List<Memcustomfield> list=MemoryListener.goodscustomfields;
			
			for(Memcustomfield mc:list){
				sqlsb.append(", goods.").append(mc.getCustomfield());
			}
			sqlsb.append(" FROM goods left join goodsclass on goods.goodsclassid=classid left join goodsnumber on  goods.goodsid=goodsnumber.goodsid ");
			
			
			Integer goodsClassID=goodsFormBean.getGoodsclassid();
			Boolean iswhere=Boolean.TRUE;
			if(null!=goodsClassID&&goodsClassID!=0){
				if(iswhere){
					sqlsb.append(" where ");
					iswhere=Boolean.FALSE;
				}else{
					sqlsb.append(" and ");
				}
				sqlsb.append(" GoodsClassID ="+goodsClassID);
			}
			
			
			Integer goodsType=goodsFormBean.getGoodstype();
			
			if(null!=goodsType&&goodsType!=0){
				if(iswhere){
					sqlsb.append(" where ");
					iswhere=Boolean.FALSE;
				}else{
					sqlsb.append(" and ");
				}
				sqlsb.append(" GoodsType ="+goodsType);
			}
			
			Integer shopid=goodsFormBean.getShopid();
			
			if(null!=shopid&&shopid!=0){
				if(iswhere){
					sqlsb.append(" where ");
					iswhere=Boolean.FALSE;
				}else{
					sqlsb.append(" and ");
				}
				sqlsb.append(" goodsnumber.shopid ="+shopid);
			}
			
			Integer goodsnumber=goodsFormBean.getGoodsnumber();
			if(null!=goodsnumber&&goodsnumber!=0){
				if(iswhere){
					sqlsb.append(" where ");
					iswhere=Boolean.FALSE;
				}else{
					sqlsb.append(" and ");
				}
				sqlsb.append(" goodsnumber.Number >="+goodsnumber);
			}
			
			Integer commissionType=goodsFormBean.getCommissiontype();
			if(null!=commissionType&&commissionType!=0){
				if(iswhere){
					sqlsb.append(" where ");
					iswhere=Boolean.FALSE;
				}else{
					sqlsb.append(" and ");
				}
				sqlsb.append(" goods.commissionType ="+commissionType);
			}
			sqlsb.append(" order by GoodsCreateTime desc");
			sqlsb.append(" LIMIT ").append(goodsFormBean.getFirstResult())
			.append(",").append(goodsFormBean.getPageSize());
			 pre=conn.prepareStatement(sqlsb.toString());
			ResultSet rs= pre.executeQuery();
			while(rs.next()){
				Goods goods=new Goods();
				goods.setGoodsid (rs.getInt("GoodsID"));
				goods.setGoodscode(rs.getString("GoodsCode"));
				goods.setGoodsclassid(rs.getInt("GoodsClassID"));
				goods.setName(rs.getString("Name"));
				goods.setNamecode(rs.getString("NameCode"));
				goods.setUnit(rs.getString("Unit"));
				goods.setGoodsnumber(rs.getInt("GoodsNumber"));
				goods.setGoodssalenumber(rs.getInt("GoodsSaleNumber"));
				goods.setPrice(rs.getBigDecimal("Price"));
				goods.setCommissiontype(rs.getInt("CommissionType"));
				goods.setCommissionnumber(rs.getBigDecimal("CommissionNumber"));
				goods.setSalepercet(rs.getBigDecimal("SalePercet"));
				goods.setPoint(rs.getInt("Point"));
				goods.setMinpercent(rs.getBigDecimal("MinPercent"));
				goods.setGoodstype(rs.getInt("GoodsType"));
				goods.setGoodsbidprice(rs.getBigDecimal("GoodsBidPrice"));
				goods.setGoodsremark(rs.getString("GoodsRemark"));
				goods.setGoodspicture(rs.getString("GoodsPicture"));
				goods.setGoodscreatetime(rs.getString("GoodsCreateTime"));
				goods.setCreateshopid(rs.getInt("CreateShopID"));
				goods.setShopid(rs.getInt("shopid"));
				goods.setClassname(rs.getString("classname"));

				Map<String, String> map=new HashMap<String, String>();
				for(Memcustomfield mc:list){
					String value=rs.getString(mc.getCustomfield());
					map.put(mc.getCustomfield(), value);
				}
				goods.setMap(map);
				rows.add(goods);
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
		
		
		
		
		//List<Goods> rows = goodsDao.pageList(goodsFormBean);
		goodsFormBean.setDatas(rows);

		return goodsFormBean;
	}

	/**
	 * 
	 * @param goods
	 */
	public void saveGoods(Goods goods) {
		goodsDao.insert(goods);
		Goodsnumber goodsnumber = new Goodsnumber();
		goodsnumber.setGoodsid(goods.getGoodsid());
		goodsnumber.setNumber(goods.getGoodsnumber());
		goodsnumber.setShopid(goods.getShopid());
		goodsnumberDao.insert(goodsnumber);
	}

	public Goods findGoods(Goods goods) {
		
		Connection conn= null;
		PreparedStatement pre=null;
		try {
			 conn= dataSource.getConnection();
			StringBuffer sqlsb=new StringBuffer();
			sqlsb.append("select ")
			.append("GoodsID,GoodsCode,GoodsClassID,Name,NameCode,Unit,GoodsSaleNumber,Price,CommissionType,CommissionNumber,SalePercet,")
			.append("Point,MinPercent,GoodsType,GoodsBidPrice,GoodsRemark,")
			.append("GoodsPicture,GoodsCreateTime,CreateShopID");
			List<Memcustomfield> list=MemoryListener.goodscustomfields;
			
			for(Memcustomfield mc:list){
				sqlsb.append(", ").append(mc.getCustomfield());
			}
			sqlsb.append(" FROM goods ").append(" where GoodsID=").append(goods.getGoodsid());
			
			 pre=conn.prepareStatement(sqlsb.toString());
			ResultSet rs= pre.executeQuery();
			if(rs.next()){
				
				goods.setGoodsid (rs.getInt("GoodsID"));
				goods.setGoodscode(rs.getString("GoodsCode"));
				goods.setGoodsclassid(rs.getInt("GoodsClassID"));
				goods.setName(rs.getString("Name"));
				goods.setNamecode(rs.getString("NameCode"));
				goods.setUnit(rs.getString("Unit"));
				goods.setGoodssalenumber(rs.getInt("GoodsSaleNumber"));
				goods.setPrice(rs.getBigDecimal("Price"));
				goods.setCommissiontype(rs.getInt("CommissionType"));
				goods.setCommissionnumber(rs.getBigDecimal("CommissionNumber"));
				goods.setSalepercet(rs.getBigDecimal("SalePercet"));
				goods.setPoint(rs.getInt("Point"));
				goods.setMinpercent(rs.getBigDecimal("MinPercent"));
				goods.setGoodstype(rs.getInt("GoodsType"));
				goods.setGoodsbidprice(rs.getBigDecimal("GoodsBidPrice"));
				goods.setGoodsremark(rs.getString("GoodsRemark"));
				goods.setGoodspicture(rs.getString("GoodsPicture"));
				goods.setGoodscreatetime(rs.getString("GoodsCreateTime"));
				goods.setCreateshopid(rs.getInt("CreateShopID"));
				

				Map<String, String> map=new HashMap<String, String>();
				for(Memcustomfield mc:list){
					String value=rs.getString(mc.getCustomfield());
					map.put(mc.getCustomfield(), value);
				}
				goods.setMap(map);
				
			}
			
		}catch(Exception e){
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
		return goods;
	}

	public List<Goods> findGoodsList(Goods goods) {
		return goodsDao.list(goods);
	}

	public void delGoods(Integer goodsid) {
		goodsDao.deleteById(goodsid);
	}

	/**
	 * 修改商品信息
	 * 
	 * @param goods
	 *            [参数说明]
	 * 
	 * @return void [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public void updateGoods(Goods goods) {
		goodsDao.update(goods);
	}

	public int saveGoodsIn(Goodslog goodslog) {
		goodslog.setType(1);

		String createTime = goodslog.getCreatetime();
		if (StringUtil.isBlank(createTime)) {
			goodslog.setCreatetime(DateUtil.format(new Date(),
					DateUtil.yyyy_MM_dd_HH_mm_ss));
		}

		goodslogDao.insert(goodslog);
		List<Goodslogdetail> goodslogdetails = goodslog.getDetails();
		for (Goodslogdetail goodslogdetail : goodslogdetails) {
			goodslogdetail.setGoodslogid(goodslog.getId());
			goodslogdetailDao.insert(goodslogdetail);
			Goodsnumber goodsnumber = new Goodsnumber();
			goodsnumber.setShopid(goodslog.getShopid());
			goodsnumber.setGoodsid(goodslogdetail.getGoodsid());
			goodsnumber.setInnumber(goodslog.getGoodsnumber());
			goodsnumberDao.updateNumber(goodsnumber);

		}
		return 1;
	}

	public GoodslogFormBean getPage(GoodslogFormBean goodslogFormBean) {

		int total = goodslogDao.count(goodslogFormBean);
		goodslogFormBean.setTotal(total);
		List<Goodslog> rows = goodslogDao.pageList(goodslogFormBean);
		goodslogFormBean.setDatas(rows);
		return goodslogFormBean;
	}

	public void saveGoodsExpense(Orderlog orderlog) {

		Mem mem = new Mem();
		mem.setMemid(orderlog.getOrdermemid());
		List<ExpenseDatailPojo> detail = orderlog.getDetail();
		Boolean isgdflag=Boolean.FALSE;

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
			 * if(pojo.getPayType().equals(PrefixConstant.ExpensePrefix_String))
			 * { orderlog.setOrderpaytype(PrefixConstant.ExpensePrefix_Int); }
			 **/
			
			if(pojo.getPayType().equals(PrefixConstant.EmptyBillsPrefix_String)){
				orderlog.setOrdertype(PrefixConstant.EmptyBillsPrefix_Int);
				isgdflag=Boolean.TRUE;
			}else if(pojo.getPayType().equals(PrefixConstant.GoodsExpensePrefix_String)){
				orderlog.setOrdertype(PrefixConstant.GoodsExpensePrefix_Int);
				isgdflag=Boolean.FALSE;
			}else{
				System.out.println("未找到此类型");
			}
			orderlog.setOrderdiscountmoney(pojo.getDiscountMoney());
			orderlog.setOrdertotalmoney(pojo.getChangeMoney());
			if (pojo.getIsCard() > 0) {
				BigDecimal money = pojo.getCardMoney();
				if (money.compareTo(BigDecimal.ZERO) > 0) {
					mem.setMemmoney(new BigDecimal("-" + money));
					mem.setConsumemoney( money);
					mem.setMemconsumecount(1);

				}

			}
		}

		if (orderlog.getOrderpoint() > 0) {
			mem.setMempoint(orderlog.getOrderpoint());
		}
		orderlogDao.insert(orderlog);
		
		List<Orderdetail> details=orderlog.getDetails();
		for(Orderdetail d:details){
			Integer type=d.getGoodstype();
			d.setOrderdetailtype(type);
			if(type==0){
				
				Goodsnumber goodsnumber = new Goodsnumber();
				goodsnumber.setShopid(orderlog.getOrdershopid());
				goodsnumber.setGoodsid(d.getGoodsid());
				goodsnumber.setInnumber(-d.getOrderdetailnumber());
				goodsnumberDao.updateNumber(goodsnumber);
			}
			
			d.setOrderid(orderlog.getOrderid());
			
			
			orderdetailDao.insert(d);
			
		}
		if(!isgdflag){
			if(mem.getMemmoney()!=null||mem.getMempoint()!=null){
				memDao.updateMemMoney(mem);
			}
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
	
	
	public void updateGoodsExpense(Orderlog orderlog) {
		orderlog.setOrdertype(PrefixConstant.GoodsExpensePrefix_Int);
		orderlogDao.update(orderlog);
		
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
			if (pojo.getIsCard() > 0) {
				BigDecimal money = pojo.getCardMoney();
				if (money.compareTo(BigDecimal.ZERO) > 0) {
					mem.setMemmoney(new BigDecimal("-" + money));
					mem.setConsumemoney( money);
					mem.setMemconsumecount(1);
				}

			}
		}
		
		if (orderlog.getOrderpoint() > 0) {
			mem.setMempoint(orderlog.getOrderpoint());
		}
		
		if(mem.getMemmoney()!=null||mem.getMempoint()!=null){
			memDao.updateMemMoney(mem);
		}
		
	}
	
	public void deleteGoodsExpense(Orderlog orderlog) {
		Orderdetail orderdetail=new Orderdetail();
		orderdetail.setOrderid(orderlog.getOrderid());
		List<Orderdetail> list=orderdetailDao.list(orderdetail);
		List<Integer> ids=new ArrayList<Integer>();
		for(Orderdetail detail:list){
			Goodsnumber goodsnumber=new Goodsnumber();
			goodsnumber.setGoodsid(detail.getGoodsid());
			goodsnumber.setInnumber(detail.getOrderdetailnumber());
			goodsnumberDao.updateNumber(goodsnumber);
			ids.add(detail.getOrderdetailid());
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("Ids", ids);
		orderlogDao.deleteById(orderlog.getOrderid());
		orderdetailDao.deleteByIds(map);
		
		
	}
	
	
	public boolean createGoodsExcel(List<GoodsExcel>  goods,Integer createshopid){
		Batch batchGoods=new Batch();
		
		
		
		/**
		for(Memcustomfield memcustomfield:MemoryListener.goodscustomfields){
			head.add(memcustomfield.getCustomfield());
		}
		**/
		
		List<String> goodscodes=new ArrayList<String>(); 
		int ishead=0;
		Map<String,String> head=new HashMap<String, String>();
		List<Object> goodsArr=new ArrayList<Object>();
		
		for(GoodsExcel goodsExcel:goods){
			Map<String, String> map=new HashMap<String, String>();
			List<ExcelField> list=goodsExcel.getExcelFields();
			for(ExcelField excelField:list){
				String value=null;
				if(null==excelField.getFieldvalue()){
					value=null;
				}else if("".equals(excelField.getFieldvalue())){
					value=null;
				}else{
					value=excelField.getFieldvalue();
				}
				if(ishead==0){
					head.put(excelField.getField(),null);
					
				}
				map.put(excelField.getField(),value);
				
			}
			ishead=1;
			goodsExcel.setMap(map);
			Goods goodssex=goodsExcel;
			
			goodscodes.add(goodssex.getGoodscode());
			goodsArr.add(goodssex);
			
		}
		
		batchGoods.setHead(head);
		batchGoods.setListvalue(goodsArr);
		goodsDao.batchCreateGoods(batchGoods);
		
		List<Goodsnumber> list=new ArrayList<Goodsnumber>();
		for(String code:goodscodes){
			Goodsnumber goodsnumber=new Goodsnumber();
			goodsnumber.setGoodscode(code);
			goodsnumber.setShopid(createshopid);
			goodsnumber.setNumber(0);
			list.add(goodsnumber);
		}
		
		goodsnumberDao.replace(list);
		return true;
	}
	
	
	public int timingrules_add(Timingrules timingrules){
		timingrulesDao.insert(timingrules);
		return 1;
	}
	public int timingrules_edit(Timingrules timingrules){
		timingrulesDao.update(timingrules);
		return 1;
	}
	public List<Timingrules> timingrules_get(Timingrules timingrules){
		List<Timingrules> list=timingrulesDao.list(timingrules);
		return list;
	}
	
	public int timingrules_del(Integer rulesid){
		timingrulesDao.deleteById(rulesid);
		return 1;
	}
	public Integer timingProject_add(Timingproject timingproject){
		timingprojectDao.insert(timingproject);
		return 1;
	}
	
	public Integer timingProject_edit(Timingproject timingproject){
		timingprojectDao.update(timingproject);
		return 1;
	}
	
	public Integer timingProject_del(Integer projectid){
		timingprojectDao.deleteById(projectid);
		return 1;
	}
	
	public List<Timingproject> timingrules_get(Timingproject timingproject){
		List<Timingproject> list=timingprojectDao.list(timingproject);
		return list;
	}
}
