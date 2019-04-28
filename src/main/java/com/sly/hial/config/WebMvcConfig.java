package com.sly.hial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sly.hial.interceptor.LoginInterceptor;
import com.sly.hial.interceptor.AuthPermissionInterceptor;

/**
 * 默认首页配置
 * 
 * @author sly
 * @time 2018年12月9日
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;
	@Autowired
	private AuthPermissionInterceptor permissionAccessInterceptor;

	/**
	 * 注册登录拦截器
	 * 
	 * @param registry
	 * @author sly
	 * @time 2018年11月25日
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns("/**") 表示拦截所有的请求，
		// excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(
				//静态资源放行
				"/resource/**",
				"/",
				//放行页面及请求连接
				"/error", 
				"/system/login/toLogin",
				"/system/login/login",
				"/system/validate/getJPGCode",
				"/system/validate/getGifCode",
				"/register/toRegister",  
				"/index.jsp"
				);
		
		registry.addInterceptor(permissionAccessInterceptor).addPathPatterns("/**").excludePathPatterns(
				//静态资源放行
				"/resource/**",
				//放行页面及请求连接
				"/error", 
				"/system/login/toLogin",
				"/system/login/login",
				"/system/validate/getJPGCode",
				"/system/validate/getGifCode",
				"/register/toRegister",  
				"/index.jsp"
				);
	}


	/**
	 * 添加视图
	 * 
	 * @param registry
	 * @author sly
	 * @time 2018年12月9日
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		WebMvcConfigurer.super.addViewControllers(registry);
	}
}
