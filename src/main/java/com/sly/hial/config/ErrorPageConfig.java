package com.sly.hial.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

/**
 * 错误页面配置
 * 
 * @author sly
 * @time 2019年4月29日
 */
public class ErrorPageConfig implements ErrorPageRegistrar {
	
	/**
	 * 注册错误页面
	 * @param registry
	 * @author sly
	 * @time 2019年4月29日
	 */
	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
		ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");
		registry.addErrorPages(error404Page, error500Page);
	}

}
