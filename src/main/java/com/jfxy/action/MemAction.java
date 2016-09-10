package com.jfxy.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfxy.pojo.Goods;
import com.jfxy.pojo.GoodsClassRebat;
import com.jfxy.pojo.Mem;
import com.jfxy.pojo.Memcount;
import com.jfxy.pojo.Memdrawmoney;
import com.jfxy.pojo.Memlevel;
import com.jfxy.pojo.Memrecharge;
import com.jfxy.pojo.SendCards;
import com.jfxy.pojo.form.GoodsFormBean;
import com.jfxy.pojo.form.MemFormBean;
import com.jfxy.pojo.form.MemlevelFormBean;
import com.jfxy.pojo.form.MemrechargeFormBean;
import com.jfxy.service.KafkaProducerService;
import com.jfxy.service.MemService;
import com.jfxy.service.MemoryService;
import com.jfxy.service.StockManagerService;
import com.jfxy.util.DateUtil;
import com.jfxy.util.StringUtil;
import com.jfxy.util.UserUtils;
/**
 * 
 * 会员管理模块
 * 包括会员管理，会员注册，挂失解锁功能
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
@Controller
@RequestMapping(value = "/Member")
public class MemAction extends BaseAction{

	@Autowired
	private MemService memService;
	
	@Autowired
	private MemoryService memoryService;
	
	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@Autowired
	private StockManagerService stockManagerService;

	
	/**
	 * 会员列表
	 * @param request
	 * @param memFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequiresPermissions("Member/memList.do")
	@RequestMapping(value = "memList", method = RequestMethod.GET)
	public String mem_list(HttpServletRequest request, MemFormBean memFormBean) {

		
		
		Integer userid=getUserId();
		if(UserUtils.isNotAdmin(userid)){
			List<Integer> memshopids=memoryService.listShopID(getUserId());
			
			memFormBean.setMemshopids(memshopids);
			memFormBean = memService.getPage(memFormBean); 
			
		}else{
			memFormBean.setMemshopid(null);
			memFormBean = memService.getPage(memFormBean); 
			
		}
		
		//查询会员等级
		List<Memlevel> memlevelList= memService.getList();

		request.setAttribute("memlevelList", memlevelList);
		
		
		request.setAttribute("memFormBean", memFormBean);
		
		return "MemList.jsp";

	}
	
	/**
	 * 获取会员信息
	 * @param request
	 * @param memFormBean
	 * @return [参数说明]
	 * 
	 * @return List<Mem> [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "GetMem")
	@ResponseBody
	public List<Mem> getMem(HttpServletRequest request,MemFormBean memFormBean){

		List<Mem> mems=memService.findMem(memFormBean);
		return mems;
		
	}
	
	
	/**
	 * 会员注册和会员修改
	 * @param request
	 * @param memid
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequiresPermissions("Member/memRegister.do")
	@RequestMapping(value = "memRegister", method = RequestMethod.GET)
	public String mem_register(HttpServletRequest request,Long memid){
		
		//查询会员等级
		List<Memlevel> memlevelList= memService.getList();

		request.setAttribute("memlevelList", memlevelList);
		if(memid!=null){
			Mem mem=memService.findMem(memid);
			request.setAttribute("mem", mem);
		}
		
		
		return "MemRegister.jsp";
	}
	
	/**
	 * 
	 * 会员删除
	 * @return
	 * 0-系统错误 请与系统管理员联系！
	 * 1-删除成功！
	 * other-错误
	 */
	
	/**
	 * 会员删除
	 * @param request
	 * @param memid
	 * @return [参数说明]
	 * 
	 * @return int [
	 * 0-系统错误 请与系统管理员联系！
	 * 1-删除成功！
	 * other-错误]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "memDelete", method = RequestMethod.POST)
	@ResponseBody
	public int mem_delete(HttpServletRequest request,long memid){
		memService.deleteMem(memid);
		
		return 1;
	}
	
	/**
	 * 删除会员级别
	 * @return
	 */
	/**
	 * 删除会员级别
	 * @param request
	 * @param memLevelId
	 * @param shopid
	 * @return [参数说明]
	 * 
	 * @return int [1成功
	 * other失败]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "memLevelDelete", method = RequestMethod.POST)
	@ResponseBody
	public int mem_levelDelete(HttpServletRequest request,int memLevelId,int shopid){

		memService.deleteMemLevel(memLevelId,shopid);
		return 1;
	}

	/**
	 * 添加会员等级
	 * @param request
	 * @param memlevel
	 * @return [1添加成功
	 * ２保存成功]
	 * 
	 * @return int [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "memLevelSave", method = RequestMethod.POST)
	@ResponseBody
	public int memLevel_save(HttpServletRequest request,Memlevel memlevel){
		Integer memlevelid=memlevel.getLevelid();
		
		
		
		if(memlevelid!=null&&memlevelid!=0){
			memService.updateMemLevel(memlevel);
			return 2;
		}else{
			
			memService.saveMemLevel(memlevel);
			
			
			return 1;
		}
		
		
	}
	
	/**
	 * 编辑会员等级
	 * @param request
	 * @param memlevelid
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "editMemLevel", method = RequestMethod.GET)
	public String edit_memLevel(HttpServletRequest request,Integer memlevelid){
		
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("discountshopid", getUserShopId());
		if(memlevelid!=null){
				Memlevel	memlevel=memService.findMemLevel(memlevelid);
			
			   request.setAttribute("memlevel", memlevel);
			   
			   map.put("memlevelid", memlevelid);
			   
			   List<GoodsClassRebat> goodsClassList=memService.queryGoodsClass(map);
			   
			   
			   request.setAttribute("goodsClassList", goodsClassList);
		}else{
			 List<GoodsClassRebat> goodsClassList=memService.queryGoodsClassforA(map);
			 request.setAttribute("goodsClassList", goodsClassList);
		}
	   
	   
		return "EditLevel.jsp";
	}
	
	/**
	 * 会员信息管理
	 * <功能详细描述>
	 * @param request
	 * @param memlevelFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequiresPermissions("Member/memLevelList.do")
	@RequestMapping(value = "memLevelList", method = RequestMethod.GET)
	public String memLevel_list(HttpServletRequest request,
			MemlevelFormBean memlevelFormBean) {

		memlevelFormBean = memService.getPage(memlevelFormBean);

		request.setAttribute("memlevelFormBean", memlevelFormBean);
		return "SetLevel.jsp";
	}
	
	
	/**
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param request
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
	 * 
	 * @return int [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "MemAdd")
	@ResponseBody
	public int mem_add(HttpServletRequest request,Mem mem){
		
		mem.setMemuserid(getUserId());
		
		mem.setMemcreatetime(new Date());
		Map<String, String> gl=new HashMap<String, String>();
		
		Map<String, String> map=mem.getMap();
		for (Map.Entry<String, String> re : map.entrySet()) {
			if(StringUtil.isNotBlank(re.getValue())){
				gl.put(re.getKey(), re.getValue());
			}
		}
		mem.setMap(gl);;
		
		
		int result=memService.createMem(mem);
		
		
		
		
		
		//kafkaProducerService.sendMem(mem);
		//return -1;
		return result;
	}
	

	/**
	 * 会员信息修改
	 * @param request
	 * @param mem
	 * @return [参数说明]
	 * 
	 * @return int [0系统异常，未保存数据，请再次点击保存！
	 * -1 此卡号已经在系统中存在，请重新输入卡号，然后重试！
	 * -2此手机号码已经在系统中存在，请重新输入手机号，然后重试！
	 * -3保存成功，短信余额不足，不能发送短信，请充值短信！
	 * -4会员已经存在其他数据异动，不能修改创建时间！
	 * -5系统错误 请与系统管理员联系！
	 * -6此卡面号码已经在系统中存在，请重新输入卡面号码，然后重试！
	 * -7该卡不在发卡范围内，请与总店联系！
	 * -8该店铺剩余可用积分不足，请重新填写！
	 * other 成功！]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "MemEdit")
	@ResponseBody
	public int mem_edit(HttpServletRequest request,Mem mem){
		
		memService.updateMem(mem);
		
		
		//return -1;
		return 1;
	}
	
	/**
	 * 会员充值
	 * @param request
	 * @param memrecharge
	 * @return [参数说明]
	 * 
	 * @return int [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "RechargeMoney")
	@ResponseBody
	public int RechargeMoney(HttpServletRequest request,Memrecharge memrecharge){
		memrecharge.setRechargeuserid(getUserId());
		memrecharge.setRechargeshopid(getUserShopId());
		memrecharge.setRechargetype(2);
		memrecharge.setRechargemoney(memrecharge.getRechargemoney().add(memrecharge.getRechargegive()));
		
		memService.saveMemRecharge(memrecharge);
		
		return 1;
	}
	/**
	 * 获取会员信息
	 * @param request
	 * @param memFormBean
	 * @return [参数说明]
	 * 
	 * @return MemFormBean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "GetQueryMem")
	@ResponseBody
	public MemFormBean getQueryMem(HttpServletRequest request, MemFormBean memFormBean){
		memFormBean = memService.getPage(memFormBean); 
		return memFormBean;
	}
	/**
	 * 会员信息显示
	 * <功能详细描述>
	 * @param request
	 * @param memcard
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "MemInfo")
	public String memInfo(HttpServletRequest request,String memcard){
		request.setAttribute("memcard", memcard);
		return "MemInfo.jsp";
	}
	/**
	 * 会员信息注册
	 * @param request
	 * @param memrechargeFormBean
	 * @return [参数说明]
	 * 
	 * @return MemrechargeFormBean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "MemInfoRecharge")
	@ResponseBody
	public MemrechargeFormBean  memInfoRecharge(HttpServletRequest request,MemrechargeFormBean memrechargeFormBean){
		memrechargeFormBean=memService.getPage(memrechargeFormBean);
		
		return memrechargeFormBean;
	}
	
	/**
	 * 会员换卡
	 * @param request
	 * @param memrechargeFormBean
	 * @return [参数说明]
	 * 
	 * @return MemrechargeFormBean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "MemChangeCard")
	public String  MemChangeCard(HttpServletRequest request){
		System.out.println("ok");
		
		return "MemChangeCard.jsp";
	}
	@RequestMapping(value = "saveDrawMoney")
	@ResponseBody
	public Integer saveDrawMoney(HttpServletRequest request,Memdrawmoney memdrawmoney){
		memdrawmoney.setDrawmoneyuserid(this.getUserId());
		memdrawmoney.setDrawmoneyshopid(this.getUserShopId());
		memService.saveDrawMoney(memdrawmoney);
		return 1;
	}
	@RequestMapping(value = "ChangeCard")
	@ResponseBody
	public Integer ChangeCard(HttpServletRequest request,com.jfxy.pojo.MemChangeCard memChangeCard){
		Integer result=memService.changeCard(memChangeCard);
		
		return result;
	}
	@RequestMapping(value = "MemChangePwd")
	public String MemChangePwd(HttpServletRequest request){
		return "MemChangePwd.jsp";
	}
	@RequestMapping(value = "ChangePwd")
	@ResponseBody
	public Integer ChangePwd(HttpServletRequest request,com.jfxy.pojo.MemChangeCard memChangeCard){
		Integer result=memService.changePwd(memChangeCard);
		
		return result;
	}
	@RequestMapping(value = "SendCards")
	@ResponseBody
	public Integer SendCards(HttpServletRequest request,SendCards sendCards){
		sendCards.setShopid(getUserShopId());
		sendCards.setUserid(getUserId());
		Integer result=memService.sendCards(sendCards);
		return result;
	}
	
	@RequestMapping(value = "MemLock")
	public String MemLock(HttpServletRequest request){
		return "MemLock.jsp";
	}
	@RequestMapping(value = "saveMemLock")
	@ResponseBody
	public Integer saveMemLock(HttpServletRequest request,Integer memid,Integer state,String remark){
		
		memService.saveMemLock(memid,state,remark);
		return 1;
	}
	
	
	
	@RequestMapping(value = "MemDelay")
	public String MemDelay(HttpServletRequest request){
		return "MemDelay.jsp";
	}
	
	@RequestMapping(value = "saveDelayTime")
	@ResponseBody
	public Integer saveDelayTime(HttpServletRequest request,Integer memid,String newPastTime,String remark){
		
		memService.saveDelayTime(memid,newPastTime,remark);
		return 1;
	}
	
	
	
	@RequestMapping(value = "GetServiceList")
	@ResponseBody
	public GoodsFormBean getService_list(GoodsFormBean goodsFormBean){
		
		if(goodsFormBean.getShopid()==null){
			goodsFormBean.setShopid(getUserShopId());
		}
		
		
		goodsFormBean.setGoodstype(1);
		
		goodsFormBean=stockManagerService.getPage(goodsFormBean);
		
		return goodsFormBean;
	}
	
	@RequestMapping(value = "GetGoodsInfo")
	@ResponseBody
	public List<Goods> GetGoodsInfo(HttpServletRequest request,Goods goods){
		
		
		List<Goods> goodsList=stockManagerService.findGoodsList(goods);
		
		return goodsList;
	}
	@RequestMapping(value = "saveMemCount")
	@ResponseBody
	public Map<String, Object> saveMemCount(HttpServletRequest request,@RequestBody  Memcount memcount){
		Map<String, Object> map=new HashMap<String, Object>();
		memcount.setCountshopid(this.getUserShopId());
		memcount.setCountuserid(this.getUserId());
		memService.saveMemCount(memcount);
		map.put("result", 1);
		map.put("strUpdateMemLevel", "");
		return map;
	}
	

}
