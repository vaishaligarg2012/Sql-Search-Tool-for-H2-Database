package com.Cmail.Filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/GmailHomeController")
public class HomePageRedirect implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter initialized");
		
		
	}
	
    public void destroy() {
    	System.out.println("Filter destroyed");
	}                 

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			PrintWriter out=response.getWriter();
			out.println("Before Processing the Request-filter 1<br/>");
			
			chain.doFilter(request, response);
			
			out.println("<br/>After Processing the Request-filter 1");
	}

	

}
