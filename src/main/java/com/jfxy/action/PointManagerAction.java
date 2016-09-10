package com.jfxy.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfxy.pojo.Pointgift;
import com.jfxy.pojo.Pointlog;
import com.jfxy.pojo.form.PointgiftFormBean;
import com.jfxy.service.MemService;
import com.jfxy.util.Pagination;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jfxy.pojo.Giftclass;
import com.jfxy.service.PointManagerService;
/**
 *
 * 积分管理模块 包括礼品分类
 *
 * @author wangkun
 * @version 1.0, 2016年3月9日
 */
@Controller
@RequestMapping(value = "/PointManager")
public class PointManagerAction extends BaseAction{
	private Logger logger = Logger.getLogger(PointManagerAction.class.getName());
	@Autowired
	private PointManagerService pointManagerService;
	@Autowired
	private MemService memService;
	/**
	 * 礼品分类列表页
	 * @return
	 */
	@RequestMapping(value = "/SetGiftLevel")
	public String queryGiftClassIndex(HttpServletRequest request) {
		
		try {
			List<Giftclass> giftClassList = pointManagerService.queryGiftClassList();
			request.setAttribute("giftList", giftClassList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("query GiftClassIndex error" + e.getMessage());
		}
		return "SetGiftLevel.jsp";
	}

	@RequestMapping("/getGiftCategory")
	@ResponseBody
	public ModelAndView getGiftCategory(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("GiftCategoryList.jsp");
		try {
			List<Giftclass> gifts = pointManagerService.queryGiftCategory();
			mav.addObject("gifts", gifts);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getGiftCategory error" + e.getMessage());
		}
		return mav;
	}

	/**
	 * 添加礼品分类
	 * @return 1.添加成功  0.添加失败 -1.类别名称已存在
	 */
	@RequestMapping(value = "GiftClassAdd", method = RequestMethod.POST)
	@ResponseBody
	public int GiftClassAdd(HttpServletRequest request,Giftclass giftclass){
		int count=0;
		int status=0;
		try{
			count=pointManagerService.queryGiftClassCountByName(giftclass);
			if(count>0){
				return -1;
			}else{
				status=pointManagerService.addGiftClass(giftclass);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("saveGiftClass error"+ e.getMessage());
		}
		if(status>0){
			return  1;
		}else {
			return  0;
		}
	}

	/**
	 * 礼品列表页
	 * @return
	 */
	@RequestMapping(value = "/GiftList")
	public String queryPointGiftList(HttpServletRequest request,PointgiftFormBean pointgiftFormBean) {
		try {
			pointgiftFormBean= pointManagerService.queryPointGiftListByCondition(pointgiftFormBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("query queryGiftList error" + e.getMessage());
		}
		request.setAttribute("pointgiftFormBean", pointgiftFormBean);
		return "GiftList.jsp";
	}

	/**
	 * 查看礼品详情
	 * @param GiftID 礼品id
	 * @return json  10107 活动id缺失
	 */
	@RequestMapping(value = "/giftDetail")
	@ResponseBody
	public Map<String,Object> giftDetail(int GiftID) throws Exception {
		Map<String,Object>  map=new HashMap<String, Object>();
		List<Giftclass> giftClassList=pointManagerService.queryGiftClassIdList();
		Pointgift	pointgift=pointManagerService.queryPointGiftDetailById(GiftID);
		map.put("giftClassList",giftClassList);
        map.put("pointgift",pointgift);
		return map;
	}
	/**
	 * 会员删除
	 * @param GiftID  礼品id
	 * @return
	 */
	@RequestMapping(value = "GiftDel", method = RequestMethod.POST)
	@ResponseBody
	public int GiftDel(HttpServletRequest request,int GiftID){
		int status=0;
		try{
			int count=pointManagerService.queryGiftCountById(GiftID);
			if(count>0){
                   return -4;
			}else {
				status = pointManagerService.deleteGiftById(GiftID);
				if (status > 0) {
					return 1;
				} else {
					return 0;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.info("gift delete error!"+e.getMessage());
		}
               return -3;
	}
	/**
	 * 添加礼品
	 * @return 1.添加成功  0.添加失败 -1.礼品名称已存在
	 */
	@RequestMapping(value = "GiftAdd", method = RequestMethod.POST)
	@ResponseBody
	public int GiftAdd(HttpServletRequest request,Pointgift pointgift){
		int count=0;
		int status=0;
		try{
			count=pointManagerService.queryGiftCountByName(pointgift);
			if(count>0){
				return -1;
			}else{
				status=pointManagerService.addGift(pointgift);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("saveGift error"+ e.getMessage());
		}
		if(status>0){
			return  1;
		}else {
			return  0;
		}
	}

	@RequestMapping(value = "GiftEdit")
	@ResponseBody
	public int giftEdit(HttpServletRequest request,Pointgift pointgift){
		int status=0;
		try{
			status=pointManagerService.updateGift(pointgift);
			if(status>0){
				return  1;
			}else {
				return  0;
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("updateGift error"+ e.getMessage());
		}
            return -3;
	}
	/**
	 * 积分兑换页面显示
	 */
	@RequestMapping(value = "GiftExchange")
	public String giftExchange(HttpServletRequest request){
		return "GiftExchange.jsp";
	}
	/**
	 * 积分兑换列表页
	 * @param index 首页下标
	 * @param size   显示条数
	 * @param key    礼品名称或简码
	 * @return
	 */
	@RequestMapping(value = "/GetGiftList")
	@ResponseBody
	public Map<String,Object> queryGiftExchange(HttpServletRequest request,int index,int size,String key,Pagination<Pointgift> page) {
		Map<String,Object>  map=new HashMap<String, Object>();
		page.setPage(index);
		page.setRows(size);
		List<Pointgift> giftList= pointManagerService.queryPointGiftListByPage(page,key);
		map.put("List",giftList);
		map.put("RecordCount", page.getTotal());
		return map;
	}
	/**
	 * 积分兑换成功后一系列操作
	 * @param memID  会员id
	 * @return
	 */
	@RequestMapping(value = "/GiftChange")
	@ResponseBody
	public Map<String,Object> operationGift(HttpServletRequest request,String memID,String giftList) {
		System.out.println("用户id：" + memID + "----" + giftList);
		Map<String,Object>  map=new HashMap<String, Object>();
        return  map;
	}
	
	@RequestMapping(value = "PointChange")
	@ResponseBody
	public Map<String, Object> point_change(HttpServletRequest request,Pointlog pointlog){
		Map<String,Object>  result=new HashMap<String, Object>();
		pointlog.setPointshopid(getUserShopId());
		pointlog.setPointuserid(getUserId());
		pointManagerService.updatePoint(pointlog);
		
		result.put("result", 1);
		result.put("strUpdateMemLevel", "test");
		result.put("point", 11);
					
		return result;
	}
}
