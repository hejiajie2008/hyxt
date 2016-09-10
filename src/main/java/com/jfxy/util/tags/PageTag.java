package com.jfxy.util.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class PageTag extends BaseTag {
	private Integer pageIndex;// 当前页数
	private Integer pageCount;// 总页数
	private Integer rowCount;//总记录数
	private Integer pageSize;
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	private String path;// 页面链接
	private String param;// 传入的参数
	
	public void  getHI(int topage, String text,String classtype){
		sb.append(" <a  style=\"margin-right:2px;\"");
		sb.append(classtype);
		sb.append(" href=\"javascript:fyck(");
		sb.append(topage);
		sb.append(",'");
		sb.append(param);
		sb.append("')\">");
		sb.append(text);
		sb.append("</a> ");
	}
	
	
	
	public String leftshow(){
		return "<span>当前第"+this.pageIndex+"/"+this.pageCount+"页 共"+rowCount+"条记录 每页显示"+this.pageSize+"条</span>";
		
	}
	
	int[] pageArr=new int[]{10,20,30,40,50};
	int width=10;
	
	public void rightshow(){
		
		
		
		if(pageIndex>1){
			getHI(1,"首页","");
			getHI(pageIndex-1,"上一页","");
		}else{
			getHI(1,"首页","disabled=\"disabled\"");
			getHI(1,"上一页","disabled=\"disabled\"");
		}
		int start=pageIndex-width/2;
		int end=1;
		
		if(pageCount<=width){
			start=1;
			end=pageCount;
		}else{
			if(pageIndex<=width/2+1){
				start=1;
				end=width;
			}else if(pageIndex<=width*3/2){
				start=pageIndex-width/2+1;
				end=pageIndex+width/2;
			}else{
				start=pageCount-width;
				end=pageCount;
			}
			
		}
		for(int i=start;i<=end;i++){
			if(i==pageIndex){
				getHI(i, i+"", " class=\"cpb\" ");
			}else{
				getHI(i, i+"", "");
			}
			
		}
		if(pageIndex<pageCount){
			getHI(pageIndex+1,"下一页","");
			getHI(pageCount,"尾页","");
		}else{
			getHI(1,"下一页","disabled=\"disabled\"");
			getHI(pageCount,"尾页","disabled=\"disabled\"");
		}
		
		
		sb.append("&nbsp;&nbsp;转到");
		sb.append("<select id=\"page\">");
		for(int i=1;i<=pageCount;i++){
			if(i==pageIndex){
				sb.append("<option value=\""+i+"\" selected=\"true\">"+i+"</option>");
			}else{
				sb.append("<option value=\""+i+"\">"+i+"</option>");
			}
			
		}
		sb.append("</select>");
		sb.append("页<span>&nbsp;每页记录数：</span>");
		sb.append("<select id=\"pagesize\">");
		for(int p:pageArr){
			if(p==pageSize){
				sb.append("<option selected=selected value="+p+">"+p+"</option>");
			}else{
				sb.append("<option  value="+p+">"+p+"</option>");
			}
			
		}
		sb.append("</select>");
		
	}

	
	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签
	@Override
	public void doTag() throws JspException, IOException {

		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息、
		sb.append("<input name=\"PID\" value=\""+getPid()+"\" type=\"hidden\"/>");
		sb.append("<input name=\"page\" value=\""+pageIndex+"\" type=\"hidden\"/>");
		sb.append("<input name=\"pageSize\" value=\""+pageSize+"\" type=\"hidden\"/>");
		sb.append("<ul><li class=\"paginator\" valign=\"bottom\" nowrap=\"true\" style=\"width:360px;float:left;\">");
		sb.append(leftshow());
		sb.append("</li>");
		sb.append("<li align=\"right\" class=\"paginator\" valign=\"bottom\" nowrap=\"true\" style=\"float:right;\">");
		
		rightshow();
		
		sb.append("</li></ul>");
		
		
		/**
		
		//添加首页
		getHI(1,"首页","");
		// 下面的代码显示页码，当前页在中间位置，
		if (this.getPageCount() <= 3) {
			for (int i = 1; i <= this.getPageCount(); i++) {
				// 如果页数小于等于10页,则全部显示

				if (i == pageIndex) {// 如果页码等于当前页，则该页数没有超链接
					
					getHI(i,String.valueOf(i),"class='active'");

				} else {// 否则给出超链接
					
					getHI(i,String.valueOf(i),"");

				}

			}
		} else {// 如果大于10页，则从当前页为中心只显示其中10页

			// 如果当前页是最后一页，则末页和下一页没有超链接
			if (1 < (this.pageIndex - 2)) {
				sb.append(" <li><span>. . . . . . . . . .</span></li> ");
			}

			int minIndex = Math.max(this.pageIndex - 2, 1);
			int maxIndex = Math.min(this.pageIndex + 2, this.getPageCount());

			for (int i = minIndex; i <= maxIndex; i++) {
				if (i == this.pageIndex) {// 如果页码等于当前页，则该页数没有超链接
					getHI(i,String.valueOf(i),"class='active'");
				} else {// 否则给定超链接
					getHI(i,String.valueOf(i),"");
				}
			}

		}

		// 如果当前页是最后一页，则末页和下一页没有超链接
		if (this.pageIndex < (this.pageCount - 2)) {
			sb.append(" <li><span>. . . . . . . . . .</span></li> ");
		}

		// System.out.prIntegerln(sb.toString());

		// 一下代码拼接转到第几页的js代码
		getHI(this.getPageCount(),"尾页","");
		**/
		
		out.print(sb);
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public static void main(String[] args) {
		PageTag pt = new PageTag();
		pt.setPageIndex(13);
		pt.setPageCount(13);
		// pt.setPageList(pageList)
		pt.setPath("index.jsp");
		pt.setParam("pageIndex");

		try {
			pt.doTag();
		} catch (JspException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	
	
}
