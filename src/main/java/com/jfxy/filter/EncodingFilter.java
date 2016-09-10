package com.jfxy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤器
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
public class EncodingFilter implements Filter {

	private String charSet;
	
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding(this.charSet);
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.charSet = config.getInitParameter("charset");
	}

}
