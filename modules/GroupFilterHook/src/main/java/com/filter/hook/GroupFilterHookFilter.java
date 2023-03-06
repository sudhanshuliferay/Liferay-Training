package com.filter.hook;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudhanshu
 */

@Component(immediate = true, property = { "servlet-context-name=", "servlet-filter-name=Custom Filter",
		"url-pattern=/group/*" }, service = Filter.class)
public class GroupFilterHookFilter extends BaseFilter {

	private final Log log = LogFactoryUtil.getLog(this.getClass());

	/*
	 * @Override public void init(FilterConfig filterConfig) throws ServletException
	 * { log.info("Filter is registered........."); String
	 * welcomeMessage=filterConfig.getInitParameter("hello");
	 * log.info("init paramter for this request is : "+welcomeMessage); }
	 */

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("request is registered.........");
		// preprocessing/prefilter
		
		chain.doFilter(request, response);

		// postprocessing/postfilter
		log.info("response is served...............");
	}

	@Override
	protected void processFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws Exception {
		log.info("request is registered.........");
		// preprocessing/prefilter

		filterChain.doFilter(httpServletRequest, httpServletResponse);

		// postprocessing/postfilter
		log.info("response is served...............");
		// super.processFilter(httpServletRequest, httpServletResponse, filterChain);
	}

	@Override
	public void destroy() {
		log.info("Filter is destroyed.........");
	}

	@Override
	protected Log getLog() {

		return log;
	}

}