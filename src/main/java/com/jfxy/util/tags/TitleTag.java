package com.jfxy.util.tags;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Sysmodule;
import com.jfxy.util.StringUtil;
public class TitleTag extends BaseTag {

	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签


	@Override
	public void doTag() throws JspException, IOException {
	
		
		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息
		sb.append("<a href='").append(MemoryListener.projectName).append("/startPage.jsp'>主页</a>&nbsp;&nbsp;");
		
		List<Sysmodule> menus=MemoryListener.listSysmodule;
		String pid=this.getPid();
		
		
		if(pid!=null){
			Stack<Sysmodule> s=new Stack<Sysmodule>();
			Integer pidInt=Integer.parseInt(pid);
			Integer parentId=pidInt;
			while(parentId!=0){
				for(Sysmodule m:menus){
					if(parentId.intValue()==m.getModuleid().intValue()){
						s.add(m);
						parentId=m.getModuleparentid();
						break;
					}
					
				}
			}
			
			while(!s.empty()){
				Sysmodule m=s.pop();
				sb.append(">&nbsp;&nbsp;");
				
				if(StringUtil.isBlank(m.getModulelink())){
					sb.append(m.getModulecaption());
				}else{
					sb.append("<a href='").append(MemoryListener.projectName).append("/")
					.append(m.getModulelink()).append("?PID=").append(m.getModuleid()).append("'>")
					.append(m.getModulecaption()).append("</a>");
				}
				
				
			}
			
		}
		
		
		

		out.print(sb);
	}
	
	

	
	

	

}