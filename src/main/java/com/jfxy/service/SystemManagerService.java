package com.jfxy.service;


import java.util.List;

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
public interface SystemManagerService {

	
	
	public WeixinruleFormBean getPage(WeixinruleFormBean weixinruleFormBean);
	
	public WeixinmenuFormBean getPage(WeixinmenuFormBean weixinruleFormBean);
	
	public WeixinnewsFormBean getPage(WeixinnewsFormBean weixinnewsFormBean);
	
	public SysuserFormBean getPage(SysuserFormBean sysuserFormBean);
	
	public SysgroupFormBean getPage(SysgroupFormBean sysgroupFormBean);
	
	public SysshopFormBean getPage(SysshopFormBean sysshopFormBean);
	public StaffFormBean getPage(StaffFormBean staffFormBean);
	
	
	public Integer staffClassAdd(Staffclass staffclass);
	
	public Integer staffClassEdit(Staffclass staffclass);
	
	public Integer staffClassDelete(Integer classid);
	
	public Integer staffAdd(Staff staff);
	
	public Integer staffEdit(Staff staff);
	
	public Integer staffDelete(Integer staffid);
	
	public List<Staffclass> staffClassGet(Staffclass staffclass);
	
	public List<Staff> staffGet(Staff staff);
	
	public StaffclassFormBean getPage(StaffclassFormBean staffclassFormBean);

	
	public SyslogFormBean getPage(SyslogFormBean syslogFormBean);
	
	public MemcustomfieldFormBean getPage(MemcustomfieldFormBean memcustomfieldFormBean);
	
	public void changePassword(Sysuser sysuser);
	
	public Sysuser getUserInfo(Sysuser sysuser);
	
	
	public List<Sysgroup> getGroupListByShopAndGroup(Sysgroup sysgroup);
	
	public int user_edit(Sysuser sysuser);
	
	public int user_add(Sysuser sysuser);
	
	public int user_del(Sysuser sysuser);
	
	public int customField_add(Memcustomfield memcustomfield);
	public int customField_eidt(Memcustomfield memcustomfield);
	
	public Memcustomfield getCustomField(Memcustomfield memcustomfield);
	
	public Sysgroup group_authority(Integer groupid);
	
	public List<Sysmodule> all_group_authority();
	
	public int authority_save(Sysgroup sysgroup);
	
	public int group_del(Integer groupid);
	public List<Sysmodule> listSysmoduleandaction(Integer groupid);
	
	public int shop_add(Sysshop sysshop);

	public int shop_update(Sysshop sysshop);
	
	public Sysshop getShopInfo(Integer shopid);
	
	public String getSysshopauthorityData(Integer shopid);
	
	public int save_shop_authority(Sysshopauthority sysshopauthority);
	
	public int save_sysParameter(Sysparameter sysparameter);
	
	public int customField_del(Integer customfieldid );
	
	public List<Sysarea> getnext_areaname(Integer pid);
	
	public SysnoticeFormBean getPage(SysnoticeFormBean sysnoticeFormBean);
	
	public Integer noticeAdd(Sysnotice sysnotice);
	
	public Integer noticeEdit(Sysnotice sysnotice);
	public Integer noticeDel(Integer sysnoticeid);
	
	public Sysnotice findSysnotice(Integer sysnoticeid);
	public SyscustomremindFormBean getPage(SyscustomremindFormBean syscustomremindFormBean);
	
	
	public Integer customRemindAdd(Syscustomremind syscustomremind);
	
	public Integer customRemindEdit(Syscustomremind syscustomremind);
	
	public Integer customRemindDel(Integer customremindid);
	
	
	public MessageFormBean getPage(MessageFormBean messageFormBean);
	
	
}
