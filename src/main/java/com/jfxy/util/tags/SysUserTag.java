package com.jfxy.util.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Sysuser;

public class SysUserTag extends BaseTag {

	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签

	private Integer userid;// 订单类型
	@Override
	public void doTag() throws JspException, IOException {
		

		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息、
		
		List<Sysuser> userList=MemoryListener.listUser;
		for(Sysuser user:userList){
			if(user.getUserid()==userid){
				sb.append("<option value=\""+user.getUserid()+"\" selected=\"selected\">"+user.getUsername()+"</option>");
			}else{
				sb.append("<option value=\""+user.getUserid()+"\">"+user.getUsername()+"</option>");
			}
			
		}
		

		out.print(sb);
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	

}