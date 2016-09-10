package com.jfxy.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jfxy.dao.MemcustomfieldDao;
import com.jfxy.dao.MessageDao;
import com.jfxy.dao.StaffDao;
import com.jfxy.dao.StaffclassDao;
import com.jfxy.dao.SyscustomremindDao;
import com.jfxy.dao.SysgroupDao;
import com.jfxy.dao.SysgroupauthorityDao;
import com.jfxy.dao.SyslogDao;
import com.jfxy.dao.SysmoduleDao;
import com.jfxy.dao.SysnoticeDao;
import com.jfxy.dao.SysparameterDao;
import com.jfxy.dao.SysshopDao;
import com.jfxy.dao.SysshopauthorityDao;
import com.jfxy.dao.SysuserDao;
import com.jfxy.dao.WeixinmenuDao;
import com.jfxy.dao.WeixinnewsDao;
import com.jfxy.dao.WeixinruleDao;
import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Memcustomfield;
import com.jfxy.pojo.Message;
import com.jfxy.pojo.Staff;
import com.jfxy.pojo.Staffclass;
import com.jfxy.pojo.Sysarea;
import com.jfxy.pojo.Syscustomremind;
import com.jfxy.pojo.Sysgroup;
import com.jfxy.pojo.Sysgroupauthority;
import com.jfxy.pojo.Syslog;
import com.jfxy.pojo.Sysmodule;
import com.jfxy.pojo.Sysnotice;
import com.jfxy.pojo.Sysparameter;
import com.jfxy.pojo.Sysshop;
import com.jfxy.pojo.Sysshopauthority;
import com.jfxy.pojo.Sysuser;
import com.jfxy.pojo.Weixinmenu;
import com.jfxy.pojo.Weixinnews;
import com.jfxy.pojo.Weixinrule;
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
import com.jfxy.util.Md5Utils;
@Transactional
@Service("systemService")
public class SystemManagerServiceImpl implements SystemManagerService{

	
	
	@Resource
	private WeixinruleDao weixinruleDao;
	
	

	@Resource
	private WeixinmenuDao weixinmenuDao;
	
	@Resource
	private WeixinnewsDao weixinnewsDao;
	@Resource
	private SysuserDao sysuserDao;
	@Resource
	private SysgroupDao sysgroupDao;
	@Resource
	private SysshopDao sysshopDao;
	@Resource
	private SyslogDao syslogDao;
	
	@Resource
	private MemcustomfieldDao memcustomfieldDao;
	@Resource
	private SysmoduleDao sysmoduleDao;
	@Resource
	private SysgroupauthorityDao sysgroupauthorityDao;
	@Resource
	private SysshopauthorityDao sysshopauthorityDao;
	@Resource
	private SysparameterDao sysparameterDao;
	
	@Resource
	private SysnoticeDao sysnoticeDao;
	
	@Resource
	private MemoryListener memoryListener;
	
	@Resource
	private SyscustomremindDao syscustomremindDao;
	
	@Resource
	private MessageDao messageDao;
	
	@Resource
	private StaffclassDao staffclassDao;
	@Resource
	private StaffDao staffDao;

	
	public WeixinruleFormBean getPage(WeixinruleFormBean weixinruleFormBean) {

		int total = weixinruleDao.count(weixinruleFormBean);
		weixinruleFormBean.setTotal(total);
		List<Weixinrule> rows = weixinruleDao.pageList(weixinruleFormBean);
		weixinruleFormBean.setDatas(rows);
		

		return weixinruleFormBean;
	}
	
	public SyslogFormBean getPage(SyslogFormBean syslogFormBean){
		int total = syslogDao.count(syslogFormBean);
		syslogFormBean.setTotal(total);
		List<Syslog> rows = syslogDao.pageList(syslogFormBean);
		syslogFormBean.setDatas(rows);
		

		return syslogFormBean;
	}
	
	
	public MemcustomfieldFormBean getPage(MemcustomfieldFormBean memcustomfieldFormBean){
		List<Memcustomfield> rows = memcustomfieldDao.pageList(memcustomfieldFormBean);
		memcustomfieldFormBean.setDatas(rows);
		return memcustomfieldFormBean;
	}
	
	public WeixinmenuFormBean getPage(WeixinmenuFormBean weixinruleFormBean) {

		int total = weixinmenuDao.count(weixinruleFormBean);
		weixinruleFormBean.setTotal(total);
		//List<Weixinmenu> rows = weixinmenuDao.pageList(weixinruleFormBean);
		List<Weixinmenu> rows = weixinmenuDao.findWeixinmenu(0);
		weixinruleFormBean.setDatas(rows);
		//List<Weixinmenu> list2 = weixinmenuDao.findWeixinmenu(0);
		//System.out.println(list2);
		return weixinruleFormBean;
	}
	
	public WeixinnewsFormBean getPage(WeixinnewsFormBean weixinnewsFormBean) {

		int total = weixinnewsDao.count(weixinnewsFormBean);
		weixinnewsFormBean.setTotal(total);
		List<Weixinnews> rows = weixinnewsDao.pageList(weixinnewsFormBean);
		weixinnewsFormBean.setDatas(rows);
		
		
		

		return weixinnewsFormBean;
	}
	
	public SysuserFormBean getPage(SysuserFormBean sysuserFormBean) {

		int total = sysuserDao.count(sysuserFormBean);
		sysuserFormBean.setTotal(total);
		List<Sysuser> rows = sysuserDao.pageList(sysuserFormBean);
		sysuserFormBean.setDatas(rows);
		
		
		

		return sysuserFormBean;
	}
	
	public SysgroupFormBean getPage(SysgroupFormBean sysgroupFormBean) {

		int total = sysgroupDao.count(sysgroupFormBean);
		sysgroupFormBean.setTotal(total);
		List<Sysgroup> rows = sysgroupDao.pageList(sysgroupFormBean);
		sysgroupFormBean.setDatas(ListToTreeUtils.getSysGroupTree(rows));
		
		
		

		return sysgroupFormBean;
	}
	
	public SysshopFormBean getPage(SysshopFormBean sysshopFormBean){
		int total = sysshopDao.count(sysshopFormBean);
		sysshopFormBean.setTotal(total);
		List<Sysshop> rows = sysshopDao.pageList(sysshopFormBean);
		sysshopFormBean.setDatas(rows);
		
		
		

		return sysshopFormBean;
	}
	public StaffclassFormBean getPage(StaffclassFormBean staffclassFormBean){
		int total = staffclassDao.count(staffclassFormBean);
		staffclassFormBean.setTotal(total);
		List<Staffclass> rows = staffclassDao.pageList(staffclassFormBean);
		staffclassFormBean.setDatas(rows);
		
		return staffclassFormBean;
	}
	
	public StaffFormBean getPage(StaffFormBean staffFormBean){
		int total = staffDao.count(staffFormBean);
		staffFormBean.setTotal(total);
		List<Staff> rows = staffDao.pageList(staffFormBean);
		staffFormBean.setDatas(rows);
		
		return staffFormBean;
	}
	
	public Integer staffClassAdd(Staffclass staffclass){
		staffclassDao.insert(staffclass);
		return 1;
	}
	
	public Integer staffClassEdit(Staffclass staffclass){
		staffclassDao.update(staffclass);
		return 1;
	}
	
	public Integer staffClassDelete(Integer classid){
		staffclassDao.deleteById(classid);
		return 1;
	}
	
	public Integer staffAdd(Staff staff){
		staffDao.insert(staff);
		return 1;
	}
	
	public Integer staffEdit(Staff staff){
		staffDao.update(staff);
		return 1;
	}
	
	public Integer staffDelete(Integer staffid){
		staffDao.deleteById(staffid);
		return 1;
	}
	
	public List<Staffclass> staffClassGet(Staffclass staffclass){
		return staffclassDao.list(staffclass);
	}
	public List<Staff> staffGet(Staff staff){
		return staffDao.list(staff);
	}

	
	public String getSysshopauthorityData(Integer shopid){
	
		
		String data= sysshopauthorityDao.querysysshopdata(shopid);
		
		
		return data;
		
	}
	
	public void changePassword(Sysuser sysuser){
		String password=sysuser.getUserpassword();
		String md5password=Md5Utils.encrypt(password);
		sysuser.setUserpassword(md5password);
		
		sysuserDao.updatePassword(sysuser);
	}
	
	public Sysuser getUserInfo(Sysuser sysuser){
		return sysuserDao.findByUserid(sysuser.getUserid());
	}
	
	public List<Sysgroup> getGroupListByShopAndGroup(Sysgroup sysgroup){
		List<Sysgroup> list=sysgroupDao.list(sysgroup);
		
		return ListToTreeUtils.getSysGroupTree(list);
	}
	
	
	public int user_edit(Sysuser sysuser){
		sysuserDao.update(sysuser);
		return 1;
	}
	
	public int user_add(Sysuser sysuser){
		String password=sysuser.getUserpassword();
		String md5password=Md5Utils.encrypt(password);
		sysuser.setUserpassword(md5password);
		sysuserDao.insert(sysuser);
		return 1;
	}
	
	public int user_del(Sysuser sysuser){
		sysuserDao.deleteById(sysuser.getUserid());
		return 1;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int customField_add(Memcustomfield memcustomfield){
		try {
			memcustomfieldDao.insert(memcustomfield);
			
			Map<String, String> map=new HashMap<String, String>();
			
			StringBuffer sb=new StringBuffer("alter table ");
			
			Integer ctype=memcustomfield.getCustomtype();
			if(ctype!=null){
				if(ctype==1){
					sb.append("mem");
					
				}else if(ctype==2){
					sb.append("goods");
				}else{
					return 2;
				}
			}else{
				return 3;
			}
			
			
			sb.append(" add column ").append(memcustomfield.getCustomfield()).append(" ");
			String type=memcustomfield.getCustomfieldtype();
			int len=200;
			if("text".equals(type)){
				sb.append("varchar(").append(len).append(")");
			}else if("select".equals(type)){
				String[] ss=memcustomfield.getCustomfieldinfo().split("\\|");
				int l=ss.length;
				sb.append(" enum(");
				for(int i=0;i<l;i++){
					sb.append("'"+ss[i]+"'");
					if(i<l-1){
						sb.append(",");
					}
				}
				
				sb.append(") ");
			}else if("date".equals(type)){
				sb.append("varchar(").append(32).append(")");
			}
			
			if(memcustomfield.getCustomfieldisnull()==null||memcustomfield.getCustomfieldisnull()==0){
				sb.append(" not null");
			}
			
			map.put("sql", sb.toString());
			memcustomfieldDao.alterTableSql(map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		memoryListener.customfieldInit();
		return 1;
	}
	
	public int customField_eidt(Memcustomfield memcustomfield){
		
		memcustomfieldDao.update(memcustomfield);
		
		memoryListener.customfieldInit();
		return 1;
	}
	
	public Memcustomfield getCustomField(Memcustomfield memcustomfield){
		memcustomfield=memcustomfieldDao.findbyid(memcustomfield.getCustomfieldid());
		return memcustomfield;
	}
	
	public Sysgroup group_authority(Integer groupid){
		Sysgroup sysgroup= sysgroupDao.querybyid(groupid);
		
		
		return sysgroup;
	}
	
	public List<Sysmodule> all_group_authority(){
		List<Sysmodule> list=sysmoduleDao.findModuleList(1);
		return list;
	}
	
	public List<Sysmodule> listSysmoduleandaction(Integer groupid){
		List<Sysmodule> listSysmoduleandaction=sysmoduleDao.findModuleList(groupid);
		return listSysmoduleandaction;
	}
	
	public int authority_save(Sysgroup sysgroup){
		if(sysgroup.getGroupid()==null){
			
			String result=sysgroup.getParentidstr();
			
			String parentid=sysgroup.getParentgroupid()+"/";
			if(!result.contains(parentid)){
				if(result.endsWith("/")){
					result=result+parentid;
				}else{
					result=result+"/"+parentid;
				}
			}
			sysgroup.setParentidstr(result);
			sysgroupDao.insert(sysgroup);
			
			for(Sysgroupauthority sysgroupauthority:sysgroup.getSysgroupauthorityList()){
				sysgroupauthority.setGroupid(sysgroup.getGroupid());
			}
			
			sysgroupauthorityDao.insertBatch(sysgroup.getSysgroupauthorityList());
			return 1;
		}else{
			sysgroupDao.update(sysgroup);
			sysgroupauthorityDao.deleteBygroupId(sysgroup.getGroupid());
			for(Sysgroupauthority sysgroupauthority:sysgroup.getSysgroupauthorityList()){
				sysgroupauthority.setGroupid(sysgroup.getGroupid());
			}
			sysgroupauthorityDao.insertBatch(sysgroup.getSysgroupauthorityList());
			return 2;
		}
		
		
	}
	
	public int group_del(Integer groupid){
		sysgroupDao.deleteById(groupid);
		sysgroupauthorityDao.deleteBygroupId(groupid);
		return 1;
	}
	public int shop_add(Sysshop sysshop){
		sysshopDao.insert(sysshop);
		Sysshopauthority sysshopauthority=new Sysshopauthority();
		sysshopauthority.setShopauthorityshopid(sysshop.getShopid());
		sysshopauthority.setShopauthoritydata(sysshop.getShopid()+"");
		sysshopauthorityDao.insert(sysshopauthority);
		sysshopauthorityDao.updateshopauthorydate(sysshop.getShopid());
		
		return 1;
	}
	
	public int shop_update(Sysshop sysshop){
		sysshopDao.update(sysshop);
		return 1;
	}
	
	public Sysshop getShopInfo(Integer shopid){
		Sysshop sysshop=sysshopDao.findbyid(shopid);
		return sysshop;
	}
	
	public int save_shop_authority(Sysshopauthority sysshopauthority){
		sysshopauthorityDao.update(sysshopauthority);
		return 1;
	}
	
	public int save_sysParameter(Sysparameter sysparameter){
		sysparameterDao.update(sysparameter);
		
		return 1;
	}
	
	public int customField_del(Integer customfieldid ){
		
		Memcustomfield memcustomfield=memcustomfieldDao.findbyid(customfieldid);
		memcustomfieldDao.deleteById(customfieldid);
		Map<String, String> map=new HashMap<String, String>();
		
		StringBuffer sb=new StringBuffer("alter table ");
		Integer ctype=memcustomfield.getCustomtype();
		if(ctype!=null){
			if(ctype==1){
				sb.append("mem");
				
			}else if(ctype==2){
				sb.append("goods");
			}else{
				return 2;
			}
		}else{
			return 3;
		}
		
		
		sb.append(" drop column ").append(memcustomfield.getCustomfield());
		
		map.put("sql", sb.toString());
		memcustomfieldDao.alterTableSql(map);
		
		memoryListener.customfieldInit();
		
		
		
		
		return  1;
	}
	
	public List<Sysarea> getnext_areaname(Integer pid){
		List<Sysarea> areaList=new ArrayList<Sysarea>();
		if(pid==null){
			pid=0;
		}
		for(Sysarea area:MemoryListener.areaList){
			if(area.getPid().intValue()==pid.intValue()){
				areaList.add(area);
			}
		}
		return areaList;
	}
	
	
	public SysnoticeFormBean getPage(SysnoticeFormBean sysnoticeFormBean) {

		int total = sysnoticeDao.count(sysnoticeFormBean);
		sysnoticeFormBean.setTotal(total);
		List<Sysnotice> rows = sysnoticeDao.pageList(sysnoticeFormBean);
		sysnoticeFormBean.setDatas(rows);
		

		return sysnoticeFormBean;
	}
	
	public Integer noticeAdd(Sysnotice sysnotice){
		sysnoticeDao.insert(sysnotice);
		return 1;
	}
	
	public Integer noticeEdit(Sysnotice sysnotice){
		sysnoticeDao.update(sysnotice);
		return 1;
	}
	
	public Integer noticeDel(Integer sysnoticeid){
		sysnoticeDao.deleteById(sysnoticeid);
		return 1;
	}
	
	public Sysnotice findSysnotice(Integer sysnoticeid){
		return sysnoticeDao.findSysnotice(sysnoticeid);
	}
	
	
	public SyscustomremindFormBean getPage(SyscustomremindFormBean syscustomremindFormBean) {

		int total = syscustomremindDao.count(syscustomremindFormBean);
		syscustomremindFormBean.setTotal(total);
		List<Syscustomremind> rows = syscustomremindDao.pageList(syscustomremindFormBean);
		syscustomremindFormBean.setDatas(rows);
		

		return syscustomremindFormBean;
	}
	
	public Integer customRemindAdd(Syscustomremind syscustomremind){
		syscustomremindDao.insert(syscustomremind);
		return 1;
	}
	
	public Integer customRemindEdit(Syscustomremind syscustomremind){
		syscustomremindDao.update(syscustomremind);
		return 1;
	}
	public Integer customRemindDel(Integer customremindid){
		syscustomremindDao.deleteById(customremindid);
		return 1;
	}
	
	public MessageFormBean getPage(MessageFormBean messageFormBean){

		int total = messageDao.count(messageFormBean);
		messageFormBean.setTotal(total);
		List<Message> rows = messageDao.pageList(messageFormBean);
		messageFormBean.setDatas(rows);
		

		return messageFormBean;
	}
}
