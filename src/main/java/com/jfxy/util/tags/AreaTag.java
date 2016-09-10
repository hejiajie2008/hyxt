package com.jfxy.util.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Sysarea;

/**
 * 
 * 菜单标签
 * 
 * @author hejiajie
 * @version 2.0, 2016年3月8日
 */
public class AreaTag extends BaseTag {

	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签

	private String areaName;

	private Integer memprovince;
	private Integer memcity;
	private Integer memcounty;
	private Integer memvillage;

	@Override
	public void doTag() throws JspException, IOException {
		List<Sysarea> sysareaList = MemoryListener.areaList;
		memprovince = memprovince == null ? 0 : memprovince;
		memcity = memcity == null ? 0 : memcity;
		memcounty = memcounty == null ? 0 : memcounty;
		memvillage = memvillage == null ? 0 : memvillage;

		sb.append("<div style='width: 100%;'>")
				.append("<table cellpadding='0' cellspacing='0' bordercolor='#434343' class='tableStyle' style='text-align: left'>")
				.append("<tr>");

		// 显示省
		sb.append("<td> <select id=\"")
				.append(areaName)
				.append("sltProvince\" name=\"memprovince\"  class=\"selectWidth\" style=\"width: 120px\">");
		sb.append("<option value=\"\">=== 请选择 ===</option>");
		for (Sysarea area : sysareaList) {
			if (area.getPid().intValue() == 0) {

				if (memprovince == 0) {
					sb.append("<option value=\"").append(area.getId())
							.append("\">").append(area.getName())
							.append("</option>");
				} else {
					if (area.getId().intValue() == memprovince.intValue()) {
						sb.append("<option selected=\"selected\"  value=\"")
								.append(area.getId()).append("\">")
								.append(area.getName()).append("</option>");
					} else {
						sb.append("<option value=\"").append(area.getId())
								.append("\">").append(area.getName())
								.append("</option>");
					}
				}

			}
		}
		sb.append("</select></td>");

		// 显示市
		sb.append("<td> <select id=\"")
				.append(areaName)
				.append("sltCity\" name=\"memcity\"  class=\"selectWidth\" style=\"width: 120px\">");
		sb.append("<option value=\"\">=== 请选择 ===</option>");
		
		if(memprovince!=0){
			for (Sysarea area : sysareaList) {
				if (area.getPid().intValue() == memprovince.intValue()) {
					if (memcity == 0) {
						sb.append("<option value=\"").append(area.getId())
								.append("\">").append(area.getName())
								.append("</option>");
					} else {
						if (area.getId().intValue() == memcity.intValue()) {
							sb.append("<option selected=\"selected\"  value=\"")
									.append(area.getId()).append("\">")
									.append(area.getName()).append("</option>");
						} else {
							sb.append("<option value=\"").append(area.getId())
									.append("\">").append(area.getName())
									.append("</option>");
						}
					}

				}
			}
		}
		
		sb.append("</select></td>");

		// 显示县
		sb.append("<td> <select id=\"")
				.append(areaName)
				.append("sltCounty\" name=\"memcounty\"  class=\"selectWidth\" style=\"width: 120px\">");
		sb.append("<option value=\"\">=== 请选择 ===</option>");
		if(memprovince!=0){
		for (Sysarea area : sysareaList) {
			if (area.getPid().intValue() == memcity.intValue()) {
				if (memcounty == 0) {
					sb.append("<option value=\"").append(area.getId())
							.append("\">").append(area.getName())
							.append("</option>");
				} else {
					if (area.getId().intValue() == memcounty.intValue()) {
						sb.append("<option selected=\"selected\"  value=\"")
								.append(area.getId()).append("\">")
								.append(area.getName()).append("</option>");
					} else {
						sb.append("<option value=\"").append(area.getId())
								.append("\">").append(area.getName())
								.append("</option>");
					}
				}

			}
		}
		}
		sb.append("</select></td>");

		// 显示镇
		sb.append("<td> <select id=\"")
				.append(areaName)
				.append("sltVillage\" name=\"memvillage\"  class=\"selectWidth\" style=\"width: 120px\">");
		sb.append("<option value=\"\">=== 请选择 ===</option>");
		if(memprovince!=0){
		for (Sysarea area : sysareaList) {
			if (area.getPid().intValue() == memcounty.intValue()) {
				if (memvillage == 0) {
					sb.append("<option value=\"").append(area.getId())
							.append("\">").append(area.getName())
							.append("</option>");
				} else {
					if (area.getId().intValue() == memvillage.intValue()) {
						sb.append("<option selected=\"selected\"  value=\"")
								.append(area.getId()).append("\">")
								.append(area.getName()).append("</option>");
					} else {
						sb.append("<option value=\"").append(area.getId())
								.append("\">").append(area.getName())
								.append("</option>");
					}
				}

			}
		}
		}
		sb.append("</select></td>");
		
		
		sb.append("</tr></table></div>");

		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息、

		out.print(sb);
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getMemprovince() {
		return memprovince;
	}

	public void setMemprovince(Integer memprovince) {
		this.memprovince = memprovince;
	}

	public Integer getMemcity() {
		return memcity;
	}

	public void setMemcity(Integer memcity) {
		this.memcity = memcity;
	}

	public Integer getMemcounty() {
		return memcounty;
	}

	public void setMemcounty(Integer memcounty) {
		this.memcounty = memcounty;
	}

	public Integer getMemvillage() {
		return memvillage;
	}

	public void setMemvillage(Integer memvillage) {
		this.memvillage = memvillage;
	}

}
