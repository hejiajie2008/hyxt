package com.jfxy.util.tags;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Memcustomfield;
/**
 * 
 * 菜单标签
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
public class CustomfieldTag extends BaseTag {

	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签
	private Integer type;
	private Map<String, String> map=null;
	
	public void getType(Memcustomfield memcustomfield){
		
		String type=memcustomfield.getCustomfieldtype();
		String field=memcustomfield.getCustomfield();
		sb.append("<td class='tableStyle_left'><span id='Mem_Custom_T_").append(field).append("'>")
		.append(memcustomfield.getCustomfieldname())
		.append("</span>：</td><td class='tableStyle_right' style='width: 270px'>");
		if("text".equals(type)){
			sb.append("<input type='text' id='Mem_Custom_")
			.append(field).append("' name=\"map['").append(field).append("']\" ");
			if(memcustomfield.getCustomfieldisnull()==1){
				sb.append("isNull='True'");
			}
			if(null!=map){
				if(map.containsKey(field)){
					
					String value=map.get(field);
					value=value==null?"":value;
					sb.append(" value='").append(value).append("' ");
				}
			}
			
			sb.append(" class='border_radius'/></td>");
		}else if("select".equals(type)){
			sb.append("<select id='Mem_Custom_").append(field)
			.append("' name=\"map['").append(field).append("']\" class='selectWidth' ");
			if(memcustomfield.getCustomfieldisnull()==1){
				sb.append("isNull='True'");
			}
			sb.append(" isSelect='true' ><option value=''>===== 请选择 =====</option>");
			String infos=memcustomfield.getCustomfieldinfo();
			for(String info:infos.split("\\|")){
				
				
				sb.append("<option value='").append(info).append("' ");
				
				if(null!=map){
					if(map.containsKey(field)){
						
						if(info.equals(map.get(field))){
							sb.append("  selected='selected' ");
						}
					}
				}
				sb.append(">").append(info).append("</option>");
			}
			sb.append("</select></td>");
		}
		
	}

	

	@Override
	public void doTag() throws JspException, IOException {
		List<Memcustomfield> fields=null;
		if(type==null||type==0){
			fields=MemoryListener.memcustomfields;
		}else{
			fields=MemoryListener.goodscustomfields;
		}
		
		
		int size=fields.size();
		
		if(size%2==0){
			for(int i=0;i<size;i=i+2){
				
				sb.append("<tr>");
				
				getType(fields.get(i));
				
				getType(fields.get(i+1));
				
				
				
				sb.append("</tr>");
			}
		}else{
			for(int i=0;i<size-1;i=i+2){
				sb.append("<tr>");
				getType(fields.get(i));
				getType(fields.get(i+1));
				sb.append("</tr>");
			}
			sb.append("<tr>");
			getType(fields.get(size-1));
			sb.append("<td class='tableStyle_left'></td><td class='tableStyle_right' style='width: 270px'></td>");
			sb.append("</tr>");
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
