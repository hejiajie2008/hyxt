package com.jfxy.util.tags;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Memcustomfield;

public class CustomTableTag extends BaseTag{
	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签
	private Integer type=0;
	
	private Map<String, String> map=null;
	
	@Override
	public void doTag() throws JspException, IOException {
		List<Memcustomfield> fields=null;
		if(type==null||type==0){
			fields=MemoryListener.memcustomfields;
		}else{
			fields=MemoryListener.goodscustomfields;
		}
		
		if(map==null||map.size()==0){
			
			for(Memcustomfield m:fields){
				if(m.getCustomfieldisshow()!=0){
					sb.append("<th>").append(m.getCustomfieldname()).append("</th>");
				}
				
			}
		}else{
			for(Memcustomfield m:fields){
				if(m.getCustomfieldisshow()!=0){
					String field=m.getCustomfield();
					String value=map.get(field);
					if(value==null){
						value="";
					}
					sb.append("<td>").append(value).append("</td>");
				}
				
			}
		}
		
		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息、
		

		out.print(sb);
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	

}
