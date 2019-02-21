package com.kfit.Filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

//过滤器，检票员例子
//@WebFilter(urlPatterns="/*",filterName="loginFilter")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
//		HttpServletResponse resp = (HttpServletResponse)response;
		System.out.println("FilterConfig doFilter");
		//resp.sendRedirect("/index.html");
		chain.doFilter(request, response);
		
	}
	@Override
	public void init(FilterConfig fi) throws ServletException{
		System.out.println("LoginFilter init");
	}
//	@Override
//public void doFilter(ServletRequest s,ServletResponse res, FilterChain chain)throws IOException,ServletException{
//		
//	}
//	@Override
//	public void destroy{
//		
//	}
}
