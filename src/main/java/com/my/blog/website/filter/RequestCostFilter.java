package com.my.blog.website.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * HTTP请求耗时监控统一入口
 * 
 * @author shangpan
 * 
 * @since Feb 13, 2017
 */
//@WebFilter(filterName = "costFilter", urlPatterns = "/*", initParams = {
//		@WebInitParam(name = "encoding", value = "UTF-8"), @WebInitParam(name = "forceEncoding", value = "true") })
public class RequestCostFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(RequestCostFilter.class);

	@SuppressWarnings("unused")
	private String encoding;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	/*
	 * -- 原来代码
	 * 
	 * @Override 
	 * public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	 * 		HttpServletRequest httpRequest = (HttpServletRequest) request; StopWatch
	 * 		stopWatch = new StopWatch(System.currentTimeMillis() + "");
	 * 		stopWatch.start();
	 * 		chain.doFilter(request, response);
	 * 		stopWatch.stop();
	 * 		
	 * 		log.debug(httpRequest.getRequestURI() + " -> request cost - " + stopWatch.getTotalTimeMillis() + " ms"); 
	 * }
	 */

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		log.info("======>encoding:" + encoding);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		// org.springframework.util.StopWatch
		StopWatch stopWatch = new StopWatch(System.currentTimeMillis() + "");
		stopWatch.start();
		chain.doFilter(request, response);
		stopWatch.stop();
		log.info("======>RequestURI: " + httpRequest.getRequestURI() + " -->Time cost: " + stopWatch.getTotalTimeMillis() + " ms");
	}

	@Override
	public void destroy() {
		
	}
}
