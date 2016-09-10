package com.jfxy.action;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Memcustomfield;
import com.jfxy.pojo.Staff;
import com.jfxy.pojo.Staffclass;
import com.jfxy.pojo.Sysarea;
import com.jfxy.pojo.Syscustomremind;
import com.jfxy.pojo.Sysgroup;
import com.jfxy.pojo.Sysmodule;
import com.jfxy.pojo.Sysnotice;
import com.jfxy.pojo.Sysparameter;
import com.jfxy.pojo.Sysshop;
import com.jfxy.pojo.Sysshopauthority;
import com.jfxy.pojo.Sysuser;
import com.jfxy.pojo.form.MemcustomfieldFormBean;
import com.jfxy.pojo.form.MessageFormBean;
import com.jfxy.pojo.form.StaffFormBean;
import com.jfxy.pojo.form.StaffclassFormBean;
import com.jfxy.pojo.form.SyscustomremindFormBean;
import com.jfxy.pojo.form.SysgroupFormBean;
import com.jfxy.pojo.form.SyslogFormBean;
import com.jfxy.pojo.form.SysnoticeFormBean;
import com.jfxy.pojo.form.SysshopFormBean;
import com.jfxy.pojo.form.SysuserFormBean;
import com.jfxy.pojo.form.WeixinmenuFormBean;
import com.jfxy.pojo.form.WeixinruleFormBean;
import com.jfxy.pojo.form.WeixinnewsFormBean;
import com.jfxy.service.SystemManagerService;
import com.jfxy.util.ListToTreeUtils;
import com.jfxy.util.StringUtil;
import com.jfxy.util.UserUtils;

/**
 * 
 * 系统管理模块
 * 
 * @author hejiajie
 * @version 2.0, 2016年3月8日
 */
@Controller
@RequestMapping(value = "/SystemManager")
public class SystemManagerAction extends BaseAction {

	@Autowired
	private MemoryListener memoryListener;
	
	@Autowired
	private SystemManagerService systemManagerService;

	/**
	 * 微信管理
	 * 
	 * @param request
	 * @param weixinruleFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "WeiXinRuleList", method = RequestMethod.GET)
	public String weixi_rule_list(HttpServletRequest request,
			WeixinruleFormBean weixinruleFormBean) {

		weixinruleFormBean = systemManagerService.getPage(weixinruleFormBean);

		request.setAttribute("weixinruleFormBean", weixinruleFormBean);
		WeixinmenuFormBean weixinmenuFormBean = new WeixinmenuFormBean();

		weixinmenuFormBean = systemManagerService.getPage(weixinmenuFormBean);
		request.setAttribute("weixinmenuFormBean", weixinmenuFormBean);

		WeixinnewsFormBean weixinNewsFormBean = new WeixinnewsFormBean();

		weixinNewsFormBean = systemManagerService.getPage(weixinNewsFormBean);
		request.setAttribute("weixinnewsFormBean", weixinNewsFormBean);

		request.setAttribute("type", 1);
		return "WeiXinRuleList.jsp";
	}

	/**
	 * 微信菜单设置
	 * 
	 * @param request
	 * @param weixinmenuFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "WeiXinMenuList", method = RequestMethod.GET)
	public String weixi_menu_list(HttpServletRequest request,
			WeixinmenuFormBean weixinmenuFormBean) {

		weixinmenuFormBean = systemManagerService.getPage(weixinmenuFormBean);

		request.setAttribute("weixinmenuFormBean", weixinmenuFormBean);

		request.setAttribute("type", 2);
		return "WeiXinRuleList.jsp";
	}

	/**
	 * 系统用户列表
	 * 
	 * @param request
	 * @param sysuserFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "UserList", method = RequestMethod.GET)
	public String sys_user_list(HttpServletRequest request,
			SysuserFormBean sysuserFormBean) {
		sysuserFormBean = systemManagerService.getPage(sysuserFormBean);
		List<Sysgroup> SysgroupList = systemManagerService
				.getGroupListByShopAndGroup(new Sysgroup());
		request.setAttribute("sysgroupList", SysgroupList);
		request.setAttribute("sysuserFormBean", sysuserFormBean);
		return "UserList.jsp";
	}

	/**
	 * 系统角色列表
	 * 
	 * @param request
	 * @param sysgroupFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "GroupList", method = RequestMethod.GET)
	public String sys_group_list(HttpServletRequest request,
			SysgroupFormBean sysgroupFormBean) {
		sysgroupFormBean = systemManagerService.getPage(sysgroupFormBean);
		request.setAttribute("sysgroupFormBean", sysgroupFormBean);
		return "GroupList.jsp";
	}

	/**
	 * 系统店铺列表
	 * 
	 * @param request
	 * @param sysshopFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "ShopList", method = RequestMethod.GET)
	public String sys_shop_list(HttpServletRequest request,
			SysshopFormBean sysshopFormBean) {
		if (UserUtils.isNotAdmin(this.getUserId())) {
			sysshopFormBean.setShopauthorityshopid(this.getUserShopId());
		} else{
			sysshopFormBean.setShopauthorityshopid(1);
		}
		sysshopFormBean = systemManagerService.getPage(sysshopFormBean);

		request.setAttribute("sysshopFormBean", sysshopFormBean);
		return "ShopList.jsp";
	}

	/**
	 * 系统店铺列表
	 * 
	 * @param request
	 * @param sysshopFormBean
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "SysLogList", method = RequestMethod.GET)
	public String sys_log_list(HttpServletRequest request,
			SyslogFormBean syslogFormBean) {
		syslogFormBean = systemManagerService.getPage(syslogFormBean);
		request.setAttribute("syslogFormBean", syslogFormBean);
		return "SysLogList.jsp";
	}

	/**
	 * 修改用户密码 <功能详细描述>
	 * 
	 * @param request
	 * @param sysuser
	 * @return [参数说明]
	 * 
	 * @return Integer [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "ChangeUserPwd")
	@ResponseBody
	public Integer ChangeUserPwd(HttpServletRequest request, Sysuser sysuser) {
		systemManagerService.changePassword(sysuser);
		return 1;
	}

	@RequestMapping(value = "GetUserInfo")
	@ResponseBody
	public Sysuser GetUserInfo(HttpServletRequest request, Sysuser sysuser) {

		sysuser = systemManagerService.getUserInfo(sysuser);
		return sysuser;
	}

	@RequestMapping(value = "GetGroupListByShopAndGroup")
	@ResponseBody
	public List<Sysgroup> GetGroupListByShopAndGroup(
			HttpServletRequest request, Sysgroup sysgroup) {
		List<Sysgroup> list = systemManagerService
				.getGroupListByShopAndGroup(sysgroup);
		return list;
	}

	@RequestMapping(value = "UserEdit")
	@ResponseBody
	public Integer user_edit(HttpServletRequest request, Sysuser sysuser) {
		systemManagerService.user_edit(sysuser);
		return 1;
	}

	@RequestMapping(value = "UserAdd")
	@ResponseBody
	public Integer user_add(HttpServletRequest request, Sysuser sysuser) {

		systemManagerService.user_add(sysuser);
		return 1;
	}

	@RequestMapping(value = "UserDel")
	@ResponseBody
	public Integer user_del(HttpServletRequest request, Sysuser sysuser) {
		systemManagerService.user_del(sysuser);
		return 1;
	}

	@RequestMapping(value = "CustomField")
	public String CustomField(HttpServletRequest request,
			MemcustomfieldFormBean memcustomfieldFormBean) {
		memcustomfieldFormBean.setPageSize(1000);
		memcustomfieldFormBean = systemManagerService
				.getPage(memcustomfieldFormBean);
		request.setAttribute("memcustomfieldFormBean", memcustomfieldFormBean);
		return "CustomField.jsp";
	}

	@RequestMapping(value = "CustomFieldAdd")
	@ResponseBody
	public Integer customField_add(HttpServletRequest request,
			Memcustomfield memcustomfield) {
		memcustomfield.setCustomfielduserid(this.getUserId());
		memcustomfield.setCustomfieldshopid(this.getUserShopId());
		systemManagerService.customField_add(memcustomfield);
		return 1;
	}

	@RequestMapping(value = "CustomFieldEdit")
	@ResponseBody
	public Integer customField_eidt(HttpServletRequest request,
			Memcustomfield memcustomfield) {
		systemManagerService.customField_eidt(memcustomfield);
		return 1;
	}

	@RequestMapping(value = "GetCustomField")
	@ResponseBody
	public Memcustomfield getCustomField(HttpServletRequest request,
			Memcustomfield memcustomfield) {
		memcustomfield = systemManagerService.getCustomField(memcustomfield);
		return memcustomfield;
	}

	@RequestMapping(value = "GroupAuthority")
	public String group_authority(HttpServletRequest request, Integer groupid,
			Integer parentgroupid) {
		Sysgroup sysgroup = new Sysgroup();
		sysgroup.setParentidstr(this.getRoleId() + "");

		List<Sysmodule> listmoduleaction = systemManagerService
				.listSysmoduleandaction(this.getRoleId());

		request.setAttribute("listmoduleaction",
				ListToTreeUtils.getSysModuleTree(listmoduleaction));
		if (groupid != null && groupid != 0) {
			sysgroup = systemManagerService.group_authority(groupid);

		}
		sysgroup.setParentgroupid(this.getRoleId());
		List<Sysgroup> sysgroups = systemManagerService
				.getGroupListByShopAndGroup(sysgroup);

		for (Sysgroup s : sysgroups) {
			if (s.getGroupid() == parentgroupid) {
				sysgroup.setParentidstr(s.getParentidstr());
			}
		}

		if (parentgroupid == null) {
			parentgroupid = this.getRoleId();
		}
		sysgroup.setParentgroupid(parentgroupid);
		request.setAttribute("sysgroup", sysgroup);
		request.setAttribute("sysgroups", sysgroups);
		return "GroupAuthority.jsp";
	}

	@RequestMapping(value = "AuthoritySave", method = RequestMethod.POST)
	@ResponseBody
	public Integer authority_save(HttpServletRequest request, Sysgroup sysgroup) {
		sysgroup.setCreateuserid(getUserId());
		int result = systemManagerService.authority_save(sysgroup);
		System.out.println(result);

		return result;
	}

	@RequestMapping(value = "GroupDel", method = RequestMethod.POST)
	@ResponseBody
	public Integer group_del(HttpServletRequest request, Integer groupid) {
		int result = systemManagerService.group_del(groupid);
		return result;
	}

	@RequestMapping(value = "ShopAdd")
	@ResponseBody
	public Integer shop_add(HttpServletRequest request, Sysshop sysshop) {

		int result = systemManagerService.shop_add(sysshop);
		return result;
	}

	@RequestMapping(value = "ShopEdit")
	@ResponseBody
	public Integer shop_update(HttpServletRequest request, Sysshop sysshop) {

		int result = systemManagerService.shop_update(sysshop);
		return result;
	}

	@RequestMapping(value = "GetShopInfo")
	@ResponseBody
	public Sysshop getShopInfo(HttpServletRequest request, Integer shopid) {
		Sysshop sysshop = systemManagerService.getShopInfo(shopid);
		return sysshop;
	}

	@RequestMapping(value = "ShopAuthority")
	public String shop_authority(HttpServletRequest request,
			SysshopFormBean sysshopFormBean) {
		Integer shopid = sysshopFormBean.getShopid();
		if (UserUtils.isNotAdmin(this.getUserId())) {
			sysshopFormBean.setShopauthorityshopid(this.getUserShopId());
		}else{
			sysshopFormBean.setShopauthorityshopid(1);
		}
		sysshopFormBean = systemManagerService.getPage(sysshopFormBean);
		String mydata = systemManagerService.getSysshopauthorityData(shopid);
		for (Sysshop sysshop : sysshopFormBean.getRows()) {
			Integer shopidtemp = sysshop.getShopid();
			if ((","+mydata+",").contains(","+shopidtemp + ",")) {
				sysshop.setIscheck(true);
			}
		}
		request.setAttribute("data", mydata);
		request.setAttribute("sysshopFormBean", sysshopFormBean);
		return "ShopAuthority.jsp";
	}

	@RequestMapping(value = "saveShopAuthority")
	@ResponseBody
	public Integer saveShopAuthority(HttpServletRequest request,
			Integer shopid,
			// 选中数据
			String listck,
			// 原数据
			String data,
			// 分页数据
			String fydata) {

		String[] fwArr = fydata.split(",");
		int len = fwArr.length;
		int start = Integer.parseInt(fwArr[0]);
		int end = Integer.parseInt(fwArr[len - 1]);

		StringBuffer result = new StringBuffer();
		int flag = 0;
		String[] dataArr = data.split(",");
		if(shopid<start){
			result.append(shopid+",");
		}

		for (String d : dataArr) {
			int dq = Integer.parseInt(d);

			if (dq <= start && dq >= end) {
				result.append(dq + ",");
			} else {
				if (flag == 0) {

					if (StringUtil.isNotBlank(listck)) {
						String[] listckArr = listck.split(",");
						int astart = start;
						int flagb = 0;
						int aend=astart;
						for (String a : listckArr) {
							 aend = Integer.parseInt(a);
							if (shopid > astart && shopid <= aend && flagb == 0) {
								result.append(shopid + ",");
								flagb = 1;
							}
							result.append(a + ",");
							astart = aend;
						}
						if(shopid>aend&&shopid<=end){
							result.append(shopid + ",");
						}

					} else {
						if (shopid > start && shopid < end) {
							result.append(shopid + ",");
						}
					}
					flag = 1;
				}

			}
		}
		if(shopid>end){
			result.append(shopid+",");
		}

		if (',' == result.charAt(result.length() - 1)) {
			result.delete(result.lastIndexOf(","), result.length());
		}

		Sysshopauthority sysshopauthority = new Sysshopauthority();
		sysshopauthority.setShopauthorityshopid(shopid);
		sysshopauthority.setShopauthoritydata(result.toString());
		systemManagerService.save_shop_authority(sysshopauthority);

		return 1;
	}
	@RequestMapping(value = "saveSysParameter")
	@ResponseBody
	public Integer saveSysParameter(HttpServletRequest request,Sysparameter sysparameter){
		int result=systemManagerService.save_sysParameter(sysparameter);
		memoryListener.reloadSysParameter();
		return result;
	}
	
	@RequestMapping(value = "CustomFieldDel")
	@ResponseBody
	public Integer customField_del(HttpServletRequest request,Integer customfieldid){
		
		systemManagerService.customField_del(customfieldid);
		return 1;
	}
	@RequestMapping(value = "GetNextAreaName")
	@ResponseBody
	public List<Sysarea> getnext_areaname(HttpServletRequest request,Integer pid){
		System.out.println(pid);
		return systemManagerService.getnext_areaname(pid);
	}
	
	
	@RequestMapping(value = "SysNoticeList")
	public String SysNoticeList(HttpServletRequest request,SysnoticeFormBean sysnoticeFormBean){
		sysnoticeFormBean=systemManagerService.getPage(sysnoticeFormBean);
		return "SysNoticeList.jsp";
	}
	
	@RequestMapping(value = "NoticeAdd")
	@ResponseBody
	public Integer NoticeAdd(HttpServletRequest request,Sysnotice sysnotice){
		Integer result=systemManagerService.noticeAdd(sysnotice);
		return result;
	}
	@RequestMapping(value = "NoticeEdit")
	@ResponseBody
	public Integer NoticeEdit(HttpServletRequest request,Sysnotice sysnotice){
		Integer result=systemManagerService.noticeEdit(sysnotice);
		return result;
	}
	
	
	@RequestMapping(value = "NoticeDel")
	@ResponseBody
	public Integer noticeDel(HttpServletRequest request,Integer sysnoticeid){
		Integer result=systemManagerService.noticeDel(sysnoticeid);
		return result;
	}
	
	@RequestMapping(value = "SysNotice")
	public String SysNotice(HttpServletRequest request,Integer sysnoticeid){
		
		
		if(sysnoticeid!=null&&sysnoticeid!=0){
			Sysnotice sysnotice=systemManagerService.findSysnotice(sysnoticeid);
			request.setAttribute("sysnotice", sysnotice);
		}
		
		
		return "SysNotice.jsp";
	}
	
	
	@RequestMapping(value = "SysCustomRemind")
	public String SysCustomRemind(HttpServletRequest request,
			SyscustomremindFormBean syscustomremindFormBean){
		
		syscustomremindFormBean=systemManagerService.getPage(syscustomremindFormBean);
		
		
		
		return "SysCustomRemind.jsp";
	}
	@RequestMapping(value = "CustomRemindAdd")
	@ResponseBody
	public Integer customRemindAdd(HttpServletRequest request,Syscustomremind syscustomremind){
		syscustomremind.setCustomremindshopid(getUserShopId());
		syscustomremind.setCustomreminduserid(getUserId());
		systemManagerService.customRemindAdd(syscustomremind);
		
		return 1;
	}
	@RequestMapping(value = "CustomRemindEdit")
	@ResponseBody
	public Integer customRemindEdit(HttpServletRequest request,Syscustomremind syscustomremind){
		systemManagerService.customRemindEdit(syscustomremind);
		return 1;
	}
	
	@RequestMapping(value = "CustomRemindDel")
	@ResponseBody
	public Integer customRemindDel(HttpServletRequest request,Integer customremindid){
		systemManagerService.customRemindDel(customremindid);
		return 1;
	}
	
	@RequestMapping(value = "Message")
	public String Message(HttpServletRequest request,MessageFormBean messageFormBean){
		messageFormBean=systemManagerService.getPage(messageFormBean);
		return "Message.jsp";
	}
	
	
	
	@RequestMapping(value = "SysNoticeShow")
	public String SysNoticeShow(HttpServletRequest request,Integer sysnoticeid){
		
		
		if(sysnoticeid!=null&&sysnoticeid!=0){
			Sysnotice sysnotice=systemManagerService.findSysnotice(sysnoticeid);
			request.setAttribute("sysnotice", sysnotice);
		}
		
		
		return "SysNoticeShow.jsp";
	}
	
	@RequestMapping(value="StaffClassList")
	public String staffClassList(HttpServletRequest request,StaffclassFormBean staffclassFormBean){
		staffclassFormBean=systemManagerService.getPage(staffclassFormBean);
		return "StaffClassList.jsp";
	}
	
	@RequestMapping(value="StaffList")
	public String staffList(HttpServletRequest request,StaffFormBean staffFormBean){
		staffFormBean=systemManagerService.getPage(staffFormBean);
		List<Staffclass> staffclassList=systemManagerService.staffClassGet(new Staffclass());
		request.setAttribute("staffclassList", staffclassList);
		return "StaffList.jsp";
	}
	@RequestMapping(value = "GetStaffList")
	@ResponseBody
	public StaffFormBean GetStaffList(HttpServletRequest request,StaffFormBean staffFormBean){
		staffFormBean=systemManagerService.getPage(staffFormBean);
		return staffFormBean;
	}
	
	@RequestMapping(value="StaffClassAdd")
	@ResponseBody
	public Integer staffClassAdd(HttpServletRequest request,Staffclass staffclass){
		Integer result=systemManagerService.staffClassAdd(staffclass);
		return result;
	}
	
	@RequestMapping(value="StaffClassEdit")
	@ResponseBody
	public Integer staffClassEdit(HttpServletRequest request,Staffclass staffclass){
		Integer result=systemManagerService.staffClassEdit(staffclass);
		return result;
	}
	@RequestMapping(value="StaffClassDelete")
	@ResponseBody
	public Integer staffClassDelete(HttpServletRequest request,Integer classid){
		Integer result=systemManagerService.staffClassDelete(classid);
		return result;
	}
	
	@RequestMapping(value="GetStaffClass")
	@ResponseBody
	public List<Staffclass> getStaffClass(HttpServletRequest request,Staffclass staffclass){
		List<Staffclass> staffclassList=systemManagerService.staffClassGet(staffclass);
		return staffclassList;
	}
	
	@RequestMapping(value="StaffAdd")
	@ResponseBody
	public Integer staffAdd(HttpServletRequest request,Staff staff){
		Integer result=systemManagerService.staffAdd(staff);
		return result;
	}
	
	@RequestMapping(value="StaffEdit")
	@ResponseBody
	public Integer staffEdit(HttpServletRequest request,Staff staff){
		Integer result=systemManagerService.staffEdit(staff);
		return result;
	}
	
	@RequestMapping(value="StaffDelete")
	@ResponseBody
	public Integer StaffDelete(HttpServletRequest request,Integer staffid){
		Integer result=systemManagerService.staffDelete(staffid);
		return result;
	}
	
	@RequestMapping(value="GetStaff")
	@ResponseBody
	public List<Staff> getStaff(HttpServletRequest request,Staff staff){
		List<Staff> staffList=systemManagerService.staffGet(staff);
		return staffList;
	}
}
