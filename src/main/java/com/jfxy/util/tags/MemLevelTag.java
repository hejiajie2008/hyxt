package com.jfxy.util.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Memlevel;

/**
 * 
 * 会员级别列表
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月10日
 */
public class MemLevelTag extends BaseTag {

	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签
	private Integer levelid;

	@Override
	public void doTag() throws JspException, IOException {
		

		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息、
		List<Memlevel> listMemlevels=MemoryListener.listMemlevels;
		for(Memlevel memlevel:listMemlevels){
			if(levelid!=null&&memlevel.getLevelid()==levelid){
				sb.append("<option value=\""+memlevel.getLevelid()+"\" selected=\"selected\">"+memlevel.getLevelname()+"</option>");
			}else{
				sb.append("<option value=\""+memlevel.getLevelid()+"\" >"+memlevel.getLevelname()+"</option>");
			}
			
		}
		
		

		out.print(sb);
	}

	public Integer getLevelid() {
		return levelid;
	}

	public void setLevelid(Integer levelid) {
		this.levelid = levelid;
	}
	
	
	
	

	
	
	

	

}