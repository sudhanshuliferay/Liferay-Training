package com.filter.hook;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class CustomServletFilter implements Filter{

	private final Log log=LogFactoryUtil.getLog(this.getClass());
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("Filter is registered.........");
		String welcomeMessage=filterConfig.getInitParameter("hello");
		log.info("init paramter for this request is : "+welcomeMessage);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("request is registered.........");
		//preprocessing/prefilter
		
		chain.doFilter(request, response);
		
		//postprocessing/postfilter
		log.info("response is served...............");
	}

	@Override
	public void destroy() {
		log.info("Filter is destroyed.........");
	}

}
