package com.my.blog.website.config;

import javax.servlet.DispatcherType;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.my.blog.website.filter.RequestCostFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean costFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setDispatcherTypes(DispatcherType.REQUEST);
		registration.setFilter(new RequestCostFilter());
		registration.addUrlPatterns("/*");
		registration.setName("costFilter");
		registration.setOrder(Integer.MAX_VALUE);
		return registration;
	}

}
