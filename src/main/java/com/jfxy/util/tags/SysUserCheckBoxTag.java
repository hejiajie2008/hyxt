package com.jfxy.util.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Sysuser;

public class SysUserCheckBoxTag extends BaseTag {

	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签

	private Integer userid;// 订单类型
	@Override
	public void doTag() throws JspException, IOException {
		

		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息、
		
		List<Sysuser> userList=MemoryListener.listUser;
		sb.append(" <table id=\"cblCustomReminder\" border=\"0\">");
		sb.append("<tr>");
		int i=0;
		for(Sysuser user:userList){
			i++;
			sb.append("<td><span alt=\"")
			.append(i).append("\"><input id=\"cblCustomReminder_1\" type=\"checkbox\" name=\"cblCustomReminder$1\" />");
			sb.append("<label>")
			.append(user.getUsername()).append("</label></span>");
			sb.append("</td>");
			
			if(i%3==0){
				sb.append("</tr>");
				sb.append("<tr>");
			}
			
		}
		sb.append("</tr>");
		sb.append("</table>");

		out.print(sb);
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	

}