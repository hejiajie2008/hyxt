package com.jfxy.util.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.jfxy.pojo.Sysgroup;
import com.jfxy.pojo.Sysgroupauthority;
import com.jfxy.pojo.Sysmodule;
import com.jfxy.pojo.Sysmoduleaction;

public class GroupAuthorityTag  extends BaseTag {

	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签

	private Sysgroup sysgroup;
	private List<Sysmodule> listSysmoduleandaction;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息、
		int i=0;
		int j=0;
		for(Sysmodule sysmodule:listSysmoduleandaction){
			sb.append("<tr class='td'><td>").append(++i).append("</td><td style='text-align: left; padding-left: 4px;'>")
			.append(sysmodule.getModulecaption())
            .append("<td style='text-align: left;'>")
            .append("<table  class='CssrepeatTable' border='0' style='color:Black;'>")
            .append("<tr>");
			List<Sysmoduleaction> listaction=sysmodule.getSysmoduleactionList();
			for(Sysmoduleaction sysmoduleaction:listaction){
				sb.append("<td><input type='checkbox' id='ChkListPerm")
				.append(sysmodule.getModuleid())
				.append("' ");
				
				if(sysgroup!=null&&sysgroup.getSysgroupauthorityList()!=null){
					
					for(Sysgroupauthority g:sysgroup.getSysgroupauthorityList()){
						if(g.getActionid().intValue()==sysmoduleaction.getActionid().intValue()){
							if(g.getActionvalue()==1){
								sb.append(" checked='checked'");
							}
							
							break;
						}
					}
				}
				
				sb.append(" name='sysgroupauthorityList[").append(j)
				.append("].actionvalue' />");
				
				sb.append("<input type='hidden' name='sysgroupauthorityList[").append(j).append("].actionid' value='")
				.append(sysmoduleaction.getActionid()).append("' />");
				
				sb.append("<input type='hidden' name='sysgroupauthorityList[").append(j).append("].moduleid' value='")
				.append(sysmodule.getModuleid()).append("' />");
				
				sb.append("<input type='hidden' name='sysgroupauthorityList[").append(j).append("].tempc' value='")
				.append(sysmodule.getModuleid()).append("' />");
				
				sb.append(sysmoduleaction.getActioncaption());
				
				sb.append("</td>");
				j++;
			}
			
			sb.append("</tr></table>");
			sb.append("</td></tr>");
			
			
		}
		out.print(sb);
	}

	public Sysgroup getSysgroup() {
		return sysgroup;
	}

	public void setSysgroup(Sysgroup sysgroup) {
		this.sysgroup = sysgroup;
	}

	public List<Sysmodule> getListSysmoduleandaction() {
		return listSysmoduleandaction;
	}

	public void setListSysmoduleandaction(List<Sysmodule> listSysmoduleandaction) {
		this.listSysmoduleandaction = listSysmoduleandaction;
	}

	
	

	

}