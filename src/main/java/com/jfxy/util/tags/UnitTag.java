package com.jfxy.util.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import com.jfxy.listener.MemoryListener;

/**
 * 
 * 显示计量单位
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月10日
 */
public class UnitTag extends BaseTag {

	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签


	@Override
	public void doTag() throws JspException, IOException {
		

		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息、
		String uintlist=MemoryListener.sysparameter.getUnitlist();
		
		String[] unitArr=uintlist.split("\\|");
		for(String unit:unitArr){
			//sb.append("<option value=\""+unit+"\" selected=\"selected\">"+unit+"</option>");
			sb.append("<option value=\""+unit+"\" selected=\"selected\">"+unit+"</option>");
		}
		
		

		out.print(sb);
	}
	
	

	
	
	

	

}