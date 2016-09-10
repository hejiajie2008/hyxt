package com.jfxy.util.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jfxy.listener.MemoryListener;
import com.jfxy.util.DateUtil;


public class OrderTag extends SimpleTagSupport {

	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签

	private Integer type;// 订单类型

	@Override
	public void doTag() throws JspException, IOException {
		

		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息、
		String prefix=MemoryListener.prefix.get(type);

		sb.append(prefix+DateUtil.dateRandom());

		out.print(sb);
	}
	
	

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	

	

}