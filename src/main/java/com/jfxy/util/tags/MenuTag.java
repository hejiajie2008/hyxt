package com.jfxy.util.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import com.jfxy.pojo.Sysmodule;
/**
 * 
 * 菜单标签
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
public class MenuTag extends BaseTag {

	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签

	

	@Override
	public void doTag() throws JspException, IOException {
		List<Sysmodule> menus=getMenus();

		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息、
		sb.append("<ul class='nav clearfix'>");
		int parentid = -1;
		int flag=0;
		for (Sysmodule sysmodule:menus) {
			if (sysmodule.getModuleparentid() == 0) {

				

				sb.append("<li class='m' target='menu"
						+ sysmodule.getModuleid() + "'><h3><a href='#'>"
						+ sysmodule.getModulecaption() + "</a></h3><li class='s'></li>");
			} else {
				if(flag==0){
					sb.append("</ul><ul class='subNav' style='position: relative;'>");
					flag=1;
				}
				

				if (parentid != sysmodule.getModuleparentid()) {
					
					

					sb.append("<li id='menu"
							+ sysmodule.getModuleparentid()
							+ "' style='position: absolute; top: 0px; display: none; left: 938px;'>");

					parentid = sysmodule.getModuleparentid();

				} else {
					sb.append("<b>|</b>");
				}
				sb.append("<a href='" + sysmodule.getModulelink()+"?PID="+sysmodule.getModuleid()
						+ "' target='mainFrame'>"
						+ sysmodule.getModulecaption() + "</a>");

			}
		}

		sb.append("</ul>");

		out.print(sb);
	}

	

}
